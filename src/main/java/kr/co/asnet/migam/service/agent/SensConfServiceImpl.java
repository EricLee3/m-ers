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
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensConf;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.repository.agent.AlarmLogDao; 
import kr.co.asnet.migam.repository.agent.FaultAlarmLogDao;
import kr.co.asnet.migam.repository.agent.SensConfDao;
import kr.co.asnet.migam.repository.agent.SensMetaDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("sensConfService")
public class SensConfServiceImpl implements SensConfService { 
	
	@Inject
	private SensConfDao sensConfDao; 
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensConf> getSensConfList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensConfList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<SensConf> getSensConfList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensConfList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<SensConf> getSensConfList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensConfList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<SensConf> getSensConfList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensConfList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<SensConf> getSensConfList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensConfList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensConf> getSensConfList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensConfList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countSensConfList(SearchDTO searchDTO) {
		return sensConfDao.selectCount(searchDTO);
	}
	
	@Override
	public int countSensConfList2(SearchDTO searchDTO) {
		return sensConfDao.selectCount2(searchDTO);
	}


	@Override
	public List<SensConf> getSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSvIndiList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<SensConf> getIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectIndiList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<SensConf> getSensChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensChkList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<SensConf> getSensConf(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectSensConf(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public int updateSensConf(SensConf sensConf) {
		return sensConfDao.updateSensConf(sensConf);
	}
	
	@Override
	public Boolean deleteSensConf(SensConf sensConf) {
		return sensConfDao.deleteSensConf(sensConf) > 0 ? true : false;	
	}
	
	@Override
	public Boolean deleteSensConf2(String index) {
		return sensConfDao.deleteSensConf2(index) > 0 ? true : false;	
	}
	
	@Override
	public String insertSensConf(SensConf sensConf) {
		return sensConfDao.insertSensConf(sensConf);	
	} 
	
	@Override
	public List<SensConf> getProChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectProChkList(pageDTO, searchDTO, orderby); 
	}
	
	@Override
	public List<SensConf> getLevelList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return sensConfDao.selectLevelList(pageDTO, searchDTO, orderby); 
	}
	
	@Override
	public int countLevel(SearchDTO searchDTO) {
		return sensConfDao.selectLevel(searchDTO);
	}
	
	@Override
	public int countDupMinMax(SensConf sensConf) {
		return sensConfDao.selectDupMinMax(sensConf);
	}
}
