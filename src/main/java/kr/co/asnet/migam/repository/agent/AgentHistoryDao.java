package kr.co.asnet.migam.repository.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentHistory;

/**
 * 상담원관련 메모사항 DAO 인터페이스
 */
public interface AgentHistoryDao {
	/**
	 * 상담원관련 메모사항 정보를 데이터베이스에 추가합니다. 
	 * 
	 * @param agentHistory
	 * @return
	 *  성공적으로 추가되면, 헤당 정보의 idx값을 반환합니다.
	 */
	public int insertAgentHistory(AgentHistory agentHistory);

	/**
	 * 주어진 고유번호를 기반으로 해당 메모 사항 정보를 반환합니다. 
	 * 
	 * @param index
	 * @return
	 *   AgentHistory 인스턴스를 반환합니다. 만일, 대상 데이터가 없는 경우, NULL을 반환합니다.
	 */
	public AgentHistory selectAgentHistory(int index);

	/**
	 * 지정된 조건에 맞는 상담원 관련 메모사항 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<AgentHistory> selectAgentHistoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 상담원관련 메모사항 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	/**
	 * 상담원관련 메모사항 삭제
	 * 
	 * @param index
	 * @return
	 */
	public int deleteAgentHistory(int index);
	
}
