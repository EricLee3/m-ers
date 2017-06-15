/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.repository.agent.AgentGroupDao;

/**
 * @author byonghee
 * 상담원 그룹 정보 구현 클래스 
 */
@Service("agentGroupService")
public class AgentGroupServiceImpl implements AgentGroupService {

	@Inject
	private AgentGroupDao agentGroupDao;
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#insertAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public String insertAgentGroup(AgentGroup agentGroup) {
		return agentGroupDao.insertAgentGroup(agentGroup);	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroup(java.lang.String)
	 */
	@Override
	public AgentGroup getAgentGroup(String groupId) {
		return agentGroupDao.selectAgentGroup(groupId);	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> getAgentGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectAgentGroupList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<AgentGroup> getProfileList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectProfileList(pageDTO, searchDTO, orderby);
	}
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> getAgentGroupList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectAgentGroupList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> getAgentGroupList10(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectAgentGroupList10(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> getAgentGroupList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectAgentGroupList25(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> getAgentGroupList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectAgentGroupList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AgentGroup> getAgentGroupList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectAgentGroupList100(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#countAgentGroupList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countAgentGroupList(SearchDTO searchDTO) {
		return agentGroupDao.selectCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#updateAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public int updateAgentGroup(AgentGroup agentGroup) {
		return agentGroupDao.updateAgentGroup(agentGroup);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#deleteAgentGroup(java.lang.String)
	 */
	@Override
	public Boolean deleteAgentGroup(String groupId) {
		return agentGroupDao.deleteAgentGroup(groupId) > 0 ? true : false;	
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#deleteAgentGroup(java.lang.String)
	 */
	@Override
	public boolean isDuplicatedGroupId(String groupId) {
		return agentGroupDao.selectAgentGroup(groupId) != null ? true : false;	
	}

	@Override
	public List<AgentGroup> getProcessList(PageDTO pageDTO,
			SearchDTO searchDTO, String orderby) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<AgentGroup> getAgentProfileList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return agentGroupDao.selectAgentProfileList(pageDTO, searchDTO, orderby); 
	}
	
}
