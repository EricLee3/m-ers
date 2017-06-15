package kr.co.asnet.migam.service.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.DailyCall;

/**
 * 일간 Call 정보를 제공하기 위한 서비스  인터페이스
 */
public interface DailyCallService {

	/**
	 * 주어진 조건에 따라  DailyCall객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<DailyCall> getDailyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	
	/**
	 * 주어진 조건에 따라  DailyCall객체 목록을 반환합니다.
	 * 단, 본 메소드는 차트를 그리는 것에 필요한 정보를 제공합니다.
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<DailyCall> getDailyCallListForChart(SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라  DailyCall객체 목록을 반환합니다.
	 * 단, 본 메소드는 고객별 차트를 그리는 것에 필요한 정보를 제공하므로, DailyCall의 몇몇 정보만 사용합니다.
	 * @param searchDTO
	 * @return
	 */
	public List<DailyCall> getCustomerCallListForChart(SearchDTO searchDTO);

}
	


