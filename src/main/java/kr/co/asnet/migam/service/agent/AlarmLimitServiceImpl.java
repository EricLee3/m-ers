/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmLimit;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.repository.agent.AlarmLimitDao;

/**
 * @author byonghee
 *
 */
@Service("alarmLimitService")

public class AlarmLimitServiceImpl implements AlarmLimitService { 

	@Inject
	AlarmLimitDao alarmLimitDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#getParameter()
	 */
	@Override
	public AlarmLimit getAlarmLimit(String alarmIdx) {
		return alarmLimitDao.selectAlarmLimit(alarmIdx);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#updateParameter(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public int updateAlarmLimit(AlarmLimit alarmLimit) {
		return alarmLimitDao.updateAlarmLimit(alarmLimit);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#insertParameterHistory(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public String insertAlarmLimit(AlarmLimit alarmLimit) {
		return alarmLimitDao.insertAlarmLimit(alarmLimit);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#insertParameterHistory(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public int insertHis(HisLog hisLog) {
		return alarmLimitDao.insertHis(hisLog); 
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#getParameterHistoryList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AlarmLimit> getAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLimitDao.selectAlarmLimitList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<AlarmLimit> getSearchAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmLimitDao.selectSearchAlarmLimitList(pageDTO, searchDTO, orderby);
	}

}
