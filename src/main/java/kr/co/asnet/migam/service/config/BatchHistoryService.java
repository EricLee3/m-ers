package kr.co.asnet.migam.service.config;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.BatchHistory;

/**
 * 자동 수행 목록 정보 인터페이스
 */
public interface BatchHistoryService {

	/**
	 * 데이터베이스에 새로운 자동 수행 목록를 추가합니다.
	 * @param batchHistory
	 * @return int  
	 *  새로 추가된 자동 수행 목록의 index를 반환합니다.
	 */
	public int insertBatchHistory(BatchHistory batchHistory);


	/**
	 * 지정된 번호(index)에 해당하는 Batch객체를 반환합니다. 
	 * @param index
	 * @return
	 */
	public BatchHistory getBatchHistory(int index);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<BatchHistory> getBatchHistoryList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	public List<BatchHistory> getBatchHistoryList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	public List<BatchHistory> getBatchHistoryList15(PageDTO pageDTO15, SearchDTO searchDTO, String orderby);
	public List<BatchHistory> getBatchHistoryList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	public List<BatchHistory> getBatchHistoryList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	public List<BatchHistory> getBatchHistoryList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동수행목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countBatchHistoryList(SearchDTO searchDTO);

	
	/**
	 * 자동 수행 목록 삭제
	 * 
	 * @param index
	 * @return
	 */
	public Boolean deleteBatchHistory(int index);

	
	
	
}


