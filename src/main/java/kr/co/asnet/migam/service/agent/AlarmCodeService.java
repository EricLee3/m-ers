package kr.co.asnet.migam.service.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmCode;

/**
 * 상담원 그룹 정보 인터페이스
 */
public interface AlarmCodeService {

	/**
	 * @param alarmCode
	 * 	alarmCode.id는 반드시 고유한 값으로 지정되어야 합니다. 
	 * 
	 * @return String  
	 *   성공적으로 추가된 경우, 해당 alarmCode의 id를 반환합니다.
	 *   실패한 경우에는 null을 반환합니다. ( 오류 정보는 logger를 확인해 주십시오 ) 
	 */
	public String insertAlarmCode(AlarmCode alarmCode);


	/**
	 * 지정된 아이디(groupId)에 해당하는 AlarmCode객체를 반환합니다. 
	 * @param groupId
	 * @return
	 */
	public AlarmCode getAlarmCode(String alarmCode);

	/**
	 * 주어진 조건에 따라 AlarmCode 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<AlarmCode> getAlarmCodeList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 AlarmCode 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<AlarmCode> getAlarmCodeList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 AlarmCode 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<AlarmCode> getAlarmCodeList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 AlarmCode 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<AlarmCode> getAlarmCodeList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 AlarmCode 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<AlarmCode> getAlarmCodeList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 AlarmCode 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<AlarmCode> getAlarmCodeList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 상담원 그룹  카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countAlarmCodeList(SearchDTO searchDTO);

	/**
	 * 상담원 크룹 정보를 업데이트합니다. 
	 * @param AlarmCode
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateAlarmCode(AlarmCode alarmCode);

	/**
	 * 상담원 그룹을 삭제합니다. 단, 연관된 상담원 목록을 삭제하지 않으므로 상담원 정보에 포함된 그룹 ID 참고시 오류가 발생할 수 있습니다.
	 * 
	 * @param groupId
	 * @return
	 */
	public Boolean deleteAlarmCode(String alarmCode);
	
	/**
	 * 존재하는 ID 인지 조회합니다.
	 * 
	 * @param groupId
	 * @return
	 */
	public boolean isDuplicatedAlarmCode(String alarmCode);
	
	/**
	 * 주어진 조건에 따라 프로세스상태를 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<AlarmCode> getProcessList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
}


