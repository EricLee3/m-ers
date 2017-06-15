package kr.co.asnet.migam.repository.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.FaultAlarmHisGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmStatGroup;
import kr.co.asnet.migam.domain.agent.ProcessGroup;
import kr.co.asnet.migam.domain.agent.AlarmStatGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
/**
 * 상담원 그룹 DAO 인터페이스
 */
public interface ProcessGroupDao {
	
	
	/**
	 * CPU 정보
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 */
	public List<ProcessGroup> selectProcessGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * MEMORY 정보
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 */
	public List<ProcessGroup> selectMemoryGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * DISK 정보
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 */
	public List<ProcessGroup> selectDiskGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * PROCESS 정보
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 */
	public List<ProcessGroup> selectProcessList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 프로세스 목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectProcessCount(SearchDTO searchDTO);
	
	/**
	 * 프로세스 종료
	 * 
	 * @param groupId
	 * @return
	 */
	//public int deleteProcess(String category);
	
	/**
	 * 프로세스 시작
	 * 
	 * @param groupId
	 * @return
	 */
	//public int startProcess(String category);
	
	
	/**
	 * 현재 알람 이력
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 */
	public List<AlarmStatGroup> selectAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby); 
	
	/**
	 * 현재 알람 목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectAlarmStatCount(SearchDTO searchDTO);
	
	/**
	 * Fault 알람 이력
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby : SQL구문에서 사용한 order by 구문을 모두 입력해야 함
	 * @return
	 */
	public List<FaultAlarmStatGroup> selectFaultAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby); 
	
	/**
	 * Fault 알람 목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectFaultAlarmStatCount(SearchDTO searchDTO);

	
	/**
	 * 상담원 그룹 삭제
	 * 
	 * @param groupId
	 * @return
	 */
	public int deleteFaultAlarm(String code);
	
	/**
	 * 상담원 그룹 정보를 입력합니다.
	 * 
	 * @param alarmCode
	 * @return
	 *  성공하면 해당 그룹의 아이디를 반환합니다.
	 *  실패하면, NULL을 반환합니다.
	 */
	public String insertFaultHis(FaultAlarmLog fault);

}
