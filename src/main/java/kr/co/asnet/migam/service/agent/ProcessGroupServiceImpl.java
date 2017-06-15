/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.FaultAlarmHisGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmStatGroup;
import kr.co.asnet.migam.domain.agent.ProcessGroup;
import kr.co.asnet.migam.domain.agent.AlarmStatGroup;
import kr.co.asnet.migam.repository.agent.ProcessGroupDao;

/**
 * @author byonghee
 * 상담원 그룹 정보 구현 클래스 
 */
@Service("processGroupService")
public class ProcessGroupServiceImpl implements ProcessGroupService {

	@Inject
	private ProcessGroupDao processGroupDao;

	/* CPU
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> getProcessGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return processGroupDao.selectProcessGroupList(pageDTO, searchDTO, orderby);
	}
	
	/* CPU
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> getMemoryGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return processGroupDao.selectMemoryGroupList(pageDTO, searchDTO, orderby);
	}
	
	/* DISK
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> getDiskGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return processGroupDao.selectDiskGroupList(pageDTO, searchDTO, orderby);
	}
	
	/* PROCESS
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> getProcessList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return processGroupDao.selectProcessList(pageDTO, searchDTO, orderby);
	}
	
	/* PROCESS 목록 카운트
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#countAgentList(kr.co.asnet.migam.domain.agent.Agent, kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countProcessList(SearchDTO searchDTO) {
		return processGroupDao.selectProcessCount(searchDTO);
	}
	
	/* 현재 알람 목록
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	
	@Override
	public List<AlarmStatGroup> getAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return processGroupDao.selectAlarmStatList(pageDTO, searchDTO, orderby);
	}
	
	/* 현재 알람 목록 카운트
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#countAgentList(kr.co.asnet.migam.domain.agent.Agent, kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countAlarmStatList(SearchDTO searchDTO) {
		return processGroupDao.selectAlarmStatCount(searchDTO);
	}
	
	/* 현재 알람 목록
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentGroupService#getAgentGroupList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	
	@Override
	public List<FaultAlarmStatGroup> getFaultAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return processGroupDao.selectFaultAlarmStatList(pageDTO, searchDTO, orderby);
	}
	
	/* 현재 알람 목록 카운트
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AgentService#countAgentList(kr.co.asnet.migam.domain.agent.Agent, kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countFaultAlarmStatList(SearchDTO searchDTO) {
		return processGroupDao.selectFaultAlarmStatCount(searchDTO);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#deleteFaultAlarm(java.lang.String)
	 */
	@Override
	public Boolean deleteFaultAlarm(String code) {
		return processGroupDao.deleteFaultAlarm(code) > 0 ? true : false;	
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#insertAlarmCode(kr.co.asnet.migam.domain.agent.AlarmCode)
	 */
	@Override
	public String insertFaultHis(FaultAlarmLog fault) {
		return processGroupDao.insertFaultHis(fault);	
	}
}
