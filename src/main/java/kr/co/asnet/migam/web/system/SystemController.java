package kr.co.asnet.migam.web.system;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.AlarmLimit;
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.AnalResult;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmStatGroup;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.agent.AlarmStatGroup;
import kr.co.asnet.migam.domain.agent.ImsiMent;
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.ProcessGroup;
import kr.co.asnet.migam.domain.agent.Recognition_job;
import kr.co.asnet.migam.domain.agent.ResourceLog;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.SensConf;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.domain.agent.Voicefile;
import kr.co.asnet.migam.domain.config.License;
import kr.co.asnet.migam.domain.user.User;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmCodeService;
import kr.co.asnet.migam.service.agent.AlarmLimitService; 
import kr.co.asnet.migam.service.agent.AlarmLogService;
import kr.co.asnet.migam.service.agent.FaultAlarmLogService;
import kr.co.asnet.migam.service.agent.HisLogService;
import kr.co.asnet.migam.service.agent.ProConfService;
import kr.co.asnet.migam.service.agent.ProMetaService;
import kr.co.asnet.migam.service.agent.ProcessGroupService;
import kr.co.asnet.migam.service.agent.ResourceLogService;
import kr.co.asnet.migam.service.agent.SensBasicService;
import kr.co.asnet.migam.service.agent.SensConfService;
import kr.co.asnet.migam.service.agent.SensDemoService;
import kr.co.asnet.migam.service.agent.SensMetaService;
import kr.co.asnet.migam.service.config.LicenseService;
import kr.co.asnet.migam.service.user.UserService;

import java.net.InetAddress;  
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;


/**
 * 시스템::시스템 설정 컨트롤러
 * 
 * @author kwonsy
 * 
 */
@Controller
@RequestMapping("/system")
public class SystemController {
	private final Logger logger = LoggerFactory.getLogger(SystemController.class);
	@Inject
	private UserService userService;
	@Inject
	private AgentService agentService;
	@Inject 
	private AgentGroupService agentGroupService;
	@Inject
	private LicenseService licenseService;
	@Inject
	private ProcessGroupService processGroupService;
	@Inject
	private ResourceLogService resourceLogService;
	@Inject
	private AlarmLogService alarmLogService;
	@Inject
	private AlarmCodeService alarmCodeService;
	@Inject
	private AlarmLimitService alarmLimitService;
	@Inject
	private HisLogService hisLogService;
	@Inject
	private FaultAlarmLogService faultalarmLogService;
	@Inject
	private SensMetaService sensMetaService;
	@Inject
	private SensBasicService sensBasicService;
	@Inject
	private ProMetaService proMetaService;
	@Inject
	private SensConfService sensConfService;
	@Inject
	private ProConfService proConfService;
	@Inject
	private SensDemoService sensDemoService;	
	
    // 프로퍼티 객체 주입
    @Resource(name = "appProp")
    private Properties appProp;
	/**
	 * 시스템::시스템 설정::라이선스 설정
	 * 
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/license", method = RequestMethod.GET)
	public String systemLicense(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		License license = licenseService.getLicense();
		model.addAttribute("license", license);
		
		model.addAttribute("menu", "license");
		model.addAttribute("menuCategory", "system");
		return "/system/license";
	}
	
	/**
	 * 시스템::시스템 설정::라이선스 설정 변경
	 * 
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/license_update", method = RequestMethod.GET)
	public String licenseUpdateForm(Model model, SearchDTO searchDTO) {
		License license = licenseService.getLicense();		
		model.addAttribute("license", license);
		
		//실시간 대상 상담원 조회
		searchDTO.setSearchIsAudit("1");
		int auditCount = agentService.countAgentList(searchDTO);
		model.addAttribute("auditCount", auditCount);
		
		//비실시간 대상 상담원 조회
		searchDTO.setSearchIsAudit(null);
		searchDTO.setSearchIsAuditBatch("1");
		int auditBatchCount = agentService.countAgentList(searchDTO);
		model.addAttribute("auditBatchCount", auditBatchCount);
		
		model.addAttribute("menu", "license");
		model.addAttribute("menuCategory", "system");
		return "/system/license_update";
	}

	/**
	 * 라이선스 설정값 업데이트
	 * 
	 * @param license
	 * @param model
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/license_update", method = RequestMethod.POST)
	public String licenseUpdate(License license, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		licenseService.updateLicense(license);
		String realtime = "";
		String stress = "";
		
		if(license.getRealtimeService() == 1) {
			realtime = "실시간";
		}
		
		if(license.getNonrealtimeService() == 1) {
			realtime = "비실시간";
		}
		
		if(license.getRealtimeService() == 1 && license.getNonrealtimeService() == 1) {
			realtime = "실시간, 비실시간";
		}
		
		if(license.getAgentStress() == 1) {
			stress = "상담원";
		}
		
		if(license.getCustomerStress() == 1) {
			stress = "고객";
		}
		
		if(license.getAgentStress() == 1 && license.getCustomerStress() == 1) {
			stress = "상담원, 고객";
		}
		
		hislog.setDetail("[설정] 채널 라이선스 : ["+realtime+"] 실시간 분석채널 : ["+license.getRealtimeChannel()+"] 비실시간 분석채널 : ["+license.getNonrealtimeChannel()+"]"
				+ " 서비스별 라이선스 : ["+stress+"]");
		hislog.setMenu("서비스 설정 > 라이선스 설정[설정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog); 
		
		return String.format("/system/license");
	}
	
	/**
	 * 시스템::시스템 설정::사용자 목록
	 * 
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public String userList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO = new PageDTO(page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchDTO", searchDTO);
		List<User> userList = userService.getUserList(pageDTO, searchDTO, "order by n_index desc");
		model.addAttribute("userList", userList);
		model.addAttribute("userCount", userService.countUserList(searchDTO) );
		
		PageDTO pageDTOforLogin = new PageDTO();
		pageDTOforLogin.setItemPerPage(10);
		List<User> loginList = userService.getUserList(pageDTOforLogin, null, "order by d_visitdate desc");
		model.addAttribute("loginList", loginList);
		
		model.addAttribute("menu", "user");
		model.addAttribute("menuCategory", "system");
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		
		return "/system/user_list"; 
	}
	@RequestMapping(value = "/resource_log", method = RequestMethod.GET)
	public String resourceLog( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
			if( searchDTO.getStartDate() == null ) {
				Calendar calendar = Calendar.getInstance(); 
				calendar.add(Calendar.DATE, -1); // 최근 -1일
			
				searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
				searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}else {
				searchDTO.setStartDate(searchDTO.getStartDate() + " 00:00:00");
				searchDTO.setEndDate(searchDTO.getEndDate() + " 23:59:59");
			}
			
			if( searchDTO.getStartDate() != null ) {
				Calendar calendar = Calendar.getInstance(); 
				calendar.add(Calendar.DATE, -1); // 최근 -1일
			
				searchDTO.setStartDate(searchDTO.getStartDate() + " 00:00:00");
				searchDTO.setEndDate(searchDTO.getEndDate() + " 23:59:59");
			}else {
				searchDTO.setStartDate(searchDTO.getStartDate() + " 00:00:00");
				searchDTO.setEndDate(searchDTO.getEndDate() + " 23:59:59");
			}
		}else {
			searchDTO.setStartDate(searchDTO.getStartDate() + " 00:00:00");
			searchDTO.setEndDate(searchDTO.getEndDate() + " 23:59:59");
		}
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList15(pageDTO15, searchDTO, "order by update_time desc");
			model.addAttribute("resourceLogList", resourceLogList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList5(pageDTO5, searchDTO, "order by update_time desc");
				model.addAttribute("resourceLogList", resourceLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList(pageDTO, searchDTO, "order by update_time desc");
				model.addAttribute("resourceLogList", resourceLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList15(pageDTO15, searchDTO, "order by update_time desc");
				model.addAttribute("resourceLogList", resourceLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList25(pageDTO25, searchDTO, "order by update_time desc");
				model.addAttribute("resourceLogList", resourceLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList50(pageDTO50, searchDTO, "order by update_time desc");
				model.addAttribute("resourceLogList", resourceLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList100(pageDTO100, searchDTO, "order by update_time desc");
				model.addAttribute("resourceLogList", resourceLogList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<ResourceLog> resourceLogList = resourceLogService.getResourceLogList15(pageDTO15, searchDTO, "order by update_time desc");
				model.addAttribute("resourceLogList", resourceLogList);
			}
		}
		model.addAttribute("resourceLogCount", resourceLogService.countResourceLogList(searchDTO));
		model.addAttribute("searchDTO", searchDTO);
		
		/*List<ResourceLog> categoryList = resourceLogService.getCategoryList(pageDTO15, searchDTO, "order by category asc");
		model.addAttribute("categoryList", categoryList);
		
		List<ResourceLog> levelList = resourceLogService.getLevelList(pageDTO15, searchDTO, "order by alarm_lv asc");
		model.addAttribute("levelList", levelList);*/
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DATE, -1); // 최근 -1일
		searchDTO.setStartDate(searchDTO.getStartDate().substring(0,10));
		searchDTO.setEndDate(searchDTO.getEndDate().substring(0,10));
		
		model.addAttribute("listCount", 10);
		model.addAttribute("searchQuery", searchDTO.getSearchQuery());
		model.addAttribute("searchId", searchDTO.getSearchId());
		model.addAttribute("searchCondition", searchDTO.getSearchCondition());
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		model.addAttribute("menu", "resource");
		model.addAttribute("menuCategory", "system");
		return "/system/resource_log"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	@RequestMapping(value = "/alarm_log", method = RequestMethod.GET)
	public String alarmLog( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
			if( searchDTO.getStartDate() == null ) {
				Calendar calendar = Calendar.getInstance(); 
				calendar.add(Calendar.DATE, -1); // 최근 -1일
			
				searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
				searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
		}
		
		if( searchDTO.getSearchCondition() == null ) {
			searchDTO.setSearchCondition("");
		}
		
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("");
		}
		
		
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList15(pageDTO15, searchDTO, "order by alarmed_time desc");
			model.addAttribute("alarmLogList", alarmLogList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList5(pageDTO5, searchDTO, "order by alarmed_time desc");
				model.addAttribute("alarmLogList", alarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList(pageDTO, searchDTO, "order by alarmed_time desc");
				model.addAttribute("alarmLogList", alarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList15(pageDTO15, searchDTO, "order by alarmed_time desc");
				model.addAttribute("alarmLogList", alarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList25(pageDTO25, searchDTO, "order by alarmed_time desc");
				model.addAttribute("alarmLogList", alarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList50(pageDTO50, searchDTO, "order by alarmed_time desc");
				model.addAttribute("alarmLogList", alarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList100(pageDTO100, searchDTO, "order by alarmed_time desc");
				model.addAttribute("alarmLogList", alarmLogList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<AlarmLog> alarmLogList = alarmLogService.getAlarmLogList15(pageDTO15, searchDTO, "order by alarmed_time desc");
				model.addAttribute("alarmLogList", alarmLogList);
			}
		}
		
		model.addAttribute("searchDTO", searchDTO);
		
		model.addAttribute("alarmLogCount", alarmLogService.countAlarmLogList(searchDTO));
		
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "alarmLog");
		model.addAttribute("searchType", searchDTO.getSearchType());
		model.addAttribute("searchId", searchDTO.getSearchId());
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		model.addAttribute("menuCategory", "system");
		return "/system/alarm_log"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	@RequestMapping(value = "/fault_alarm_log", method = RequestMethod.GET)
	public String faultalarmLog( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
			if( searchDTO.getStartDate() == null ) {
				Calendar calendar = Calendar.getInstance(); 
				calendar.add(Calendar.DATE, -1); // 최근 -1일
			
				searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
				searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
		}
		
		if( searchDTO.getSearchCondition() == null ) {
			searchDTO.setSearchCondition("");
		}
		
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("");
		}
		
		PageDTO15 pageDTO15 = new PageDTO15(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList15(pageDTO15, searchDTO, "order by delete_time desc");
			model.addAttribute("faultalarmLogList", faultalarmLogList);
			searchDTO.setSearchBoardIndex("15");
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList5(pageDTO5, searchDTO, "order by delete_time desc");
				model.addAttribute("faultalarmLogList", faultalarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList(pageDTO, searchDTO, "order by delete_time desc");
				model.addAttribute("faultalarmLogList", faultalarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList15(pageDTO15, searchDTO, "order by delete_time desc");
				model.addAttribute("faultalarmLogList", faultalarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList25(pageDTO25, searchDTO, "order by delete_time desc");
				model.addAttribute("faultalarmLogList", faultalarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList50(pageDTO50, searchDTO, "order by delete_time desc");
				model.addAttribute("faultalarmLogList", faultalarmLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList100(pageDTO100, searchDTO, "order by delete_time desc");
				model.addAttribute("faultalarmLogList", faultalarmLogList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<FaultAlarmLog> faultalarmLogList = faultalarmLogService.getFaultAlarmLogList15(pageDTO15, searchDTO, "order by delete_time desc");
				model.addAttribute("faultalarmLogList", faultalarmLogList);
				searchDTO.setSearchBoardIndex("15");
			}
		}
		model.addAttribute("searchDTO", searchDTO);
		
		model.addAttribute("faultalarmLogCount", faultalarmLogService.countFaultAlarmLogList(searchDTO));
		
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "faultalarmLog");
		model.addAttribute("searchType", searchDTO.getSearchType());
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		model.addAttribute("menuCategory", "system");
		return "/system/fault_alarm_log"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}
	
	/*운영자 조작 이력*/
	@RequestMapping(value = "/his_log", method = RequestMethod.GET)
	public String hisLog( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){
		
		if( searchDTO.getStartDate() == null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.DATE, -1); // 최근 -1일
		
			searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
			searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		}
		if( searchDTO.getStartDate() != null ) {
			Calendar calendar = Calendar.getInstance(); 
			calendar.add(Calendar.DATE, -1); // 최근 -1일
		
			searchDTO.setStartDate(searchDTO.getStartDate() + " 00:00:00");
			searchDTO.setEndDate(searchDTO.getEndDate() + " 23:59:59");
		}
		
		if( searchDTO.getSearchId() == null ) {
			searchDTO.setSearchId("");
		}
		
		if( searchDTO.getSearchIndex() == null ) {
			searchDTO.setSearchIndex("");
		}
		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
		}
		
		if( searchDTO.getSearchGroup() == null ) {
			searchDTO.setSearchGroup("");
		}
		
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("");
		}
		
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<HisLog> hisLogList = hisLogService.getHisLogList15(pageDTO15, searchDTO, "order by change_date desc");
			model.addAttribute("hisLogList", hisLogList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<HisLog> hisLogList = hisLogService.getHisLogList5(pageDTO5, searchDTO, "order by change_date desc");
				model.addAttribute("hisLogList", hisLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<HisLog> hisLogList = hisLogService.getHisLogList(pageDTO, searchDTO, "order by change_date desc");
				model.addAttribute("hisLogList", hisLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<HisLog> hisLogList = hisLogService.getHisLogList15(pageDTO15, searchDTO, "order by change_date desc");
				model.addAttribute("hisLogList", hisLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<HisLog> hisLogList = hisLogService.getHisLogList25(pageDTO25, searchDTO, "order by change_date desc");
				model.addAttribute("hisLogList", hisLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<HisLog> hisLogList = hisLogService.getHisLogList50(pageDTO50, searchDTO, "order by change_date desc");
				model.addAttribute("hisLogList", hisLogList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<HisLog> hisLogList = hisLogService.getHisLogList100(pageDTO100, searchDTO, "order by change_date desc");
				model.addAttribute("hisLogList", hisLogList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<HisLog> hisLogList = hisLogService.getHisLogList15(pageDTO15, searchDTO, "order by change_date desc");
				model.addAttribute("hisLogList", hisLogList);
			}
		}
		model.addAttribute("searchDTO", searchDTO);
		model.addAttribute("hisLogCount", hisLogService.countHisLogList(searchDTO));
		
		Calendar calendar = Calendar.getInstance(); 
		calendar.add(Calendar.DATE, -1); // 최근 -1일
		searchDTO.setStartDate(searchDTO.getStartDate().substring(0,10));
		searchDTO.setEndDate(searchDTO.getEndDate().substring(0,10));
		
		List<HisLog> hisLogNameList = hisLogService.getHisLogNameList(pageDTO15, searchDTO, "order by user_id desc");
		model.addAttribute("hisLogNameList", hisLogNameList);
		
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "hisLog");
		model.addAttribute("searchType", searchDTO.getSearchType());
		model.addAttribute("searchId", searchDTO.getSearchId());
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		model.addAttribute("menuCategory", "system");
		return "/system/his_log"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
	}

	@RequestMapping(value = "/alarm_code", method = RequestMethod.GET)
	public String alarmCode(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList15(pageDTO15, searchDTO, "order by alarm_code asc");
			model.addAttribute("alarmList", alarmList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList5(pageDTO5, searchDTO, "order by alarm_code asc");
				model.addAttribute("alarmList", alarmList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList(pageDTO, searchDTO, "order by alarm_code asc");
				model.addAttribute("alarmList", alarmList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList15(pageDTO15, searchDTO, "order by alarm_code asc");
				model.addAttribute("alarmList", alarmList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList25(pageDTO25, searchDTO, "order by alarm_code asc");
				model.addAttribute("alarmList", alarmList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList50(pageDTO50, searchDTO, "order by alarm_code asc");
				model.addAttribute("alarmList", alarmList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList100(pageDTO100, searchDTO, "order by alarm_code asc");
				model.addAttribute("alarmList", alarmList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<AlarmCode> alarmList = alarmCodeService.getAlarmCodeList15(pageDTO15, searchDTO, "order by alarm_code asc");
				model.addAttribute("alarmList", alarmList);
			}
		}
		model.addAttribute("searchDTO", searchDTO);
		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
		}
		
		if( searchDTO.getSearchCondition() == null ) {
			searchDTO.setSearchCondition("");
		}
		
		if( searchDTO.getSearchType() == null ) {
			searchDTO.setSearchType("");
		}
		
		
		model.addAttribute("alarmCodeCount",alarmCodeService.countAlarmCodeList(searchDTO));
		
		model.addAttribute("listCount", 10);
		model.addAttribute("menu", "alarmCode");
		model.addAttribute("searchType", searchDTO.getSearchType());
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		model.addAttribute("menuCategory", "system");
		return "/system/alarm_code"; 
	}
		@RequestMapping(value = "/alarm_limit", method = RequestMethod.GET)
	   public String configLimitForm(@RequestParam(value = "page", required = false, defaultValue = "1")int page, Model model, SearchDTO searchDTO) {
		      PageDTO pageDTO = new PageDTO(page);
		      //AlarmLimit recognitionAlarmLimit = alarmLimitService.getAlarmLimit(idx);
		      //model.addAttribute("recognitionAlarmLimit", recognitionAlarmLimit);
		      
		      List<AlarmLimit> recognitionAlarmLimit = alarmLimitService.getAlarmLimitList(pageDTO, searchDTO, "order by alarm_idx desc");
		      model.addAttribute("recognitionAlarmLimit", recognitionAlarmLimit);
		      model.addAttribute("menu", "alarmLimit");
		      model.addAttribute("menuCategory", "system"); 
		      return "/system/alarm_limit"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		   }
		   
		   @RequestMapping(value = "/alarm_limit", method = RequestMethod.POST)
		   public String configLimit(AlarmLimit alarmLimit, Model model, SearchDTO searchDTO,HisLog hislog, String username, String userid, HttpServletRequest req ) throws UnknownHostException {
		      PageDTO pageDTO = new PageDTO(1);
		      InetAddress ip = InetAddress.getLocalHost(); 
		      model.addAttribute("alarmLmitIdx",alarmLimit);
		      
		      String[] array_idx = req.getParameterValues("idx");
		      String[] cri = req.getParameterValues("criticalValue");
		      String[] mj = req.getParameterValues("majorValue");
		      String[] mi = req.getParameterValues("minorValue");
		     
		      
		      for(int i = 0; i < array_idx.length; i++) {
		    	  
		    	  alarmLimit.setAlarmIdx(array_idx[i]);
		    	  alarmLimit.setCriticalValue(cri[i]);
		    	  alarmLimit.setMajorValue(mj[i]);
		    	  alarmLimit.setMinorValue(mi[i]);
		    	  
		    	  alarmLimitService.updateAlarmLimit(alarmLimit);
		      }
		      
		      String idx = "";
		     
		      if(alarmLimit.getAlarmIdx().equals("0")) {
		    	  idx = "CPU";
		      }else if(alarmLimit.getAlarmIdx().equals("1")) {
		    	  idx = "DISK";
		      }else {
		    	  idx = "MEMORY";
		      }
		      
		      hislog.setDetail("시스템  ["+idx+"] CRITICAL_VALUE ["+alarmLimit.getCriticalValue()+"]"
		      		+ " MAJOR_VALUE ["+alarmLimit.getMajorValue()+"] MINOR_VALUE ["+alarmLimit.getMinorValue()+"] 로 설정");
		      hislog.setMenu("시스템 설정 > 알람 임계치 설정");
		      hislog.setUser_id(userid);
		      hislog.setUser_ip(ip.getHostAddress());
		      hislog.setUser_name(username);
		      alarmLimitService.insertHis(hislog); 
		      
		      List<AlarmLimit> recognitionAlarmLimit = alarmLimitService.getAlarmLimitList(pageDTO, searchDTO, "order by alarm_idx desc");
		      
		      model.addAttribute("recognitionAlarmLimit", recognitionAlarmLimit);
		      model.addAttribute("menu", "alarmLimit");
		      model.addAttribute("menuCategory", "system");
		      
		      return "/system/alarm_limit";
		   }
	/**
	 * 시스템::시스템 설정::상담원 목록
	 * 검색이 없을 시(첫 페이지 로딩) getSearchQuery값을 ""으로 해야 전체 출력됩니다.
	 * sort는 실시간 / 비실시간 정렬을 위한 것 입니다.
	 * 
	 * @param page
	 * @param sort
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	@RequestMapping(value = "/agent_list", method = RequestMethod.GET)
	public String agentList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,@RequestParam(value = "sort", required = false, defaultValue = "0") int sort, Model model, SearchDTO searchDTO) {
		
		if( searchDTO.getSearchQuery() == null ) {
			searchDTO.setSearchQuery("");
		}
		
		if( searchDTO.getSearchGroup() == null ) {
			searchDTO.setSearchGroup("");
		}else{
			AgentGroup agentGroup = agentGroupService.getAgentGroup(searchDTO.getSearchGroup());
			
			if(agentGroup == null){
				model.addAttribute("groupName", "전체 그룹");
			}else{
				String groupName = agentGroup.getGroupName();
				model.addAttribute("groupName", groupName);
			}
		}
		//logger.debug(searchDTO.getSearchGroup());
		model.addAttribute("searchDTO", searchDTO);
		
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<Agent> agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by idx desc");
			if(sort == 1){
				searchDTO.setSearchIsAudit("1");
				pageDTO.setItemPerPage(100);
				agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by agent_name desc");
			}
			if(sort == 2){
				searchDTO.setSearchIsAuditBatch("1");
				pageDTO.setItemPerPage(100);
				agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by agent_name desc");
			}
			model.addAttribute("agentList", agentList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<Agent> agentList = agentService.getAgentList5(pageDTO5, searchDTO, "order by idx desc");
				if(sort == 1){
					searchDTO.setSearchIsAudit("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList5(pageDTO5, searchDTO, "order by agent_name desc");
				}
				if(sort == 2){
					searchDTO.setSearchIsAuditBatch("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList5(pageDTO5, searchDTO, "order by agent_name desc");
				}
				model.addAttribute("agentList", agentList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<Agent> agentList = agentService.getAgentList(pageDTO, searchDTO, "order by idx desc");
				if(sort == 1){
					searchDTO.setSearchIsAudit("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList(pageDTO, searchDTO, "order by agent_name desc");
				}
				if(sort == 2){
					searchDTO.setSearchIsAuditBatch("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList(pageDTO, searchDTO, "order by agent_name desc");
				}
				model.addAttribute("agentList", agentList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<Agent> agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by idx desc");
				if(sort == 1){
					searchDTO.setSearchIsAudit("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by agent_name desc");
				}
				if(sort == 2){
					searchDTO.setSearchIsAuditBatch("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by agent_name desc");
				}
				model.addAttribute("agentList", agentList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<Agent> agentList = agentService.getAgentList25(pageDTO25, searchDTO, "order by idx desc");
				if(sort == 1){
					searchDTO.setSearchIsAudit("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList25(pageDTO25, searchDTO, "order by agent_name desc");
				}
				if(sort == 2){
					searchDTO.setSearchIsAuditBatch("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList25(pageDTO25, searchDTO, "order by agent_name desc");
				}
				model.addAttribute("agentList", agentList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<Agent> agentList = agentService.getAgentList50(pageDTO50, searchDTO, "order by idx desc");
				if(sort == 1){
					searchDTO.setSearchIsAudit("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList50(pageDTO50, searchDTO, "order by agent_name desc");
				}
				if(sort == 2){
					searchDTO.setSearchIsAuditBatch("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList50(pageDTO50, searchDTO, "order by agent_name desc");
				}
				model.addAttribute("agentList", agentList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<Agent> agentList = agentService.getAgentList100(pageDTO100, searchDTO, "order by idx desc");
				if(sort == 1){
					searchDTO.setSearchIsAudit("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList100(pageDTO100, searchDTO, "order by agent_name desc");
				}
				if(sort == 2){
					searchDTO.setSearchIsAuditBatch("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList100(pageDTO100, searchDTO, "order by agent_name desc");
				}
				model.addAttribute("agentList", agentList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<Agent> agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by idx desc");
				if(sort == 1){
					searchDTO.setSearchIsAudit("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by agent_name desc");
				}
				if(sort == 2){
					searchDTO.setSearchIsAuditBatch("1");
					pageDTO.setItemPerPage(100);
					agentList = agentService.getAgentList15(pageDTO15, searchDTO, "order by agent_name desc");
				}
				model.addAttribute("agentList", agentList);
			}
		}

		
		
		
		model.addAttribute("sort", sort);
		
		model.addAttribute("agentCount", agentService.countAgentList(searchDTO) );
		model.addAttribute("pageDTO", pageDTO);
		searchDTO.setSearchIsAudit("0");
		searchDTO.setSearchIsAuditBatch("0");
		
		//실시간 모니터링 대상자 리스트
		searchDTO.setSearchIsAudit("1");
		List<Agent> LatestagentList = agentService.getLatestAgentList(searchDTO, "order by agent_name desc");
		model.addAttribute("LatestagentList", LatestagentList);
		
		List<AgentGroup> groupList = agentGroupService.getAgentGroupList(null, null, "order by group_id desc");
		model.addAttribute("groupList", groupList);
		
		List<AgentGroup> ProfileList = agentGroupService.getProfileList(null, null, "order by name asc");
		model.addAttribute("ProfileList", ProfileList);
		
		model.addAttribute("menu", "agent");
		model.addAttribute("menuCategory", "system");
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		
		return "/system/agent_list"; 
	}
	
	/**
	 * 상담원 아이디가 유용한지 확인하여 결과를 JSON을 반환합니다.  
	 * @param agentId
	 * @return
	 */
	@RequestMapping(value = "/isDuplicatedAgentId", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedAgentId(@RequestParam(value = "agentId") String agentId) {
		boolean result = false;
		if( agentService.isDuplicatedAgentId(agentId) ) result = false;
		else result = true;
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	/**
	 * 시스템::시스템 설정::그룹관리
	 * 상담원 등록, 삭제, 수정될 때  그룹 테이블 mecs5_agent_group.agent_count 값이 갱신됩니다. 이 부분은 DB 에서 트리거로 처리되어 있습니다.
	 * 
	 * @param page
	 * @param model
	 * @param searchDTO
	 * @return
	 */
	
	
	@RequestMapping(value = "/group_list", method = RequestMethod.GET)
	public String groupList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		
		PageDTO pageDTO15 = new PageDTO(page);
		PageDTO2 pageDTO = new PageDTO2(page);
		PageDTO5 pageDTO5 = new PageDTO5(page);
		PageDTO25 pageDTO25 = new PageDTO25(page);
		PageDTO50 pageDTO50 = new PageDTO50(page);
		PageDTO100 pageDTO100 = new PageDTO100(page);
		
		model.addAttribute("searchDTO", searchDTO);
		
		if(searchDTO.getSearchBoardIndex() == null) {
			model.addAttribute("pageDTO", pageDTO15);
			List<AgentGroup> groupList = agentGroupService.getAgentGroupList(pageDTO15, searchDTO, "order by group_id desc");
			model.addAttribute("groupList", groupList);
		}else {
			if(searchDTO.getSearchBoardIndex().equals("5")) {
				model.addAttribute("pageDTO", pageDTO5);
				List<AgentGroup> groupList = agentGroupService.getAgentGroupList5(pageDTO5, searchDTO, "order by group_id desc");
				model.addAttribute("groupList", groupList);
			}else if(searchDTO.getSearchBoardIndex().equals("10")) {
				model.addAttribute("pageDTO", pageDTO);
				List<AgentGroup> groupList = agentGroupService.getAgentGroupList10(pageDTO, searchDTO, "order by group_id desc");
				model.addAttribute("groupList", groupList);
			}else if(searchDTO.getSearchBoardIndex().equals("15")) {
				model.addAttribute("pageDTO", pageDTO15);
				List<AgentGroup> groupList = agentGroupService.getAgentGroupList(pageDTO15, searchDTO, "order by group_id desc");
				model.addAttribute("groupList", groupList);
			}else if(searchDTO.getSearchBoardIndex().equals("25")) {
				model.addAttribute("pageDTO", pageDTO25);
				List<AgentGroup> groupList = agentGroupService.getAgentGroupList25(pageDTO25, searchDTO, "order by group_id desc");
				model.addAttribute("groupList", groupList);
			}else if(searchDTO.getSearchBoardIndex().equals("50")) {
				model.addAttribute("pageDTO", pageDTO50);
				List<AgentGroup> groupList = agentGroupService.getAgentGroupList50(pageDTO50, searchDTO, "order by group_id desc");
				model.addAttribute("groupList", groupList);
			}else if(searchDTO.getSearchBoardIndex().equals("100")) {
				model.addAttribute("pageDTO", pageDTO100);
				List<AgentGroup> groupList = agentGroupService.getAgentGroupList100(pageDTO100, searchDTO, "order by group_id desc");
				model.addAttribute("groupList", groupList);
			}else {
				model.addAttribute("pageDTO", pageDTO15);
				List<AgentGroup> groupList = agentGroupService.getAgentGroupList(pageDTO15, searchDTO, "order by group_id desc");
				model.addAttribute("groupList", groupList);
			}
		}
		
		List<AgentGroup> ProfileList = agentGroupService.getProfileList(null, null, "order by name asc");
		model.addAttribute("ProfileList", ProfileList);
		
		model.addAttribute("menu", "group");
		model.addAttribute("menuCategory", "system");
		model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
		return "/system/group_list"; 
	}
	
	/*
	 * 시스템 > 시스템 설정 > 세그먼트 관리
	 * 테스트 예제입니다.
	 */
	@RequestMapping(value = "/segment_list", method = {RequestMethod.POST,RequestMethod.GET})
	public String segmentList(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		PageDTO pageDTO = new PageDTO(page);
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("searchDTO", searchDTO);
		
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
		
		/*fault 알람 이력*/
		List<FaultAlarmStatGroup> faultalarmstatList = processGroupService.getFaultAlarmStatList(pageDTO, searchDTO, "order by happened_time desc");
		model.addAttribute("faultalarmstatList", faultalarmstatList);
		
		/*fault 알람 이력 카운트*/
		int faultalarmstatCount = processGroupService.countFaultAlarmStatList(searchDTO);
		model.addAttribute("faultalarmstatCount", faultalarmstatCount);
		
		model.addAttribute("search_flag", "1");
		model.addAttribute("menu", "segment");
		model.addAttribute("menuCategory", "system");
		return "/system/segment_list";
	}
	
	 @RequestMapping(value = "/reqcount", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public int reqcount(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){   

	      PageDTO pageDTO = new PageDTO(page);
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);
	      

	      return processGroupService.countAlarmStatList(searchDTO);
	   }
	 
	 @RequestMapping(value = "/reqfcount", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public int reqfcount(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){   

	      PageDTO pageDTO = new PageDTO(page);
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);
	      

	      return processGroupService.countFaultAlarmStatList(searchDTO);
	   }
	
	 @RequestMapping(value = "/reqprocess", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public List<ProcessGroup> reqprocess(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){   

	      PageDTO pageDTO = new PageDTO(page);
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);
	      

	      return processGroupService.getProcessList(pageDTO, searchDTO, "order by update_time desc");
	   }
	   
	   @RequestMapping(value = "/reqdisk", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public List<ProcessGroup> reqdisk(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){   

	      PageDTO pageDTO = new PageDTO(page);
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);
	      
	      return processGroupService.getDiskGroupList(pageDTO, searchDTO, "order by update_time desc");
	   }
	   @RequestMapping(value = "/reqfaultalarm", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public List<FaultAlarmStatGroup> reqfaultalarm(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){   

	      PageDTO pageDTO = new PageDTO(page);
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);
	      

	      return processGroupService.getFaultAlarmStatList(pageDTO, searchDTO, "order by happened_time desc");
	   }
	   
	   @RequestMapping(value = "/reqcpu", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public List<ProcessGroup> reqcpu(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){   

	      PageDTO pageDTO = new PageDTO(page);
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);
	      

	      return processGroupService.getProcessGroupList(pageDTO, searchDTO, "order by update_time desc");
	   }
	   
	   @RequestMapping(value = "/reqalarm", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public List<AlarmStatGroup> reqalarm(@RequestParam(value = "page", required = false, defaultValue = "1")int page, Model model, SearchDTO searchDTO
			   , HttpServletRequest request, HttpServletResponse response) throws ParseException{   
		   PageDTO pageDTO = new PageDTO(page);
		 
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);

	      return processGroupService.getAlarmStatList(pageDTO, searchDTO, "order by alarmed_time desc");
	   }
	   

	   @RequestMapping(value = "/reqmemory", method = {RequestMethod.POST, RequestMethod.GET})   
	   @ResponseBody
	   public List<ProcessGroup> reqmemory(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO){   

	      PageDTO pageDTO = new PageDTO(page);
	      model.addAttribute("pageDTO", pageDTO);
	      model.addAttribute("searchDTO", searchDTO);
	      

	      return processGroupService.getMemoryGroupList(pageDTO, searchDTO, "order by update_time desc");
	   }
	   
	   /*보이스크림 감성지표 기초정보 설정*/
	   
	   @RequestMapping(value = "/sens_meta", method = RequestMethod.GET)
		public String sens_meta( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
			
			if( searchDTO.getSearchQuery() == null ) {
				searchDTO.setSearchQuery("");
				if( searchDTO.getStartDate() == null ) {
					Calendar calendar = Calendar.getInstance(); 
					calendar.add(Calendar.DATE, -1); // 최근 -1일
				
					searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
					searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				}
			}
			
			if( searchDTO.getSearchCondition() == null ) {
				searchDTO.setSearchCondition("");
			}
			
			if( searchDTO.getSearchType() == null ) {
				searchDTO.setSearchType("");
			}
			
			PageDTO15 pageDTO15 = new PageDTO15(page);
			PageDTO2 pageDTO = new PageDTO2(page);
			PageDTO5 pageDTO5 = new PageDTO5(page);
			PageDTO25 pageDTO25 = new PageDTO25(page);
			PageDTO50 pageDTO50 = new PageDTO50(page);
			PageDTO100 pageDTO100 = new PageDTO100(page);
			
			
			if(searchDTO.getSearchBoardIndex() == null) {
				model.addAttribute("pageDTO", pageDTO15);
				List<SensMeta> sensmetaList = sensMetaService.getSensMetaList15(pageDTO15, searchDTO, "order by svc_meta_idx desc");
				model.addAttribute("sensmetaList", sensmetaList);
				searchDTO.setSearchBoardIndex("15");
			}else {
				if(searchDTO.getSearchBoardIndex().equals("5")) {
					model.addAttribute("pageDTO", pageDTO5);
					List<SensMeta> sensmetaList = sensMetaService.getSensMetaList5(pageDTO5, searchDTO, "order by svc_meta_idx desc");
					model.addAttribute("sensmetaList", sensmetaList);
				}else if(searchDTO.getSearchBoardIndex().equals("10")) {
					model.addAttribute("pageDTO", pageDTO);
					List<SensMeta> sensmetaList = sensMetaService.getSensMetaList(pageDTO, searchDTO, "order by svc_meta_idx desc");
					model.addAttribute("sensmetaList", sensmetaList);
				}else if(searchDTO.getSearchBoardIndex().equals("15")) {
					model.addAttribute("pageDTO", pageDTO15);
					List<SensMeta> sensmetaList = sensMetaService.getSensMetaList15(pageDTO15, searchDTO, "order by svc_meta_idx desc");
					model.addAttribute("sensmetaList", sensmetaList);
				}else if(searchDTO.getSearchBoardIndex().equals("25")) {
					model.addAttribute("pageDTO", pageDTO25);
					List<SensMeta> sensmetaList = sensMetaService.getSensMetaList25(pageDTO25, searchDTO, "order by svc_meta_idx desc");
					model.addAttribute("sensmetaList", sensmetaList);
				}else if(searchDTO.getSearchBoardIndex().equals("50")) {
					model.addAttribute("pageDTO", pageDTO50);
					List<SensMeta> sensmetaList = sensMetaService.getSensMetaList50(pageDTO50, searchDTO, "order by svc_meta_idx desc");
					model.addAttribute("sensmetaList", sensmetaList);
				}else if(searchDTO.getSearchBoardIndex().equals("100")) {
					model.addAttribute("pageDTO", pageDTO100);
					List<SensMeta> sensmetaList = sensMetaService.getSensMetaList100(pageDTO100, searchDTO, "order by svc_meta_idx desc");
					model.addAttribute("sensmetaList", sensmetaList);
				}else {
					model.addAttribute("pageDTO", pageDTO15);
					List<SensMeta> sensmetaList = sensMetaService.getSensMetaList15(pageDTO15, searchDTO, "order by svc_meta_idx desc");
					model.addAttribute("sensmetaList", sensmetaList);
					searchDTO.setSearchBoardIndex("15");
				}
			}
			model.addAttribute("searchDTO", searchDTO);
			
			model.addAttribute("SensMetaCount", sensMetaService.countSensMetaList(searchDTO));
			List<SensMeta> svIndiList = sensMetaService.getSvIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("svIndiList", svIndiList);
			
			List<SensMeta> svIndiList_chk = sensMetaService.getSvIndiList_chk(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("svIndiList_chk", svIndiList_chk);
			
			List<SensMeta> IndiList = sensMetaService.getIndiList(pageDTO, searchDTO, "order by b.basic_idx desc");
			model.addAttribute("IndiList", IndiList);
			
			model.addAttribute("listCount", 10);
			model.addAttribute("searchType", searchDTO.getSearchType());
			model.addAttribute("searchId", searchDTO.getSearchId());
			model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
			model.addAttribute("menu", "sensmeta");
			model.addAttribute("menuCategory", "system");
			return "/system/sens_meta"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	   
	   @RequestMapping(value = "/sens_basic", method = RequestMethod.GET)
		public String sens_basic( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		   
		   if( searchDTO.getSearchQuery() == null ) {
				searchDTO.setSearchQuery("");
				if( searchDTO.getStartDate() == null ) {
					Calendar calendar = Calendar.getInstance(); 
					calendar.add(Calendar.DATE, -1); // 최근 -1일
				
					searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
					searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				}
			}
			
			if( searchDTO.getSearchCondition() == null ) {
				searchDTO.setSearchCondition("");
			}
			
			if( searchDTO.getSearchType() == null ) {
				searchDTO.setSearchType("");
			}
			
			PageDTO15 pageDTO15 = new PageDTO15(page);
			PageDTO2 pageDTO = new PageDTO2(page);
			PageDTO5 pageDTO5 = new PageDTO5(page);
			PageDTO25 pageDTO25 = new PageDTO25(page);
			PageDTO50 pageDTO50 = new PageDTO50(page);
			PageDTO100 pageDTO100 = new PageDTO100(page);
			
			
			if(searchDTO.getSearchBoardIndex() == null) {
				model.addAttribute("pageDTO", pageDTO15);
				List<SensBasic> sensbasicList = sensBasicService.getSensBasicList15(pageDTO15, searchDTO, "order by name desc");
				model.addAttribute("sensbasicList", sensbasicList);
				searchDTO.setSearchBoardIndex("15");
			}else {
				if(searchDTO.getSearchBoardIndex().equals("5")) {
					model.addAttribute("pageDTO", pageDTO5);
					List<SensBasic> sensbasicList = sensBasicService.getSensBasicList5(pageDTO5, searchDTO, "order by name asc");
					model.addAttribute("sensbasicList", sensbasicList);
				}else if(searchDTO.getSearchBoardIndex().equals("10")) {
					model.addAttribute("pageDTO", pageDTO);
					List<SensBasic> sensbasicList = sensBasicService.getSensBasicList(pageDTO, searchDTO, "order by name asc");
					model.addAttribute("sensbasicList", sensbasicList);
				}else if(searchDTO.getSearchBoardIndex().equals("15")) {
					model.addAttribute("pageDTO", pageDTO15);
					List<SensBasic> sensbasicList = sensBasicService.getSensBasicList15(pageDTO15, searchDTO, "order by name asc");
					model.addAttribute("sensbasicList", sensbasicList);
				}else if(searchDTO.getSearchBoardIndex().equals("25")) {
					model.addAttribute("pageDTO", pageDTO25);
					List<SensBasic> sensbasicList = sensBasicService.getSensBasicList25(pageDTO25, searchDTO, "order by name asc");
					model.addAttribute("sensbasicList", sensbasicList);
				}else if(searchDTO.getSearchBoardIndex().equals("50")) {
					model.addAttribute("pageDTO", pageDTO50);
					List<SensBasic> sensbasicList = sensBasicService.getSensBasicList50(pageDTO50, searchDTO, "order by name asc");
					model.addAttribute("sensbasicList", sensbasicList);
				}else if(searchDTO.getSearchBoardIndex().equals("100")) {
					model.addAttribute("pageDTO", pageDTO100);
					List<SensBasic> sensbasicList = sensBasicService.getSensBasicList100(pageDTO100, searchDTO, "order by name asc");
					model.addAttribute("sensbasicList", sensbasicList);
				}else {
					model.addAttribute("pageDTO", pageDTO15);
					List<SensBasic> sensbasicList = sensBasicService.getSensBasicList15(pageDTO15, searchDTO, "order by name asc");
					model.addAttribute("sensbasicList", sensbasicList);
					searchDTO.setSearchBoardIndex("15");
				}
			}
			model.addAttribute("searchDTO", searchDTO);
			
			model.addAttribute("SensBasicCount", sensBasicService.countSensBasicList(searchDTO));
			List<SensBasic> nameList = sensBasicService.getNameList(pageDTO, searchDTO, "order by name asc");
			model.addAttribute("nameList", nameList);
			
			model.addAttribute("listCount", 10);
			model.addAttribute("searchType", searchDTO.getSearchType());
			model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
			model.addAttribute("searchId", searchDTO.getSearchId());
		   
			model.addAttribute("menu", "sensbasic");
			model.addAttribute("menuCategory", "system");
			return "/system/sens_basic"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	   
	   
	   
	   
	   
	  /* 
	
	   @RequestMapping(value = "/selectSensConf", method = {RequestMethod.GET, RequestMethod.POST})
		public String selectSensConf( @RequestParam(value = "groupId", required = false, defaultValue = "1") String groupId,PageDTO pageDTO, Model model, SearchDTO searchDTO) {
		
		   
		   String[] array;
			array = groupId.split(",");
		   
		   searchDTO.setSearchQuery(array[0]);
		   searchDTO.setSearchId(array[1]);
		   
			List<SensConf> svIndiList = sensConfService.getSensConf(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("svIndiList", svIndiList);
			return "/system/sens_conf"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	         */
	   
	   
	   @RequestMapping(value = "/selectSensConf", method = {RequestMethod.POST, RequestMethod.GET})   
	      @ResponseBody
	      public List<Map> reqMent( @RequestParam(value = "groupId", required = false, defaultValue = "1") String groupId,PageDTO2 pageDTO, Model model, SearchDTO searchDTO, String Mentval) throws UnsupportedEncodingException {   
	 
		   String groupId_de = URLDecoder.decode(groupId,"UTF-8");
		   
	         String[] array;
				array = groupId_de.split(",");
			   
			   searchDTO.setSearchQuery(array[0]);
			   searchDTO.setSearchId(array[1]);
	         //List<SensConf> svIndiList = sensConfService.getSensConf(pageDTO, searchDTO, "order by name desc");
	         
	         List<SensConf> SensChkList = sensConfService.getSensChkList(pageDTO, searchDTO, "order by name desc");
				model.addAttribute("SensChkList", SensChkList);
	         
	         List<Map> Mentlist = new ArrayList<Map>();
	         	
	         for(int i=0;i< SensChkList.size();i++){
	        	 Map map = new HashMap();
	        		 map.put("name", array[0]);
	        		 map.put("emotion_level", array[1]);/*
	        		 map.put("kr_name", array[2]);*/
	        	 
	            map.put("max", SensChkList.get(i).getMax());
	            map.put("min", SensChkList.get(i).getMin());
	            map.put("description", SensChkList.get(i).getDescription());

	            map.put("basic_idx", SensChkList.get(i).getBasic_idx());
	            map.put("indi_name", SensChkList.get(i).getName());
	            map.put("indi_min", SensChkList.get(i).getIndi_min());
	            map.put("indi_max", SensChkList.get(i).getIndi_max());
	            map.put("b_max", SensChkList.get(i).getB_max());
	            map.put("b_min", SensChkList.get(i).getB_min());
	            
	            Mentlist.add(map);
	         }
	         return Mentlist;
	      }
	   
	   
	   
	   @RequestMapping(value = "/selectProConf", method = {RequestMethod.POST, RequestMethod.GET})   
	      @ResponseBody
	      public List<Map> selectProConf( @RequestParam(value = "groupId", required = false, defaultValue = "1") String groupId,PageDTO2 pageDTO, Model model, SearchDTO searchDTO, String Mentval) throws UnsupportedEncodingException {   
	         
		   String groupId_de = URLDecoder.decode(groupId,"UTF-8");
		   
	         String[] array;
				array = groupId_de.split(",");
				
				
			   searchDTO.setSearchQuery(array[0]);
			   searchDTO.setSearchId(array[1]);
			   searchDTO.setSearchCondition(array[2]);
	         //List<SensConf> svIndiList = sensConfService.getSensConf(pageDTO, searchDTO, "order by name desc");
	         
	         List<ProConf> ProChkList = proConfService.getProChkList_update(pageDTO, searchDTO, "order by name desc");
				model.addAttribute("ProChkList", ProChkList);
	         
	         List<Map> Mentlist = new ArrayList<Map>();
	         	
	         for(int i=0;i< ProChkList.size();i++){
	        	 Map map = new HashMap();
	        		 map.put("profile_idx", array[0]);
	        		 map.put("s_script", array[1]);
	        	 map.put("p_name", array[2]);
	        	 map.put("s_profile_idx", ProChkList.get(i).getS_profile_idx());
	            map.put("s_max", ProChkList.get(i).getS_max());
	            map.put("s_min", ProChkList.get(i).getS_min());
	            map.put("sv_max", ProChkList.get(i).getSv_max());
	            map.put("sv_min", ProChkList.get(i).getSv_min());
	            map.put("p_description", ProChkList.get(i).getP_description());
	            map.put("name", ProChkList.get(i).getName());
	            map.put("service_idx", ProChkList.get(i).getS_svc_meta_idx());
	            map.put("p_profile_idx", ProChkList.get(i).getP_profile_idx());
	            map.put("count", ProChkList.get(i).getCount());
	            
	            Mentlist.add(map);
	         }
	         return Mentlist;
	      }
	   
	   @RequestMapping(value = "/selectSvList", method = {RequestMethod.POST, RequestMethod.GET})   
	      @ResponseBody
	      public List<Map> selectSvList( @RequestParam(value = "name", required = false, defaultValue = "1") String name,PageDTO2 pageDTO, Model model, SearchDTO searchDTO, String Mentval) throws UnsupportedEncodingException {   
		   		String name_de = URLDecoder.decode(name,"UTF-8");
			   searchDTO.setSearchId(name_de);
	         //List<SensConf> svIndiList = sensConfService.getSensConf(pageDTO, searchDTO, "order by name desc");
	         
	         List<ProConf> ProChkList = proConfService.getProChkList(pageDTO, searchDTO, "order by name desc");
				model.addAttribute("ProChkList", ProChkList);
	         
	         List<Map> Mentlist = new ArrayList<Map>();
	         
	         for(int i=0;i< ProChkList.size();i++){
	            Map map = new HashMap();
	            map.put("service_idx", ProChkList.get(i).getService_idx());
	            map.put("name", ProChkList.get(i).getName());
	            map.put("sv_min", ProChkList.get(i).getSv_min());
	            map.put("sv_max", ProChkList.get(i).getSv_max());
	            Mentlist.add(map);
	         }
	         
	         return Mentlist;
	      }
	   
	   @RequestMapping(value = "/selectAgentProfileList", method = {RequestMethod.POST, RequestMethod.GET})   
	      @ResponseBody
	      public List<Map> selectAgentProfileList( @RequestParam(value = "name", required = false, defaultValue = "1") String name,PageDTO2 pageDTO, Model model, SearchDTO searchDTO, String Mentval) {   
	         
			   searchDTO.setSearchId(name);
	         //List<SensConf> svIndiList = sensConfService.getSensConf(pageDTO, searchDTO, "order by name desc");
	         
	         List<AgentGroup> ProChkList = agentGroupService.getAgentProfileList(pageDTO, searchDTO, "order by name desc");
				model.addAttribute("ProChkList", ProChkList);
	         
	         List<Map> Mentlist = new ArrayList<Map>();
	         
	         for(int i=0;i< ProChkList.size();i++){
	            Map map = new HashMap();
	            map.put("agent_profile_id", ProChkList.get(i).getAgent_profile_id());
	            map.put("customer_profile_id", ProChkList.get(i).getCustomer_profile_id());
	           /* map.put("service_idx", ProChkList.get(i).getService_idx());
	            map.put("name", ProChkList.get(i).getName());
	            map.put("sv_min", ProChkList.get(i).getSv_min());
	            System.out.println("aa:::" + ProChkList.get(i).getSv_min());
	            map.put("sv_max", ProChkList.get(i).getSv_max());*/
	            Mentlist.add(map);
	         }
	         
	         return Mentlist;
	      }
	   
	   @RequestMapping(value = "/selectSvList2", method = {RequestMethod.POST, RequestMethod.GET})   
	      @ResponseBody
	      public List<Map> selectSvList2( @RequestParam(value = "name", required = false, defaultValue = "1") String name,PageDTO2 pageDTO, Model model, SearchDTO searchDTO, String Mentval) throws UnsupportedEncodingException {   
		   String name_de = URLDecoder.decode(name,"UTF-8");
			   searchDTO.setSearchId(name_de);
	         //List<SensConf> svIndiList = sensConfService.getSensConf(pageDTO, searchDTO, "order by name desc");
	         
	         List<SensConf> ProChkList = sensConfService.getProChkList(pageDTO, searchDTO, "order by name desc");
				model.addAttribute("ProChkList", ProChkList);
	         
	         List<Map> Mentlist = new ArrayList<Map>();
	         
	         for(int i=0;i< ProChkList.size();i++){
	            Map map = new HashMap();
	            map.put("basic_idx", ProChkList.get(i).getBasic_idx());
	            map.put("b_name", ProChkList.get(i).getB_name());
	            map.put("min", ProChkList.get(i).getMin());
	            map.put("max", ProChkList.get(i).getMax());
	            map.put("b_min", ProChkList.get(i).getB_min());
	            map.put("b_max", ProChkList.get(i).getB_max());
	            Mentlist.add(map);
	         }
	         
	         return Mentlist;
	      }
	   
	   @RequestMapping(value = "/selectLevelList", method = {RequestMethod.POST, RequestMethod.GET})   
	      @ResponseBody
	      public List<Map> selectLevelList( @RequestParam(value = "name", required = false, defaultValue = "1") String name,PageDTO2 pageDTO, Model model, SearchDTO searchDTO, String Mentval) {   
	         
			   searchDTO.setSearchId(name);
	         //List<SensConf> svIndiList = sensConfService.getSensConf(pageDTO, searchDTO, "order by name desc");
	         
	         List<SensConf> LevelList = sensConfService.getLevelList(pageDTO, searchDTO, "order by emotion_level desc");
				model.addAttribute("LevelList", LevelList);
	         
	         List<Map> Mentlist = new ArrayList<Map>();
	         for(int i=0;i< LevelList.size();i++){
	            Map map = new HashMap();
	            	map.put("emotion_level", LevelList.get(i).getEmotion_level());
	            Mentlist.add(map);
	         }
	         
	         return Mentlist;
	      }
	   
	   @RequestMapping(value = "/sens_conf", method = RequestMethod.GET)
		public String sens_conf( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		   if( searchDTO.getSearchQuery() == null ) {
				searchDTO.setSearchQuery("");
				if( searchDTO.getStartDate() == null ) {
					Calendar calendar = Calendar.getInstance(); 
					calendar.add(Calendar.DATE, -1); // 최근 -1일
				
					searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
					searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				}
			}
			
			if( searchDTO.getSearchCondition() == null ) {
				searchDTO.setSearchCondition("");
			}
			
			if( searchDTO.getSearchType() == null ) {
				searchDTO.setSearchType("");
			}
			
			PageDTO15 pageDTO15 = new PageDTO15(page);
			PageDTO2 pageDTO = new PageDTO2(page);
			PageDTO5 pageDTO5 = new PageDTO5(page);
			PageDTO25 pageDTO25 = new PageDTO25(page);
			PageDTO50 pageDTO50 = new PageDTO50(page);
			PageDTO100 pageDTO100 = new PageDTO100(page);
			
			
			if(searchDTO.getSearchBoardIndex() == null) {
				model.addAttribute("pageDTO", pageDTO15);
				List<SensConf> sensconfList = sensConfService.getSensConfList15(pageDTO15, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
				model.addAttribute("sensconfList", sensconfList);
				searchDTO.setSearchBoardIndex("15");
			}else {
				if(searchDTO.getSearchBoardIndex().equals("5")) {
					model.addAttribute("pageDTO", pageDTO5);
					List<SensConf> sensconfList = sensConfService.getSensConfList5(pageDTO5, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
					model.addAttribute("sensconfList", sensconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("10")) {
					model.addAttribute("pageDTO", pageDTO);
					List<SensConf> sensconfList = sensConfService.getSensConfList(pageDTO, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
					model.addAttribute("sensconfList", sensconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("15")) {
					model.addAttribute("pageDTO", pageDTO15);
					List<SensConf> sensconfList = sensConfService.getSensConfList15(pageDTO15, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
					model.addAttribute("sensconfList", sensconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("25")) {
					model.addAttribute("pageDTO", pageDTO25);
					List<SensConf> sensconfList = sensConfService.getSensConfList25(pageDTO25, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
					model.addAttribute("sensconfList", sensconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("50")) {
					model.addAttribute("pageDTO", pageDTO50);
					List<SensConf> sensconfList = sensConfService.getSensConfList50(pageDTO50, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
					model.addAttribute("sensconfList", sensconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("100")) {
					model.addAttribute("pageDTO", pageDTO100);
					List<SensConf> sensconfList = sensConfService.getSensConfList100(pageDTO100, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
					model.addAttribute("sensconfList", sensconfList);
				}else {
					model.addAttribute("pageDTO", pageDTO15);
					List<SensConf> sensconfList = sensConfService.getSensConfList15(pageDTO15, searchDTO, "ORDER BY NAME ASC, emotion_level ASC");
					model.addAttribute("sensconfList", sensconfList);
					searchDTO.setSearchBoardIndex("15");
				}
			}
			model.addAttribute("searchDTO", searchDTO);
			
			model.addAttribute("SensConfCount", sensConfService.countSensConfList(searchDTO));
			List<SensConf> svIndiList = sensConfService.getSvIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("svIndiList", svIndiList);
			
			List<SensConf> IndiList = sensConfService.getIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("IndiList", IndiList);
			
			
			model.addAttribute("listCount", 10);
			model.addAttribute("searchType", searchDTO.getSearchType());
			model.addAttribute("searchId", searchDTO.getSearchId());
			model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
			model.addAttribute("menu", "sensconf");
			model.addAttribute("menuCategory", "system");
			return "/system/sens_conf"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	   @RequestMapping(value = "/pro_meta", method = RequestMethod.GET)
		public String pro_meta( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
			
			if( searchDTO.getSearchQuery() == null ) {
				searchDTO.setSearchQuery("");
				if( searchDTO.getStartDate() == null ) {
					Calendar calendar = Calendar.getInstance(); 
					calendar.add(Calendar.DATE, -1); // 최근 -1일
				
					searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
					searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				}
			}
			
			if( searchDTO.getSearchCondition() == null ) {
				searchDTO.setSearchCondition("");
			}
			
			if( searchDTO.getSearchType() == null ) {
				searchDTO.setSearchType("");
			}
			
			PageDTO15 pageDTO15 = new PageDTO15(page);
			PageDTO2 pageDTO = new PageDTO2(page);
			PageDTO5 pageDTO5 = new PageDTO5(page);
			PageDTO25 pageDTO25 = new PageDTO25(page);
			PageDTO50 pageDTO50 = new PageDTO50(page);
			PageDTO100 pageDTO100 = new PageDTO100(page);
			
			
			if(searchDTO.getSearchBoardIndex() == null) {
				model.addAttribute("pageDTO", pageDTO15);
				List<ProMeta> prometaList = proMetaService.getProMetaList15(pageDTO15, searchDTO, "order by profile_meta_idx desc");
				model.addAttribute("prometaList", prometaList);
				searchDTO.setSearchBoardIndex("15");
			}else {
				if(searchDTO.getSearchBoardIndex().equals("5")) {
					model.addAttribute("pageDTO", pageDTO5);
					List<ProMeta> prometaList = proMetaService.getProMetaList5(pageDTO5, searchDTO, "order by profile_meta_idx desc");
					model.addAttribute("prometaList", prometaList);
				}else if(searchDTO.getSearchBoardIndex().equals("10")) {
					model.addAttribute("pageDTO", pageDTO);
					List<ProMeta> prometaList = proMetaService.getProMetaList(pageDTO, searchDTO, "order by profile_meta_idx desc");
					model.addAttribute("prometaList", prometaList);
				}else if(searchDTO.getSearchBoardIndex().equals("15")) {
					model.addAttribute("pageDTO", pageDTO15);
					List<ProMeta> prometaList = proMetaService.getProMetaList15(pageDTO15, searchDTO, "order by profile_meta_idx desc");
					model.addAttribute("prometaList", prometaList);
				}else if(searchDTO.getSearchBoardIndex().equals("25")) {
					model.addAttribute("pageDTO", pageDTO25);
					List<ProMeta> prometaList = proMetaService.getProMetaList25(pageDTO25, searchDTO, "order by profile_meta_idx desc");
					model.addAttribute("prometaList", prometaList);
				}else if(searchDTO.getSearchBoardIndex().equals("50")) {
					model.addAttribute("pageDTO", pageDTO50);
					List<ProMeta> prometaList = proMetaService.getProMetaList50(pageDTO50, searchDTO, "order by profile_meta_idx desc");
					model.addAttribute("prometaList", prometaList);
				}else if(searchDTO.getSearchBoardIndex().equals("100")) {
					model.addAttribute("pageDTO", pageDTO100);
					List<ProMeta> prometaList = proMetaService.getProMetaList100(pageDTO100, searchDTO, "order by profile_meta_idx desc");
					model.addAttribute("prometaList", prometaList);
				}else {
					model.addAttribute("pageDTO", pageDTO15);
					List<ProMeta> prometaList = proMetaService.getProMetaList15(pageDTO15, searchDTO, "order by profile_meta_idx desc");
					model.addAttribute("prometaList", prometaList);
					searchDTO.setSearchBoardIndex("15");
				}
			}
			model.addAttribute("searchDTO", searchDTO);
			
			model.addAttribute("ProMetaCount", proMetaService.countProMetaList(searchDTO));
			List<ProMeta> svIndiList = proMetaService.getSvIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("svIndiList", svIndiList);
			
			List<ProMeta> IndiList = proMetaService.getIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("IndiList", IndiList);
			
			model.addAttribute("listCount", 10);
			model.addAttribute("searchType", searchDTO.getSearchType());
			model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
			model.addAttribute("searchId", searchDTO.getSearchId());
			model.addAttribute("menu", "prometa");
			model.addAttribute("menuCategory", "system");
			return "/system/pro_meta"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	   @RequestMapping(value = "/pro_conf", method = RequestMethod.GET)
		public String pro_conf( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO) {
		   if( searchDTO.getSearchQuery() == null ) {
				searchDTO.setSearchQuery("");
				if( searchDTO.getStartDate() == null ) {
					Calendar calendar = Calendar.getInstance(); 
					calendar.add(Calendar.DATE, -1); // 최근 -1일
				
					searchDTO.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
					searchDTO.setEndDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				}
			}
			
			if( searchDTO.getSearchCondition() == null ) {
				searchDTO.setSearchCondition("");
			}
			
			if( searchDTO.getSearchType() == null ) {
				searchDTO.setSearchType("");
			}
			
			PageDTO15 pageDTO15 = new PageDTO15(page);
			PageDTO2 pageDTO = new PageDTO2(page);
			PageDTO5 pageDTO5 = new PageDTO5(page);
			PageDTO25 pageDTO25 = new PageDTO25(page);
			PageDTO50 pageDTO50 = new PageDTO50(page);
			PageDTO100 pageDTO100 = new PageDTO100(page);
			
			
			if(searchDTO.getSearchBoardIndex() == null) {
				model.addAttribute("pageDTO", pageDTO15);
				List<ProConf> proconfList = proConfService.getProConfList15(pageDTO15, searchDTO, "order by d.PROFILE_IDX desc");
				model.addAttribute("proconfList", proconfList);
				searchDTO.setSearchBoardIndex("15");
			}else {
				if(searchDTO.getSearchBoardIndex().equals("5")) {
					model.addAttribute("pageDTO", pageDTO5);
					List<ProConf> proconfList = proConfService.getProConfList5(pageDTO5, searchDTO, "order by d.PROFILE_IDX desc");
					model.addAttribute("proconfList", proconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("10")) {
					model.addAttribute("pageDTO", pageDTO);
					List<ProConf> proconfList = proConfService.getProConfList(pageDTO, searchDTO, "order by d.PROFILE_IDX desc");
					model.addAttribute("proconfList", proconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("15")) {
					model.addAttribute("pageDTO", pageDTO15);
					List<ProConf> proconfList = proConfService.getProConfList15(pageDTO15, searchDTO, "order by d.PROFILE_IDX desc");
					model.addAttribute("proconfList", proconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("25")) {
					model.addAttribute("pageDTO", pageDTO25);
					List<ProConf> proconfList = proConfService.getProConfList25(pageDTO25, searchDTO, "order by d.PROFILE_IDX desc");
					model.addAttribute("proconfList", proconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("50")) {
					model.addAttribute("pageDTO", pageDTO50);
					List<ProConf> proconfList = proConfService.getProConfList50(pageDTO50, searchDTO, "order by d.PROFILE_IDX desc");
					model.addAttribute("proconfList", proconfList);
				}else if(searchDTO.getSearchBoardIndex().equals("100")) {
					model.addAttribute("pageDTO", pageDTO100);
					List<ProConf> proconfList = proConfService.getProConfList100(pageDTO100, searchDTO, "order by d.PROFILE_IDX desc");
					model.addAttribute("proconfList", proconfList);
				}else {
					model.addAttribute("pageDTO", pageDTO15);
					List<ProConf> proconfList = proConfService.getProConfList15(pageDTO15, searchDTO, "order by d.PROFILE_IDX desc");
					model.addAttribute("proconfList", proconfList);
					searchDTO.setSearchBoardIndex("15");
				}
			}
			model.addAttribute("searchDTO", searchDTO);
			
			model.addAttribute("SensConfCount", proConfService.countProConfList(searchDTO));
			List<ProConf> proNameList = proConfService.getProNameList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("proNameList", proNameList);
			
			List<ProConf> IndiList = proConfService.getIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("IndiList", IndiList);
			
			
			model.addAttribute("listCount", 10);
			model.addAttribute("searchType", searchDTO.getSearchType());
			model.addAttribute("searchId", searchDTO.getSearchId());
			model.addAttribute("searchBoardIndex", searchDTO.getSearchBoardIndex());
			model.addAttribute("menu", "proconf");
			model.addAttribute("menuCategory", "system");
			return "/system/pro_conf"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	   @RequestMapping(value = "/sens_demo", method = {RequestMethod.GET, RequestMethod.POST})
		public String sens_demo( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, PageDTO2 pageDTO) {
			List<ProMeta> IndiList = proMetaService.getIndiList(pageDTO, searchDTO, "order by name desc");
			
			// to get rid of service ind for demo except Angry, Stress [24 Nov 17 IOS]
			List<ProMeta> IndListTemp = IndiList.subList(2,  4);
			model.addAttribute("IndiList", IndListTemp);
			
			
			//model.addAttribute("IndiList", IndiList);
			model.addAttribute("menu", "prometa");
			model.addAttribute("menuCategory", "system");
			return "/system/sens_demo"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	   @RequestMapping(value = "/voiceCream_demo", method = {RequestMethod.GET, RequestMethod.POST})
		public String voiceCream_demo( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, PageDTO2 pageDTO) {
			List<ProMeta> IndiList = proMetaService.getIndiList(pageDTO, searchDTO, "order by name desc");
			
			// to get rid of service ind for demo except Angry, Stress [1 Dec 17 IOS]
			model.addAttribute("IndiList", IndiList.subList(2, 4));
			//model.addAttribute("IndiList", IndiList);			
			return "/demo/voiceCream_demo"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
		}
	   
	   
	   @RequestMapping(value = "/sens_demo_act", method = RequestMethod.POST)
		public String sens_demo_act(PageDTO2 pageDTO,SearchDTO searchDTO,HttpServletRequest request, HttpServletResponse response,MultipartHttpServletRequest reqm, String svr_array, Model model) throws UnsupportedEncodingException, FileUploadException {   
		   request.setCharacterEncoding("utf-8");
		   MultipartFile uploadfile = reqm.getFile("wavfile");
		    Voicefile voicefile = new Voicefile();
            Recognition_job recognition_job = new Recognition_job();
            
            
	        if (uploadfile != null) {
	            String fileName = uploadfile.getOriginalFilename();
	            String soxfilename="";
	
	            try {
	                // 1. FileOutputStream 사용
	                // byte[] fileData = file.getBytes();
	                // FileOutputStream output = new FileOutputStream("C:/images/" + fileName);
	                // output.write(fileData);

	            	GregorianCalendar today = new GregorianCalendar();
	            	SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
	            	Calendar cal = Calendar.getInstance();
	            	Calendar calendarNow = Calendar.getInstance();
	            	String tri_time="";
	            	String mm="", dd="", hh="", mi=""; 
	            	int year = today.get ( today.YEAR );
	            	int month = today.get ( today.MONTH )+1 ;
	            	int date = today.get ( today.DATE ) ;
	            	int hour = today.get ( today.HOUR_OF_DAY );
	            	int minute = today.get ( today.MINUTE );
	           
	            	if(month < 10) mm = "0"+ String.valueOf(month) ; else mm =String.valueOf(month); 
	            	if(date < 10) dd = "0"+ String.valueOf(date);else dd =String.valueOf(date); 
	            	if(hour < 10) hh = "0"+ String.valueOf(hour);else hh =String.valueOf(hour); 
	            	if(minute < 10) mi = "0"+ String.valueOf(minute);else mi =String.valueOf(minute); 
	            	
	            	// 5초 더하기
	            //	cal.add(Calendar.SECOND, 5);
	            	  
	            	tri_time = sdformat.format(cal.getTime());  
	            	//System.out.println("70초 후 : " + tri_time);
	
	            	File file = new File("C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/" + fileName);
                    if(!file.exists()){
                        //디렉토리 생성 메서드
                        file.mkdirs();
                        System.out.println("created directory successfully!");
                    }
                    uploadfile.transferTo(file);
	                    
                    soxfilename = "sox_"+fileName;
                    Runtime rt = Runtime.getRuntime();
	                     
	                     // IOS
	                     /*경로바꾸기*/
	                     //로컬
	                     //String exeFile = "C:/Users/in.lee/workspace/projects/M-ERS/src/main/sox-14.2.0/sox "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;
	                     //TB
	                     //String exeFile = "C:/tomcat/webapps/src_20161102_mers/sox-14.2.0/sox "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;
	                     
	                     // TM presentation
	                     // String exeFile = "C:/tomcat/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16/webapps/mers/sox-14.2.0/sox "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;

                     String soxdir = appProp.getProperty("sox.dir");
                     String exeFile = soxdir+" "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;
             
                     Process p;
                                  
                     try {
                         p = rt.exec(exeFile);
                         p.waitFor();
                         file.delete();
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
	       
	                 voicefile.setCall_id("WEB_"+sdformat.format(calendarNow.getTime()));
	                 voicefile.setCall_type("1");
	                 voicefile.setRealtimeness("0");
	                 voicefile.setBm_agent("1");
	                 voicefile.setBm_customer("0");
	                 voicefile.setAgent_voice_filename("C:\\home\\mecs\\PSNR\\record\\"+year+"\\"+mm+"\\"+dd+"\\"+hh+"\\" + soxfilename);
	                 voicefile.setAgent_emo_profile(svr_array);
	                 voicefile.setEmtion_analysis_state("0");
	                 
	                 sensDemoService.insertVoicefile(voicefile);
	                 
	                 recognition_job.setJob_id("WEB_"+sdformat.format(calendarNow.getTime()));  // call_id = job_id
	                 recognition_job.setStart_time(sdformat.format(calendarNow.getTime()));
	                 recognition_job.setEnd_time(year+mm+dd);
	                 
	                 
	                Calendar aa = Calendar.getInstance();
		            // (2) 출력 형태를 지정하기 위해 Formatter를 얻는다.
		            SimpleDateFormat sdf1 = new SimpleDateFormat("HHmmss");
		            // (3) 출력형태에 맞는 문자열을 얻는다.
		            String datetime1 = sdf1.format(aa.getTime());
		              
	                Calendar cal2 = Calendar.getInstance();
	              	int tri_hh = cal.get(cal2.HOUR_OF_DAY);
	            	int tri_mi = cal.get(cal2.MINUTE);
	            	int tri_ss = cal.get(cal2.SECOND);
	            	String tri_hhstr="", tri_mistr="", tri_ssstr="";
	            	if(tri_hh < 10) tri_hhstr = "0"+ String.valueOf(tri_hh);else tri_hhstr =String.valueOf(tri_hh); 
	            	if(tri_mi < 10) tri_mistr = "0"+ String.valueOf(tri_mi);else tri_mistr =String.valueOf(tri_mi); 
	            	if(tri_ss < 10) tri_ssstr = "0"+ String.valueOf(tri_ss);else tri_ssstr =String.valueOf(tri_ss); 
	            	
	            	String tri_sum=tri_hhstr+tri_mistr+tri_ssstr;
	            	
		             recognition_job.setJob_trigger_time(datetime1);
	                 recognition_job.setRecord_start_time(hh+mi);
	                 recognition_job.setRecord_end_time(hh+mi);
	                 recognition_job.setDay_repeat("0");
	                 recognition_job.setStatus("0");
	                 
	                 sensDemoService.insertRecognition_job(recognition_job);
	                 
	            } catch (IOException e) {
	                e.printStackTrace();
	            } // try - catch
	        } // if
				List<ProMeta> IndiList = proMetaService.getIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("IndiList", IndiList);
		    model.addAttribute("call_id", voicefile.getCall_id());
			model.addAttribute("result_flag", "1");
		    return "/system/sens_demo";
		}
	   
	   @RequestMapping(value = "/voiceCream_demo_act", method = RequestMethod.POST)
		public String voiceCream_demo_act(PageDTO2 pageDTO,SearchDTO searchDTO,HttpServletRequest request, HttpServletResponse response,MultipartHttpServletRequest reqm, String svr_array, Model model) throws UnsupportedEncodingException, FileUploadException {   
		   request.setCharacterEncoding("utf-8");
		   MultipartFile uploadfile = reqm.getFile("wavfile");
		    Voicefile voicefile = new Voicefile();
           Recognition_job recognition_job = new Recognition_job();
           
	        if (uploadfile != null) {
	            String fileName = uploadfile.getOriginalFilename();
	            String soxfilename="";
	
	            try {
	                // 1. FileOutputStream 사용
	                // byte[] fileData = file.getBytes();
	                // FileOutputStream output = new FileOutputStream("C:/images/" + fileName);
	                // output.write(fileData);

	            	GregorianCalendar today = new GregorianCalendar();
	            	SimpleDateFormat sdformat = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
	            	Calendar cal = Calendar.getInstance();
	            	Calendar calendarNow = Calendar.getInstance();
	            	String tri_time="";
	            	String mm="", dd="", hh="", mi=""; 
	            	int year = today.get ( today.YEAR );
	            	int month = today.get ( today.MONTH )+1 ;
	            	int date = today.get ( today.DATE ) ;
	            	int hour = today.get ( today.HOUR_OF_DAY );
	            	int minute = today.get ( today.MINUTE );
	           
	            	if(month < 10) mm = "0"+ String.valueOf(month) ; else mm =String.valueOf(month); 
	            	if(date < 10) dd = "0"+ String.valueOf(date);else dd =String.valueOf(date); 
	            	if(hour < 10) hh = "0"+ String.valueOf(hour);else hh =String.valueOf(hour); 
	            	if(minute < 10) mi = "0"+ String.valueOf(minute);else mi =String.valueOf(minute); 
	            	
	            	// 5초 더하기
	            //	cal.add(Calendar.SECOND, 5);
	            	  
	            	tri_time = sdformat.format(cal.getTime());  
	            	//System.out.println("70초 후 : " + tri_time);
	            	
	   
	            	File file = new File("C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/" + fileName);
	                   if(!file.exists()){
	                       //디렉토리 생성 메서드
	                       file.mkdirs();
	                       System.out.println("created directory successfully!");
	                   }
	                    uploadfile.transferTo(file);
	                    
	                    
	                    
	                     soxfilename = "sox_"+fileName;
	                     Runtime rt = Runtime.getRuntime();
	                     

	                     // IOS
	                     /*경로바꾸기*/
	                     //String exeFile = "C:/Users/in.lee/workspace/projects/M-ERS/src/main/sox-14.2.0/sox "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;
	                     //TB
	                     //String exeFile = "C:/tomcat/webapps/src_20161102_mers/sox-14.2.0/sox "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;
	                     
	                     // TM presentation
	//                     String exeFile = "C:/tomcat/apache-tomcat-8.5.16-windows-x64/apache-tomcat-8.5.16/webapps/mers/sox-14.2.0/sox "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;
	                     

	                     String soxdir = appProp.getProperty("sox.dir");
	                     String exeFile = soxdir+" "+file+" -b 16 -r 8000 -c 1 "+"C:/home/mecs/PSNR/record/"+year+"/"+mm+"/"+dd+"/"+hh+"/"+soxfilename;
 

	                     Process p;
	                                  
	                     try {
	                         p = rt.exec(exeFile);
	                         p.waitFor();
	                         file.delete();
	                     } catch (Exception e) {
	                         e.printStackTrace();
	                     }
	                     
	       
	                 voicefile.setCall_id("WEB_"+sdformat.format(calendarNow.getTime()));
	                 voicefile.setCall_type("1");
	                 voicefile.setRealtimeness("0");
	                 voicefile.setBm_agent("1");
	                 voicefile.setBm_customer("0");
	                 voicefile.setAgent_voice_filename("C:\\home\\mecs\\PSNR\\record\\"+year+"\\"+mm+"\\"+dd+"\\"+hh+"\\" + soxfilename);
	                 voicefile.setAgent_emo_profile(svr_array);
	                 voicefile.setEmtion_analysis_state("0");
	                 
	                 sensDemoService.insertVoicefile(voicefile);
	                 
	                 recognition_job.setJob_id("WEB_"+sdformat.format(calendarNow.getTime()));  // call_id = job_id
	                 recognition_job.setJob_name("WEB_"+sdformat.format(calendarNow.getTime()));  // call_id = job_id
	                 recognition_job.setStart_time(sdformat.format(calendarNow.getTime()));
	                 recognition_job.setEnd_time(year+mm+dd);
	                 
	                 Calendar aa = Calendar.getInstance();
	                 // (2) 출력 형태를 지정하기 위해 Formatter를 얻는다.
	                 SimpleDateFormat sdf1 = new SimpleDateFormat("HHmmss");
	                 // (3) 출력형태에 맞는 문자열을 얻는다.
	                 String datetime1 = sdf1.format(aa.getTime());
	              
	                 Calendar cal2 = Calendar.getInstance();
		             int tri_hh = cal.get(cal2.HOUR_OF_DAY);
		             int tri_mi = cal.get(cal2.MINUTE);
		             int tri_ss = cal.get(cal2.SECOND);
		             String tri_hhstr="", tri_mistr="", tri_ssstr="";
		             if(tri_hh < 10) tri_hhstr = "0"+ String.valueOf(tri_hh);else tri_hhstr =String.valueOf(tri_hh); 
		             if(tri_mi < 10) tri_mistr = "0"+ String.valueOf(tri_mi);else tri_mistr =String.valueOf(tri_mi); 
		             if(tri_ss < 10) tri_ssstr = "0"+ String.valueOf(tri_ss);else tri_ssstr =String.valueOf(tri_ss); 
		            	
		            	String tri_sum=tri_hhstr+tri_mistr+tri_ssstr;
	                 recognition_job.setJob_trigger_time(datetime1);
	                 recognition_job.setRecord_start_time(hh+mi);
	                 recognition_job.setRecord_end_time(hh+mi);
	                 recognition_job.setDay_repeat("0");
	                 recognition_job.setStatus("0");
	                 
	                 sensDemoService.insertRecognition_job(recognition_job);
	                 
	            } catch (IOException e) {
	                e.printStackTrace();
	            } // try - catch
	        }else{// if
	        }
				List<ProMeta> IndiList = proMetaService.getIndiList(pageDTO, searchDTO, "order by name desc");
			model.addAttribute("IndiList", IndiList);
		    model.addAttribute("call_id", voicefile.getCall_id());
			model.addAttribute("result_flag", "1");
		    return "/demo/voiceCream_demo";
		}
	   
		@RequestMapping(value = "/reqMent", method = {RequestMethod.POST, RequestMethod.GET})	
		@ResponseBody
		public List<Map> reqMent( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, String Mentval) {	
			PageDTO pageDTO = new PageDTO(page);
			searchDTO.setSearchQuery(Mentval);
		   List<ImsiMent> ImsimentList = sensDemoService.getImsiMentList(pageDTO, searchDTO, "order by ment desc");
			
			
			
			List<Map> Mentlist = new ArrayList<Map>();
			
			for(int i=0;i< ImsimentList.size();i++){
				Map map = new HashMap();
				map.put("ment1", ImsimentList.get(i).getMent());
		
			
				
				Mentlist.add(map);
			}
			
			return Mentlist;
		} 
		
		@RequestMapping(value = "/sens_resultCnt", method = {RequestMethod.POST, RequestMethod.GET})	
		@ResponseBody
		public int sens_resultCnt( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, String call_id) {	
			PageDTO pageDTO = new PageDTO(page);
			searchDTO.setSearchQuery(call_id);
		   int sens_resultcnt = sensDemoService.countAgentList(searchDTO);
		   return sens_resultcnt;
		}
		
		@RequestMapping(value = "/sens_failcode", method = {RequestMethod.POST, RequestMethod.GET})	
		@ResponseBody
		public int sens_failcode( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, String call_id) {	
			PageDTO pageDTO = new PageDTO(page);
			searchDTO.setSearchQuery(call_id);
		   /*minju add*/
		   int failcode = sensDemoService.countAgentFailCode(searchDTO);
		   /*minju add*/
		  
		   return failcode;
		}
		

	      @RequestMapping(value = "linegraph", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	       public @ResponseBody String linegraph( @RequestParam(value = "page", required = false, defaultValue = "1") int page,SearchDTO searchDTO, Locale locale, Model model,String call_id) {
	           Gson gson = new Gson();
	           
	           PageDTO pageDTO = new PageDTO(page);
	           searchDTO.setSearchQuery(call_id);
			   List<AnalResult> AnlResultList = sensDemoService.getAnalResultList(pageDTO, searchDTO, "order by indicator_name desc");
	            List<Map> hashlist = new ArrayList<Map>();
			   String indicator_name = "";
			   String indicator_end_pos = "";
			   String indicator_result ="";
			   DecimalFormat format = new DecimalFormat("#");
		          
			   for(int i=0;i< AnlResultList.size();i++){

					indicator_name = AnlResultList.get(i).getIndicator_name();
					indicator_end_pos = AnlResultList.get(i).getIndicator_end_pos();
					indicator_result = AnlResultList.get(i).getIndicator_result();
			
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
	                hashmap = new HashMap();
	                hashmap.put("name", indicator_name);
	                hashmap.put("data", postime);
	                hashlist.add(hashmap);
		       
		         
				}

	           return gson.toJson(hashlist);
	       }
	      
	      
	      @RequestMapping(value = "linegraph_csv", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	       public @ResponseBody String linegraph_csv( @RequestParam(value = "page", required = false, defaultValue = "1") int page,SearchDTO searchDTO, Locale locale, Model model,String call_id) {
	           Gson gson = new Gson();
	           
	           PageDTO pageDTO = new PageDTO(page);
	           searchDTO.setSearchQuery(call_id);
			   List<AnalResult> AnlResultList = sensDemoService.getAnalResultList(pageDTO, searchDTO, "order by indicator_name desc");
	            List<Map> hashlist = new ArrayList<Map>();
			   String indicator_name = "";
			   String indicator_end_pos = "";
			   String indicator_start_pos = "";
			   String indicator_result ="";
			   DecimalFormat format = new DecimalFormat("#");
		          
			   for(int i=0;i< AnlResultList.size();i++){

					indicator_name = AnlResultList.get(i).getIndicator_name();
					indicator_start_pos = AnlResultList.get(i).getIndicator_start_pos();
					indicator_end_pos = AnlResultList.get(i).getIndicator_end_pos();
					indicator_result = AnlResultList.get(i).getIndicator_result();
			
			        String indicator_result_sub[] = indicator_result.split(",");
			        String start_posbtime[] = indicator_start_pos.split(",");
			        String end_posbtime[] = indicator_end_pos.split(",");

			        int[] indicator_result_sub2 = new int[indicator_result_sub.length];
					

			        double[] indicator_result_sub3 = new double[indicator_result_sub.length];
			        int[] start_postime_sub2 = new int[start_posbtime.length];
		            int[] end_postime_sub2 = new int[end_posbtime.length];
		            
		            Object[] startpostime = new Object[start_posbtime.length];
		            Object[] endpostime = new Object[end_posbtime.length];
		            Object[] indicator_result_obj = new Object[indicator_result_sub.length];
		            
		            for(int j = 0; j<indicator_result_sub.length; j++){
		            	  String str_start = format.format(Double.parseDouble(start_posbtime[j]));
		                  String str = format.format(Double.parseDouble(end_posbtime[j]));
		                 
		                  start_postime_sub2[j] =  Integer.parseInt(str_start) ;
		                  end_postime_sub2[j] =  Integer.parseInt(str) ;
		                  indicator_result_sub2[j] = Integer.parseInt(indicator_result_sub[j]);

		                  Object[] startpostime2 ={start_postime_sub2[j]}; 
		                  Object[] endpostime2 ={end_postime_sub2[j]}; 
		                  Object[] indicator_result_sub4 ={indicator_result_sub2[j]}; 
		                  
		                  startpostime[j] = startpostime2;
		                  endpostime[j] = endpostime2;
		                  indicator_result_obj[j] = indicator_result_sub4;
		                
		            }
		            

		        	
		        	HashMap hashmap = new HashMap();
	                hashmap = new HashMap();
	                hashmap.put("a", indicator_name);
	             //   hashmap.put("b", startpostime);
	              //  hashmap.put("c", endpostime);
	                hashmap.put("d", indicator_result_obj);
	                hashlist.add(hashmap);
		       
		         
				}

	           return gson.toJson(hashlist);
	       }
	      
	      
	      @RequestMapping(value = "circle", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	       public @ResponseBody String circle(@RequestParam(value = "page", required = false, defaultValue = "1") int page,SearchDTO searchDTO, Locale locale, Model model,String call_id) {
	           Gson gson = new Gson();
	           
	           PageDTO pageDTO = new PageDTO(page);
	           searchDTO.setSearchQuery(call_id);
			   List<AnalResult> AnlResultList = sensDemoService.getAnalResultList(pageDTO, searchDTO, "order by indicator_name desc");
	            List<Map> hashlist = new ArrayList<Map>();
			   String indicator_name = "";
			   String indicator_result ="";
			   DecimalFormat format = new DecimalFormat("#");
		         Object[] obj = new Object[AnlResultList.size()];
		       int indicator_result_sum=0;
			   for(int i=0;i< AnlResultList.size();i++){

					indicator_name = AnlResultList.get(i).getIndicator_name();
					indicator_result = AnlResultList.get(i).getIndicator_result();
					
					 String indicator_result_sub[] = indicator_result.split(",");
					 
					  for(int j = 0; j<indicator_result_sub.length; j++){
						  indicator_result_sum += Integer.parseInt(indicator_result_sub[j].toString());
					  }
					  Object[] obj2 = {indicator_name,indicator_result_sum};
					  indicator_result_sum=0;
					  obj[i] = obj2;
			   }
			   Object[] mj = {obj};
			
	           
	           
	           return gson.toJson(mj);
	       }
	      
	      
	      
	      
	      
		   @RequestMapping(value = "/demo_excel", method = {RequestMethod.GET, RequestMethod.POST})
			public String demo_excel( @RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model, SearchDTO searchDTO, PageDTO2 pageDTO, String excel_call_id) {
				//List<ProMeta> IndiList = proMetaService.getIndiList(pageDTO, searchDTO, "order by name desc");
				model.addAttribute("call_id", excel_call_id);
				return "/system/demo_excel"; //메인페이지가 완성되지 않아 임시 주석처리합니다.
			}
		   
	      
	      /*csv*/
	      @RequestMapping(value = "demo_excel_act", method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
          public @ResponseBody String demo_excel_act( @RequestParam(value = "page", required = false, defaultValue = "1") int page,SearchDTO searchDTO, Locale locale, Model model,String call_id) {
              Gson gson = new Gson();
              
              PageDTO pageDTO = new PageDTO(page);
               searchDTO.setSearchQuery(call_id);
            List<ImsiMent> ExceliList = sensDemoService.gettdemo_excel(pageDTO, searchDTO, "order by name desc");
            
               List<Map> hashlist = new ArrayList<Map>();
               String dname = "";
               String resutlval = "";
               Object[] obj = new Object[ExceliList.size()];
               Object[] mj = new Object[ExceliList.size()];
               DecimalFormat format = new DecimalFormat("#.00");
               for(int i=0;i< ExceliList.size();i++){
                  dname = ExceliList.get(i).getDname();
                  resutlval = ExceliList.get(i).getResultval();
                  
                  
                  
                   String resutlval_sub[] = resutlval.split(",");
                //   double resutlval_sub2 =0.00;
                   String resutlval_sub2="0.00";
                   String[] resultstr = new String[resutlval_sub.length+1];
                  /*  for(int j = 0; j<resutlval_sub.length+1; j++){

                        if(j == 0){
                        	if(dname.equals("start_pos")) {
                        		resultstr[0] = "Start Pos";
                        	}else if(dname.equals("end_pos")) {
                        		resultstr[0] = "End Pos";
                        	}else {
                        		resultstr[0] = String.valueOf(dname);
                        	}
                        }else{
                         //  resutlval_sub2 = Double.parseDouble(resutlval_sub[j-1].toString());
                           resutlval_sub2 =String.valueOf(resutlval_sub[j-1].toString());
                           resultstr[j] = String.valueOf(resutlval_sub2);
                        }
                       
                    }*/
                   
                   for(int j = 0; j<resutlval_sub.length+1; j++){

                       if(j == 0){
                          if(dname.equals("start_pos")){
                             resultstr[0] = "Start Pos";
                          }else if(dname.equals("end_pos")){
                             resultstr[0] = "End Pos";
                          }else{
                             resultstr[0] = String.valueOf(dname);
                          }  
                       }else{
                          if(i==0){
                             resutlval_sub2= String.valueOf(j);
                          }else{
                             resutlval_sub2 = String.valueOf(resutlval_sub[j-1].toString());
                          }
                          resultstr[j] = String.valueOf(resutlval_sub2);
                       }
                      
                   }
               

      
               /*
                 HashMap hashmap = new HashMap();
                   hashmap = new HashMap();
                   hashmap.put("aname", dname);
                   hashmap.put("bdata", resutlval);
                   hashlist.add(hashmap);
             */
                    mj[i] = resultstr;
               
            }
               
              return gson.toJson(mj);
          }
         
		
}
