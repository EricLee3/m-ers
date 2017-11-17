/**
 * 
 */
package kr.co.asnet.migam.service.call;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.repository.call.CallAnalysisDao;
import kr.co.asnet.migam.repository.call.DailyCallDao;
import kr.co.asnet.migam.web.report.ReportController;

/**
 * @author kwonsy
 *
 */

@Service("dailyCallService")
public class DailyCallServiceImpl implements DailyCallService {
	private final Logger logger = LoggerFactory.getLogger(ReportController.class);
	@Inject
	private DailyCallDao dailyCallDao;
	@Inject 
	private CallAnalysisDao callAnalysisDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.DailyCallService#getDailyCallList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<DailyCall> getDailyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return dailyCallDao.selectDailyCallList(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.DailyCallService#getDailyCallListforChart(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<DailyCall> getDailyCallListForChart(PageDTO2 pageDTO2,SearchDTO searchDTO, String orderby) {
		return dailyCallDao.selectDailyCallListForChart(pageDTO2, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.DailyCallService#getCustomerCallListForChart(kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<DailyCall> getCustomerCallListForChart(SearchDTO searchDTO) {
		List<CallAnalysis> callAnalysisList = callAnalysisDao.selectCallAnalysisList(null, searchDTO, "");
		List<DailyCall> dailyCallList = new ArrayList<DailyCall>();
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
		endCalendar.add(Calendar.DATE, 1);
		
		for (Date date = startCalenndar.getTime(); startCalenndar.before(endCalendar); startCalenndar.add(Calendar.DATE, 1), date = startCalenndar.getTime()) {
			//logger.debug("date=" + date.toString());
			DailyCall dailyCall = makeDailyCall(callAnalysisList, date);
		    dailyCallList.add(dailyCall);
		}
		return dailyCallList;
	}
	
	/**
	 * getCustomerCallListForChart에서만 호출하는 메소드입니다.
	 * 주어진 List에서 해당 날짜의 정보를 찾아내서,그 숫자를 합하요 DailyCall 객체를 만들어서 반환합니다.
	 * mecs5_analysis_result 테이블에서, start_time 이나 insert_date 필드에는 반드시 데이터가 들어있고, null 이 아니어야 합니다.
	 * 
	 * @param callAnalysisList
	 * @param date
	 * @return
	 */
	private DailyCall makeDailyCall(List<CallAnalysis> callAnalysisList, Date date) {
		SimpleDateFormat simpleDateFormet = new SimpleDateFormat("yyyy-MM-dd");
		DailyCall dailyCall = new DailyCall();
		dailyCall.setStatTime(date);
		dailyCall.setAngryCount(0);
		dailyCall.setStressCount(0);
		for( CallAnalysis callAnalysis : callAnalysisList ) {
			Date callDate = callAnalysis.getStartTime();
			if ( callDate == null ) callDate = callAnalysis.getCreateDate(); // 데이터에서 시작일이나 작성일에  null 이 있으면 오류가 발생합니다. 
			if( simpleDateFormet.format(callDate).equals( simpleDateFormet.format(date)) ) {
				if( callAnalysis.getCustomerResultFlag() == 1 && callAnalysis.getCustomerFailCode() == 0 ) {
					dailyCall.setAngryCount(dailyCall.getAngryCount()+1);  
				}
				if ( callAnalysis.getAgentResultFlag() == 1 && callAnalysis.getAgentFailCode() == 0 ) {
					dailyCall.setStressCount(dailyCall.getStressCount()+1);
				}
			}
		}
		return dailyCall;
	}
	
	@Override
	public int selectDayMonitorStatCount(SearchDTO searchDTO) {
		return dailyCallDao.selectDayMonitorStatCount(searchDTO);
	}

}
