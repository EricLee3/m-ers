/**
 * 
 */
package kr.co.asnet.migam.service.call;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.call.HourlyCall;
import kr.co.asnet.migam.repository.call.HourlyCallDao;

/**
 * @author byonghee
 *
 */

@Service("hourlyCallService")
public class HourlyCallSerivceImpl implements HourlyCallService {

	@Inject
	private HourlyCallDao hourlyCallDao;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.DailyCallService#getDailyCallList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<HourlyCall> getHourlyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return hourlyCallDao.selectHourlyCallList(pageDTO, searchDTO, orderby);
	}


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.HourlyCallService#getHourlyCallListForChart(kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<HourlyCall> getHourlyCallListForChart(SearchDTO searchDTO, String orderby) {
		return hourlyCallDao.selectHourlyCallListForChart(searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.HourlyCallService#getHourlyCallListForChart(kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<HourlyCall> getHourlyCallListByOrder(SearchDTO searchDTO, String orderby) {
		return hourlyCallDao.selectHourlyCallListByOrderForYmdH(searchDTO, orderby);
	}

}
