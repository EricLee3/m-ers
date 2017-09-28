package kr.co.asnet.migam.service.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AgentHistory;

/**
 * 상담원 메모 정보 인터페이스
 */
public interface AgentHistoryService {

	/**
	 * 데이터베이스에 새로운 메모 정보를 추가합니다.
	 * 
	 * @param agentHistory
	 * @return
	 *  성공적으로 추가되면, 해당 메모의 idx값을 반환합니다.
	 */
	public int insertAgentHistory(AgentHistory agentHistory);


	public int updateAgentHistory(AgentHistory agentHistory);
	/**
	 * 지정된 번호(index)에 해당하는 AgentHistory객체를 반환합니다. 
	 * @param index
	 * @return
	 */
	public AgentHistory getAgentHistory(int index);
	
	/**
	 * 주어진 조건에 따라 AgentHistory 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<AgentHistory> getAgentHistoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 주어진 조건에 맞는 AgentHistory 객체의 숫자를 반환합니다.
	 *   
	 * @param searchDTO
	 * @return
	 */
	public int countAgentHistoryList(SearchDTO searchDTO);

	/**
	 * 주어진 index에 해당하는 AgentHistory를 삭제합니다. 
	 *  
	 * @param index
	 * @return
	 *  성공적으로 삭제되면 true를 반환합니다. 
	 */
	public Boolean deleteAgentHistory(int index);

}
