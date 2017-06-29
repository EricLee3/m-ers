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
import kr.co.asnet.migam.domain.call.RealindState;
import kr.co.asnet.migam.repository.call.RealindStateDao;


/** 
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("RealindStateService")
public class RealindStateServiceImpl implements RealindStateService { 
	
	@Inject
	private RealindStateDao RealindStateDao; 

	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.call.CallAnalysisService#getCallAnalysisList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public RealindState getRealindState(SearchDTO searchDTO) {
		return RealindStateDao.selectRealindState(searchDTO);
	}
	
	@Override
	public List<RealindState> getRealindStateList(SearchDTO searchDTO, String orderby) {
		return RealindStateDao.selectRealindStateList(searchDTO, orderby);
	}
}
