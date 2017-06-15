package kr.co.asnet.migam.web.main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.AlarmStatGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmStatGroup;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.agent.ProcessGroup;
import kr.co.asnet.migam.domain.call.AgentCall;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.config.Parameter;
import kr.co.asnet.migam.domain.user.User;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.ProcessGroupService;
import kr.co.asnet.migam.service.call.AgentCallService;
import kr.co.asnet.migam.service.call.CallAnalysisService;
import kr.co.asnet.migam.service.call.CallAuditService;
import kr.co.asnet.migam.service.call.DailyCallService;
import kr.co.asnet.migam.service.config.ParameterService;

/**
 * 메인 컨트롤러
 * 
 * @author 권성윤
 * 
 */
@Controller
public class MainController {
	private final Logger logger = LoggerFactory.getLogger(MainController.class);
	@Inject
	private CallAuditService callAuditService;
	@Inject
	private ParameterService parameterService;
	@Inject
	private DailyCallService dailyCallService;
	@Inject 
	private AgentCallService agentCallService;
	@Inject
	private AgentService agentService;
	@Inject
	private CallAnalysisService callAnalysisService;
	@Inject
	private ProcessGroupService processGroupService;
	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String intro(Model model) {
		return ("redirect:/main");
	}
	/**
	 * MIGAM 메인페이지 입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model, SearchDTO searchDTO, HttpServletRequest request, HttpServletResponse response, User user) {
		PageDTO pageDTO = new PageDTO(1);
		Login login = Login.getInstance();
		HttpSession session = request.getSession();
		String login_id = (String)session.getAttribute("login_id");
		String loginflag = (String)session.getAttribute("login");
		String logout = (String)session.getAttribute("logout");
		
		return "main/main";
	}
	
	@RequestMapping(value = "/main4", method = RequestMethod.GET)
	public String main4(Model model, SearchDTO searchDTO, HttpServletRequest request, HttpServletResponse response) {
		PageDTO pageDTO = new PageDTO(1);
		Login login = Login.getInstance();
		HttpSession session = request.getSession();
		String login_id = (String)session.getAttribute("login_id");
		String loginflag = (String)session.getAttribute("login");
		
		
		// 현재 콜 정보 : 모니터 > 콜 목록 의 기능을 그대로 가져와서 사용합니다.
		List<CallAudit> callAuditList = callAuditService.getCallAuditList(pageDTO, null, "order by agent_id asc");
		model.addAttribute("callAuditList", callAuditList);
		
		// 한계치 설정을 위한 값을 모델에 담습니다.
		Parameter systemParameter = parameterService.getParameter();
		model.addAttribute("angryCountParameter", systemParameter.getAngryCount());
		model.addAttribute("stressCountParameter", systemParameter.getStressCount());
		
		// 지난 달과 이번 달 전체 Angry 콜 수 비교 
		// 지난 달 1일과 마지막 날짜를 시작일과 종료일로 지정합니다.
		if( searchDTO.getStartDate() == null ) {
			Date today = new Date(); 
			Calendar calendar = Calendar.getInstance(); 
			/*calendar.add(Calendar.DATE, -30); // 최근 30일
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));*/
			
	        calendar.setTime(today);  
	        calendar.add(Calendar.MONTH, -1);
	        calendar.set(Calendar.DAY_OF_MONTH, 1);
	        searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 지난달 1일
	        
	        calendar.add(Calendar.MONTH, 1);
	        calendar.set(Calendar.DAY_OF_MONTH, 1);
	        calendar.add(Calendar.DATE, -1);  
	        searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 지난달 마지막 일자
		}
		model.addAttribute("searchDTO", searchDTO);
		
		// 지난달 1일부터 마지막 날까지 값
		List<DailyCall> dailyLastMonthCallListForChart = dailyCallService.getDailyCallListForChart(searchDTO, "order by stat_time asc");
		model.addAttribute("dailyLastMonthCallListForChart", dailyLastMonthCallListForChart);
		
		// 이번 달 1일부터 어제까지를 시작일과 종료일로 지정합니다.
		Date today = new Date(); 
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		calendar.add(Calendar.DATE, -1);
		searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 어제 일자
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 이번 달 1일
		
		// 이번달 1일부터 어제까지 값
		List<DailyCall> dailyCallListForChart = dailyCallService.getDailyCallListForChart(searchDTO, "order by stat_time asc");
		model.addAttribute("dailyCallListForChart", dailyCallListForChart);
		
		searchDTO.setSearchIsAudit("1");
		List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
		model.addAttribute("agentList", agentList);
		String agentIdList = "";
		for (Agent agent : agentList) {
			if (agentIdList != "") {
				agentIdList += ",";
			}
			agentIdList += "'" + agent.getAgentId() + "'";
			//logger.debug(agentIdList);
		}
		searchDTO.setSearchId(agentIdList);
		
		List<AgentCall> agentCallListForChart = agentCallService.getAgentCallListForChart(searchDTO, "order by agent_id asc");
		model.addAttribute("agentCallListForChart", agentCallListForChart);
		
		List<CallAnalysis> agentDailyAngryCallForDashBoard = callAnalysisService.getAgentDailyAngryCallForDashBoard(null, searchDTO, "order by agent_id asc");
		model.addAttribute("agentDailyAngryCallForDashBoard", agentDailyAngryCallForDashBoard);
		
		
		
		/*CPU*/
		List<ProcessGroup> processList = processGroupService.getProcessGroupList(pageDTO, searchDTO, "order by update_time desc");
		model.addAttribute("processList", processList);
		
		/*MEMORY*/
		List<ProcessGroup> memoryList = processGroupService.getMemoryGroupList(pageDTO, searchDTO, "order by update_time desc");
		model.addAttribute("memoryList", memoryList);
		
		/*DISK*/
		List<ProcessGroup> diskList = processGroupService.getDiskGroupList(pageDTO, searchDTO, "order by update_time desc");
		model.addAttribute("diskList", diskList);
		
		/*PROCESS*/
		List<ProcessGroup> processList2 = processGroupService.getProcessList(pageDTO, searchDTO, "order by update_time desc");
		model.addAttribute("processList2", processList2);
		
		/*프로세스 카운트*/
		int processCount = processGroupService.countProcessList(searchDTO);
		model.addAttribute("processCount", processCount);
		
		/*현재 알람 이력*/
		List<AlarmStatGroup> alarmstatList = processGroupService.getAlarmStatList(pageDTO, searchDTO, "order by alarmed_time desc");
		model.addAttribute("alarmstatList", alarmstatList);
		
		
		/*현재 알람 이력 카운트*/
		int alarmstatCount = processGroupService.countAlarmStatList(searchDTO);
		model.addAttribute("alarmstatCount", alarmstatCount);
		
		/*Fault 알람 이력*/
		List<FaultAlarmStatGroup> faultalarmstatList = processGroupService.getFaultAlarmStatList(pageDTO, searchDTO, "order by happened_time desc");
		model.addAttribute("faultalarmstatList", faultalarmstatList);
		
		/*현재 알람 이력 카운트*/
		int faultalarmstatCount = processGroupService.countFaultAlarmStatList(searchDTO);
		model.addAttribute("faultalarmstatCount", faultalarmstatCount);
		
		
		model.addAttribute("a_flag", (String)session.getAttribute("a_flag"));
		model.addAttribute("a_date", (String)session.getAttribute("a_date"));
		
		return "main/main4"; 
	}
	
	
	@RequestMapping(value = "/main5", method = RequestMethod.GET)
	   public String main5(Model model, SearchDTO searchDTO, HttpServletRequest request, HttpServletResponse response) {
	      PageDTO pageDTO = new PageDTO(1);
	      
	      // 현재 콜 정보 : 모니터 > 콜 목록 의 기능을 그대로 가져와서 사용합니다.
	      List<CallAudit> callAuditList = callAuditService.getCallAuditList(pageDTO, null, "order by agent_id asc");
	      model.addAttribute("callAuditList", callAuditList);
	      
	      // 한계치 설정을 위한 값을 모델에 담습니다.
	      Parameter systemParameter = parameterService.getParameter();
	      model.addAttribute("angryCountParameter", systemParameter.getAngryCount());
	      model.addAttribute("stressCountParameter", systemParameter.getStressCount());
	      
	      // 지난 달과 이번 달 전체 Angry 콜 수 비교 
	      // 지난 달 1일과 마지막 날짜를 시작일과 종료일로 지정합니다.
	      if( searchDTO.getStartDate() == null ) {
	         Date today = new Date(); 
	         Calendar calendar = Calendar.getInstance(); 
	         /*calendar.add(Calendar.DATE, -30); // 최근 30일
	         searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
	         searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));*/
	         
	           calendar.setTime(today);  
	           calendar.add(Calendar.MONTH, -1);
	           calendar.set(Calendar.DAY_OF_MONTH, 1);
	           searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 지난달 1일
	           
	           calendar.add(Calendar.MONTH, 1);
	           calendar.set(Calendar.DAY_OF_MONTH, 1);
	           calendar.add(Calendar.DATE, -1);  
	           searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 지난달 마지막 일자
	      }
	      model.addAttribute("searchDTO", searchDTO);
	      
	      // 지난달 1일부터 마지막 날까지 값
	      List<DailyCall> dailyLastMonthCallListForChart = dailyCallService.getDailyCallListForChart(searchDTO, "order by stat_time asc");
	      model.addAttribute("dailyLastMonthCallListForChart", dailyLastMonthCallListForChart);
	      
	      // 이번 달 1일부터 어제까지를 시작일과 종료일로 지정합니다.
	      Date today = new Date(); 
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(today);
	      calendar.add(Calendar.DATE, -1);
	      searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 어제 일자
	      calendar.set(Calendar.DAY_OF_MONTH, 1);
	      searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime())); // 이번 달 1일
	      
	      // 이번달 1일부터 어제까지 값
	      List<DailyCall> dailyCallListForChart = dailyCallService.getDailyCallListForChart(searchDTO, "order by stat_time asc");
	      model.addAttribute("dailyCallListForChart", dailyCallListForChart);
	      
	      searchDTO.setSearchIsAudit("1");
	      List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
	      model.addAttribute("agentList", agentList);
	      String agentIdList = "";
	      for (Agent agent : agentList) {
	         if (agentIdList != "") {
	            agentIdList += ",";
	         }
	         agentIdList += "'" + agent.getAgentId() + "'";
	         //logger.debug(agentIdList);
	      }
	      searchDTO.setSearchId(agentIdList);
	      
	      List<AgentCall> agentCallListForChart = agentCallService.getAgentCallListForChart(searchDTO, "order by agent_id asc");
	      model.addAttribute("agentCallListForChart", agentCallListForChart);
	      
	      List<CallAnalysis> agentDailyAngryCallForDashBoard = callAnalysisService.getAgentDailyAngryCallForDashBoard(null, searchDTO, "order by agent_id asc");
	      model.addAttribute("agentDailyAngryCallForDashBoard", agentDailyAngryCallForDashBoard);
	      
	      
	      
	      /*CPU*/
	      List<ProcessGroup> processList = processGroupService.getProcessGroupList(pageDTO, searchDTO, "order by update_time desc");
	      model.addAttribute("processList", processList);
	      
	      /*MEMORY*/
	      List<ProcessGroup> memoryList = processGroupService.getMemoryGroupList(pageDTO, searchDTO, "order by update_time desc");
	      model.addAttribute("memoryList", memoryList);
	      
	      /*DISK*/
	      List<ProcessGroup> diskList = processGroupService.getDiskGroupList(pageDTO, searchDTO, "order by update_time desc");
	      model.addAttribute("diskList", diskList);
	      
	      /*PROCESS*/
	      List<ProcessGroup> processList2 = processGroupService.getProcessList(pageDTO, searchDTO, "order by update_time desc");
	      model.addAttribute("processList2", processList2);
	      
	      /*프로세스 카운트*/
	      int processCount = processGroupService.countProcessList(searchDTO);
	      model.addAttribute("processCount", processCount);
	      
	      /*현재 알람 이력*/
	      List<AlarmStatGroup> alarmstatList = processGroupService.getAlarmStatList(pageDTO, searchDTO, "order by alarmed_time desc");
	      model.addAttribute("alarmstatList", alarmstatList);
	      
	      
	      /*현재 알람 이력 카운트*/
	      int alarmstatCount = processGroupService.countAlarmStatList(searchDTO);
	      model.addAttribute("alarmstatCount", alarmstatCount);
	      
	      /*Fault 알람 이력*/
	      List<FaultAlarmStatGroup> faultalarmstatList = processGroupService.getFaultAlarmStatList(pageDTO, searchDTO, "order by happened_time desc");
	      model.addAttribute("faultalarmstatList", faultalarmstatList);
	      
	      /*현재 알람 이력 카운트*/
	      int faultalarmstatCount = processGroupService.countFaultAlarmStatList(searchDTO);
	      model.addAttribute("faultalarmstatCount", faultalarmstatCount);
	      
	      HttpSession session = request.getSession();
	      
	      model.addAttribute("a_flag", (String)session.getAttribute("a_flag"));
	      model.addAttribute("a_date", (String)session.getAttribute("a_date"));
	      
	      return "main/main5"; 
	   }
	

	
	/**
	 * 대시보드에서 현재 콜 정보에 대한 처리한 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main/call_list_refresh", method = RequestMethod.GET)
	public String callListRefresh(Model model) {
		List<CallAudit> callAuditList = callAuditService.getCallAuditList(null, null, "order by agent_id asc");
		model.addAttribute("callAuditList", callAuditList);
		
		// 한계치 설정을 위한 값을 모델에 담습니다.
		Parameter systemParameter = parameterService.getParameter();
		model.addAttribute("angryCountParameter", systemParameter.getAngryCount());
		model.addAttribute("stressCountParameter", systemParameter.getStressCount());
		
		return "/main/call_list_refresh";
	}
	
	/**
	 * 대시보드에서 선택한 콜의 상세 정보 조회에 대한 처리한 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal로 표시되는 것이 원칙입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main/call_view/{agentId}", method = RequestMethod.GET)
	public String callViewModal(@PathVariable("agentId") String agentId, Model model) {
		CallAudit callAudit = callAuditService.getCallAudit(agentId);
		model.addAttribute("callAudit", callAudit);
		
		return "/main/call_view";
	}
	
	/**
	 * 대시보드::상담원 상세조회 화면에서 선택한 콜의 상세 정보 조회에 대한 처리한 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal로 표시되는 것이 원칙입니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main/call_view_agent/{index}", method = RequestMethod.GET)
	public String callViewAgentModal(@PathVariable("index") int index, Model model) {
		CallAnalysis callAnalysis = callAnalysisService.getCallAnalysis(index);
		model.addAttribute("callAnalysis", callAnalysis);
	
		return "/main/call_view_agent";
	}

	/**
	 * 실시간 콜 차트 정보 조회 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal 에서 표시하기 위해 사용합니다.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/main/call_view_refresh/{agentId}", method = RequestMethod.GET)
	public String callViewRefresh(@PathVariable("agentId") String agentId, Model model) {
		CallAudit callAudit = callAuditService.getCallAudit(agentId);
		model.addAttribute("callAudit", callAudit);
		
		// 데이터 숫자를 구하여 차트 label 개수를 동일하게 맞춰야, 차트 데이터를 모두 표시할 수 있습니다.
		int customerStateCount = 0;
		int agentStateCount = 0;
		int count = 0;
		String labelString = callAudit.getCustomerState();
		for (int i=0; i < labelString.length(); i++) {
			if (labelString.charAt(i) == ',') customerStateCount++;
		}
		labelString = callAudit.getAgentState();
		for (int i=0; i < labelString.length(); i++) {
			if (labelString.charAt(i) == ',') agentStateCount++;
		}
		if ( customerStateCount >= agentStateCount ) {
			count = customerStateCount;
		} else {
			count = agentStateCount;
		}
		
		labelString = "";
		for (int i=0; i < count; i++) {
			labelString += "\'\'" + ",";
		}
		labelString = "\'00:00\'," + labelString + "\'\'";
		model.addAttribute("labelString", labelString);
		
		return "/main/call_view_refresh";
	}
	
}
