package kr.co.asnet.migam.web.REST;


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

import kr.co.asnet.migam.domain.agent.AgentHistory;
import kr.co.asnet.migam.service.agent.AgentHistoryService;

/**
 * 상담원 메모 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/agentHistory")
public class AgentHistoryREST {
	private final Logger logger = LoggerFactory.getLogger(AgentHistoryREST.class);

	@Autowired
	private AgentHistoryService agentHistoryService;
	
	/**
	 * 새로운 상담원 관련 메모를 DB에 추가하기 위한 엔드포인트 입니다. 
	 * @param agentHistory
	 * @param model
	 * @return
	 *  성공하면, agent정보를 JSON형태로 반환 합니다.
	 */
	@RequestMapping(value = "/createAgentHistory", method = RequestMethod.POST)
	public ResponseEntity<AgentHistory> createAgentHistory(AgentHistory agentHistory, Model model) {
		// logger.debug(agent.toString());
		int agentHistoryIndex = agentHistoryService.insertAgentHistory(agentHistory);
		if(agentHistoryIndex > 0) {
			return new ResponseEntity<AgentHistory>(agentHistory, HttpStatus.OK);
		} else {
			return new ResponseEntity<AgentHistory>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 주어진 상담원 정보를 삭제하기 위한 엔드포인트입니다.
	 * @param agentHistoryIndex
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteAgentHistory/{index}", method = RequestMethod.GET)
	public ResponseEntity<Boolean> deleteAgent(@PathVariable("index") int agentHistoryIndex, Model model) {
		
		Boolean isDeleted = agentHistoryService.deleteAgentHistory(agentHistoryIndex);
		if(isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
		}
	}
}
