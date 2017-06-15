package kr.co.asnet.migam.repository.agent;

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
 * 상담원 그룹 DAO 인터페이스
 */
public interface AlarmCodeDao {
	/**
	 * 상담원 그룹 정보를 입력합니다.
	 * 
	 * @param alarmCode
	 * @return
	 *  성공하면 해당 그룹의 아이디를 반환합니다.
	 *  실패하면, NULL을 반환합니다.
	 */
	public String insertAlarmCode(AlarmCode alarmCode);

	/**
	 * 주어진 상담원 그룹의 고유 번호를 기반으로 해당 상담원 그룹 정보를 반환합니다. 
	 * 
	 * @param groupId
	 * @return
	 *  domain.AlarmCode 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public AlarmCode selectAlarmCode(String alarmCode);

	/**
	 * 상담원 그룹 정보를 수정합니다.
	 * 
	 * @param alarmCode
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateAlarmCode(AlarmCode alarmCode);
	
	/**
	 * 상담원 그룹 리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 * 10개
	 */
	public List<AlarmCode> selectAlarmCodeList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 상담원 그룹 리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 * 5개
	 */
	public List<AlarmCode> selectAlarmCodeList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 상담원 그룹 리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 * 15개
	 */
	public List<AlarmCode> selectAlarmCodeList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 상담원 그룹 리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 * 25개
	 */
	public List<AlarmCode> selectAlarmCodeList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 상담원 그룹 리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 * 50개
	 */
	public List<AlarmCode> selectAlarmCodeList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 상담원 그룹 리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 * 100개
	 */
	public List<AlarmCode> selectAlarmCodeList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 상담원 그룹 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	/**
	 * 상담원 그룹 삭제
	 * 
	 * @param groupId
	 * @return
	 */
	public int deleteAlarmCode(String groupId);
	

}
