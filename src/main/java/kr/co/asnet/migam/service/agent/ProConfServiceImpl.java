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
import kr.co.asnet.migam.repository.agent.ProConfDao;
import kr.co.asnet.migam.repository.agent.SensConfDao;
import kr.co.asnet.migam.repository.agent.SensMetaDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("proConfService")
public class ProConfServiceImpl implements ProConfService { 
	
	@Inject
	private ProConfDao proConfDao; 
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ProConf> getProConfList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConfList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<ProConf> getProConfList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConfList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<ProConf> getProConfList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConfList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<ProConf> getProConfList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConfList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<ProConf> getProConfList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConfList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ProConf> getProConfList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConfList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countProConfList(SearchDTO searchDTO) {
		return proConfDao.selectCount(searchDTO);
	}
	
	@Override
	public int countProConfList2(SearchDTO searchDTO) {
		return proConfDao.selectCount2(searchDTO);
	}

	@Override
	public List<ProConf> getProNameList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProNameList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<ProConf> getIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectIndiList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<ProConf> getProChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProChkList(pageDTO, searchDTO, orderby); 
	}
	
	@Override
	public List<ProConf> getProChkList_update(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProChkList_update(pageDTO, searchDTO, orderby); 
	}
	
	@Override
	public List<ProConf> getProConf(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConf(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public int updateProConf(ProConf proConf) { 
		return proConfDao.updateProConf(proConf); 
	}
	
	@Override
	public Boolean deleteProConf(ProConf proConf) {
		return proConfDao.deleteProConf(proConf) > 0 ? true : false;	
	}
	
	@Override
	public Boolean deleteProConf_script(ProConf proConf) {
		return proConfDao.deleteProConf_script(proConf) > 0 ? true : false;	
	}
	
	@Override
	public Boolean deleteProConf2(String index) {
		return proConfDao.deleteProConf2(index) > 0 ? true : false;	
	}
	
	public String insertProConf(ProConf proConf) {
		return proConfDao.insertProConf(proConf);	
	}

	public String insertProConf_S(ProConf proConf) {
		return proConfDao.insertProConf_S(proConf);	
	}
	
	@Override
	public int countDupMinMax(ProConf proConf) {
		return proConfDao.selectDupMinMax(proConf);
	}
	
	@Override
	public List<ProConf> getProConfName(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return proConfDao.selectProConfName(pageDTO, searchDTO, orderby);
	}
}
