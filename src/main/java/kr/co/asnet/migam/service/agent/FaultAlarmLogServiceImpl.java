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
import kr.co.asnet.migam.repository.agent.AlarmLogDao; 
import kr.co.asnet.migam.repository.agent.FaultAlarmLogDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("faultalarmLogService")
public class FaultAlarmLogServiceImpl implements FaultAlarmLogService { 
	
	@Inject
	private FaultAlarmLogDao FaultalarmLogDao;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<FaultAlarmLog> getFaultAlarmLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return FaultalarmLogDao.selectFaultAlarmLogList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<FaultAlarmLog> getFaultAlarmLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return FaultalarmLogDao.selectFaultAlarmLogList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<FaultAlarmLog> getFaultAlarmLogList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		return FaultalarmLogDao.selectFaultAlarmLogList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<FaultAlarmLog> getFaultAlarmLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return FaultalarmLogDao.selectFaultAlarmLogList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<FaultAlarmLog> getFaultAlarmLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return FaultalarmLogDao.selectFaultAlarmLogList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<FaultAlarmLog> getFaultAlarmLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return FaultalarmLogDao.selectFaultAlarmLogList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countFaultAlarmLogList(SearchDTO searchDTO) {
		return FaultalarmLogDao.selectCount(searchDTO);
	}

	
}
