package kr.co.asnet.migam.web.REST;


import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.config.Parameter;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.config.ParameterService;

/**
 * 임계치 설정 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/config")
public class ParameterREST {
	private final Logger logger = LoggerFactory.getLogger(ParameterREST.class);

	@Autowired
	private ParameterService parameterService;
	@Autowired
	private AlarmLimitService alarmLimitService;
	
	/**
	 * 임계치 설정값을 DB에 업데이트 하기 위한 엔드포인트 입니다. 
	 * @param parameter
	 * @param model
	 * @return
	 *  성공하면, parameter 정보를 JSON형태로 반환 합니다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/updateParameter", method = RequestMethod.POST)
	public ResponseEntity<Parameter> updateParameter(Parameter parameter, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		// logger.debug(parameter.toString());
		int parameterIndex = parameterService.updateParameter(parameter);
		
		hislog.setDetail("[설정] Angry : ["+parameter.getCustomerAngry()+"] Stress : ["+parameter.getAgentStress()+"]"
				+ " Angry Count : ["+parameter.getAngryCount()+"] Stress Count : ["+parameter.getStressCount()+"] 임계치 설정명 : ["+parameter.getTitle()+"]");
		hislog.setMenu("서비스 설정 > 임계치 설정[설정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(parameterIndex > 0) {
			return new ResponseEntity<Parameter>(parameter, HttpStatus.OK);
		} else {
			return new ResponseEntity<Parameter>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 임계치 설정 내역을  DB에 추가하기 위한 엔드포인트 입니다. 
	 * @param parameter
	 * @param model
	 * @return
	 *  성공하면, parameter 정보를 JSON형태로 반환합니다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/createParameterHistory", method = RequestMethod.POST)
	public ResponseEntity<Parameter> createParameter(Parameter parameter, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//logger.debug(parameter.toString());
		String title = parameterService.insertParameterHistory(parameter);
		
		hislog.setDetail("[설정] Angry : ["+parameter.getCustomerAngry()+"] Stress : ["+parameter.getAgentStress()+"]"
				+ " Angry Count : ["+parameter.getAngryCount()+"] Stress Count : ["+parameter.getStressCount()+"] 임계치 설정명 : ["+parameter.getTitle()+"]");
		hislog.setMenu("서비스 설정 > 임계치 설정[설정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog); 
		
		if(title != null) {
			return new ResponseEntity<Parameter>(parameter, HttpStatus.OK);
		} else {
			return new ResponseEntity<Parameter>(HttpStatus.NO_CONTENT);
		}
	}

}
