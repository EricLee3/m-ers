/**
 * 
 */
package kr.co.asnet.migam.service.call;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.domain.call.MonthlyCall;
import kr.co.asnet.migam.repository.call.CallAnalysisDao;
import kr.co.asnet.migam.repository.call.MonthlyCallDao;

/**
 * @author kwonsy
 *
 */

@Service("monthlyCallService")
public class MonthlyCallServiceImpl implements MonthlyCallService {

	@Inject
	private MonthlyCallDao monthlyCallDao;
	@Inject 
	private CallAnalysisDao callAnalysisDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.MonthlyCallService#getMonthlyCallList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<MonthlyCall> getMonthlyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return monthlyCallDao.selectMonthlyCallList(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.MonthlyCallService#getMonthlyCallListforChart(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<MonthlyCall> getMonthlyCallListForChart(PageDTO2 pageDTO2,SearchDTO searchDTO, String orderby) {
		return monthlyCallDao.selectMonthlyCallListForChart(pageDTO2, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.MonthlyCallService#getCustomerCallListForChart(kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<MonthlyCall> getCustomerCallListForChart(SearchDTO searchDTO) {
		List<CallAnalysis> callAnalysisList = callAnalysisDao.selectCallAnalysisList(null, searchDTO, "");
		List<MonthlyCall> monthlyCallList = new ArrayList<MonthlyCall>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate=null, endDate=null;
		try {
			startDate = dateFormat.parse(searchDTO.getStartDate());
			endDate = dateFormat.parse(searchDTO.getEndDate());
		} catch(Exception e) {
			;;
		}
		Calendar startCalenndar = Calendar.getInstance();
		startCalenndar.setTime(startDate);
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		for (Date date = startCalenndar.getTime(); startCalenndar.before(endCalendar); startCalenndar.add(Calendar.DATE, 1), date = startCalenndar.getTime()) {
		    MonthlyCall monthlyCall = makeMonthlyCall(callAnalysisList, date);
		    monthlyCallList.add(monthlyCall);
		}
		return monthlyCallList;
	}
	
	/**
	 * getCustomerCallListForChart에서만 호출하는 메소드입니다.
	 * 주어진 List에서 해당 날짜의 정보를 찾아내서,그 숫자를 합하요 MonthlyCall 객체를 만들어서 반환합니다.
	 * 
	 * @param callAnalysisList
	 * @param date
	 * @return
	 */
	private MonthlyCall makeMonthlyCall(List<CallAnalysis> callAnalysisList, Date date) {
		SimpleDateFormat simpleDateFormet = new SimpleDateFormat("yyyy-MM-dd");
		MonthlyCall monthlyCall = new MonthlyCall();
		monthlyCall.setStatTime(date);
		monthlyCall.setAngryCount(0);
		monthlyCall.setStressCount(0);
		for( CallAnalysis callAnalysis : callAnalysisList ) {
			Date callDate = callAnalysis.getStartTime();
			if( simpleDateFormet.format(callDate).equals( simpleDateFormet.format(date)) ) {
				if( callAnalysis.getCustomerResultFlag() == 1 && callAnalysis.getCustomerFailCode() == 0 ) {
					monthlyCall.setAngryCount(monthlyCall.getAngryCount()+1);  
				} else if ( callAnalysis.getAgentResultFlag() == 1 && callAnalysis.getAgentFailCode() == 0 ) {
					monthlyCall.setStressCount(monthlyCall.getStressCount()+1);
				}
			}
		}
		return monthlyCall;
	}
	
	@Override
	public int selectMonthMonitorStatCount(SearchDTO searchDTO) {
		return monthlyCallDao.selectMonthMonitorStatCount(searchDTO);
	}

}
