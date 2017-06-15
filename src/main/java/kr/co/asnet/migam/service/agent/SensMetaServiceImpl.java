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
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.repository.agent.AlarmLogDao; 
import kr.co.asnet.migam.repository.agent.FaultAlarmLogDao;
import kr.co.asnet.migam.repository.agent.SensMetaDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("sensMetaService")
public class SensMetaServiceImpl implements SensMetaService { 
	
	@Inject
	private SensMetaDao sensMetaDao; 
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensMeta> getSensMetaList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSensMetaList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<SensMeta> getSensMetaList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSensMetaList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<SensMeta> getSensMetaList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSensMetaList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<SensMeta> getSensMetaList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSensMetaList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<SensMeta> getSensMetaList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSensMetaList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensMeta> getSensMetaList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSensMetaList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countSensMetaList(SearchDTO searchDTO) {
		return sensMetaDao.selectCount(searchDTO);
	}

	@Override
	public List<SensMeta> getSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSvIndiList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<SensMeta> getSvIndiList_chk(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectSvIndiList_chk(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<SensMeta> getIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensMetaDao.selectIndiList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public SensMeta getSensMeta(String groupId) {
		return sensMetaDao.selectSensMeta(groupId);	}
	
	@Override
	public SensMeta getSensMeta2(String groupId) {
		return sensMetaDao.selectSensMeta2(groupId);	}
	
	@Override
	public int updateSensMeta(SensMeta sensMeta) {
		return sensMetaDao.updateSensMeta(sensMeta);
	}
	
	@Override
	public Boolean deleteSensMeta(String index) {
		return sensMetaDao.deleteSensMeta(index) > 0 ? true : false;	
	}
	
	@Override
	public Boolean deleteSensMeta2(String index) {
		return sensMetaDao.deleteSensMeta2(index) > 0 ? true : false;	
	}
	
	@Override
	public int countSensMetaList_sc(SearchDTO searchDTO) {
		return sensMetaDao.selectCount_sc(searchDTO);
	}
	
	@Override
	public int countSvIndiList(SearchDTO searchDTO) {
		return sensMetaDao.selectCount_sv(searchDTO);
	}
}
