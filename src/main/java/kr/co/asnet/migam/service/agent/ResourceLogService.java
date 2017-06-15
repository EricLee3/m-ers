package kr.co.asnet.migam.service.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.ResourceLog;

/**
 * 자동 수행 목록 정보 인터페이스
 */
public interface ResourceLogService {

	/**
	 * 데이터베이스에 새로운 자동 수행 목록를 추가합니다.
	 * @param batchHistory
	 * @return int  
	 *  새로 추가된 자동 수행 목록의 index를 반환합니다.
	 */
	public int insertResourceLog(ResourceLog resourceLog);


	/**
	 * 지정된 번호(index)에 해당하는 Batch객체를 반환합니다. 
	 * @param index
	 * @return
	 */
	public ResourceLog getResourceLog(int index);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다. 10개
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ResourceLog> getResourceLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다. 15개
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ResourceLog> getResourceLogList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ResourceLog> getCategoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ResourceLog> getLevelList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다. 5개
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ResourceLog> getResourceLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다. 25개
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ResourceLog> getResourceLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다. 50개
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ResourceLog> getResourceLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다. 100개
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<ResourceLog> getResourceLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동수행목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countResourceLogList(SearchDTO searchDTO);

	
	/**
	 * 자동 수행 목록 삭제
	 * 
	 * @param index
	 * @return
	 */
	public Boolean deleteResourceLog(int index);

	
	
	
}


