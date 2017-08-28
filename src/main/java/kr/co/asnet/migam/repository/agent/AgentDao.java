package kr.co.asnet.migam.repository.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.user.User;

/**
 * 상담원 DAO 인터페이스
 */
public interface AgentDao { 
	/**
	 * 상담원 정보를 입력합니다.
	 * 
	 * @param agent
	 * @return
	 */
	public int insertAgent(Agent agent);
	
	public int insertAgentChanged(Agent agent);

	/**
	 * 주어진 상담원의 고유 번호를 기반으로 해당 상담원 정보를 반환합니다. 
	 * 
	 * @param agentIndex
	 * @return
	 *  domain.Agent 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우,  NULL 을 반환합니다.
	 */
	public Agent selectAgent(int agentIndex);

	/**
	 * 주어진 상담원의 아이디를 기반으로 해당 상담원 정보를 반환합니다. 
	 * 
	 * @param agentId
	 * @return
	 *  domain.Agent 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우,  NULL 을 반환합니다.
	 */
	public Agent selectAgent(String agentId);
	
	/**
	 * 상담원 정보를 수정합니다.
	 * 
	 * @param agent
	 * @return
	 */
	public int updateAgent(Agent agent);
	
	public int updateAgentById(Agent agent);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하지 않습니다. )
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하지 않습니다. )
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하지 않습니다. )
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하지 않습니다. )
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하지 않습니다. )
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하지 않습니다. )
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하지 않습니다. )
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectLatestAgentList(SearchDTO searchDTO, String orderby);

	/**
	 * 상담원 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	/**
	 * 상담원 삭제
	 * 
	 * @param agentIndex
	 * @return
	 */
	public int deleteAgent(String agentIndex);
	
	/**
	 * 상담원 삭제
	 * 
	 * @param agentId
	 * @return
	 * IOS
	 */
	public int deleteAgentById(String agentId);
	
	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하여 반환하지만, 성능이 좋지 않습니다.  )
	 * @param pageDTO
	 * @param searchDTO.startDate에 'yyyy-MM-dd' 형식의 값이 들어가야 합니다.
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentListWithCount(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 지정된 조건에 맞는 상담원 목록을 반환합니다. ( 본 메소드는 AngryCount, StressCount 값을 포함하여 반환하지만, 성능이 좋지 않습니다.  )
	 * @param pageDTO
	 * @param searchDTO.startDate 및 searchDTO.endDate에 'yyyy-MM-dd' 형식의 값이 들어가야 합니다.
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentListWithCountFromDaily(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 현재 통화중인 상담의 AngerCall여부를 포함한 Agent목록을 반환합니다. 
	 * 
	 * @param pageDTO
	 * @param searchDTO.searchGroup 해당 그룹을 반드시 넣어야 합니다.
	 * @param orderby
	 * @return
	 */
	public List<Agent> selectAgentListWithAngry(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	
	/**
	 * 현재 통화중인 상담의 AngerCall여부를 포함한 Agent목록을 반환합니다. 
	 * 
	 * @param searchDTO.searchId = 상담원 ID, searchDTO.( startDate, endDate) 기간 
	 * @return
	 */
	public Agent selectAgentWithCount(SearchDTO searchDTO);
	
	/**
	 * 주어진 상담원 아이디를 기반으로 해당 상담원 정보를 반환합니다. 
	 * 
	 * @param agentId
	 * @return
	 *  domain.Agent 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public Agent selectAgentById(String agentId);
}
