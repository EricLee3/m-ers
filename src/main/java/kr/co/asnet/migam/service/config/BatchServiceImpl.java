/**
 * 
 */
package kr.co.asnet.migam.service.config;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.Batch;
import kr.co.asnet.migam.repository.config.BatchDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("batchService")
public class BatchServiceImpl implements BatchService { 
	
	@Inject
	private BatchDao batchDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#insertAgent(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int insertBatch(Batch batch) {
		return batchDao.insertBatch(batch);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatch(int)
	 */
	@Override
	public Batch getBatch(int index) {
		return batchDao.selectBatch(index);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Batch> getBatchList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchDao.selectBatchList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<Batch> getBatchList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchDao.selectBatchList5(pageDTO, searchDTO, orderby);
	}
	

	
	@Override
	public List<Batch> getBatchList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return batchDao.selectBatchList15(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<Batch> getBatchList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchDao.selectBatchList25(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<Batch> getBatchList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchDao.selectBatchList50(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<Batch> getBatchList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchDao.selectBatchList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countBatchList(SearchDTO searchDTO) {
		return batchDao.selectCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#updateBatch(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int updateBatch(Batch batch) {
		return batchDao.updateBatch(batch);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#deleteBatch(int)
	 */
	@Override
	public Boolean deleteBatch(String index) {
		return batchDao.deleteBatch(index) > 0 ? true : false;
	}

}
