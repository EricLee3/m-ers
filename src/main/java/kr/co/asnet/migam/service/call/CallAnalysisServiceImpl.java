/**
 * 
 */
package kr.co.asnet.migam.service.call;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.repository.call.CallAnalysisDao;
import kr.co.asnet.migam.web.report.ReportController;

/**
 * @author kwonsy
 *
 */

@Service("callAnalysisService")
public class CallAnalysisServiceImpl implements CallAnalysisService {
	private final Logger logger = LoggerFactory.getLogger(CallAnalysisServiceImpl.class);

	@Inject
	private CallAnalysisDao callAnalysisDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAnalysisService#getCallAnalysisList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<CallAnalysis> getCallAnalysisList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return callAnalysisDao.selectCallAnalysisList(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAnalysisService#getCallAnalysisCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int getCallAnalysisCount(SearchDTO searchDTO) {
		return callAnalysisDao.selectCallAnalysisCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAnalysisService#getCallAnalysis(int)
	 */
	@Override
	public CallAnalysis getCallAnalysis(int callIndex) {
		return callAnalysisDao.selectCallAnalysis(callIndex);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAnalysisService#getAgentDailyAngryCallForDashBoard(int)
	 */
	@Override
	public List<CallAnalysis> getAgentDailyAngryCallForDashBoard(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return callAnalysisDao.selectAgentDailyAngryCallForDashBoard(pageDTO, searchDTO, orderby);
	}
}
