package kr.co.asnet.migam.service.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.CallAnalysis;

/**
 * 최근 Call 목록, 콜별 리포트 정보를 제공하기 위한 서비스  인터페이스
 */
public interface CallAnalysisService {

	/**
	 * 주어진 조건에 따라  CallAnalysis객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<CallAnalysis> getCallAnalysisList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 맞는 Call-Analysis 아이템의 갯수를 반환합니다.
	 * @param searchDTO
	 * @return
	 */
	public int getCallAnalysisCount(SearchDTO searchDTO);
	
	/**
	 * 주어진 정보에 해당하는 Call 정보(CallAnaysis)를 반환합니다.
	 * @param callIndex
	 * @return
	 */
	public CallAnalysis getCallAnalysis(int callIndex);
	
	public List<CallAnalysis> getAgentDailyAngryCallForDashBoard(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
}
