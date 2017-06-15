package kr.co.asnet.migam.repository.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.FaultAlarmHisGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmStatGroup;
import kr.co.asnet.migam.domain.agent.ProcessGroup;
import kr.co.asnet.migam.domain.agent.AlarmStatGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;

/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "processDao")
public class ProcessDaoMapper implements ProcessGroupDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ProcessDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;

	
	/* CPU
	 *  (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> selectProcessGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectProcessGroupList", parameters);
	}
	
	/* MEMORY
	 *  (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> selectMemoryGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectMemoryGroupList", parameters);
	}
	
	/* DISK
	 *  (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> selectDiskGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectDiskGroupList", parameters);
	}
	
	/* PROCESS
	 *  (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<ProcessGroup> selectProcessList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectProcessList", parameters);
	}
	
	/* 프로세스 목록 카운트
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int selectProcessCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectProcessCount", parameters);
	}
	
	
	
	/* 현재 알람 목록
	 *  (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AlarmStatGroup> selectAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectAlarmStatList", parameters);
	}
	
	/* 현재 알람 목록 카운트
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int selectAlarmStatCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectAlarmStatCount", parameters);
	}
	
	/* Fault 알람 목록
	 *  (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentDao#selectAgentList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<FaultAlarmStatGroup> selectFaultAlarmStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectFaultAlarmStatList", parameters);
	}
	
	/* Fault 알람 목록 카운트
	 * (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int selectFaultAlarmStatCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.selectFaultAlarmStatCount", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.ProcessDaoMapper#deleteFaultAlarm(java.lang.String)
	 */
	@Override
	public int deleteFaultAlarm(String code) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.deleteFaultAlarm", code);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#insertAlarmCode(kr.co.asnet.migam.domain.agentAlarmCodep)
	 */
	@Override
	public String insertFaultHis(FaultAlarmLog fault) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.ProcessDaoMapper.insertFaultHis", fault);
		if (resultCode > 0) return fault.getCode();
		else return null; 
	}
}
