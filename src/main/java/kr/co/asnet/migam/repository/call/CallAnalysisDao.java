package kr.co.asnet.migam.repository.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.CallAnalysis;

/**
 * 일간 통화 내역을 조회하기 위한 Repository 클래스입니다.
 * 
 * Updated 2016-09-25
 */
public interface CallAnalysisDao {

	/**
	 * 최근 콜 내역 리스트를 조회합니다.
	 * 상담원 상세 조회 화면과 콜 리포트 화면에서 사용합니다.
	 * 주의 사항 : 콜 내역은 분석된 결과가 저장된 테이블  mecs5_analysis_result 를 참고합니다.
	 * 	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<CallAnalysis> selectCallAnalysisList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 맞는 Call-Analysis 아이템의 갯수를 반환합니다.
	 * @param searchDTO
	 * @return
	 */
	public int selectCallAnalysisCount(SearchDTO searchDTO);
	
	/**
	 * 주어진 정보에 해당하는 Call 정보(CallAnaysis)를 반환합니다.
	 * @param index
	 * @return
	 */
	public CallAnalysis selectCallAnalysis(int index);
	
	public List<CallAnalysis> selectAgentDailyAngryCallForDashBoard(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
}
