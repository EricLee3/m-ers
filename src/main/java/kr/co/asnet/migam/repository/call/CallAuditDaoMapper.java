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

}
