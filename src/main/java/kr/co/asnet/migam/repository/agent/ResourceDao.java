package kr.co.asnet.migam.repository.agent;

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
 * 자동 수행 작업 목록 DAO 인터페이스
 */
public interface ResourceDao {

	/**
	 * 자동 수행 작업 수행 히스토리를 입력합니다.
	 * 
	 * @param ResourceLog
	 * @return
	 */
	public int insertResourceLog(ResourceLog resourceLog);

	/**
	 * 주어진 자동 수행 작업 목록의 히스토리 고유 번호를 기반으로 해당 자동 수행 작업 목록 정보를 반환합니다. 
	 * 
	 * @param ResourceLogIndex
	 * @return
	 *  domain.ResourceLog 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우,  NULL 을 반환합니다.
	 */
	public ResourceLog selectResourceLog(int ResourceLogIndex);

	/**
	 * 주어진 자동 수행 작업 목록의 아이디를 기반으로 해당 자동 수행 작업 목록 정보를 반환합니다. 
	 * 
	 * @param jobId
	 * @return
	 *  domain.batch 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우,  NULL 을 반환합니다.
	 */
	public ResourceLog selectResourceLog(String jobId);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<ResourceLog> selectResourceLogList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<ResourceLog> selectResourceLogList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ResourceLog> selectCategoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ResourceLog> selectLevelList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<ResourceLog> selectResourceLogList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<ResourceLog> selectResourceLogList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<ResourceLog> selectResourceLogList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<ResourceLog> selectResourceLogList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

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
	 * @param ResourceLogIndex
	 * @return
	 */
	public int deleteResourceLog(int ResourceLogIndex);
	
}