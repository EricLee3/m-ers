/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentHistory;
import kr.co.asnet.migam.repository.agent.AgentHistoryDao;

/**
 * @author byonghee
 *
 */
@Service("agentHistoryService")
public class AgentHistoryServiceImpl implements AgentHistoryService {

	@Inject
	private AgentHistoryDao agentHistoryDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentHistoryService#insertAgentHistory(kr.co.asnet.migam.domain.agent.AgentHistory)
	 */
	@Override
	public int insertAgentHistory(AgentHistory agentHistory) {
		return agentHistoryDao.insertAgentHistory(agentHistory);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentHistoryService#insertAgentHistory(kr.co.asnet.migam.domain.agent.AgentHistory)
	 */
	@Override
	public int updateAgentHistory(AgentHistory agentHistory) {
		return agentHistoryDao.updateAgentHistory(agentHistory);
	}

	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentHistoryService#getAgentHistory(int)
	 */
	@Override
	public AgentHistory getAgentHistory(int index) {
		return agentHistoryDao.selectAgentHistory(index);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentHistoryService#getAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentHistory> getAgentHistoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return agentHistoryDao.selectAgentHistoryList(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentHistoryService#countAgentList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countAgentHistoryList(SearchDTO searchDTO) {
		return agentHistoryDao.selectCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentHistoryService#deleteAgent(int)
	 */
	@Override
	public Boolean deleteAgentHistory(int index) {
		return agentHistoryDao.deleteAgentHistory(index) > 0 ? true : false;
	}

}
