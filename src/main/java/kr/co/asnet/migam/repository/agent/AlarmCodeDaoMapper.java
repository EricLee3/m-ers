/**
 * 
 */
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
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmCode;

/**
 * @author byonghee
 *
 */
@Repository(value = "AlarmCodeDao")
public class AlarmCodeDaoMapper implements AlarmCodeDao {

	private static final Logger logger = LoggerFactory.getLogger(AlarmCodeDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#insertAlarmCode(kr.co.asnet.migam.domain.agentAlarmCodep)
	 */
	@Override
	public String insertAlarmCode(AlarmCode alarmCode) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.insertAlarmCode", alarmCode);
		if (resultCode > 0) return alarmCode.getAlarmCode();
		else return null; 
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectAlarmCode(java.lang.String)
	 */
	@Override
	public AlarmCode selectAlarmCode(String alarmCode) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectAlarmCode", alarmCode);	
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#updateAlarmCode(kr.co.asnet.migam.domain.agent.AlarmCode)
	 */
	@Override
	public int updateAlarmCode(AlarmCode alarmCode) {
		return sqlSession.update("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.updateAlarmCode", alarmCode);	
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<AlarmCode> selectAlarmCodeList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectAlarmCodeList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<AlarmCode> selectAlarmCodeList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectAlarmCodeList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<AlarmCode> selectAlarmCodeList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectAlarmCodeList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<AlarmCode> selectAlarmCodeList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectAlarmCodeList", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<AlarmCode> selectAlarmCodeList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectAlarmCodeList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 100개
	 */
	@Override
	public List<AlarmCode> selectAlarmCodeList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectAlarmCodeList", parameters);
	}



	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#selectCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AlarmCodeDao#deleteAlarmCode(java.lang.String)
	 */
	@Override
	public int deleteAlarmCode(String groupId) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.AlarmCodeDaoMapper.deleteAlarmCode", groupId);
	}

}
