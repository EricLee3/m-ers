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
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.repository.agent.AlarmLogDao; 

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("alarmLogService")
public class AlarmLogServiceImpl implements AlarmLogService { 
	
	@Inject
	private AlarmLogDao alarmLogDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#insertAgent(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int insertAlarmLog(AlarmLog alarmLog) {
		return alarmLogDao.insertAlarmLog(alarmLog);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatch(int)
	 */
	@Override
	public AlarmLog getAlarmLog(int index) {
		return alarmLogDao.selectAlarmLog(index);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<AlarmLog> getAlarmLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLogDao.selectAlarmLogList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<AlarmLog> getAlarmLogList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLogDao.selectAlarmLogList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<AlarmLog> getAlarmLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLogDao.selectAlarmLogList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<AlarmLog> getAlarmLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLogDao.selectAlarmLogList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<AlarmLog> getAlarmLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLogDao.selectAlarmLogList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 100개
	 */
	@Override
	public List<AlarmLog> getAlarmLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLogDao.selectAlarmLogList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countAlarmLogList(SearchDTO searchDTO) {
		return alarmLogDao.selectCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#deleteBatch(int)
	 */
	@Override
	public Boolean deleteAlarmLog(int index) {
		return alarmLogDao.deleteAlarmLog(index) > 0 ? true : false;
	}

}
