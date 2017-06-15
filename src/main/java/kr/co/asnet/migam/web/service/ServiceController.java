package kr.co.asnet.migam.web.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.agent.ResourceLog;
import kr.co.asnet.migam.domain.config.Batch;
import kr.co.asnet.migam.domain.config.BatchHistory;
import kr.co.asnet.migam.domain.config.License;
import kr.co.asnet.migam.domain.config.Parameter;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.config.BatchHistoryService;
import kr.co.asnet.migam.service.config.BatchService;
import kr.co.asnet.migam.service.config.ParameterService;

/**
 * 시스템::서비스 설정 컨트롤러
 * 
 * @author kwonsy
 * 
 */
@Controller
@RequestMapping(value="/service")
public class ServiceController {
	private final Logger logger = LoggerFactory.getLogger(ServiceController.class);

	@Inject
	private ParameterService parameterService;
	@Inject
	private BatchService batchService;
	@Inject
	private BatchHistoryService batchHistoryService;
	@Inject
	private AgentGroupService agentGroupService;
	@Inject
	private AgentService agentService;

	@Inject
	private AlarmLimitService alarmLimitService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String main() {
		return "/service/index";
	}
	
	
	@RequestMapping(value = "/batch_list", method = RequestMethod.GET)
	public String batchList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<Batch> batchList = batchService.getBatchList15(pageDTO15, searchDTO, "order by idx desc");
			model.addAttribute("batchList", batchList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<Batch> batchList = batchService.getBatchList5(pageDTO5, searchDTO, "order by idx desc");
				model.addAttribute("batchList", batchList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<Batch> batchList = batchService.getBatchList(pageDTO, searchDTO, "order by idx desc");
				model.addAttribute("batchList", batchList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<Batch> batchList = batchService.getBatchList15(pageDTO15, searchDTO, "order by idx desc");
				model.addAttribute("batchList", batchList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) { 
				model.addAttribute("pageDTO", pageDTO25);
				List<Batch> batchList = batchService.getBatchList25(pageDTO25, searchDTO, "order by idx desc");
				model.addAttribute("batchList", batchList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<Batch> batchList = batchService.getBatchList50(pageDTO50, searchDTO, "order by idx desc");
				model.addAttribute("batchList", batchList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<Batch> batchList = batchService.getBatchList100(pageDTO100, searchDTO, "order by idx desc");
				model.addAttribute("batchList", batchList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<Batch> batchList = batchService.getBatchList15(pageDTO15, searchDTO, "order by idx desc");
				model.addAttribute("batchList", batchList);
			}
		}
		
		
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("batchCount", batchService.countBatchList(searchDTO));
		
		List<AgentGroup> agentGroupList = agentGroupService.getAgentGroupList(null, null, "order by group_name asc");
		model.addAttribute("agentGroupList", agentGroupList);
		if( searchDTO.getSearchGroup() != null ) {
			List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
			model.addAttribute("agentList", agentList);
		}
		
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( "yyyyMMddHHmmss", Locale.KOREA );
		Date currentTime = new Date ( );
		String mTime = mSimpleDateFormat.format ( currentTime );
		model.addAttribute("nowdate", mTime);
		
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "batch");
		model.addAttribute("menuCategory", "service");
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		return "/service/batch_list"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}

	@RequestMapping(value = "/batch_create", method = RequestMethod.GET)
	public String batchCreate(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO = new PageDTO(page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("menu", "batch_create");
		model.addAttribute("menuCategory", "service");
		return "/service/batch_create"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	@RequestMapping(value = "/batch_view", method = RequestMethod.GET)
	public String batchView(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO = new PageDTO(page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("menu", "batch");
		model.addAttribute("menuCategory", "service");
		return "/service/batch_view"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	@RequestMapping(value = "/batch_log", method = RequestMethod.GET)
	public String batchLog( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
			if( searchDTO.getStartDate() == null ) {
				Calendar calendar = Calendar.getInstance(); 
				calendar.add(Calendar.DATE, -1); // 최근 -1일
			
				searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
				//searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
		}
		
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList15(pageDTO15, searchDTO, "order by idx desc");
			model.addAttribute("batchHistoryList", batchHistoryList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList5(pageDTO5, searchDTO, "order by idx desc");
				model.addAttribute("batchHistoryList", batchHistoryList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList(pageDTO, searchDTO, "order by idx desc");
				model.addAttribute("batchHistoryList", batchHistoryList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList15(pageDTO15, searchDTO, "order by idx desc");
				model.addAttribute("batchHistoryList", batchHistoryList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) { 
				model.addAttribute("pageDTO", pageDTO25);
				List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList25(pageDTO25, searchDTO, "order by idx desc");
				model.addAttribute("batchHistoryList", batchHistoryList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList50(pageDTO50, searchDTO, "order by idx desc");
				model.addAttribute("batchHistoryList", batchHistoryList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList100(pageDTO100, searchDTO, "order by idx desc");
				model.addAttribute("batchHistoryList", batchHistoryList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList15(pageDTO15, searchDTO, "order by idx desc");
				model.addAttribute("batchHistoryList", batchHistoryList);
			}
		}
		
		
		
		
		
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("searchId", searchDTO.getSearchId());
		
		/*
		List<BatchHistory> batchHistoryList = batchHistoryService.getBatchHistoryList(pageDTO, searchDTO, "order by idx desc");
		model.addAttribute("batchHistoryList", batchHistoryList);
		*/
		model.addAttribute("batchHistoryCount", batchHistoryService.countBatchHistoryList(searchDTO));
		
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "batch_log");
		model.addAttribute("menuCategory", "service");
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		return "/service/batch_log"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	@RequestMapping(value = "/batch_edit", method = RequestMethod.GET)
	public String batchEdit(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO = new PageDTO(page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("menu", "batch");
		model.addAttribute("menuCategory", "service");
		return "/service/batch_edit"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	@RequestMapping(value = "/config_limit", method = RequestMethod.GET)
	public String configLimitForm(Model model) {
		
		Parameter recognitionParameter = parameterService.getParameter();
		model.addAttribute("recognitionParameter", recognitionParameter);
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setItemPerPage(10);
		List<Parameter> parameterHistoryList = parameterService.getParameterHistoryList(pageDTO, null, "order by insert_date desc");
		model.addAttribute("parameterHistoryList", parameterHistoryList);
		
		model.addAttribute("menu", "config");
		model.addAttribute("menuCategory", "service");
		return "/service/config_limit"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	@RequestMapping(value = "/config_limit", method = RequestMethod.POST)
	public String configLimit(Parameter parameter, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		parameterService.updateParameter(parameter);
		hislog.setDetail("[설정] Angry : ["+parameter.getCustomerAngry()+"] Stress : ["+parameter.getAgentStress()+"]"
				+ " Angry Count : ["+parameter.getAngryCount()+"] Stress Count : ["+parameter.getStressCount()+"]");
		hislog.setMenu("서비스 설정 > 임계치 설정[설정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		return ("redirect:/service/config_limit");
	}
}
