package kr.co.asnet.migam.service.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmLimit;
import kr.co.asnet.migam.domain.agent.HisLog;

/**
 * 임계치 정보 인터페이스
 */
public interface AlarmLimitService {

	/**
	 * 현재 Database에 등록된 Parameter값을 가져온다. 
	 * @return
	 */
	public AlarmLimit getAlarmLimit(String alarmIdx);

	/**
	 * 임계치 설정 정보를 업데이트합니다. 
	 * @param parameter
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateAlarmLimit(AlarmLimit alarmLimit);
	
	/**
	 * 사용자 이력에 등록합니다. 
	 * @param parameter
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */

	public int insertHis(HisLog hisLog);
	
	/**
	 * @param parameter
	 * 	설정 내역을 mecs5_recognition_parameter_history 에 인서트합니다.
	 *  설정값은  mecs5_recognition_parameter 테이블에 저장됩니다.
	 * 
	 * @return String  
	 *   성공적으로 추가된 경우, title 을 반환합니다.
	 *   실패한 경우에는 null을 반환합니다. ( 오류 정보는 logger를 확인해 주십시오 ) 
	 */
	public String insertAlarmLimit(AlarmLimit alarmLimit);
	
	/**
	 * 주어진 조건에 따라 Parameter 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<AlarmLimit> getAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<AlarmLimit> getSearchAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
}


