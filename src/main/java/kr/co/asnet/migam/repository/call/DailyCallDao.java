package kr.co.asnet.migam.repository.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.DailyCall;

/**
 * 일간 통계 내역을 조회하기 위한 Repository 클래스입니다.
 * 
 * Updated 2016-09-28
 */
public interface DailyCallDao {

	/**
	 * 일간 통계(DailyCall) 내역 리스트를 조회합니다.
	 * 주의 사항 : 일간 통화 내역은, Daily-Call 관련 테이블인 mecs5_agent_stat_daily 와 mecs5_service_stat_daily 를 참고합니다.
	 * 
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<DailyCall> selectDailyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 콜별리포트의 차트 작성을 위해 필요한 정보를 반환합니다.
	 * 
	 * @param searchDTO / startDate, endDate를 사용하고 - searchGroup:agentGroup, searchId:agentId로 사용합니다.
	 * @param orderby
	 * @return
	 */
	public List<DailyCall> selectDailyCallListForChart(PageDTO2 pageDTO2,SearchDTO searchDTO, String orderby);
	
	
	public int selectDayMonitorStatCount(SearchDTO searchDTO);
}
