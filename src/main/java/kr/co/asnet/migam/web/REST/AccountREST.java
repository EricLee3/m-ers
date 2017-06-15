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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.user.User;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.user.UserService;

/**
 * 사용자 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/account")
public class AccountREST {
	private final Logger logger = LoggerFactory.getLogger(AccountREST.class);

	@Autowired
	private UserService userService;
	@Autowired
	private AlarmLimitService alarmLimitService;
	
	/**
	 * 사용자 아이디가 유용한지 확인하여 결과를 JSON을 반환합니다.  
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/isDuplicatedUserId", method = RequestMethod.GET)
	public ResponseEntity<Boolean> isDuplicatedUserId(@RequestParam(value = "userId") String userId) {
		boolean result = false;
		if( userService.isDuplicatedUserId(userId) ) result = false;
		else result = true;
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
	
	/**
	 * 새로운 사용자 정보를 DB에 추가하기 위한 엔드포인트 입니다. 
	 * @param user
	 * @param model
	 * @return
	 *  성공하면, user정보를 JSON형태로 반환합니다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ResponseEntity<User> createUser(User user, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		// logger.debug(user.toString());
		int userIndex = userService.insertUser(user);
		
		hislog.setDetail("[등록] 사용자ID(이름) : ["+user.getUserId()+"("+user.getUserName()+")]");
		hislog.setMenu("시스템 설정 > 사용자 목록[등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(userIndex > 0) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 주어진 인덱스에 해당하는 사용자 정보를 가져오기 위한 엔드포인트입니다.
	 * @param userIndex
	 * @param model
	 * @return
	 *  성공하면 User객체를 반환하고, 실패하면 NULL을 반환합니다.
	 */
	@RequestMapping(value = "/selectUser/{index}", method = RequestMethod.GET)
	public ResponseEntity<User> selectUser(@PathVariable("index") int userIndex, Model model) {
		User user = userService.getUser(userIndex);
		if(user!=null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 주어진 사용자 정보에 따라 해당 사용자 정보를 업데이트하기 위한 엔드포인트입니다.
	 * @param user
	 * @param model
	 * @return
	 *  성공하면 사용자 정보를 반환하고, 실패하면 NULL을 반환합니다. 
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ResponseEntity<User> updateUser(User user, Model model,HisLog hislog, String username, String userid) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		
		int updateCount = userService.updateUser(user);
		
		hislog.setDetail("[수정] 사용자ID(이름) : ["+user.getUserId()+"("+user.getUserName()+")] 등급 : ["+user.getRole()+"]"
				+ " 부서 : ["+user.getOrg()+"] 직위 : ["+user.getPosition()+"] 전화번호 : ["+user.getPhone()+"]");
		hislog.setMenu("시스템 설정 > 사용자 목록[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(updateCount > 0) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 주어진 사용자 정보를 삭제하기 위한 엔드포인트입니다.
	 * @param userIndex
	 * @param model
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/deleteUser/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteUser(@PathVariable("index") String userIndex, Model model, HisLog hislog) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost(); 
		String[] array;
		array = userIndex.split(",");
		
		hislog.setDetail("[삭제] 사용자ID(이름) : ["+array[1]+"("+array[2]+")]");
		hislog.setMenu("시스템 설정 > 사용자 목록[삭제]");
		hislog.setUser_id(array[4]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[3]);
		alarmLimitService.insertHis(hislog); 
		
		Boolean isDeleted = userService.deleteUser(array[0]);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
}
