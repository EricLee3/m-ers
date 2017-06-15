/**
 * 
 */
package kr.co.asnet.migam.repository.config;

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
import kr.co.asnet.migam.domain.config.BatchHistory;

/**
 * @author younghoon
 *
 */
@Repository(value = "BatchHistoryDao")
public class BatchHistoryDaoMapper implements BatchHistoryDao {
	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#insertBatch(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int insertBatchHistory(BatchHistory batchHistory) {
		return sqlSession.insert("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.insertBatchHistory", batchHistory);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatch(int)
	 */
	@Override
	public BatchHistory selectBatchHistory(int batchHistoryIndex) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistory", batchHistoryIndex);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatch(java.lang.String)
	 */
	@Override
	public BatchHistory selectBatchHistory(String jobId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistoryById", jobId);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<BatchHistory> selectBatchHistoryList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistoryList", parameters);
	}
	
	@Override
	public List<BatchHistory> selectBatchHistoryList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistoryList", parameters);
	}
	
	@Override
	public List<BatchHistory> selectBatchHistoryList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistoryList", parameters);
	}
	
	@Override
	public List<BatchHistory> selectBatchHistoryList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistoryList", parameters);
	}
	
	@Override
	public List<BatchHistory> selectBatchHistoryList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistoryList", parameters);
	}
	
	@Override
	public List<BatchHistory> selectBatchHistoryList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectBatchHistoryList", parameters);
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
		return sqlSession.selectOne("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#deleteBatch(int)
	 */
	@Override
	public int deleteBatchHistory(int batchHistoryIndex) {
		return sqlSession.delete("kr.co.asnet.migam.repository.config.BatchHistoryDaoMapper.deleteBatchHistory", batchHistoryIndex);
	}

}
