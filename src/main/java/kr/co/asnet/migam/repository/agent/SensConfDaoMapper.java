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
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensConf;
import kr.co.asnet.migam.domain.agent.SensMeta;


/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "sensconfDao")
public class SensConfDaoMapper implements SensConfDao { 
	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<SensConf> selectSensConfList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensConfList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<SensConf> selectSensConfList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensConfList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<SensConf> selectSensConfList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensConfList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<SensConf> selectSensConfList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensConfList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<SensConf> selectSensConfList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensConfList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 100개
	 */
	@Override
	public List<SensConf> selectSensConfList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensConfList", parameters);
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
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectCount", parameters);
	}

	@Override
	public int selectCount2(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectCount2", parameters);
	}


	@Override
	public List<SensConf> selectSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSvIndiList", parameters);
	}
	
	@Override
	public List<SensConf> selectIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectIndiList", parameters);
	}
	
	@Override
	public List<SensConf> selectSensChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensChkList", parameters);
	}
	
	@Override
	public List<SensConf> selectSensConf(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectSensConf", parameters);
	}
	
	
	
	@Override
	public int updateSensConf(SensConf sensConf) {
		return sqlSession.update("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.updateSensConf", sensConf);	
	}
	
	@Override
	public int deleteSensConf(SensConf sensConf) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.deleteSensConf", sensConf);
	}
	
	@Override
	public int deleteSensConf2(String index) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.deleteSensConf2", index);
	}
	
	@Override
	public String insertSensConf(SensConf sensConf) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.insertSensConf", sensConf);
		if (resultCode > 0) return sensConf.getName();
		else return null; 
	}
	
	@Override
	public List<SensConf> selectProChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectProChkList", parameters);
	}
	
	@Override
	public List<SensConf> selectLevelList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectLevelList", parameters);
	}
	
	@Override
	public int selectLevel(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectLevel", parameters);
	}
	
	@Override
	public int selectDupMinMax(SensConf sensConf) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.SensConfDaoMapper.selectDupMinMax", sensConf);
	}
}
