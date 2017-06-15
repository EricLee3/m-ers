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
import kr.co.asnet.migam.domain.config.Batch;

/**
 * 자동 수행 작업 정보 인터페이스
 */
public interface BatchService {

	/**
	 * 데이터베이스에 새로운 자동 수행 작업을 추가합니다.
	 * @param batch
	 * @return int  
	 *  새로 추가된 자동 수행 작업의 index를 반환합니다.
	 */
	public int insertBatch(Batch batch);


	/**
	 * 지정된 번호(index)에 해당하는 Batch객체를 반환합니다. 
	 * @param index
	 * @return
	 */
	public Batch getBatch(int index);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Batch> getBatchList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> getBatchList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby); 
	public List<Batch> getBatchList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> getBatchList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> getBatchList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> getBatchList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동수행목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countBatchList(SearchDTO searchDTO);

	/**
	 * @param batch
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateBatch(Batch batch);

	/**
	 * 자동 수행 작업 삭제
	 * 
	 * @param index
	 * @return
	 */
	public Boolean deleteBatch(String index);

	
	
	
}


