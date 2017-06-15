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
import kr.co.asnet.migam.domain.agent.AlarmLimit;
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.HisLog;

/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "alarmLimitDao")
public class AlarmLimitDaoMapper implements AlarmLimitDao { 
	
	private static final Logger logger = LoggerFactory.getLogger(AlarmLimitDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.AlarmLimitDaoMapper.selectParameter()
	 */
	@Override
	public AlarmLimit selectAlarmLimit(String alarmIdx) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.AlarmLimitDaoMapper.selectAlarmLimit", alarmIdx);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.parameter.ParameterDao#updateParameter(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public int updateAlarmLimit(AlarmLimit alarmLimit) {
		return sqlSession.update("kr.co.asnet.migam.repository.agent.AlarmLimitDaoMapper.updateAlarmLimit", alarmLimit);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.parameter.ParameterDao#insertAlarmLimit(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public String insertAlarmLimit(AlarmLimit alarmLimit) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.AlarmLimitDaoMapper.insertAlarmLimit", alarmLimit);
		if (resultCode > 0) return alarmLimit.getAlarmIdx();
		else return null; 
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.parameter.ParameterDao#insertAlarmLimit(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public int insertHis(HisLog hisLog) {
		return sqlSession.insert("kr.co.asnet.migam.repository.agent.AlarmLimitDaoMapper.insertHis", hisLog);
	}


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.parameter.ParameterDao#selectAlarmLimitList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<AlarmLimit> selectAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmLimitDaoMapper.selectAlarmLimitList", parameters);
	}
	
	@Override
	public List<AlarmLimit> selectSearchAlarmLimitList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.AlarmLimitDaoMapper.selectSearchAlarmLimitList", parameters);
	}
}
