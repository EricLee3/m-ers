/**
 * 
 */
package kr.co.asnet.migam.service.call;
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
import kr.co.asnet.migam.domain.call.CompletionCallAnalysis;
import kr.co.asnet.migam.repository.call.CompletionCallAnalysisDao;


/** 
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("CompletionCallAnalysisService")
public class CompletionCallAnalysisServiceImpl implements CompletionCallAnalysisService { 
	
	@Inject
	private CompletionCallAnalysisDao CompletionCallAnalysisDao; 

	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAnalysisService#getCallAnalysisList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<CompletionCallAnalysis> getCompletionCallAnalysisList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return CompletionCallAnalysisDao.selectCompletionCallAnalysisList(pageDTO, searchDTO, orderby);
	}
	
	
}
