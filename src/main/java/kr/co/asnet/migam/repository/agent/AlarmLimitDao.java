package kr.co.asnet.migam.repository.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmLimit;
import kr.co.asnet.migam.domain.agent.HisLog;

/**
 * 임계치 값을 가져오기 위한  DAO 인터페이스
 */
public interface AlarmLimitDao {
	/**
	 * 현재 Database에 저장된 임계치(Parameter)값을 반환합니다.
	 * History를 반환하지 않습니다. 
	 */
	public AlarmLimit selectAlarmLimit(String alrmIdx);
	
	/**
	 * 임계치 정보를 수정합니다.
	 * 
	 * @param parameter
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateAlarmLimit(AlarmLimit alarmLimit);
	
	/**
	 * 사용자 조작이력을 등록합니다.
	 * 
	 * @param parameter
	 * @return
	 *  성공하면 제목을 반환합니다.
	 *  실패하면, NULL을 반환합니다.
	 */
	public int insertHis(HisLog hisLog);
	
	/**
	 * 임계치 설정 기록 정보를 입력합니다.
	 * 
	 * @param parameter
	 * @return
	 *  성공하면 제목을 반환합니다.
	 *  실패하면, NULL을 반환합니다.
	 */
	public String insertAlarmLimit(AlarmLimit alarmLimit);
	
	/**
	 * 임계치 설정 기록을 목록으로 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<AlarmLimit> selectAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<AlarmLimit> selectSearchAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
}
