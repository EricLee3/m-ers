/**
 * 
 */
package kr.co.asnet.migam.repository.call;

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
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.call.RealStat;
import kr.co.asnet.migam.repository.user.UserDaoMapper;

/**
 * @author byonghee
 *
 */
@Repository(value = "callAuditDao")
public class CallAuditDaoMapper implements CallAuditDao {

	private static final Logger logger = LoggerFactory.getLogger(CallAuditDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAuditDaoMapper.insertCallAudit(kr.co.asnet.migam.domain.CallAudit)
	 */
	@Override
	public int insertCallAudit(String agentId, String groupId, int callStatus) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("agentId", agentId);
			parameters.put("groupId", groupId);
			parameters.put("callStatus", callStatus);
		}
		return sqlSession.insert("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.insertCallAudit", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAuditDao#selectCallAudit(java.lang.String)
	 */
	@Override
	public CallAudit selectCallAudit(String agentId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectCallAudit", agentId);	
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAuditDao#selectCallAuditList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<CallAudit> selectCallAuditList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectCallAuditList", parameters);
	}
	
	@Override
	public List<RealStat> selectRealStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectRealStatList", parameters);
	}
	@Override
	public List<RealStat> selectGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectGroupList", parameters);
	}
	@Override
	public List<RealStat> selectAgentList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectAgentList", parameters);
	}

	


	
	
	
	
	
	
	
	
	@Override
	public List<RealStat> selectRealStatList5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO5);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectRealStatList", parameters);
	}
	@Override
	public List<RealStat> selectGroupList5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO5);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectGroupList", parameters);
	}
	@Override
	public List<RealStat> selectAgentList5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO5);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectAgentList", parameters);
	}
	
	@Override
	public List<RealStat> selectRealStatList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectRealStatList", parameters);
	}
	@Override
	public List<RealStat> selectGroupList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectGroupList", parameters);
	}
	@Override
	public List<RealStat> selectAgentList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectAgentList", parameters);
	}
	
	@Override
	public List<RealStat> selectRealStatList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectRealStatList", parameters);
	}
	@Override
	public List<RealStat> selectGroupList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectGroupList", parameters);
	}
	@Override
	public List<RealStat> selectAgentList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectAgentList", parameters);
	}
	
	@Override
	public List<RealStat> selectRealStatList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectRealStatList", parameters);
	}
	@Override
	public List<RealStat> selectGroupList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectGroupList", parameters);
	}
	@Override
	public List<RealStat> selectAgentList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectAgentList", parameters);
	}
	
	@Override
	public int countgetRealStat(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.countgetRealStat", parameters);
	}
	

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAuditDao#selectCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.selectCount", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int deleteCallAudit(String agentId) {
		return sqlSession.delete("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.deleteCallAudit", agentId);
	}

	@Override
	public int patchCallAudit(Agent agent) {
		return sqlSession.delete("kr.co.asnet.migam.repository.call.CallAuditDaoMapper.patchCallAudit", agent);
	}
}
