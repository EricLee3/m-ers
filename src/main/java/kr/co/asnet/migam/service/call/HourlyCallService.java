package kr.co.asnet.migam.service.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.call.HourlyCall;

/**
 * 시간대별 Call 정보를 제공하기 위한 서비스  인터페이스
 */
public interface HourlyCallService {

	/**
	 * 주어진 조건에 따라  HourlyCall객체 목록을 반환합니다. 시간대별 통계, 상담원 목록-오늘 콜 정보, 콜 목록-오늘 시간대별 A,S 콜 정보 에서 사용합니다. 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<HourlyCall> getHourlyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 주어진 조건에 따라  HourlyCall객체 목록을 반환합니다.
	 * 단, 본 메소드는 차트를 그리는 것에 필요한 정보를 제공합니다.
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<HourlyCall> getHourlyCallListForChart(SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라  HourlyCall객체 목록을 반환합니다.
	 * 시간대별 통계 자료를 순서대로 가져 오며, sum 등 합산을 하지 않은 상태의 리스트로 저장됩니다.
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<HourlyCall> getHourlyCallListByOrder(PageDTO2 pageDTO2, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라  HourlyCall객체 목록을 반환합니다.
	 * 시간대별 통계 자료를 순서대로 가져 오며, sum 등 합산을 하지 않은 상태의 리스트로 count 저장됩니다.
	 * @param searchDTO
	 * @return
	 */
	public int selectHourMonitorStatCount(SearchDTO searchDTO);
}


