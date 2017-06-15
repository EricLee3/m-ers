package kr.co.asnet.migam.repository.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.AnalResult;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.ImsiMent;
import kr.co.asnet.migam.domain.agent.Recognition_job;
import kr.co.asnet.migam.domain.agent.Voicefile;



/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "SensdemoDao")
public class SensDemoDaoMapper implements SensDemoDao { 
	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	



	@Override
	public List<ImsiMent> selectImsiMentList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensDemoDaoMapper.selectImsiMentList", parameters);
	}
	
	@Override
	public List<AnalResult> selectAnalResultList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensDemoDaoMapper.selectAnalResultList", parameters);
	}

	
	@Override
	public String insertVoicefile(Voicefile voicefile) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.SensDemoDaoMapper.insertVoicefile", voicefile);
		if (resultCode > 0) return voicefile.getAgent_id();
		else return null; 
	}
	
	@Override
	public String insertRecognition_job(Recognition_job recognition_job) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.SensDemoDaoMapper.insertRecognition_job", recognition_job);
		if (resultCode > 0) return recognition_job.getJob_id();
		else return null; 
	}
	
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensDemoDaoMapper.selectCount", parameters);
	}
	
	@Override
	public int selectCountFailCode(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensDemoDaoMapper.selectCountFailCode", parameters);
	}
	
	@Override
	public List<ImsiMent> selectdemo_excel(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensDemoDaoMapper.selectdemo_excel", parameters);
	}
}
