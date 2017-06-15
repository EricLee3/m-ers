package kr.co.asnet.migam.repository.config;

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
 * 자동 수행 작업 목록 DAO 인터페이스
 */
public interface BatchDao {
	/**
	 * 자동 수행 작업 목록 정보를 입력합니다.
	 * 
	 * @param batch
	 * @return
	 */
	public int insertBatch(Batch batch);

	/**
	 * 주어진 자동 수행 작업 목록의 고유 번호를 기반으로 해당 자동 수행 작업 목록 정보를 반환합니다. 
	 * 
	 * @param batchIndex
	 * @return
	 *  domain.Agent 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우,  NULL 을 반환합니다.
	 */
	public Batch selectBatch(int batchIndex);

	/**
	 * 주어진 자동 수행 작업 목록의 아이디를 기반으로 해당 자동 수행 작업 목록 정보를 반환합니다. 
	 * 
	 * @param jobId
	 * @return
	 *  domain.batch 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우,  NULL 을 반환합니다.
	 */
	public Batch selectBatch(String jobId);
	
	/**
	 * 자동 수행 작업 목록 정보를 수정합니다.
	 * 
	 * @param batch
	 * @return
	 */
	public int updateBatch(Batch batch);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<Batch> selectBatchList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> selectBatchList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> selectBatchList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> selectBatchList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> selectBatchList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	public List<Batch> selectBatchList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동 수행 작업 목록 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	/**
	 * 자동 수행 작업 목록 삭제
	 * 
	 * @param batchIndex
	 * @return
	 */
	public int deleteBatch(String batchIndex);
	
}