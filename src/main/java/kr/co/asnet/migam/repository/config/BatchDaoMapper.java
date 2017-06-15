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
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.Batch;

/**
 * @author younghoon
 *
 */
@Repository(value = "BatchDao")
public class BatchDaoMapper implements BatchDao {
	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#insertBatch(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int insertBatch(Batch batch) {
		return sqlSession.insert("kr.co.asnet.migam.repository.config.BatchDaoMapper.insertBatch", batch);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatch(int)
	 */
	@Override
	public Batch selectBatch(int batchIndex) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatch", batchIndex);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatch(java.lang.String)
	 */
	@Override
	public Batch selectBatch(String jobId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatchById", jobId);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#updateBatch(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int updateBatch(Batch batch) {
		return sqlSession.update("kr.co.asnet.migam.repository.config.BatchDaoMapper.updateBatch", batch);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#selectBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Batch> selectBatchList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatchList", parameters);
	}
	
	@Override
	public List<Batch> selectBatchList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatchList", parameters);
	}
	
	
	@Override
	public List<Batch> selectBatchList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatchList", parameters);
	}
	
	@Override
	public List<Batch> selectBatchList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatchList", parameters);
	}
	
	@Override
	public List<Batch> selectBatchList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatchList", parameters);
	}
	
	@Override
	public List<Batch> selectBatchList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectBatchList", parameters);
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
		return sqlSession.selectOne("kr.co.asnet.migam.repository.config.BatchDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.BatchDao#deleteBatch(int)
	 */
	@Override
	public int deleteBatch(String batchIndex) {
		return sqlSession.delete("kr.co.asnet.migam.repository.config.BatchDaoMapper.deleteBatch", batchIndex);
	}

}
