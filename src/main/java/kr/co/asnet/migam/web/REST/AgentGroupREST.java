package kr.co.asnet.migam.web.REST;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.agent.ProcessGroupService;

/**
 * 상담원 그룹 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/agentgroup")
public class AgentGroupREST {
	private final Logger logger = LoggerFactory.getLogger(AgentGroupREST.class);

	@Autowired
	private AgentGroupService agentGroupService;
	
	@Autowired
	private ProcessGroupService processGroupService;
	
	@Autowired
	private AgentService agentService;

	@Autowired
	private AlarmLimitService alarmLimitService;
	
	/**
	 * 상담원 그룹 아이디가 유용한지 확인하여 결과를 JSON을 반환합니다.  
	 * @param groupId
	 * @return
	 */
	
	@RequestMapping(value = "/isDuplicatedGroupIdd", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedGroupId(@RequestParam(value = "groupId") String groupId) {
		boolean result = false;
		if( agentGroupService.isDuplicatedGroupId(groupId) ) result = false;
		else result = true;
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	

	/**
	 * 새로운 상담원 그룹 정보를 DB에 추가하기 위한 엔드포인트 입니다. 
	 * @param agentGroup
	 * @param model
	 * @return
	 *  성공하면, agent정보를 JSON형태로 반환합니다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/createAgentGroup", method = RequestMethod.POST)
	public ResponseEntity<AgentGroup> createAgentGroup(AgentGroup agentGroup, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		
		System.out.println("getProfile_name_agent::" + agentGroup.getProfile_name_agent());
		System.out.println("getProfile_name_cus::" + agentGroup.getProfile_name_cus());
		
		//logger.debug(agentGroup.toString());
		String groupId = agentGroupService.insertAgentGroup(agentGroup);
		
		hislog.setDetail("[등록] 그룹ID(이름) : ["+agentGroup.getGroupId()+"("+agentGroup.getGroupName()+")]");
		hislog.setMenu("시스템 설정 > 그룹관리[등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(groupId != null) {
			return new ResponseEntity<AgentGroup>(agentGroup, HttpStatus.OK);
		} else {
			return new ResponseEntity<AgentGroup>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 주어진 인덱스에 해당하는 상담원 그룹 정보를 가져오기 위한 엔드포인트입니다.
	 * @param groupId
	 * @param model
	 * @return
	 *  성공하면 AgentGroup객체를 반환하고, 실패하면 NULL을 반환합니다.
	 */
	@RequestMapping(value = "/selectAgentGroup/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<AgentGroup> selectAgentGroup(@PathVariable("groupId") String groupId, Model model) {
		AgentGroup agentGroup = agentGroupService.getAgentGroup(groupId);
		if(agentGroup!=null) {
			return new ResponseEntity<AgentGroup>(agentGroup, HttpStatus.OK);
		} else {
			return new ResponseEntity<AgentGroup>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 주어진 상담원 그룹 정보에 따라 해당 상담원 그룹 정보를 업데이트하기 위한 엔드포인트입니다.
	 * @param agentGroup
	 * @param model
	 * @return
	 *  성공하면 상담원 그룹 정보를 반환하고, 실패하면 NULL을 반환합니다. 
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/updateAgentGroup", method = RequestMethod.POST)
	public ResponseEntity<AgentGroup> updateAgentGroup(AgentGroup agentGroup, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug("Agent Group Update : " + agentGroup.toString());
		int updateCount = agentGroupService.updateAgentGroup(agentGroup);
		
		hislog.setDetail("[수정] 그룹ID(이름) : ["+agentGroup.getGroupId()+"("+agentGroup.getGroupName()+")] 소속인원 : ["+agentGroup.getAgentCount()+"]");
		hislog.setMenu("시스템 설정 > 그룹관리[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(updateCount > 0) {
			return new ResponseEntity<AgentGroup>(agentGroup, HttpStatus.OK);
		} else {
			return new ResponseEntity<AgentGroup>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 주어진 상담원 그룹 정보를 삭제하기 위한 엔드포인트입니다.
	 * @param groupId
	 * @param model
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/deleteAgentGroup/{groupId}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteAgentGroup(@PathVariable("groupId") String groupId, Model model, SearchDTO searchDTO, HisLog hislog) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = groupId.split(",");
		
		hislog.setDetail("[삭제] 그룹ID(이름) : ["+array[0]+"("+array[1]+")]");
		hislog.setMenu("시스템 설정 > 그룹관리[삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); 
		
		//AgentGroup agentGroup = agentGroupService.getAgentGroup(groupId);
		
		if(searchDTO.getSearchGroup() == null){
			searchDTO.setSearchGroup(groupId);
		}
		
		int agentCount = agentService.countAgentList(searchDTO);
		
		Boolean isDeleted = false;
		if(agentCount == 0){
			isDeleted = agentGroupService.deleteAgentGroup(array[0]);
		}
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
}
