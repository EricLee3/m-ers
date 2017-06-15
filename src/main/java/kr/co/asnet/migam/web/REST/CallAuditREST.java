package kr.co.asnet.migam.web.REST;


import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.service.call.CallAuditService;

/**
 * 실시간 콜 목록 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/callAudit")
public class CallAuditREST {
	private final Logger logger = LoggerFactory.getLogger(CallAuditREST.class);

	@Autowired
	private CallAuditService callAuditService;
	
	/**
	 * 주어진 아이디에 해당하는 실시간 콜 정보를 가져오기 위한 엔드포인트입니다.
	 * @param agentId
	 * @param model
	 * @return
	 *  성공하면 CallAudit 객체를 반환하고, 실패하면 NULL을 반환합니다.
	 */
	@RequestMapping(value = "/selectCallAudit/{agentId}", method = RequestMethod.GET)
	public ResponseEntity<CallAudit> selectCallAudit(@PathVariable("agentId") String agentId, Model model) {
		CallAudit callAudit = callAuditService.getCallAudit(agentId);
		if(callAudit!=null) {
			return new ResponseEntity<CallAudit>(callAudit, HttpStatus.OK);
		} else {
			return new ResponseEntity<CallAudit>(HttpStatus.NO_CONTENT);
		}
	}

	
	/**
	 * 실시간 콜 차트 정보 조회 결과를 ajax로 refresh하기 위한 엔드포인트입니다.
	 * 본 엔드포인트의 결과는 Modal 에서 표시하기 위해 사용합니다.
	 * 
	 * localhost/REST/callAudit/call_view_refresh/Agent7 와 같은 방식으로 JSON 데이터 정상 여부를 확인해야 합니다.
	 * 
	 * @param agentId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/call_view_refresh/{agentId}", method = RequestMethod.GET)
	public ResponseEntity<List<String>> callViewRefresh(@PathVariable("agentId") String agentId, Model model) {
		CallAudit callAudit = callAuditService.getCallAudit(agentId);
		if(callAudit!=null) {
			List<String> listCallData = new ArrayList<String>();
			listCallData.add("["+callAudit.getAgentState()+"]");
			//listCallData.add(callAudit.getAgentState());
			listCallData.add("["+callAudit.getCustomerState()+"]");
			//listCallData.add(callAudit.getCustomerState());
			return new ResponseEntity<List<String>>(listCallData, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
		}
	}
}
