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
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.repository.agent.AlarmLogDao; 
import kr.co.asnet.migam.repository.agent.FaultAlarmLogDao;
import kr.co.asnet.migam.repository.agent.ProMetaDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("ProMetaService")
public class ProMetaServiceImpl implements ProMetaService { 
	
	@Inject
	private ProMetaDao ProMetaDao; 
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ProMeta> getProMetaList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectProMetaList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<ProMeta> getProMetaList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectProMetaList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<ProMeta> getProMetaList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectProMetaList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<ProMeta> getProMetaList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectProMetaList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<ProMeta> getProMetaList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectProMetaList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ProMeta> getProMetaList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectProMetaList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countProMetaList(SearchDTO searchDTO) {
		return ProMetaDao.selectCount(searchDTO);
	}
	
	@Override
	public int countProMetaList_pro(SearchDTO searchDTO) {
		return ProMetaDao.selectCount_pro(searchDTO);
	}
	
	@Override
	public int countProMetaList_sc(SearchDTO searchDTO) {
		return ProMetaDao.selectCount_sc(searchDTO);
	}

	@Override
	public List<ProMeta> getSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectSvIndiList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<ProMeta> getIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return ProMetaDao.selectIndiList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public ProMeta getProMeta(String groupId) {
		return ProMetaDao.selectProMeta(groupId);	}
	
	@Override
	public ProMeta getProMeta2(String groupId) {
		return ProMetaDao.selectProMeta2(groupId);	}
	
	@Override
	public ProMeta getProIdx(String groupId) {
		return ProMetaDao.selectProIdx(groupId);	}
	
	@Override
	public int updateProMeta(ProMeta ProMeta) {
		return ProMetaDao.updateProMeta(ProMeta);
	}
	
	@Override
	public Boolean deleteProMeta(String index) {
		return ProMetaDao.deleteProMeta(index) > 0 ? true : false;	
	}
	
	@Override
	public Boolean deleteProMeta2(String index) {
		return ProMetaDao.deleteProMeta2(index) > 0 ? true : false;	
	}
	
	@Override
	public boolean isDuplicatedName(String groupId) {
		return ProMetaDao.selectName(groupId) != null ? true : false;	 
	}
	
	public String insertProMeta(ProMeta proMeta) {
		return ProMetaDao.insertProMeta(proMeta);	} 
	
}
