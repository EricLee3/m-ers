package kr.co.asnet.migam.web.REST;


import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

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

import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmCodeService;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.agent.ProcessGroupService;

/**
 * 상담원 그룹 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스 
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/alarmcode")
public class AlarmCodeREST {
	private final Logger logger = LoggerFactory.getLogger(AlarmCodeREST.class);

	@Autowired
	private AlarmCodeService alarmCodeService;
	@Autowired
	private AlarmLimitService alarmLimitService;
	
	/**
	 * 상담원 그룹 아이디가 유용한지 확인하여 결과를 JSON을 반환합니다.  
	 * @param groupId
	 * @return
	 */
	
	@RequestMapping(value = "/isDuplicatedAlarmCoded", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedAlarmCode(@RequestParam(value = "alarmCode") String alarmCode) {
		boolean result = false;
		if( alarmCodeService.isDuplicatedAlarmCode(alarmCode) ) result = false;
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
	@RequestMapping(value = "/createAlarmCode", method = RequestMethod.POST)
	public ResponseEntity<AlarmCode> createAlarmCode(AlarmCode alarmCode, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost(); 
		
		//logger.debug(alarmCode.toString());
		String alarmCode1 = alarmCodeService.insertAlarmCode(alarmCode);
		String code = "";
		String useflag = "";
		String visualflag = "";
		String audioflag = "";
		
		if(alarmCode.getAlarmLv().equals("0")) {
			code = "NORMAL";
		}else if(alarmCode.getAlarmLv().equals("1")) {
			code = "MINOR";
		}else if(alarmCode.getAlarmLv().equals("2")) {
			code = "MAJOR";
		}else if(alarmCode.getAlarmLv().equals("3")) {
			code = "CRITICAL";
		}else {
			code = "FAULT";
		}
		
		if(alarmCode.getUseFlag().equals("0")) {
			useflag = "사용안합";
		}else {
			useflag = "사용";
		}
		
		if(alarmCode.getVisualFlag().equals("0")) {
			visualflag = "사용안합";
		}else {
			visualflag = "사용";
		}
		
		if(alarmCode.getAudioFlag().equals("0")) {
			audioflag = "사용안합";
		}else {
			audioflag = "사용";
		}
		
		hislog.setDetail("[등록] 알람코드 : ["+alarmCode.getAlarmCode()+"] 알람레벨 : ["+code+ "] 알람 사용여부 : ["+useflag
				+"] 가시 여부 : ["+visualflag+"] 가시 여부 : ["+audioflag+"]");
		hislog.setMenu("시스템 설정 > 알람 코드 설정[등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog); 
		
		if(alarmCode1 != null) {
			return new ResponseEntity<AlarmCode>(alarmCode, HttpStatus.OK);
		} else {
			return new ResponseEntity<AlarmCode>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 주어진 인덱스에 해당하는 상담원 그룹 정보를 가져오기 위한 엔드포인트입니다.
	 * @param groupId
	 * @param model
	 * @return
	 *  성공하면 AgentGroup객체를 반환하고, 실패하면 NULL을 반환합니다.
	 */
	@RequestMapping(value = "/selectAlarmCode/{alarmCode}", method = RequestMethod.GET)
	public ResponseEntity<AlarmCode> selectAlarmCode(@PathVariable("alarmCode") String alarmCode, Model model) {
		AlarmCode alarmCode1 = alarmCodeService.getAlarmCode(alarmCode);
		if(alarmCode1!=null) {
			return new ResponseEntity<AlarmCode>(alarmCode1, HttpStatus.OK);
		} else {
			return new ResponseEntity<AlarmCode>(HttpStatus.NO_CONTENT);
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
	@RequestMapping(value = "/updateAlarmCode", method = RequestMethod.POST)
	public ResponseEntity<AlarmCode> updateAlarmCode(AlarmCode alarmCode, Model model,HisLog hislog, String username, String userid, HttpServletResponse response) throws UnknownHostException {
		
		InetAddress ip = InetAddress.getLocalHost(); 
		String code = alarmCode.getAlarmCode();
		String lv = alarmCode.getAlarmLv();
		
		String code2 = "";
		String useflag = "";
		String visualflag = "";
		String audioflag = "";
		
		//logger.debug("AlarmCode Update : " + alarmCode.toString());
		int updateCount = alarmCodeService.updateAlarmCode(alarmCode);
		
		
		if(alarmCode.getAlarmLv().equals("0")) {
			code2 = "NORMAL";
		}else if(alarmCode.getAlarmLv().equals("1")) {
			code2 = "MINOR";
		}else if(alarmCode.getAlarmLv().equals("2")) {
			code2 = "MAJOR";
		}else if(alarmCode.getAlarmLv().equals("3")) {
			code2 = "CRITICAL";
		}else {
			code2 = "FAULT";
		}
		
		if(alarmCode.getUseFlag().equals("0")) {
			useflag = "사용안합";
		}else {
			useflag = "사용";
		}
		
		if(alarmCode.getVisualFlag().equals("0")) {
			visualflag = "사용안합";
		}else {
			visualflag = "사용";
		}
		
		if(alarmCode.getAudioFlag().equals("0")) {
			audioflag = "사용안합";
		}else {
			audioflag = "사용";
		}
		
		hislog.setDetail("[수정] 알람코드 : ["+code+"] 알람레벨 : ["+code2+ "] 알람 사용여부 : ["+useflag
				+"] 가시 여부 : ["+visualflag+"] 가시 여부 : ["+audioflag+"]");
		hislog.setMenu("시스템 설정 > 알람 코드 설정[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog); 
		
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "");
		response.setHeader("Expires", "0");
		
		if(updateCount > 0) {
			return new ResponseEntity<AlarmCode>(alarmCode, HttpStatus.OK);
		} else {
			return new ResponseEntity<AlarmCode>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 주어진 상담원 그룹 정보를 삭제하기 위한 엔드포인트입니다.
	 * @param groupId
	 * @param model
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/deleteAlarmCode/{alarmCode}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteAlarmCode(@PathVariable("alarmCode") String alarmCode, String userid, HisLog hislog, Model model, SearchDTO searchDTO, HttpServletResponse response) throws UnknownHostException {
		
		String[] array;
		array = alarmCode.split(",");
		
		InetAddress ip = InetAddress.getLocalHost(); 
		
		if(searchDTO.getSearchGroup() == null){
			searchDTO.setSearchGroup(array[0]);
		}
		Boolean isDeleted = false;
		String code2 = "";
		if(array[1].equals("0")) {
			code2 = "NORMAL";
		}else if(array[1].equals("1")) {
			code2 = "MINOR";
		}else if(array[1].equals("2")) {
			code2 = "MAJOR";
		}else if(array[1].equals("3")) {
			code2 = "CRITICAL";
		}else {
			code2 = "FAULT";
		}
		
		hislog.setDetail("[삭제] 알람코드 : ["+array[0]+"] 알람레벨 : ["+code2+"]");
		hislog.setMenu("시스템 설정 > 알람 코드 설정[삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); 
	
		isDeleted = alarmCodeService.deleteAlarmCode(array[0]);
		
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "");
		response.setHeader("Expires", "0");
		
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
}
