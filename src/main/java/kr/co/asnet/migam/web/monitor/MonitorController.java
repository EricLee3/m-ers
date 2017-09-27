package kr.co.asnet.migam.web.monitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.AgentHistory;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.ImsiMent;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.call.HourlyCall;
import kr.co.asnet.migam.domain.call.RealStat;
import kr.co.asnet.migam.domain.call.RealindState;
import kr.co.asnet.migam.domain.config.License;
import kr.co.asnet.migam.domain.config.Parameter;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentHistoryService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.call.CallAnalysisService;
import kr.co.asnet.migam.service.call.CallAuditService;
import kr.co.asnet.migam.service.call.DailyCallService;
import kr.co.asnet.migam.service.call.HourlyCallService;
import kr.co.asnet.migam.service.call.RealindStateService;
import kr.co.asnet.migam.service.config.LicenseService;
import kr.co.asnet.migam.service.config.ParameterService;

/**
 * 모니터 컨트롤러
 * 
 * @author kwonsy
 * 
 */
@Controller
@RequestMapping(value="/monitor")
public class MonitorController {
	private final Logger logger = LoggerFactory.getLogger(MonitorController.class);
	@Inject
	private AgentService agentService;
	@Inject
	private AgentHistoryService agentHistoryService;
	@Inject
	private CallAuditService callAuditService;
	@Inject
	private AgentGroupService agentGroupService;
	@Inject
	private HourlyCallService hourlyCallService;
	@Inject
	private DailyCallService dailyCallService;
	@Inject
	private ParameterService parameterService;
	@Inject
	private CallAnalysisService callAnalysisService;
	
	@Inject
	private RealindStateService realindStateService;
	
	
	/**
	 * MIGAM 메인페이지 입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String monitorSection(Model model) {
		return "redirect:/monitor/agent_list";
	}
	
	@RequestMapping(value = "/agent_list", method = RequestMethod.GET)
	public String agentList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO = new PageDTO(page);

		// 그룹-상담원 목록
		List<AgentGroup> groupList = agentGroupService.getAgentGroupList(pageDTO, searchDTO, "order by group_id asc");
		for (AgentGroup agentGroup : groupList ) {
			searchDTO.setSearchGroup(agentGroup.getGroupId());
			List<Agent> agentList = agentService.getAgentListWithAngry(null, searchDTO, "order by realtime desc");
			agentGroup.setAgentList(agentList);
		}
		
		model.addAttribute("groupList", groupList);
		Parameter parameter = parameterService.getParameter();
		model.addAttribute("angryCountParameter", parameter.getAngryCount());
		
		//오늘 콜 정보 
		SearchDTO hourlySearchDTO = new SearchDTO();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		hourlySearchDTO.setStartDate(today);
		hourlySearchDTO.setEndDate(today);
		//List<HourlyCall> hourlyCallList = hourlyCallService.getHourlyCallList(pageDTO, hourlySearchDTO, "order by stat_time asc");
		List<HourlyCall> hourlyCallList = hourlyCallService.getHourlyCallList(null, hourlySearchDTO, "order by stat_time asc");
		int totalCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		for (HourlyCall hourlyCall : hourlyCallList ) {
			totalCount += hourlyCall.getTotalCount();
			angerCount += hourlyCall.getAngryCount();
			stressCount += hourlyCall.getStressCount();
		}
		model.addAttribute("totalCall", totalCount);
		model.addAttribute("angerCall", angerCount);
		model.addAttribute("stressCall", stressCount);
//		model.addAttribute("angerCall", 20);
//		model.addAttribute("stressCall", 10);
		
		// 오늘의 상담원별 콜 정보
		List<Agent> todayAgentList = agentService.getAgentListWithCount(null, hourlySearchDTO, null);
		model.addAttribute("todayAgentList", todayAgentList);

		// 지난주 상담원별 A,S 콜 정보
		// 7일전 날짜와 어제 날짜를 각각 시작일과 종료일로 지정합니다. 
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DATE, -1);
		searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
		calendar.add(Calendar.DATE, -7);
		searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
		pageDTO.setItemPerPage(5);
		List<Agent> lastWeekAgentList = agentService.getAgentListWithCountFromDaily(pageDTO, searchDTO, "order by B.angryCount desc");
		model.addAttribute("lastWeekAgentList", lastWeekAgentList);
		
		model.addAttribute("menu", "agent");
		model.addAttribute("menuCategory", "monitor");
		
		return "/monitor/agent_list";
	}
	/**
	 * agent_list.jsp에서 jQuery ( .load함수)로 호출되는 상담원(그룹)에 대한 HTML을 제공하기 위해 만들어진 엔드포인트입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agent_list_refresh", method = RequestMethod.GET)
	public String agentListRefresh(Model model) {
		SearchDTO searchDTO = new SearchDTO();
		List<AgentGroup> groupList = agentGroupService.getAgentGroupList(null, null, "order by group_id asc");
		for (AgentGroup agentGroup : groupList ) {
			searchDTO.setSearchGroup(agentGroup.getGroupId());
			List<Agent> agentList = agentService.getAgentListWithAngry(null, searchDTO, "order by realtime desc");
			agentGroup.setAgentList(agentList);
		}
		model.addAttribute("groupList", groupList);
		Parameter parameter = parameterService.getParameter();
		model.addAttribute("angryCountParameter", parameter.getAngryCount());
		
		return "/monitor/agent_list_refresh";
	}
	
	/**
	 * 상담원 상세정보를 보여주는 엔드포인트입니다.
	 * 
	 * @param agentId
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 * 
	 * 참고사항 : 상담원의 최근 1주일간 AngryCall과 StressCall수를 가져옵니다. ( 최근 1주일입니다. )
	 */
	@RequestMapping(value = "/agent_view/{agentId}", method = RequestMethod.GET)
	public String agentView(@PathVariable("agentId") String agentId, @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		searchDTO.setSearchId(agentId);
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DATE, -7); // 최근 1주일
		searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
		searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		Agent agentWithCount = agentService.getAgentWithCount(searchDTO);

		Agent agent = agentService.getAgent(agentId);
		if( agentWithCount != null ) {
			agent.setAngryCount(agentWithCount.getAngryCount());
			agent.setStressCount(agentWithCount.getStressCount());
		}
		model.addAttribute("agent", agent);
		
		// 메모 사항
		PageDTO pageDTO = new PageDTO(1);
		pageDTO.setItemPerPage(20);
		searchDTO.setSearchId(agentId);
		List<AgentHistory> agentHistoryList = agentHistoryService.getAgentHistoryList(pageDTO, searchDTO, "order by idx desc"); 
		model.addAttribute("agentHistoryList", agentHistoryList);
		
		// 최근 콜 목록
		String In_agentId = "'"+agentId+"'";
		searchDTO.setSearchId(In_agentId);
		searchDTO.setStartDate(null);
		searchDTO.setEndDate(null);
		List<CallAnalysis> callAnalysisList = callAnalysisService.getCallAnalysisList(pageDTO, searchDTO, "order by start_time desc");
		model.addAttribute("callAnalysisList", callAnalysisList);
		
		// 오늘의 상담원별 콜 정보
		SearchDTO hourlySearchDTO = new SearchDTO();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		hourlySearchDTO.setStartDate(today);
		List<Agent> todayAgentList = agentService.getAgentListWithCount(null, hourlySearchDTO, null);
		model.addAttribute("todayAgentList", todayAgentList);
		
		model.addAttribute("menu", "agent");
		model.addAttribute("menuCategory", "monitor");
		return "/monitor/agent_view";
	}
	
	/**
	 * 모니터::콜목록에 대한 처리를 위한 엔드포인트입니다.
	 * 
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_list", method = RequestMethod.GET)
	public String callList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO,String selectAgent) {
		PageDTO pageDTO = new PageDTO(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO5 pageDT10 = new PageDTO5(page);
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);

		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
			if( searchDTO.getStartDate() == null ) {
				Calendar calendar = Calendar.getInstance(); 
				calendar.add(Calendar.DATE, -1); // 최근 -1일
			
				searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
				searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
		}
		/*
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
		}
		
		if( searchDTO.getSearchId() == null ) {
			searchDTO.setSearchId("");
		}
		*/
		/*
		List<RealStat> groupList = callAuditService.getGroup(pageDTO15, null, "order by GR.group_name asc");
		model.addAttribute("groupList", groupList);
		*/
		List<RealStat> agentList = callAuditService.getAgent(pageDTO15, null, "order by AG.agent_name asc");
		model.addAttribute("agentList", agentList);
		
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent")) searchDTO.setSearchId(null);
		}
		
		
		if (searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			
			List<RealStat> realStatList = callAuditService.getRealStat(pageDTO15, searchDTO, "order by agent_id asc");
			model.addAttribute("realStatList", realStatList);
			

		} else {
			if (searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<RealStat> realStatList = callAuditService.getRealStat5(pageDTO5, searchDTO, "order by agent_id asc");
				model.addAttribute("realStatList", realStatList);
		
			} else if (searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO);
				List<RealStat> realStatList = callAuditService.getRealStat(pageDTO, searchDTO, "order by agent_id asc");
				model.addAttribute("realStatList", realStatList);
		
			} else if (searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<RealStat> realStatList = callAuditService.getRealStat25(pageDTO25, searchDTO, "order by agent_id asc");
				model.addAttribute("realStatList", realStatList);
				
			} else if (searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<RealStat> realStatList = callAuditService.getRealStat50(pageDTO50, searchDTO, "order by agent_id asc");
				model.addAttribute("realStatList", realStatList);

			} else if (searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<RealStat> realStatList = callAuditService.getRealStat100(pageDTO100, searchDTO, "order by agent_id asc");
				model.addAttribute("realStatList", realStatList);

			}else {
				model.addAttribute("pageDTO", pageDTO);
				List<RealStat> realStatList = callAuditService.getRealStat(pageDTO, searchDTO, "order by agent_id asc");
				model.addAttribute("realStatList", realStatList);

			}

		}
		
		
		model.addAttribute("call_list_Count", callAuditService.countgetRealStat(searchDTO));

		model.addAttribute("listCount", 10);
		
		model.addAttribute("searchDTO", searchDTO);
		
		model.addAttribute("searchGroup", searchDTO.getSearchGroup());
		if(searchDTO.getSearchId() != null) {
			model.addAttribute("searchId", selectAgent);
		}
		
	//	model.addAttribute("searchId", searchDTO.getSearchId());
		model.addAttribute("searchQuery", searchDTO.getSearchQuery());
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		
		/*
		List<CallAudit> callAuditList = callAuditService.getCallAuditList(pageDTO, null, "order by agent_id asc");
		model.addAttribute("callAuditList", callAuditList);
		
		// 한계치 설정을 위한 값을 모델에 담습니다.
		Parameter systemParameter = parameterService.getParameter();
		model.addAttribute("angryCountParameter", systemParameter.getAngryCount());
		model.addAttribute("stressCountParameter", systemParameter.getStressCount());
		
		//오늘의 콜 정보 
		SearchDTO hourlySearchDTO = new SearchDTO();
		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		hourlySearchDTO.setStartDate(today);
		hourlySearchDTO.setEndDate(today);
		List<HourlyCall> hourlyCallList2 = hourlyCallService.getHourlyCallList(pageDTO, hourlySearchDTO, "order by stat_time asc");
		int totalCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		for (HourlyCall hourlyCall : hourlyCallList2 ) {
			totalCount += hourlyCall.getTotalCount();
			angerCount += hourlyCall.getAngryCount();
			stressCount += hourlyCall.getStressCount();
		}
		model.addAttribute("totalCall", totalCount);
		model.addAttribute("angerCall", angerCount);
		model.addAttribute("stressCall", stressCount);
		
		// 오늘의 상담원별 콜 정보 
		List<Agent> todayAgentList = agentService.getAgentListWithCount(null, hourlySearchDTO, null);
		model.addAttribute("todayAgentList", todayAgentList);

		// 오늘의 시간대별 A,S Call 
		SearchDTO tocayCallSearchDTO = new SearchDTO();
		tocayCallSearchDTO.setStartDate(today);
		tocayCallSearchDTO.setEndDate(today);
		List<HourlyCall> hourlyCallList = hourlyCallService.getHourlyCallList(null, tocayCallSearchDTO, "order by stat_time asc");
		model.addAttribute("hourlyCallList", hourlyCallList);
		
		// 지난주 상담원별 A,S 콜 정보
		// 7일전 날짜와 어제 날짜를 각각 시작일과 종료일로 지정합니다. 
		SearchDTO searchDTO = new SearchDTO();
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DATE, -1);
		searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
		calendar.add(Calendar.DATE, -7);
		searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
		pageDTO.setItemPerPage(5);
		List<Agent> lastWeekAgentList = agentService.getAgentListWithCountFromDaily(pageDTO, searchDTO, "order by B.angryCount desc");
		model.addAttribute("lastWeekAgentList", lastWeekAgentList);
		
		List<AgentGroup> groupList = agentGroupService.getAgentGroupList(pageDTO, searchDTO, "order by group_id asc");
		model.addAttribute("groupList", groupList);
		*/
		
		model.addAttribute("menu", "call");
		model.addAttribute("menuCategory", "monitor");
		return "/monitor/call_list";
	}
	
	/**
	 * 모니터::콜목록에 대한 처리한 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_list_refresh", method = RequestMethod.GET)
	public String callListRefresh(Model model) {
		List<CallAudit> callAuditList = callAuditService.getCallAuditList(null, null, "order by agent_id asc");
		model.addAttribute("callAuditList", callAuditList);
		
		// 한계치 설정을 위한 값을 모델에 담습니다.
		Parameter systemParameter = parameterService.getParameter();
		model.addAttribute("angryCountParameter", systemParameter.getAngryCount());
		model.addAttribute("stressCountParameter", systemParameter.getStressCount());

		// test for 콜목록 
		return "/monitor/call_list_refresh";
	}
	
	@RequestMapping(value = "/call_list_refresh_IOS", method = RequestMethod.GET)
	public @ResponseBody String callListRefreshIOS(HttpServletResponse response) {
		String agentName = null;
		String customerProfileName = null;
		String agentProfileName = null;
		
		JSONObject jObj = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		List<RealStat> realStatList = callAuditService.getRealStat(null, null, "where agent_profile_name is not null");
		
		for (int i=0; i < realStatList.size(); i++)  {
			JSONObject jTmp = new JSONObject();
			agentName = realStatList.get(i).getAgentName();
			customerProfileName = realStatList.get(i).getCustomerProfileName();
			agentProfileName = realStatList.get(i).getAgentProfileName();
			
			jTmp.put("agentName", realStatList.get(i).getAgentName());
			jTmp.put("customerProfileName", realStatList.get(i).getCustomerProfileName());
			jTmp.put("agentProfileName", realStatList.get(i).getAgentProfileName());
			jTmp.put("customerScript", realStatList.get(i).getCustomerScript());
			jTmp.put("agentScript", realStatList.get(i).getAgentScript());
			
			jArray.add(jTmp);
		}
		jObj.put("Names", jArray);
		
		return jObj.toString();
	}
	
	/**
	 * 모니터::콜목록에서 선택한 콜의 상세 정보 조회에 대한 처리한 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal로 표시되는 것이 원칙입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_view/{agentId}", method = RequestMethod.GET)
	public String callViewModal(@PathVariable("agentId") String agentId, Model model) {
		CallAudit callAudit = callAuditService.getCallAudit(agentId);
		model.addAttribute("callAudit", callAudit);
		
		return "/monitor/call_view";
	}
	
	/**
	 * 모니터::상담원 상세조회 화면에서 선택한 콜의 상세 정보 조회에 대한 처리한 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal로 표시되는 것이 원칙입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_view_agent/{index}", method = RequestMethod.GET)
	public String callViewAgentModal(@PathVariable("index") int index, Model model) {
		CallAnalysis callAnalysis = callAnalysisService.getCallAnalysis(index);
		model.addAttribute("callAnalysis", callAnalysis);

		// 데이터 숫자를 구하여 차트 label 개수를 동일하게 맞춰야, 차트 데이터를 모두 표시할 수 있습니다.
		int count = 0;
		if (callAnalysis.getCustomerSegmentCount() > callAnalysis.getAgentSegmentCount()) {
			count = callAnalysis.getCustomerSegmentCount();
		} else {
			count = callAnalysis.getAgentSegmentCount();
		}
		
		String labelString = "";
		for (int i=0; i < count; i++) {
			labelString += "\'\'" + ",";
		}
		labelString = "\'00:00\'," + labelString + "\'\'";
		model.addAttribute("labelString", labelString);
		
		return "/monitor/call_view_agent";
	}
	
	/**
	 * 실시간 콜 차트 정보 조회 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal 에서 표시하기 위해 사용합니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_view_refresh/{agentId}", method = {RequestMethod.GET, RequestMethod.POST})
	public String callViewRefresh(@PathVariable("agentId") String agentId, Model model) {
		CallAudit callAudit = callAuditService.getCallAudit(agentId);
		model.addAttribute("callAudit", callAudit);
		
		// 데이터 숫자를 구하여 차트 label 개수를 동일하게 맞춰야, 차트 데이터를 모두 표시할 수 있습니다.
		int count = 0;
		String labelString = "";
		String customerState = callAudit.getCustomerState();
		String agentState = callAudit.getAgentState();
		if ( customerState.length() >= agentState.length() ) {
			labelString = callAudit.getCustomerState();
		} else {
			labelString = callAudit.getAgentState();
		}
		
		for (int i=0; i < labelString.length(); i++) {
			if (labelString.charAt(i) == ',') count++;
		}
		//logger.debug("count=" + count);
		
		labelString = "";
		for (int i=0; i < count; i++) {
			labelString += "\'\'" + ",";
		}
		labelString = "\'00:00\'," + labelString + "\'\'";
		model.addAttribute("labelString", labelString);
		
		return "/monitor/call_view_refresh";
	}
	
	
	
	// 주기적으로 체크
	@RequestMapping(value = "/call_linegraph", method = {RequestMethod.POST, RequestMethod.GET})	
	@ResponseBody
	public String[] call_linegraph(Model model, String agentId, SearchDTO searchDTO,kr.co.asnet.migam.domain.call.RealindState RealindState){
		searchDTO.setSearchQuery(agentId);
		//RealindState =  realindStateService.getRealindState(searchDTO);
		
		List<RealindState>StateList =  realindStateService.getRealindStateList(searchDTO, "order by indicator_name asc");
		
		String[] indicator_data = new String[StateList.size()];
		for(int i=0;i< StateList.size();i++){
			String indicator_name = StateList.get(i).getIndicator_name();

			// interim code for Service indicator
			// actually it is recommended that the operator should create unique service indicator name for profiling IOS[25-Jul-2017]
			if (indicator_name == "Energetic")  {
				if (StateList.get(i).getCall_party() == "0")
					indicator_name = "EnergeticCallee";
			} else if (indicator_name == "Stress")  {
				if (StateList.get(i).getCall_party() == "0")
					indicator_name = "StressCallee";
			}
            String indicator_level = StateList.get(i).getIndicator_level();
            indicator_data[i] = indicator_name+","+indicator_level;
		}
		return indicator_data;
	}
}
