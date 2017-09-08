package kr.co.asnet.migam.web.REST;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.config.License;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.call.CallAuditService;
import kr.co.asnet.migam.service.config.LicenseService;

/**
 * 상담원 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/agent")
public class AgentREST {
	private final Logger logger = LoggerFactory.getLogger(AgentREST.class);

	@Autowired
	private AgentService agentService;
	
	@Autowired
	private CallAuditService callAuditService;
	@Autowired
	private AlarmLimitService alarmLimitService;
	@Inject
	private LicenseService licenseService;

	/*
	 * Representative creation
	 */
    @RequestMapping(value="/repr", method = RequestMethod.POST)
    public ResponseEntity<Void> repr(@RequestBody Agent agent, HisLog hislog/*String agentInfo*/) throws UnknownHostException {
        /*
         * SQL 확인
         * DB table colomn name과 아래와 같이 다르게 등록되어 있음
         * agent-mapper.xml 'insertAgent'
         */
//        agent.setProfile_name_agent("2k_상담원스트레스");
//        agent.setProfile_name_cus("2k_고객감정");
    	
    	final HttpHeaders headers = new HttpHeaders();
    	
    	
        agent.setGroupName("2k");
        agent.setGroupId("2k");
        agent.setProfile_name_agent("7");
        agent.setProfile_name_cus("6");
        agent.setIsAudit(1);
        
        logger.debug(agent.toString());
        InetAddress ip = InetAddress.getLocalHost();
        int agentIndex = 0;
        int agentchanged = 0;
        try {
        	agentIndex = agentService.insertAgent(agent);
        	agentchanged = agentService.insertAgentChanged(agent);
        } catch (Exception e)  {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        hislog.setDetail("[등록] 상담원ID(이름) : ["+agent.getAgentId()+"("+agent.getAgentName()+")]");
        hislog.setMenu("시스템 설정 > 상담원 목록[등록]");
        hislog.setUser_id("admin");
        hislog.setUser_ip(ip.getHostAddress());
        hislog.setUser_name("2k");
        alarmLimitService.insertHis(hislog);
        
        //모니터링 대상여부 확인
        //int    intcallAudit = 1;
        //if(agent.getIsAudit() == 1){
        int    intcallAudit = callAuditService.insertCallAudit(agent.getAgentId(),agent.getGroupId(),0);
        //}
        
        if(agentIndex > 0 && intcallAudit != 0) {
            return new ResponseEntity<Void>(headers, HttpStatus.OK);
            //return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    }

	/**
	 * 사용자 아이디가 유용한지 확인하여 결과를 JSON을 반환합니다.  
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
	 * 새로운 상담원 정보를 DB에 추가하기 위한 엔드포인트 입니다. 
	 * @param agent
	 * @param model
	 * @return
	 *  성공하면, agent정보를 JSON형태로 반환합니다.
	 * 모니터링 대상 여부(실시간/비실시간 - agent.getIsAudit())에 의해 callAudit이 저장됩니다.
	 * 저장된 값이 없기때문에, callAudit저장만 일어나므로 intcallAudit이 0이 아니면 agent를 반환한다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/createAgent", method = RequestMethod.POST)
	public ResponseEntity<Agent> createAgent(Agent agent, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		
		int agentIndex = agentService.insertAgent(agent);
		int agentchanged = agentService.insertAgentChanged(agent);
		
		hislog.setDetail("[등록] 상담원ID(이름) : ["+agent.getAgentId()+"("+agent.getAgentName()+")]");
		hislog.setMenu("시스템 설정 > 상담원 목록[등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		//모니터링 대상여부 확인
		int	intcallAudit = 1;
		if(agent.getIsAudit() == 1){
			intcallAudit = callAuditService.insertCallAudit(agent.getAgentId(),agent.getGroupId(),0);
		}
		
		if(agentIndex > 0 && intcallAudit != 0) {
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		} else {
			return new ResponseEntity<Agent>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 주어진 인덱스에 해당하는 상담원 정보를 가져오기 위한 엔드포인트입니다.
	 * @param agentIndex
	 * @param model
	 * @return
	 *  성공하면 Agent객체를 반환하고, 실패하면 NULL을 반환합니다.
	 */
	@RequestMapping(value = "/selectAgent/{index}", method = RequestMethod.GET)
	public ResponseEntity<Agent> selectAgent(@PathVariable("index") int agentIndex, Model model) {
		Agent agent = agentService.getAgent(agentIndex);
		if(agent!=null) {
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		} else {
			return new ResponseEntity<Agent>(HttpStatus.NO_CONTENT);
		}
	}
	
	
	@RequestMapping(value="/repr", produces="text/plain;charset=UTF-8", method=RequestMethod.GET)
	public @ResponseBody String getAgent(SearchDTO searchDTO, HisLog hislog) throws UnknownHostException  {
		JSONArray jArray = new JSONArray();
		
		List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name  asc");
		
		if(agentList != null) {
			for (int i=0; i < agentList.size(); i++)  {
				JSONObject jTmp = new JSONObject();
				
				jTmp.put("agentId",  agentList.get(i).getAgentId());
				jTmp.put("agentName", agentList.get(i).getAgentName());
				jTmp.put("agentIp", agentList.get(i).getAgentIp());
				jTmp.put("agentNumber", agentList.get(i).getAgentNumber());

				jArray.add(jTmp);
			}
			return jArray.toString();
		} else {
			return "NO_CONTENT";
		}
	}
	
	@RequestMapping(value="/repr/{agentId}", produces="text/plain;charset=UTF-8", method=RequestMethod.GET)
	public @ResponseBody String getAgentById(@PathVariable("agentId") String agentId, HisLog hislog) throws UnknownHostException  {
		Agent agent = agentService.getAgent(agentId);
		
		if(agent != null) {
			JSONObject jTmp = new JSONObject();
			
			//jTmp.put("agentId",  agent.getAgentId());
			jTmp.put("agentName", agent.getAgentName());
			jTmp.put("agentIp", agent.getAgentIp());
			jTmp.put("agentNumber", agent.getAgentNumber());

			return jTmp.toString();
		} else {
			return "NO_CONTENT";
		}
	}
	/*
	 * patch API design 
	 */
	@RequestMapping(value = "/repr/{agentId}", method = RequestMethod.PATCH)
	public ResponseEntity<Agent> patchAgent(@PathVariable("agentId") String agentId, @RequestBody Agent agent, Model model, SearchDTO searchDTO,HisLog hislog) throws UnknownHostException {
		int updateCount = 0;
		int returncheck = 0;
		int agentchanged = 0;

		InetAddress ip = InetAddress.getLocalHost();
		CallAudit callAudit = callAuditService.getCallAudit(agentId);
		License license = licenseService.getLicense();
		
		// because of being called structure IOS
		agent.setAgentId(agentId);
		
		//실시간 선택 시 
		int	intcallAudit = 1;
		searchDTO.setSearchIsAudit("1");
		//int auditCount = agentService.countAgentList(searchDTO);
		//if(license.getRealtimeChannel() > auditCount){
			if(callAudit == null){
				intcallAudit = callAuditService.insertCallAudit(agent.getAgentId(),agent.getGroupId(),0);
			}else{
				intcallAudit = 1;
			}
			returncheck = 1;
			updateCount = agentService.updateAgentById(agent);
			// realtime_state update
			callAuditService.patchCallAudit(agent);
			agentchanged = agentService.insertAgentChanged(agent);
		//}
		
		hislog.setDetail("[수정] 상담원ID(이름) : ["+agent.getAgentId()+"("+agent.getAgentName()+")"+"] "
				+ "그룹ID(이름) : ["+agent.getGroupId()+"("+agent.getGroupName()+")] 내선번호 : ["+agent.getAgentNumber()+"] IP : ["+agent.getAgentIp()+"]"
						+ " 비실시간 모니터링 대상 여부 : ["+"실시간"+"]");
		hislog.setMenu("시스템 설정 > 상담원 목록[수정]");
		hislog.setUser_id("admin");
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name("2k");
		alarmLimitService.insertHis(hislog);
		
		if(returncheck == 1){
			if(updateCount > 0 && intcallAudit != 0) {
				return new ResponseEntity<Agent>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Agent>(HttpStatus.NO_CONTENT);
				//return 0;
			}
		}else{
			return new ResponseEntity<Agent>(HttpStatus.NOT_MODIFIED);
		}
	}
	
	
	/**
	 * 주어진 상담원 정보에 따라 해당 상담원 정보를 업데이트하기 위한 엔드포인트입니다.
	 * @param agent
	 * @param model
	 * @return
	 *  성공하면 1을 반환하고, 라이선스 채널수를 모두 사용중이면 2를 반환하고, 등록에 실패하면 0을 반환합니다. 
	 * 모니터링 대상 여부(실시간/비실시간 - agent.getIsAudit())에 의해 callAudit이 저장되고 삭제됩니다.
	 * getIsAudit(),getIsAuditBatch()이 1이라고해도, 수정이 없을 수도 있기 때문에, 먼저 select해서 값이 있는지 확인합니다. 
	 * select이 없을 시 수정 시 오류가 발생합니다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/updateAgent", method = RequestMethod.POST)
	public int updateAgent(Agent agent, Model model, SearchDTO searchDTO,HisLog hislog, String username, String userid) throws UnknownHostException {
		int updateCount = 0;
		int returncheck = 0;
		int agentchanged = 0;
		InetAddress ip = InetAddress.getLocalHost();
		CallAudit callAudit = callAuditService.getCallAudit(agent.getAgentId());
		License license = licenseService.getLicense();
		
		//실시간 선택 시 
		int	intcallAudit = 1;
		searchDTO.setSearchIsAudit("1");
		int auditCount = agentService.countAgentList(searchDTO);
		if(license.getRealtimeChannel() > auditCount && agent.getIsAudit() == 1){
			if(callAudit == null){
				intcallAudit = callAuditService.insertCallAudit(agent.getAgentId(),agent.getGroupId(),0);
			}else{
				intcallAudit = 1;
			}
			returncheck = 1;
			updateCount = agentService.updateAgent(agent);
			agentchanged = agentService.insertAgentChanged(agent);
		}
		
		//비실시간 선택 시		
		searchDTO.setSearchIsAudit(null);
		searchDTO.setSearchIsAuditBatch("1");
		int auditBatchCountCheck = agentService.countAgentList(searchDTO);
		if(license.getNonrealtimeChannel() > auditBatchCountCheck && agent.getIsAuditBatch() == 1){
			if(callAudit != null){
				intcallAudit = callAuditService.deleteCallAudit(agent.getAgentId());
			}else{
				intcallAudit = 1;
			}
			returncheck = 1;
			updateCount = agentService.updateAgent(agent);
		}
		//대상아님 선택 시			
		searchDTO.setSearchIsAuditBatch(null);
		if(agent.getIsAudit() == 0 && agent.getIsAuditBatch() == 0){
			if(callAudit != null){
				intcallAudit = callAuditService.deleteCallAudit(agent.getAgentId());
			}else{
				intcallAudit = 1;
			}
			returncheck = 1;
			updateCount = agentService.updateAgent(agent);
		}
		model.addAttribute("updateCount", updateCount);
		model.addAttribute("intcallAudit", intcallAudit);
		model.addAttribute("returncheck", returncheck);
		
		String audit = "";
		
		if(agent.getIsAudit() == 0) {
			audit = "대상아님";
		}else if(agent.getIsAudit() == 1) {
			audit = "실시간";
		}else{
			audit = "비실시간";
		}

		hislog.setDetail("[수정] 상담원ID(이름) : ["+agent.getAgentId()+"("+agent.getAgentName()+")"+"] "
				+ "그룹ID(이름) : ["+agent.getGroupId()+"("+agent.getGroupName()+")] 내선번호 : ["+agent.getAgentNumber()+"] IP : ["+agent.getAgentIp()+"]"
						+ " 비실시간 모니터링 대상 여부 : ["+audit+"]");
		hislog.setMenu("시스템 설정 > 상담원 목록[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		
		
		if(returncheck == 1){
			if(updateCount > 0 && intcallAudit != 0) {
				return 1;
			} else {
				return 0;
			}
		}else{
			return 2;
		}
	}
	
	/**
	 * 주어진 상담원의 실시간/비실시간 모니터링 여부를 업데이트하기 위한 엔드포인트입니다. 
	 * @param agent
	 * @param model
	 * @return
	 *  성공하면 1을 반환하고, 라이선스 채널수를 모두 사용중이면 2를 반환하고, 등록에 실패하면 0을 반환합니다. 
	 * 모니터링 대상 여부(실시간/비실시간 - agent.getIsAudit())에 의해 callAudit이 저장되고 삭제됩니다.
	 * getIsAudit(),getIsAuditBatch()이 1이라고해도, 수정이 없을 수도 있기 때문에, 먼저 select해서 값이 있는지 확인합니다. 
	 * select이 없을 시 수정 시 오류가 발생합니다.
	 */
	@RequestMapping(value = "/updateAgentAudit", method = RequestMethod.POST)
	public int updateAgentAudit(Agent agent, Model model, SearchDTO searchDTO) {
		
		Agent dbAgent = agentService.getAgent(agent.getAgentId());
		dbAgent.setIsAudit(agent.getIsAudit());
		dbAgent.setIsAuditBatch(agent.getIsAuditBatch());
		int updateCount = 0;
		int returncheck=0;

		CallAudit callAudit = callAuditService.getCallAudit(agent.getAgentId());
		License license = licenseService.getLicense();
		
		//실시간 선택 시
		int	intcallAudit = 1;
		searchDTO.setSearchIsAudit("1");
		int auditCount = agentService.countAgentList(searchDTO);
		if(license.getRealtimeChannel() > auditCount && agent.getIsAudit() == 1){
			if(callAudit == null){
				intcallAudit = callAuditService.insertCallAudit(agent.getAgentId(),agent.getGroupId(),0);
			}else{
				intcallAudit = 1;
			}
			returncheck = 1;
			updateCount = agentService.updateAgent(dbAgent);
		}
		
		//비실시간 선택 시		
		searchDTO.setSearchIsAudit(null);
		searchDTO.setSearchIsAuditBatch("1");
		int auditBatchCountCheck = agentService.countAgentList(searchDTO);
		if(license.getNonrealtimeChannel() > auditBatchCountCheck && agent.getIsAuditBatch() == 1){
			if(callAudit != null){
				intcallAudit = callAuditService.deleteCallAudit(agent.getAgentId());
			}else{
				intcallAudit = 1;
			}
			returncheck = 1;
			updateCount = agentService.updateAgent(dbAgent);
		}
		//대상아님 선택 시			
		searchDTO.setSearchIsAuditBatch(null);
		if(agent.getIsAudit() == 0 && agent.getIsAuditBatch() == 0){
			if(callAudit != null){
				intcallAudit = callAuditService.deleteCallAudit(agent.getAgentId());
			}else{
				intcallAudit = 1;
			}
			returncheck = 1;
			updateCount = agentService.updateAgent(dbAgent);
		}
		
		if(returncheck == 1){
			if(updateCount > 0 && intcallAudit != 0) {
				return 1;
			} else {
				return 0;
			}
		}else{
			return 2;
		}
	}
	
	
	/**
	 * 주어진 상담원 정보를 삭제하기 위한 엔드포인트입니다.
	 * @param agentIndex
	 * @param model
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/deleteAgent/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteAgent(@PathVariable("index") String agentIndex, Model model, HisLog hislog, Agent agent) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = agentIndex.split(",");
		
		hislog.setDetail("[삭제] 상담원ID(이름) : ["+array[1]+"("+array[2]+")]");
		hislog.setMenu("시스템 설정 > 상담원 목록[삭제]");
		hislog.setUser_id(array[4]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[3]);
		alarmLimitService.insertHis(hislog); 
		agent.setAgentId(array[1]);
		Boolean isDeleted = agentService.deleteAgent(array[0]);
		int agentchanged = agentService.insertAgentChanged(agent);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
	@RequestMapping(value="/repr", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteRepr(@RequestBody Agent agent, HisLog hislog) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		CallAudit callAudit = callAuditService.getCallAudit(agent.getAgentId());
		
		hislog.setDetail("[삭제] 상담원ID(이름) : ["+agent.getAgentName()+"("+agent.getAgentId()+")]");
		hislog.setMenu("시스템 설정 > 상담원 목록[삭제]");
		hislog.setUser_id("admin");
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name("2k");
		alarmLimitService.insertHis(hislog); 
		
		Boolean isDeleted = agentService.deleteAgentById(agent.getAgentId());
		int agentchanged = agentService.insertAgentChanged(agent);

		// delete mecs5_realtime_state
		int intcallAudit = 1;
		if (callAudit != null)  {
			intcallAudit = callAuditService.deleteCallAudit(agent.getAgentId());
		}
		
		if(isDeleted && intcallAudit != 0) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 주어진 그룹 ID에 해당하는 상담원 목록(Agent-List)을 반환하는 엔드포인트입니다.
	 * call_report.jsp :: ReportController에서 사용하기 위해 만들었습니다.
	 * 
	 * @param groupId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listAgent/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<List<Agent>> listAgent(@PathVariable("groupId") String groupId, Model model) {
		
		SearchDTO searchDTO = new SearchDTO();
		searchDTO.setSearchGroup(groupId);
		List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name  asc");
		if(agentList != null) {
			return new ResponseEntity<List<Agent>>(agentList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Agent>>(HttpStatus.NO_CONTENT);
		}
	}

	
	/**
	 * 엑셀로 업로드한 파일에 포함된 상담원 목록을 DB에 넣기 위해 사용하는 엔드포인트입니다. 
	 * @param req
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadAgentList", method = RequestMethod.POST)
	public ResponseEntity<Agent> uploadAgentList(MultipartHttpServletRequest req, HttpSession session, HttpServletRequest request) {
		MultipartFile uploadfile = req.getFile("agentExcelFile");
		int agentCount = agentService.uploadAgentListWithExcel(uploadfile);
		
		Agent agent = new Agent();
		agent.setIndex(agentCount );
		if(agentCount > 0) {
			return new ResponseEntity<Agent>(agent, HttpStatus.OK);
		} else {
			return new ResponseEntity<Agent>(HttpStatus.NO_CONTENT);
		}
	}
}
