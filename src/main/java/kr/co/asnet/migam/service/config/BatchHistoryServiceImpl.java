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
import kr.co.asnet.migam.domain.config.BatchHistory;
import kr.co.asnet.migam.repository.config.BatchHistoryDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("batchHistoryService")
public class BatchHistoryServiceImpl implements BatchHistoryService {
	
	@Inject
	private BatchHistoryDao batchHistoryDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#insertAgent(kr.co.asnet.migam.domain.config.Batch)
	 */
	@Override
	public int insertBatchHistory(BatchHistory batchHistory) {
		return batchHistoryDao.insertBatchHistory(batchHistory);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatch(int)
	 */
	@Override
	public BatchHistory getBatchHistory(int index) {
		return batchHistoryDao.selectBatchHistory(index);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<BatchHistory> getBatchHistoryList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchHistoryDao.selectBatchHistoryList(pageDTO, searchDTO, orderby);
	}
	@Override
	public List<BatchHistory> getBatchHistoryList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchHistoryDao.selectBatchHistoryList5(pageDTO, searchDTO, orderby);
	}
	@Override
	public List<BatchHistory> getBatchHistoryList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return batchHistoryDao.selectBatchHistoryList15(pageDTO, searchDTO, orderby);
	}
	@Override
	public List<BatchHistory> getBatchHistoryList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchHistoryDao.selectBatchHistoryList25(pageDTO, searchDTO, orderby);
	}
	@Override
	public List<BatchHistory> getBatchHistoryList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchHistoryDao.selectBatchHistoryList50(pageDTO, searchDTO, orderby);
	}
	@Override
	public List<BatchHistory> getBatchHistoryList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return batchHistoryDao.selectBatchHistoryList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#countBatchList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countBatchHistoryList(SearchDTO searchDTO) {
		return batchHistoryDao.selectCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#deleteBatch(int)
	 */
	@Override
	public Boolean deleteBatchHistory(int index) {
		return batchHistoryDao.deleteBatchHistory(index) > 0 ? true : false;
	}

}
