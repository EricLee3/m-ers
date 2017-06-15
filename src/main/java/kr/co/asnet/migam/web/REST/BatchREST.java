package kr.co.asnet.migam.web.REST;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.PropertyAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.config.Batch;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmLimitService;
import kr.co.asnet.migam.service.config.BatchService;

/**
 * 자동 수행 작업 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/batch")
public class BatchREST {
	private final Logger logger = LoggerFactory.getLogger(BatchREST.class);

	@Autowired
	private BatchService batchService;
	@Autowired
	private AlarmLimitService alarmLimitService;
	@Inject
	private AgentGroupService agentGroupService;
	@Inject
	private AgentService agentService;
	private static Logger log = LoggerFactory.getLogger(BatchREST.class);
	
	/**
	 * 새로운 자동수행작업 정보를 DB에 추가하기 위한 엔드포인트 입니다. 
	 * @param batch
	 * @param model
	 * @return
	 *  성공하면, batch정보를 JSON형태로 반환합니다.
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/createBatch", method = RequestMethod.POST)
	public ResponseEntity<Batch> createBatch(Batch batch, Model model,HisLog hislog, String username, String userid, String right_action_val) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		//log.debug(batch.toString());
		
		System.out.println("right_action_val:::" + right_action_val);
		
		if(right_action_val.equals("1")) {
			batch.setTriggerTime("date_format(now(),'%H%i%s')");
		}else {
			batch.setTriggerTime(batch.getTriggerTime()+"00");
		}
		
		System.out.println("setTriggerTime::::" + batch.getTriggerTime());
		
		int batchIndex = batchService.insertBatch(batch);
		
		hislog.setDetail("[등록] 작업ID : ["+batch.getJobId()+"]");
		hislog.setMenu("서비스 설정 > 자동 수행 작업 목록[등록]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog);
		
		if(batchIndex > 0) {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		} else {
			return new ResponseEntity<Batch>(HttpStatus.NO_CONTENT);
		}
		
		
		//return batch;
	}
	
	/**
	 * 주어진 인덱스에 해당하는 자동수행작업 정보를 가져오기 위한 엔드포인트입니다.
	 * @param batchIndex
	 * @param model
	 * @return
	 *  성공하면 Batch객체를 반환하고, 실패하면 NULL을 반환합니다.
	 */
	@RequestMapping(value = "/selectBatch/{index}", method = RequestMethod.GET)
	public ResponseEntity<Batch> selectBatch(@PathVariable("index") int batchIndex, Model model, SearchDTO searchDTO) {
		
		Batch batch = batchService.getBatch(batchIndex);
		model.addAttribute("searchDTO", searchDTO);
		if( searchDTO.getSearchGroup() != null ) {
			//logger.debug(searchDTO.getSearchGroup());
			List<Agent> agentList = agentService.getAgentList(null, searchDTO, "order by agent_name asc");
			model.addAttribute("agentList", agentList);
		}
		if(batch!=null) {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		} else {
			return new ResponseEntity<Batch>(HttpStatus.NO_CONTENT);
		}
	}
	
	/**
	 * 주어진 자동수행작업 정보에 따라 해당 상담원 정보를 업데이트하기 위한 엔드포인트입니다.
	 * @param batch
	 * @param model
	 * @return
	 *  성공하면 자동수행작업 정보를 반환하고, 실패하면 NULL을 반환합니다. 
	 * @throws Exception 
	 */
	@RequestMapping(value = "/updateBatch", method = RequestMethod.POST)
	public ResponseEntity<Batch> updateBatch(Batch batch, Model model,HisLog hislog, String username, String userid, String right_action_val_up) throws Exception {
		InetAddress ip = InetAddress.getLocalHost();
		
		
		System.out.println("right_action_val111:::" + right_action_val_up);
		
		if(right_action_val_up.equals("1")) {
			batch.setTriggerTime("date_format(now(),'%H%i%s')");
		}else {
			batch.setTriggerTime(batch.getTriggerTime()+"00");
		}
		
		System.out.println("setTriggerTime111::::" + batch.getTriggerTime());
		
		
		int updateCount = batchService.updateBatch(batch);
		String repeat = "";
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String enddate = transFormat.format(batch.getEndTime());
		String startdate = transFormat.format(batch.getStartTime());
		
		if(batch.getRepeat() == 1) {
			repeat = "반복";
		}else {
			repeat = "반복안함";
		}
		
		hislog.setDetail("[수정] 작업ID : ["+batch.getJobId()+"] 시작일 : ["+startdate+"] 종료일 :["+enddate+"]"
				+ " 녹취 시작시간 : ["+batch.getRecordStart()+"] 녹취 종료시간 : ["+batch.getRecordEnd()+"] 분석 시작시간 : ["+batch.getTriggerTime()+"]"
						+ " 그룹 : ["+batch.getGroupId()+"] 상담원 : ["+batch.getAgentId()+"] 반복 여부 : ["+repeat+"]");
		hislog.setMenu("서비스 설정 > 자동 수행 작업 목록[수정]");
		hislog.setUser_id(userid);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(username);
		alarmLimitService.insertHis(hislog); 
		
		if(updateCount > 0) {
			return new ResponseEntity<Batch>(batch, HttpStatus.OK);
		} else {
			return new ResponseEntity<Batch>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 주어진 자동수행작업 정보를 삭제하기 위한 엔드포인트입니다.
	 * @param batchIndex
	 * @param model
	 * @return
	 * @throws UnknownHostException 
	 */
	@RequestMapping(value = "/deleteBatch/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteBatch(@PathVariable("index") String batchIndex, Model model,HisLog hislog) throws UnknownHostException {
		String[] array;
		array = batchIndex.split(","); 
		
		InetAddress ip = InetAddress.getLocalHost(); 
		hislog.setDetail("[삭제] 작업ID : ["+array[1]+"]");
		hislog.setMenu("시스템 설정 > 알람 코드 설정[삭제]");
		hislog.setUser_id(array[3]);
		hislog.setUser_ip(ip.getHostAddress());
		hislog.setUser_name(array[2]);
		alarmLimitService.insertHis(hislog); 
		
		Boolean isDeleted = batchService.deleteBatch(array[0]);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
	
}
