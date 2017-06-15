/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.repository.agent.AlarmLogDao; 
import kr.co.asnet.migam.repository.agent.FaultAlarmLogDao;
import kr.co.asnet.migam.repository.agent.SensBasicDao;
import kr.co.asnet.migam.repository.agent.SensMetaDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("sensBasicService")
public class SensBasicServiceImpl implements SensBasicService { 
	
	@Inject
	private SensBasicDao sensBasicDao; 
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensBasic> getSensBasicList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensBasicDao.selectSensBasicList(pageDTO, searchDTO, orderby);
	}
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<SensBasic> getSensBasicList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensBasicDao.selectSensBasicList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<SensBasic> getSensBasicList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensBasicDao.selectSensBasicList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<SensBasic> getSensBasicList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensBasicDao.selectSensBasicList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<SensBasic> getSensBasicList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensBasicDao.selectSensBasicList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensBasic> getSensBasicList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensBasicDao.selectSensBasicList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countSensBasicList(SearchDTO searchDTO) {
		return sensBasicDao.selectCount(searchDTO);
	}

	@Override
	public List<SensBasic> getNameList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensBasicDao.selectNameList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#insertAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public String insertSensBasic(SensBasic sensBasic) {
		return sensBasicDao.insertSensBasic(sensBasic);	}
	
	public String insertSensMeta(SensMeta sensMeta) {
		return sensBasicDao.insertSensMeta(sensMeta);	}
	
	public String insertSensMap(SensMeta sensMeta) {
		return sensBasicDao.insertSensMap(sensMeta);	}
	
	public String insertSensMap_update(SensMeta sensMeta) {
		return sensBasicDao.insertSensMap_update(sensMeta);	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroup(java.lang.String)
	 */
	@Override
	public SensBasic getSensBasic(String groupId) {
		return sensBasicDao.selectSensBasic(groupId);	}
	
	

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#updateAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public int updateSensBasic(SensBasic sensBasic) {
		return sensBasicDao.updateSensBasic(sensBasic);
	}
	

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#deleteAgent(int)
	 */
	@Override
	public Boolean deleteSensBasic(String index) {
		return sensBasicDao.deleteSensBasic(index) > 0 ? true : false;	
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#deleteAgentGroup(java.lang.String)
	 */
	@Override
	public boolean isDuplicatedGroupId(String groupId) {
		return sensBasicDao.selectAgentGroup(groupId) != null ? true : false;	
	}
	
	@Override
	public boolean isDuplicatedName(String groupId) {
		return sensBasicDao.selectName(groupId) != null ? true : false;	
	}
	
	

}
