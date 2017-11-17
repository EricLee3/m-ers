package kr.co.asnet.migam.repository.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.call.HourlyCall;

/**
 * 시간대별 통계 내역을 조회하기 위한 Repository 클래스입니다.
 * 
 * Updated 2016-09-25
 */
public interface HourlyCallDao {

	/**
	 * 일간 통화(HourlyCall) 내역 리스트를 조회합니다.
	 * 주의 사항 : 일간 통화 내역은, 시간대별 통계를 가져오기 때문에, Hourly-Call관련 테이블인 mecs5_agent_stat_hourly 를 참고합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<HourlyCall> selectHourlyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 콜별리포트의 차트 작성을 위해 필요한 정보를 반환합니다.
	 * 
	 * @param searchDTO / startDate, endDate를 사용하고 - searchGroup:agentGroup, searchId:agentId로 사용합니다.
	 * @param orderby
	 * @return
	 */
	public List<HourlyCall> selectHourlyCallListForChart(SearchDTO searchDTO, String orderby);

	/**
	 * 콜별리포트의 차트 작성을 위해 필요한 정보를 반환합니다.
	 * 
	 * @param searchDTO / startDate, endDate를 사용하고 - searchGroup:agentGroup, searchId:agentId로 사용합니다.
	 * @param orderby
	 * @return
	 */
	public List<HourlyCall> selectHourlyCallListByOrderForYmdH(PageDTO2 pageDTO2, SearchDTO searchDTO, String orderby);
	
	
	public int selectHourMonitorStatCount(SearchDTO searchDTO);
}
