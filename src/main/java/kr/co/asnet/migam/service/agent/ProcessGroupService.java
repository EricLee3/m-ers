package kr.co.asnet.migam.service.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.FaultAlarmHisGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmStatGroup;
import kr.co.asnet.migam.domain.agent.ProcessGroup;
import kr.co.asnet.migam.domain.agent.AlarmStatGroup;
/**
 * 상담원 그룹 정보 인터페이스
 */
public interface ProcessGroupService {

	/**
	 * CPU 정보
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ProcessGroup> getProcessGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * MEMORY 정보
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ProcessGroup> getMemoryGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * DISK 정보
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ProcessGroup> getDiskGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * PROCESS 정보
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ProcessGroup> getProcessList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 프로세스 목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countProcessList(SearchDTO searchDTO);
	
	/**
	 * 프로세스 종류
	 * 
	 * @param groupId
	 * @return
	 */
	//public Boolean deleteProcess(String category);
	
	/**
	 * 프로세스 시작
	 * 
	 * @param groupId
	 * @return
	 */
	//public Boolean startProcess(String category);
	
	/**
	 * 현재 알람 정보
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<AlarmStatGroup> getAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * fault 알람 정보
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<FaultAlarmStatGroup> getFaultAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 현재 알람 목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countAlarmStatList(SearchDTO searchDTO);
	
	/**
	 * Fault 알람 목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countFaultAlarmStatList(SearchDTO searchDTO);
	

	/**
	 * 상담원 그룹을 삭제합니다. 단, 연관된 상담원 목록을 삭제하지 않으므로 상담원 정보에 포함된 그룹 ID 참고시 오류가 발생할 수 있습니다.
	 * 
	 * @param groupId
	 * @return
	 */
	public Boolean deleteFaultAlarm(String code);
	
	/**
	 * @param alarmCode
	 * 	alarmCode.id는 반드시 고유한 값으로 지정되어야 합니다. 
	 * 
	 * @return String  
	 *   성공적으로 추가된 경우, 해당 alarmCode의 id를 반환합니다.
	 *   실패한 경우에는 null을 반환합니다. ( 오류 정보는 logger를 확인해 주십시오 ) 
	 */
	public String insertFaultHis(FaultAlarmLog fault);

}

	
