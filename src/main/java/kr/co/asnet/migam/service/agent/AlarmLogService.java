package kr.co.asnet.migam.service.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmLog;

/**
 * 자동 수행 목록 정보 인터페이스
 */
public interface AlarmLogService {

	/**
	 * 데이터베이스에 새로운 자동 수행 목록를 추가합니다.
	 * @param batchHistory
	 * @return int  
	 *  새로 추가된 자동 수행 목록의 index를 반환합니다.
	 */
	public int insertAlarmLog(AlarmLog alarmLog);


	/**
	 * 지정된 번호(index)에 해당하는 Batch객체를 반환합니다. 
	 * @param index
	 * @return
	 */
	public AlarmLog getAlarmLog(int index);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<AlarmLog> getAlarmLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<AlarmLog> getAlarmLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<AlarmLog> getAlarmLogList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<AlarmLog> getAlarmLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<AlarmLog> getAlarmLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<AlarmLog> getAlarmLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동수행목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countAlarmLogList(SearchDTO searchDTO);

	
	/**
	 * 자동 수행 목록 삭제
	 * 
	 * @param index
	 * @return
	 */
	public Boolean deleteAlarmLog(int index);

	
	
	
}


