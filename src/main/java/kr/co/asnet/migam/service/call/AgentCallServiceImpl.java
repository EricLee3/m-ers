/**
 * 
 */
package kr.co.asnet.migam.service.call;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.AgentCall;
import kr.co.asnet.migam.repository.call.AgentCallDao;

/**
 * @author kwonsy
 *
 */

@Service("agentCallService")
public class AgentCallServiceImpl implements AgentCallService {

	@Inject
	private AgentCallDao agentCallDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.DailyCallService#getDailyCallListforChart(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentCall> getAgentCallListForChart(SearchDTO searchDTO, String orderby) {
		return agentCallDao.selectAgentCallListForChart(searchDTO, orderby);
	}

}
