/**
 * 
 */
package kr.co.asnet.migam.service.call;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.call.RealStat;
import kr.co.asnet.migam.repository.call.CallAuditDao;

/**
 * @author byonghee
 *
 */
@Service("callAuditService")
public class CallAuditServiceImpl implements CallAuditService {

	@Inject
	private CallAuditDao callAuditDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#insertAgent(kr.co.asnet.migam.domain.agent.Agent)
	 */
	@Override
	public int insertCallAudit(String agentId, String groupId, int callStatus) {
		return callAuditDao.insertCallAudit(agentId, groupId, callStatus);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAuditService#getAuditCall(java.lang.String)
	 */
	@Override
	public CallAudit getCallAudit(String agentId) {
		return callAuditDao.selectCallAudit(agentId);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAuditService#getAuditCallList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<CallAudit> getCallAuditList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectCallAuditList(pageDTO, searchDTO, orderby);
	}
	
	
	@Override
	public List<RealStat> getRealStat(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectRealStatList(pageDTO, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getGroup(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectGroupList(pageDTO, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getAgent(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectAgentList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<RealStat> getRealStat5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectRealStatList5(pageDTO5, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getGroup5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectGroupList5(pageDTO5, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getAgent5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectAgentList5(pageDTO5, searchDTO, orderby);
	}
	
	@Override
	public List<RealStat> getRealStat25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectRealStatList25(pageDTO25, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getGroup25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectGroupList25(pageDTO25, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getAgent25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectAgentList25(pageDTO25, searchDTO, orderby);
	}
	
	@Override
	public List<RealStat> getRealStat50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectRealStatList50(pageDTO50, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getGroup50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectGroupList50(pageDTO50, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getAgent50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectAgentList50(pageDTO50, searchDTO, orderby);
	}
	
	@Override
	public List<RealStat> getRealStat100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectRealStatList100(pageDTO100, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getGroup100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectGroupList100(pageDTO100, searchDTO, orderby);
	}
	@Override
	public List<RealStat> getAgent100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby) {
		return callAuditDao.selectAgentList100(pageDTO100, searchDTO, orderby);
	}
	
	
	@Override
	public int countgetRealStat(SearchDTO searchDTO) {
		return callAuditDao.countgetRealStat(searchDTO);
	}
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAuditService#countAuditCallList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countCallAuditList(SearchDTO searchDTO) {
		return callAuditDao.selectCount(searchDTO);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#deleteAgent(int)
	 */
	@Override
	public int deleteCallAudit(String agentId) {
		return callAuditDao.deleteCallAudit(agentId) > 0 ? 1 : 0;	
	}

	@Override
	public int patchCallAudit(Agent agent)  {
		return callAuditDao.patchCallAudit(agent) > 0 ? 1 : 0;
	}
}
