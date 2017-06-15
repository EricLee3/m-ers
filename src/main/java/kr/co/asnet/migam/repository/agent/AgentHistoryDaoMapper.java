/**
 * 
 */
package kr.co.asnet.migam.repository.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentHistory;

/**
 * @author byonghee
 *
 */
@Repository(value = "AgentHistoryDao")
public class AgentHistoryDaoMapper implements AgentHistoryDao {

	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentHistoryDao#insertAgentHistory(kr.co.asnet.migam.domain.agent.AgentHistory)
	 */
	@Override
	public int insertAgentHistory(AgentHistory agentHistory) {
		return sqlSession.insert("kr.co.asnet.migam.repository.agent.AgentHistoryDaoMapper.insertAgentHistory", agentHistory);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentHistoryDao#selectAgentHistory(int)
	 */
	@Override
	public AgentHistory selectAgentHistory(int index) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentHistoryDaoMapper.selectAgentHistory", index);	
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentHistoryDao#selectAgentHistoryList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentHistory> selectAgentHistoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentHistoryDaoMapper.selectAgentHistoryList", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentHistoryDao#selectCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentHistoryDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentHistoryDao#deleteAgentHistory(int)
	 */
	@Override
	public int deleteAgentHistory(int index) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.AgentHistoryDaoMapper.deleteAgentHistory", index);
	}

}
