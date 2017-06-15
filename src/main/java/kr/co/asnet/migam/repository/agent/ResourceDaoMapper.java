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
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.ResourceLog;

/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "resourcdDao")
public class ResourceDaoMapper implements ResourceDao { 
	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#insertBatch(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int insertResourceLog(ResourceLog resourceLog) {
		return sqlSession.insert("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.insertResourceLog", resourceLog);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatch(int)
	 */
	@Override
	public ResourceLog selectResourceLog(int resourceLogIndex) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLog", resourceLogIndex);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatch(java.lang.String)
	 */
	@Override
	public ResourceLog selectResourceLog(String updateTime) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLogById", updateTime);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ResourceLog> selectResourceLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLogList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<ResourceLog> selectResourceLogList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLogList", parameters);
	}
	
	@Override
	public List<ResourceLog> selectCategoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectCategoryList", parameters);
	}
	
	@Override
	public List<ResourceLog> selectLevelList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectLevelList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<ResourceLog> selectResourceLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLogList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<ResourceLog> selectResourceLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLogList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<ResourceLog> selectResourceLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLogList", parameters);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<ResourceLog> selectResourceLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {  
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectResourceLogList", parameters);
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
		return sqlSession.selectOne("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#deleteBatch(int)
	 */
	@Override
	public int deleteResourceLog(int resourceLogIndex) {
		return sqlSession.delete("kr.co.asnet.migam.repository.agent.ResourceDaoMapper.deleteResourceLog", resourceLogIndex);
	}

}
