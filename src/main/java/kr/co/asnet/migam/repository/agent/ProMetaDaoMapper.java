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
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.SensMeta;


/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "ProMetaDao")
public class ProMetaDaoMapper implements ProMetaDao { 
	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ProMeta> selectProMetaList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMetaList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<ProMeta> selectProMetaList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMetaList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<ProMeta> selectProMetaList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMetaList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<ProMeta> selectProMetaList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMetaList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<ProMeta> selectProMetaList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMetaList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 100개
	 */
	@Override
	public List<ProMeta> selectProMetaList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMetaList", parameters);
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
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectCount", parameters);
	}
	
	@Override
	public int selectCount_pro(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectCount_pro", parameters);
	}
	
	@Override
	public int selectCount_sc(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectCount_sc", parameters);
	}


	@Override
	public List<ProMeta> selectSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectSvIndiList", parameters);
	}
	
	@Override
	public List<ProMeta> selectIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectIndiList", parameters);
	}
	
	@Override
	public ProMeta selectProMeta(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMeta", groupId);	
	}
	
	@Override
	public ProMeta selectProMeta2(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProMeta2", groupId);	
	}
	
	@Override
	public ProMeta selectProIdx(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectProIdx", groupId);	
	}
	
	@Override
	public int updateProMeta(ProMeta ProMeta) {
		return sqlSession.update("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.updateProMeta", ProMeta);	
	}
	
	@Override
	public int deleteProMeta(String index) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.deleteProMeta", index);
	}
	
	@Override
	public int deleteProMeta2(String index) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.deleteProMeta2", index);
	}
	
	@Override
	public ProMeta selectName(String groupId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.selectName", groupId);	
	}
	
	@Override
	public String insertProMeta(ProMeta proMeta) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.agent.ProMetaDaoMapper.insertProMeta", proMeta);
		if (resultCode > 0) return proMeta.getName();
		else return null; 
	}
}
