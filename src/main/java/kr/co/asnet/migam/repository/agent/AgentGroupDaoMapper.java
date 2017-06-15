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
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.ProConf;

/**
 * @author byonghee
 *
 */
@Repository(value = "AgentGroupDao")
public class AgentGroupDaoMapper implements AgentGroupDao {

	private static final Logger logger = LoggerFactory.getLogger(AgentGroupDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#insertAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public String insertAgentGroup(AgentGroup agentGroup) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.insertAgentGroup", agentGroup);
		if (resultCode > 0) return agentGroup.getGroupId();
		else return null; 
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroup(java.lang.String)
	 */
	@Override
	public AgentGroup selectAgentGroup(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentGroup", groupId);	
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#updateAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public int updateAgentGroup(AgentGroup agentGroup) {
		return sqlSession.update("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.updateAgentGroup", agentGroup);	
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> selectAgentGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentGroupList", parameters);
	}
	
	@Override
	public List<AgentGroup> selectProfileList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectProfileList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> selectAgentGroupList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentGroupList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> selectAgentGroupList10(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentGroupList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> selectAgentGroupList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentGroupList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> selectAgentGroupList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentGroupList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> selectAgentGroupList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentGroupList", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#deleteAgentGroup(java.lang.String)
	 */
	@Override
	public int deleteAgentGroup(String groupId) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.deleteAgentGroup", groupId);
	}
	
	@Override
	public List<AgentGroup> selectAgentProfileList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AgentGroupDaoMapper.selectAgentProfileList", parameters);
	}

}
