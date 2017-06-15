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
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.repository.agent.HisLogDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("hisLogService")
public class HisLogServiceImpl implements HisLogService { 
	
	@Inject
	private HisLogDao hisLogDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<HisLog> getHisLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return hisLogDao.selectHisLogList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<HisLog> getHisLogList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return hisLogDao.selectHisLogList15(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<HisLog> getHisLogNameList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return hisLogDao.selectHisLogNameList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<HisLog> getHisLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return hisLogDao.selectHisLogList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<HisLog> getHisLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return hisLogDao.selectHisLogList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<HisLog> getHisLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return hisLogDao.selectHisLogList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 100개
	 */
	@Override
	public List<HisLog> getHisLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return hisLogDao.selectHisLogList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countHisLogList(SearchDTO searchDTO) {
		return hisLogDao.selectCount(searchDTO);
	}

}
