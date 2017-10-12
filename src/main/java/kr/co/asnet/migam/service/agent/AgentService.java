package kr.co.asnet.migam.service.agent;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;

/**
 * 상담원 정보 인터페이스
 */
public interface AgentService {

	/**
	 * 데이터베이스에 새로운 상담원 정보를 추가합니다. 비밀번호는 SHA256으로 암호화됩니다.
	 * @param agent
	 * 	agent.index = 0 또는  null값으로 전달됩니다.
	 * 
	 * @return int  
	 *  새로 추가된 사용자의 index를 반환합니다.
	 */
	public int insertAgent(Agent agent);
	
	public int insertAgentChanged(Agent agent);

	
	public List<Agent> AgentList_u(Agent agent);
	

	/**
	 * 지정된 번호(index)에 해당하는 Agent객체를 반환합니다. 
	 * @param index
	 * @return
	 */
	public Agent getAgent(int index);
	
	/**
	 * 지정된 상담원 ID(agentId)에 해당하는 Agent객체를 반환합니다. 
	 * @param agentId
	 * @return
	 */
	public Agent getAgent(String agentId);
	

	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> getLatestAgentList(SearchDTO searchDTO, String orderby);

	/**
	 * 사용자 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countAgentList(SearchDTO searchDTO);
	
	/*
	 * 사용자 정보 업데이트
	 * @paran Agent
	 * @return
	 * IOS
	 */
	public int updateAgentById(Agent agent);
	
	
	public int updateAgentByIp(String  agent_id);
	/**
	 * 사용자 정보를 업데이트합니다. 
	 * 만일 비밀번호가 null이거나 ''(blank) 라면, 비번은 업데이트하지 않습니다. 
	 * @param agent
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateAgent(Agent agent);

	/**
	 * 사용자 삭제
	 * 
	 * @param index
	 * @return
	 */
	public Boolean deleteAgent(String index);

	/*
	 * 사용자 삭제 
	 * 
	 * @paran agentId
	 * @return
	 * IOS
	 */
	public Boolean deleteAgentById(String agentId);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * 다만, 해당 상담원의 AnrgyCount에 현재 상담중인 통화가 AngerCall인지 확인하여 1 또는 0을 넣습니다.
	 *  
	 * @param pageDTO
	 * @param searchDTO.searchGroup
	 * @param orderby
	 * @return
	 */
	
	public List<Agent> getAgentListWithAngry(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다.
	 * 다만, 해당 상담원의 StressCount, AnrgyCount을 포함하여 반환합니다.
	 *  
	 * @param pageDTO
	 * @param searchDTO.startDate에 지정된 날짜를 넣습니다.
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentListWithCount(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Agent 객체 목록을 반환합니다. mecs5_agent_stat_daily 테이블을 조회합니다.
	 * 다만, 해당 상담원의 StressCount, AnrgyCount을 포함하여 반환합니다.
	 *  
	 * @param pageDTO
	 * @param searchDTO.startDate에 지정된 날짜를 넣습니다.
	 * @param orderby
	 * @return
	 */
	public List<Agent> getAgentListWithCountFromDaily(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 정보에 따라, 에이전트의  AngryCount, StressCount를 담아서 Agent 객체를 반환합니다.  
	 * @param searchDTO / searchId = 상담원 아이디, startDate-endDate = 기간 
	 * @return
	 */
	public Agent getAgentWithCount(SearchDTO searchDTO);
	
	/**
	 * 존재하는 ID 인지 조회합니다.
	 * 
	 * @param agentId
	 * @return
	 */
	public boolean isDuplicatedAgentId(String agentId);
	
	/**
	 * 첨부로 올라온 엑셀 파일의 내용에 포함된 상담원 목록을 DB에 넣습니다.
	 * 해당 상담원이 감청대상(callAudit=1)이면 관련 DB에 추가합니다. ( callAuditService.insertCallAudit(agent.getAgentId(),agent.getGroupId(),0); )
	 * @param uploadfile
	 * @return
	 */
	public int uploadAgentListWithExcel(MultipartFile uploadfile);
}


