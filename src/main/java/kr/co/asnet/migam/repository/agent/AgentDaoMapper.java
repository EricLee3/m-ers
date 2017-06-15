package kr.co.asnet.migam.repository.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;

/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "agentDao")
public class AgentDaoMapper implements AgentDao { 
	
	private static final Logger logger = LoggerFactory.getLogger(AgentDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int insertAgent(Agent agent) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.AgentDaoMapper.insertAgent", agent);
		if (resultCode > 0) return agent.getIndex();
		return 0; 
	}
	
	@Override
	public int insertAgentChanged(Agent agent) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.AgentDaoMapper.insertAgentChanged", agent);
		if (resultCode > 0) return agent.getIndex();
		return 0; 
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.selectAgent(int)
	 */
	@Override
	public Agent selectAgent(int agentIndex) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgent", agentIndex);
	}
	
	

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgent(java.lang.String)
	 */
	@Override
	public Agent selectAgent(String agentId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentById", agentId);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.updateAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int updateAgent(Agent agent) {
		return sqlSession.update("kr.co.asnet.migam.repository.agent.AgentDaoMapper.updateAgent", agent);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int deleteAgent(String agentIndex) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.AgentDaoMapper.deleteAgent", agentIndex);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentList", parameters);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectLatestAgentList(SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectLatestAgentList", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentListWithCount(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentListWithCount(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentListWithCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentListWithCountFromDaily(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentListWithCountFromDaily(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentListWithCountFromDaily", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentListWithAngry(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Agent> selectAgentListWithAngry(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentListWithAngry", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentWithCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public Agent selectAgentWithCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentWithCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentById(java.lang.String)
	 */
	@Override
	public Agent selectAgentById(String agentId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentDaoMapper.selectAgentById", agentId);
	}
	
}
