package kr.co.asnet.migam.service.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.CompletionCallAnalysis;


/**
 * 자동 수행 목록 정보 인터페이스
 */
public interface CompletionCallAnalysisService {

	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<CompletionCallAnalysis> getCompletionCallAnalysisList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

}



