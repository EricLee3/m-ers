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
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.SensMeta;


/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "sensbasicDao")
public class SensBasicDaoMapper implements SensBasicDao { 
	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensBasic> selectSensBasicList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectSensBasicList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<SensBasic> selectSensBasicList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectSensBasicList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<SensBasic> selectSensBasicList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectSensBasicList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<SensBasic> selectSensBasicList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectSensBasicList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<SensBasic> selectSensBasicList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectSensBasicList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 100개
	 */
	@Override
	public List<SensBasic> selectSensBasicList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectSensBasicList", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectCount", parameters);
	}

	@Override
	public List<SensBasic> selectNameList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectNameList", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#insertAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public String insertSensBasic(SensBasic sensBasic) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.insertSensBasic", sensBasic);
		if (resultCode > 0) return sensBasic.getName();
		else return null; 
	}
	
	public String insertSensMeta(SensMeta sensMeta) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.insertSensMeta", sensMeta);
		if (resultCode > 0) return sensMeta.getName();
		else return null; 
	}
	
	public String insertSensMap(SensMeta sensMeta) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.insertSensMap", sensMeta);
		if (resultCode > 0) return sensMeta.getName();
		else return null; 
	}
	
	public String insertSensMap_update(SensMeta sensMeta) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.insertSensMap_update", sensMeta);
		if (resultCode > 0) return sensMeta.getName();
		else return null; 
	}
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroup(java.lang.String)
	 */
	@Override
	public SensBasic selectSensBasic(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectSensBasic", groupId);	
	}
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#updateAgentGroup(kr.co.asnet.migam.domain.agent.AgentGroup)
	 */
	@Override
	public int updateSensBasic(SensBasic SensBasic) {
		return sqlSession.update("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.updateSensBasic", SensBasic);	
	}
	
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.insertAgent(kr.co.asnet.migam.domain.Agent)
	 */
	@Override
	public int deleteSensBasic(String index) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.deleteSensBasic", index);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.agent.AgentGroupDao#selectAgentGroup(java.lang.String)
	 */
	@Override
	public SensBasic selectAgentGroup(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectAgentGroup", groupId);	
	}
	
	@Override
	public SensBasic selectName(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensBasicDaoMapper.selectName", groupId);	
	}
	
	

}
