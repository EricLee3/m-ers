package kr.co.asnet.migam.web.report;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.AnalResult;
import kr.co.asnet.migam.domain.call.AgentCall;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.domain.call.CallAnalysisComp;
import kr.co.asnet.migam.domain.call.CompletionCallAnalysis;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.call.HourlyCall;
import kr.co.asnet.migam.domain.call.MonthlyCall;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.call.AgentCallService;
import kr.co.asnet.migam.service.call.CallAnalysisService;
import kr.co.asnet.migam.service.call.CompletionCallAnalysisService;
import kr.co.asnet.migam.service.call.DailyCallService;
import kr.co.asnet.migam.service.call.HourlyCallService;
import kr.co.asnet.migam.service.call.MonthlyCallService;
import kr.co.asnet.migam.utils.Const;

/**
 * 리포트 컨트롤러
 * 
 * @author kwonsy
 * 
 */
@Controller
@RequestMapping(value="/report")
public class ReportController {
	private final Logger logger = LoggerFactory.getLogger(ReportController.class);
	@Inject
	private AgentService agentService;
	@Inject
	private AgentGroupService agentGroupService;
	@Inject
	private CallAnalysisService callAnalysisService;
	@Inject
	private HourlyCallService hourlyCallService;
	@Inject
	private DailyCallService dailyCallService;
	@Inject
	private MonthlyCallService monthlyCallService;
	@Inject 
	private AgentCallService agentCallService;
	
	@Inject 
	private CompletionCallAnalysisService completionCallAnalysisService;
	
	
	 
	/**
	 * 리포트 URL 입력시 기본 페이지입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String monitorSection(Model model) {
		return "redirect:/report/call_report";
	}
	/*
	 * 리포트::콜별 리포트
	 * 날짜 조회기준은 mecs5_analysis_result 테이블의 insert_date 를 기준으로 하고 있습니다. 
	 * 기존 start_time 기준으로 조회하던 것을, 고객의 요청에 의하여 insert_date 로  변경합니다. (2016-10-07 kwonsy)
	 * 차트 표시를 위해서는 오름차순으로 리스트를 만들어야 하고, 목록 표시는 내림차순으로 정렬합니다.
	 * 조회 기준이 변경되면 DailyCallServiceImpl.java 에서 makeDailyCall 메소드의 callAnalysis.getCreateDate() 부분도 같이 변경했음에  주의합니다.
	 * 화면 표시 핃드 값도 같이 변경해야 하니 주의 바랍니다.
	 */
	@RequestMapping(value = "/call_report", method = RequestMethod.GET)
	public String callReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, String selectAgent) {
		// 그룹 선택을 위한 SELECT를 만들 때 사용할 목록 표시용
				List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name *1 asc");
				model.addAttribute("agentGroupList", agentGroupList);
				//if( searchDTO.getSearchGroup() != null ) {
					List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
					model.addAttribute("agentList", agentList);
				//}
						
		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent") ) searchDTO.setSearchId(null);
		}
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.DATE, -30); // 최근 30일
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		model.addAttribute("searchDTO", searchDTO);
	//	List<DailyCall> dailyCallListForChart = dailyCallService.getCustomerCallListForChart(searchDTO);
		model.addAttribute("dailyCallListForChart", null); // 느린 이유는 그래프 떄문임
		PageDTO pageDTO = new PageDTO(page);
		List<CallAnalysis> callAnalysisList = callAnalysisService.getCallAnalysisList(pageDTO, searchDTO, "order by insert_date desc");
		model.addAttribute("callAnalysisList", callAnalysisList);
		model.addAttribute("callAnalysisCount", callAnalysisService.getCallAnalysisCount(searchDTO));
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchGroup", searchDTO.getSearchGroup());
		model.addAttribute("SearchType", searchDTO.getSearchType());
		if(searchDTO.getSearchId() != null) {
			model.addAttribute("searchId", selectAgent);
		}
		
		model.addAttribute("menu", "call_report");
		model.addAttribute("menuCategory", "report");
		return "/report/call_report";
	}

	/**
	 * 리포트::콜별 리포트, 고객 리포트에서 선택한 콜의 상세 정보 조회에 대한 처리한 결과를 ajax로 가져오기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal로 표시되는 것이 원칙입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_view/{index}", method = RequestMethod.GET)
	public String callViewModal(@PathVariable("index") int index, Model model) {
		
		CallAnalysis callAnalysis = callAnalysisService.getCallAnalysis(index);
		//model.addAttribute("callAnalysis", callAnalysis);
		callAnalysis.setMixedWavePath(callAnalysis.getMixedWavePath().replaceAll("\\\\","/"));
		/*
		// 데이터 숫자를 구하여 차트 label 개수를 동일하게 맞춰야, 차트 데이터를 모두 표시할 수 있습니다.
		int count = 0;
		if (callAnalysis.getCustomerSegmentCount() > callAnalysis.getAgentSegmentCount()) {
			count = callAnalysis.getCustomerSegmentCount();
		} else {
			count = callAnalysis.getAgentSegmentCount();
		}
		
		// Bar 차트 표시를 위해 추가된 부분
		String[] customerStartPosArray, agentStartPosArray = null;
		String[] customerEndPosArray, agentEndPosArray = null;
		String[] customerSegmentDataArray, agentSegmentDataArray = null;
		customerStartPosArray = callAnalysis.getCustomerStartPos().split(",");
		agentStartPosArray = callAnalysis.getAgentStartPos().split(",");
		customerEndPosArray = callAnalysis.getCustomerEndPos().split(",");
		agentEndPosArray = callAnalysis.getAgentEndPos().split(",");
		customerSegmentDataArray = callAnalysis.getCustomerSegmentData().split(",");
		agentSegmentDataArray = callAnalysis.getAgentSegmentData().split(",");
		
		List<CallAnalysisComp> callAnalysisCompList = new ArrayList<CallAnalysisComp>();
		if ( callAnalysis.getCustomerSegmentCount() > 0 ) {
			for (int i=0; i < customerSegmentDataArray.length; i++) {
				CallAnalysisComp callAnalysisComp = new CallAnalysisComp();
				callAnalysisComp.setStartPos( customerStartPosArray[i].equals("") ? 0 : Float.parseFloat(customerStartPosArray[i]) );
				callAnalysisComp.setEndPos( customerEndPosArray[i].equals("") ? 0 : Float.parseFloat(customerEndPosArray[i]) );
				callAnalysisComp.setSegmentData( customerSegmentDataArray[i].equals("") ? "0" : customerSegmentDataArray[i] );
				callAnalysisComp.setCallParty(1);
				callAnalysisCompList.add(callAnalysisComp);
			}
		}
		if ( callAnalysis.getAgentSegmentCount() > 0 ) {
			for (int i=0; i < agentSegmentDataArray.length; i++) {
				CallAnalysisComp callAnalysisComp = new CallAnalysisComp();
				callAnalysisComp.setStartPos( agentStartPosArray[i].equals("") ? 0 : Float.parseFloat(agentStartPosArray[i]) );
				callAnalysisComp.setEndPos( agentEndPosArray[i].equals("") ? 0 : Float.parseFloat(agentEndPosArray[i]) );
				callAnalysisComp.setSegmentData( agentSegmentDataArray[i].equals("") ? "0" : agentSegmentDataArray[i] );
				callAnalysisComp.setCallParty(0);
				callAnalysisCompList.add(callAnalysisComp);
			}
		}
		Collections.sort(callAnalysisCompList);

		String labelString = "";
		String customerSegmentData = "";
		String agentSegmentData = "";
		for ( CallAnalysisComp callAnalysisComp : callAnalysisCompList ) {
			labelString += "\'\'" + ",";
			if ( callAnalysisComp.getCallParty() == 1 ) {
				customerSegmentData += callAnalysisComp.getSegmentData() + ",";
				agentSegmentData +=  "0,";
			} else if ( callAnalysisComp.getCallParty() == 0 ) {
				customerSegmentData += "0,";
				agentSegmentData +=  callAnalysisComp.getSegmentData() + ",";
			}
		}
		labelString = labelString + "\'\'";
		customerSegmentData = customerSegmentData + "0";
		agentSegmentData = agentSegmentData + "0";
		//logger.debug( "customerSegmentData=" + customerSegmentData );
		//logger.debug( "agentSegmentData=" + agentSegmentData );
		//logger.debug( "labelString=" + labelString );
		callAnalysis.setCustomerSegmentData(customerSegmentData);
		callAnalysis.setAgentSegmentData(agentSegmentData);
				model.addAttribute("labelString", labelString);
		*/
		model.addAttribute("callAnalysis", callAnalysis);
		//. Bar 차트 표시를 위해 추가된 부분
		

		
		return "/report/call_view";
	}
	
	
	@RequestMapping(value = "linegraph", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
    public @ResponseBody String linegraph( @RequestParam(value = "page", required = false, defaultValue = "1") int page,SearchDTO searchDTO, Locale locale, Model model,String idx) {
        Gson gson = new Gson();
        
        PageDTO pageDTO = new PageDTO(page);
        searchDTO.setSearchQuery(idx);
		List<CompletionCallAnalysis> CompletionCallAnalysisList = completionCallAnalysisService.getCompletionCallAnalysisList(pageDTO, searchDTO, "order by indicator_kor_name");
        List<Map> hashlist = new ArrayList<Map>();
		String indicator_name = "";
		String indicator_end_pos = "";
		String indicator_result ="";
		DecimalFormat format = new DecimalFormat("#");
	          
		for(int i=0;i< CompletionCallAnalysisList.size();i++){
			indicator_name = CompletionCallAnalysisList.get(i).getIndicator_name();
															//.getIndicator_kor_name();
			// interim code for Service indicator
			// actually it is recommended that the operator should create unique service indicator name for profiling IOS[25-Jul-2017]
			if (indicator_name.equals("Energetic"))  {
				if (CompletionCallAnalysisList.get(i).getCall_party() == "0")  {
					indicator_name = "Energetic(상담원)";
				} else  {
					indicator_name = "Energetic(고객)";
				}
			} else if (indicator_name.equals("Stress"))  {
				if (CompletionCallAnalysisList.get(i).getCall_party() == "0")  {
					indicator_name = "Stress(상담원)";
				} else  {
					indicator_name = "Stress(고객)";
				}
			}			
			
			indicator_end_pos = CompletionCallAnalysisList.get(i).getIndicator_end_pos();
			indicator_result = CompletionCallAnalysisList.get(i).getIndicator_result();
	
	        String indicator_result_sub[] = indicator_result.split(",");
	        String end_posbtime[] = indicator_end_pos.split(",");
	        int[] indicator_result_sub2 = new int[indicator_result_sub.length];
	        double[] indicator_result_sub3 = new double[indicator_result_sub.length];
	        int[] end_postime_sub2 = new int[end_posbtime.length];
	        
	        Object[] postime = new Object[end_posbtime.length];
	            
            for(int j = 0; j<indicator_result_sub.length; j++){
                String str = format.format(Double.parseDouble(end_posbtime[j]));
                end_postime_sub2[j] =  Integer.parseInt(str) ;
              
                indicator_result_sub2[j] = Integer.parseInt(indicator_result_sub[j]);

                Object[] postime2 ={end_postime_sub2[j],indicator_result_sub2[j]}; 
                postime[j] = postime2;
            }
	        	
	        HashMap hashmap = new HashMap();
//            hashmap = new HashMap();
            hashmap.put("name", indicator_name);
            hashmap.put("data", postime);
            hashlist.add(hashmap);
		}
        return gson.toJson(hashlist);
    }
	
	
	/**
	 * 통계::상담원별 통계
	 * 
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/agent_report", method = {RequestMethod.GET,RequestMethod.POST})
	public String agentReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO,String selectAgent) {
		// 그룹 선택을 위한 SELECT를 만들 때 사용할 목록 표시용
		
		PageDTO2 pageDTO2 = new PageDTO2(page);
		
		List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name *1 asc");
		model.addAttribute("agentGroupList", agentGroupList);
		//if( searchDTO.getSearchGroup() != null ) {
			List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
			model.addAttribute("agentList", agentList);
		//}

		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent")) searchDTO.setSearchId(null);
		}
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.DATE, -30); // 최근 30일
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		
		if( searchDTO.getSearchId() != null ) { 
			List<AgentCall> agentCallListForChart = agentCallService.getAgentCallListForChart(pageDTO2, searchDTO, "order by agent_id asc");
			model.addAttribute("call_list_Count", agentCallService.selectAgentMonitorStatCount(searchDTO));
			model.addAttribute("agentCallListForChart", agentCallListForChart);
			
			int totalCount = 0;
			int successCount = 0;
			int failCount = 0;
			int angerCount = 0;
			int stressCount = 0;
			int incrementCount = 0;
			int decrementCount = 0;
			for (AgentCall agentCall : agentCallListForChart ) {
				totalCount += agentCall.getTotalCount();
				successCount += agentCall.getSuccessCount();
				failCount += agentCall.getFailCount();
				angerCount += agentCall.getAngryCount();
				stressCount += agentCall.getStressCount();
				incrementCount += agentCall.getIncrementCount();
				decrementCount += agentCall.getDecrementCount();
			}
			model.addAttribute("totalCall", totalCount);
			model.addAttribute("successCount", successCount);
			model.addAttribute("failCount", failCount);
			model.addAttribute("angerCall", angerCount);
			model.addAttribute("stressCall", stressCount);
			model.addAttribute("incrementCount", incrementCount);
			model.addAttribute("decrementCount", decrementCount);
		}
		
		model.addAttribute("searchGroup", searchDTO.getSearchGroup());
		if(searchDTO.getSearchId() != null) {
			model.addAttribute("searchId", selectAgent);
		}
		
		model.addAttribute("pageDTO", pageDTO2);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "agent_report");
		model.addAttribute("menuCategory", "report");
		
		return "/report/agent_report"; 
	}

	/**
	 * 리포트::고객 리포트
	 * 기간 및 콜 타입에 따라서 콜 분석 결과를 조회하기 위한 합니다.
	 * 
	 * 날짜 조회기준은 mecs5_analysis_result 테이블의 insert_date 를 기준으로 하고 있습니다. 
	 * 기존 start_time 기준으로 조회하던 것을, 고객의 요청에 의하여 insert_date 로  변경합니다. (2016-10-07 kwonsy)
	 * 차트 표시를 위해서는 오름차순으로 리스트를 만들어야 하고, 목록 표시는 내림차순으로 정렬합니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/customer_report", method = RequestMethod.GET)
	public String customerReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.DATE, -7); // 최근 7일
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		model.addAttribute("searchDTO", searchDTO);
		
		
		List<DailyCall> dailyCallListForChart = dailyCallService.getCustomerCallListForChart(searchDTO);
		model.addAttribute("dailyCallListForChart", dailyCallListForChart);
		
		PageDTO pageDTO = new PageDTO(page);
		List<CallAnalysis> callAnalysisList = callAnalysisService.getCallAnalysisList(pageDTO, searchDTO, "order by insert_date desc");
		model.addAttribute("callAnalysisList", callAnalysisList);
		model.addAttribute("callAnalysisCount", callAnalysisService.getCallAnalysisCount(searchDTO));
		model.addAttribute("pageDTO", pageDTO);
		
		model.addAttribute("menu", "customer_report");
		model.addAttribute("menuCategory", "report");
		return "/report/customer_report";
	}

	/**
	 * 통계::일별 통계
	 * 
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/day_report", method = RequestMethod.GET)
	public String dayReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO,String selectAgent) {
			Boolean allagent=false;
			
			PageDTO2 pageDTO2 = new PageDTO2(page);
		// 그룹 선택을 위한 SELECT를 만들 때 사용할 목록 표시용
			List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name *1 asc");
			model.addAttribute("agentGroupList", agentGroupList);
			//if( searchDTO.getSearchGroup() != null ) {
				List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
				model.addAttribute("agentList", agentList);
			//}
			// 검색 조건 처리
			if( searchDTO.getSearchGroup() != null ) { 
				if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
			}
			

			if( searchDTO.getSearchId() != null ) { 
				if( searchDTO.getSearchId().equals("allAgent")  ) {
					searchDTO.setSearchId(null);
				}
					allagent=true;
			}
			
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.DATE, -30); // 최근 30일
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		
	//	List<DailyCall> dailyCallListForChart = dailyCallService.getDailyCallListForChart(searchDTO, "order by stat_time asc");
	//	model.addAttribute("dailyCallListForChart", dailyCallListForChart);
		if(allagent ==true) {
			List<DailyCall> dailyCallList = dailyCallService.getDailyCallListForChart(pageDTO2, searchDTO, "order by stat_time desc");
			model.addAttribute("call_list_Count", dailyCallService.selectDayMonitorStatCount(searchDTO));
			model.addAttribute("dailyCallList", dailyCallList);
		}
		/*
		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		
		for (DailyCall dailyCall : dailyCallList ) {
			totalCount += dailyCall.getTotalCount();
			successCount += dailyCall.getSuccessCount();
			failCount += dailyCall.getFailCount();
			angerCount += dailyCall.getAngryCount();
			stressCount += dailyCall.getStressCount();
			incrementCount += dailyCall.getIncrementCount();
			decrementCount += dailyCall.getDecrementCount();
		}
		model.addAttribute("totalCall", totalCount);
		model.addAttribute("successCount", successCount);
		model.addAttribute("failCount", failCount);
		model.addAttribute("angerCall", angerCount);
		model.addAttribute("stressCall", stressCount);
		model.addAttribute("incrementCount", incrementCount);
		model.addAttribute("decrementCount", decrementCount);
		*/
		
		model.addAttribute("searchGroup", searchDTO.getSearchGroup());
		if(searchDTO.getSearchId() != null) {
			model.addAttribute("searchId", selectAgent);
		}
		
		
		
		model.addAttribute("pageDTO", pageDTO2);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "day_report");
		model.addAttribute("menuCategory", "report");
		return "/report/day_report";
	}
	
	/**
	 * 통계::월별 통계
	 * 
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/month_report", method = RequestMethod.GET)
	public String monthReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, String selectAgent) {
		Boolean allagent=false;
		
		PageDTO2 pageDTO2 = new PageDTO2(page);
		// 그룹 선택을 위한 SELECT를 만들 때 사용할 목록 표시용
		List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name *1 asc");
		model.addAttribute("agentGroupList", agentGroupList);
		//if( searchDTO.getSearchGroup() != null ) {
			List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
			model.addAttribute("agentList", agentList);
		//}

		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent")  ) {
				searchDTO.setSearchId(null);
			}
				allagent=true;
		}
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.MONTH, -12); // 최근 1년
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM").format(new Date()));
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		model.addAttribute("searchDTO", searchDTO);
		
	//	List<MonthlyCall> monthlyCallListForChart = monthlyCallService.getMonthlyCallListForChart(searchDTO, "order by stat_time asc");
	//	model.addAttribute("monthlyCallListForChart", monthlyCallListForChart);
		if(allagent ==true) {
			List<MonthlyCall> monthlyCallList = monthlyCallService.getMonthlyCallListForChart(pageDTO2,searchDTO, "order by stat_time desc");
			model.addAttribute("call_list_Count", monthlyCallService.selectMonthMonitorStatCount(searchDTO));
			model.addAttribute("monthlyCallList", monthlyCallList);
		}
		/*
		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		for (MonthlyCall monthlyCall : monthlyCallList ) {
			totalCount += monthlyCall.getTotalCount();
			successCount += monthlyCall.getSuccessCount();
			failCount += monthlyCall.getFailCount();
			angerCount += monthlyCall.getAngryCount();
			stressCount += monthlyCall.getStressCount();
			incrementCount += monthlyCall.getIncrementCount();
			decrementCount += monthlyCall.getDecrementCount();
		}
		model.addAttribute("totalCall", totalCount);
		model.addAttribute("successCount", successCount);
		model.addAttribute("failCount", failCount);
		model.addAttribute("angerCall", angerCount);
		model.addAttribute("stressCall", stressCount);
		model.addAttribute("incrementCount", incrementCount);
		model.addAttribute("decrementCount", decrementCount);
		*/
		model.addAttribute("searchGroup", searchDTO.getSearchGroup());
		if(searchDTO.getSearchId() != null) {
			model.addAttribute("searchId", selectAgent);
		}
		
		model.addAttribute("pageDTO", pageDTO2);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "month_report");
		model.addAttribute("menuCategory", "report");
		return "/report/month_report";
	}
	
	@RequestMapping(value = "/week_report", method = RequestMethod.GET)
	public String weekReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO = new PageDTO(page);
		
		List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name asc");
		model.addAttribute("agentGroupList", agentGroupList);
		
		
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "week_report");
		model.addAttribute("menuCategory", "report");
		return "/report/week_report";
	}
	
	/**
	 * 통계::시간대별 통계
	 * 
	 * @param page
	 * @param recordStart
	 * @param recordEnd
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/hour_report", method = {RequestMethod.GET, RequestMethod.POST})
	public String hourReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "recordStart", required = false, defaultValue = "00:00") String recordStart,
			@RequestParam(value = "recordEnd", required = false, defaultValue = "23:00") String recordEnd, Model model,
			SearchDTO searchDTO, String selectAgent) {

		
		PageDTO2 pageDTO2 = new PageDTO2(page);
		
		// 그룹 선택을 위한 SELECT를 만들 때 사용할 목록 표시용
		List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name *1 asc");
		model.addAttribute("agentGroupList", agentGroupList);
		//if( searchDTO.getSearchId() != null ) {
			List<Agent> agentList = agentService.getAgentList(pageDTO2, searchDTO, "order by agent_name asc");
			model.addAttribute("agentList", agentList);
		//}
		Boolean allagent=false;
		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent")  ) {
				searchDTO.setSearchId(null);
			}
				allagent=true;
		}
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			//calendar.add(Calendar.DATE, -30); // 최근 30일
			//searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		model.addAttribute("startDate", searchDTO.getStartDate());
		model.addAttribute("endDate", searchDTO.getEndDate());
		if(searchDTO.getStartDate() != null){
			String statDateStart = searchDTO.getStartDate()+" "+recordStart.substring(0,2);
			String statDateEnd = searchDTO.getEndDate()+" "+recordEnd.substring(0,2);
			searchDTO.setStartDate(statDateStart);
			searchDTO.setEndDate(statDateEnd);
		}
		

		
		// hourlyCallListForChart 는 동일 시간대 값을 합산하여 조회. 고객 요청은 동일 시간대 합산이 아니라, 일자별로 시간대 값이 계속 표시되기를 원하여, hourlyCallListByOrder 를 추가했다.
		//List<HourlyCall> hourlyCallListForChart = hourlyCallService.getHourlyCallListForChart(searchDTO, "order by stat_time asc");
		//model.addAttribute("hourlyCallListForChart", hourlyCallListForChart);
		
		if(allagent ==true) {
			List<HourlyCall> hourlyCallListByOrder = hourlyCallService.getHourlyCallListByOrder(pageDTO2, searchDTO, "order by stat_time desc");
			model.addAttribute("hourlyCallListByOrder", hourlyCallListByOrder);
		}
		
		/*
		List<HourlyCall> hourlyCallListByOrderForChart = hourlyCallService.getHourlyCallListByOrder(searchDTO, "order by stat_time asc");
		model.addAttribute("hourlyCallListByOrderForChart", hourlyCallListByOrderForChart);
		
		int totalCount = 0;
		int successCount = 0;
		int failCount = 0;
		int angerCount = 0;
		int stressCount = 0;
		int incrementCount = 0;
		int decrementCount = 0;
		for (HourlyCall hourlyCall : hourlyCallListByOrder ) {
			totalCount += hourlyCall.getTotalCount();
			successCount += hourlyCall.getSuccessCount();
			failCount += hourlyCall.getFailCount();
			angerCount += hourlyCall.getAngryCount();
			stressCount += hourlyCall.getStressCount();
			incrementCount += hourlyCall.getIncrementCount();
			decrementCount += hourlyCall.getDecrementCount();
		}
		model.addAttribute("totalCall", totalCount);
		model.addAttribute("successCount", successCount);
		model.addAttribute("failCount", failCount);
		model.addAttribute("angerCall", angerCount);
		model.addAttribute("stressCall", stressCount);
		model.addAttribute("incrementCount", incrementCount);
		model.addAttribute("decrementCount", decrementCount);
		
		*/
		model.addAttribute("searchGroup", searchDTO.getSearchGroup());
		if(searchDTO.getSearchId() != null) {
			model.addAttribute("searchId", selectAgent);
		}
		model.addAttribute("call_list_Count", hourlyCallService.selectHourMonitorStatCount(searchDTO));
		model.addAttribute("pageDTO", pageDTO2);
		model.addAttribute("listCount", 10);
		model.addAttribute("recordStart", recordStart);
		model.addAttribute("recordEnd", recordEnd);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("menu", "hour_report");
		model.addAttribute("menuCategory", "report");
		return "/report/hour_report";
	}
	
	/**
	 * 통계::근무성과별 통계
	 * 
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/performance_report", method = RequestMethod.GET)
	public String batchReport(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, String selval) {
		// 그룹 선택을 위한 SELECT를 만들 때 사용할 목록 표시용
		PageDTO2 pageDTO2 = new PageDTO2(page);
		List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name *1 asc");
		model.addAttribute("agentGroupList", agentGroupList);
		if( searchDTO.getSearchGroup() != null ) {
			List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
			model.addAttribute("agentList", agentList);
		}

		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent") ) searchDTO.setSearchId(null);
		}
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.DATE, -30); // 최근 30일
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		model.addAttribute("searchDTO", searchDTO);
		
		if( searchDTO.getSearchId() != null ) { 
			List<AgentCall> agentCallListForChart = agentCallService.getAgentCallListForChart(null,searchDTO, "order by agent_id asc");
			model.addAttribute("agentCallListForChart", agentCallListForChart);
			
			int totalCount = 0;
			int successCount = 0;
			int failCount = 0;
			int angerCount = 0;
			int stressCount = 0;
			int incrementCount = 0;
			int decrementCount = 0;
			for (AgentCall agentCall : agentCallListForChart ) {
				totalCount += agentCall.getTotalCount();
				successCount += agentCall.getSuccessCount();
				failCount += agentCall.getFailCount();
				angerCount += agentCall.getAngryCount();
				stressCount += agentCall.getStressCount();
				incrementCount += agentCall.getIncrementCount();
				decrementCount += agentCall.getDecrementCount();
			}
			model.addAttribute("totalCall", totalCount);
			model.addAttribute("successCount", successCount);
			model.addAttribute("failCount", failCount);
			model.addAttribute("angerCall", angerCount);
			model.addAttribute("stressCall", stressCount);
			model.addAttribute("incrementCount", incrementCount);
			model.addAttribute("decrementCount", decrementCount);
		}
		
		model.addAttribute("searchGroup", searchDTO.getSearchGroup());
		model.addAttribute("selval", selval);
		if(searchDTO.getSearchId() != null) {
			model.addAttribute("searchId", searchDTO.getSearchId().replaceAll("'", ""));
		}
		
		model.addAttribute("menu", "performance_report");
		model.addAttribute("menuCategory", "report");
		
		return "/report/performance_report";
	}
	
	/**
	 * 콜별 리포트를 엑셀로 다운로드하기 위한 엔드포인트 입니다.
	 * 
	 * @param searchDTO : 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_report_download", method = RequestMethod.GET)
	public String callReportExcelDownload(SearchDTO searchDTO, Model model) {
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10000);
		//logger.debug(searchDTO.toString());
		model.addAttribute("excelType", Const.EXCELDOWNLOAD_CALLREPORT);
		model.addAttribute("callAnalysisList", callAnalysisService.getCallAnalysisList(pageDTO, searchDTO, "order by insert_date desc"));
		return "callReportExcelView";
	}
	
	/**
	 * 고객 리포트를 엑셀로 다운로드하기 위한 엔드포인트 입니다.
	 * 
	 * @param searchDTO : 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/customer_report_download", method = RequestMethod.GET)
	public String customerReportExcelDownload(SearchDTO searchDTO, Model model) {
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10000);
		model.addAttribute("excelType", Const.EXCELDOWNLOAD_CUSTOMERREPORT);
		model.addAttribute("callAnalysisList", callAnalysisService.getCallAnalysisList(pageDTO, searchDTO, "order by insert_date desc"));
		return "callReportExcelView";
	}
	
	/**
	 * 시간대별 통계를 엑셀로 다운로드하기 위한 엔드포인트 입니다.
	 * 
	 * @param searchDTO : 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hour_report_download", method = RequestMethod.GET)
	public String hourlyReportExcelDownload(@RequestParam(value = "page", required = false, defaultValue = "1") int page, SearchDTO searchDTO, Model model) {
		// 검색 조건 처리
		PageDTO2 pageDTO2 = new PageDTO2(page);
		
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
			if( searchDTO.getSearchGroup().equals("") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent") ) searchDTO.setSearchId(null);
			if( searchDTO.getSearchId().equals("") ) searchDTO.setSearchId(null);
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		//logger.debug(searchDTO.toString());
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10000);
		model.addAttribute("excelType", Const.EXCELDOWNLOAD_STATHOURLY);
		List<HourlyCall> hourlyCallList = hourlyCallService.getHourlyCallListByOrder(null, searchDTO, "order by stat_time desc");
		model.addAttribute("hourlyCallList", hourlyCallList);
		return "callReportExcelView";
	}
	
	/**
	 * 일별 통계를 엑셀로 다운로드하기 위한 엔드포인트 입니다.
	 * 
	 * @param searchDTO : 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/day_report_download", method = RequestMethod.GET)
	public String dailyReportExcelDownload(SearchDTO searchDTO, Model model) {
		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
			if( searchDTO.getSearchGroup().equals("") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent") ) searchDTO.setSearchId(null);
			if( searchDTO.getSearchId().equals("") ) searchDTO.setSearchId(null);
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10000);
		model.addAttribute("excelType", Const.EXCELDOWNLOAD_STATDAILY);
		List<DailyCall> dailyCallList = dailyCallService.getDailyCallListForChart(null,searchDTO, "order by stat_time desc");
		model.addAttribute("dailyCallList", dailyCallList);
		return "callReportExcelView";
	}
	
	/**
	 * 월별 통계를 엑셀로 다운로드하기 위한 엔드포인트 입니다.
	 * 
	 * @param searchDTO : 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/month_report_download", method = RequestMethod.GET)
	public String monthlyReportExcelDownload(SearchDTO searchDTO, Model model) {
		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
			if( searchDTO.getSearchGroup().equals("") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent") ) searchDTO.setSearchId(null);
			if( searchDTO.getSearchId().equals("") ) searchDTO.setSearchId(null);
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10000);
		model.addAttribute("excelType", Const.EXCELDOWNLOAD_STATMONTHLY);
		List<MonthlyCall> monthlyCallList = monthlyCallService.getMonthlyCallListForChart(null,searchDTO, "order by stat_time desc");
		model.addAttribute("monthlyCallList", monthlyCallList);
		return "callReportExcelView";
	}
	
	/**
	 * 상담원별 통계를 엑셀로 다운로드하기 위한 엔드포인트 입니다.
	 * 
	 * @param searchDTO : 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/agent_report_download", method = RequestMethod.GET)
	public String agentReportExcelDownload(SearchDTO searchDTO, Model model) {
		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
			if( searchDTO.getSearchGroup().equals("") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent") ) searchDTO.setSearchId(null);
			if( searchDTO.getSearchId().equals("") ) searchDTO.setSearchId(null);
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10000);
		model.addAttribute("excelType", Const.EXCELDOWNLOAD_STATAGENT);
		List<AgentCall> agentCallList = agentCallService.getAgentCallListForChart(null,searchDTO, "order by agent_id asc");
		model.addAttribute("agentCallList", agentCallList);
		return "callReportExcelView";
	}
	
	/**
	 * 근무성과별 통계를 엑셀로 다운로드하기 위한 엔드포인트 입니다.
	 * 
	 * @param searchDTO : 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/performance_report_download", method = RequestMethod.GET)
	public String performanceReportExcelDownload(SearchDTO searchDTO, Model model) {
		// 검색 조건 처리
		if( searchDTO.getSearchGroup() != null ) { 
			if( searchDTO.getSearchGroup().equals("allGroup") ) searchDTO.setSearchGroup(null);
			if( searchDTO.getSearchGroup().equals("") ) searchDTO.setSearchGroup(null);
		}
		if( searchDTO.getSearchId() != null ) { 
			if( searchDTO.getSearchId().equals("allAgent") ) searchDTO.setSearchId(null);
			if( searchDTO.getSearchId().equals("") ) searchDTO.setSearchId(null);
		}
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("0");
		}
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10000);
		model.addAttribute("excelType", Const.EXCELDOWNLOAD_STATAGENT);
		List<AgentCall> agentCallList = agentCallService.getAgentCallListForChart(null,searchDTO, "order by agent_id asc");
		model.addAttribute("agentCallList", agentCallList);
		return "callReportExcelView";
	}
}
