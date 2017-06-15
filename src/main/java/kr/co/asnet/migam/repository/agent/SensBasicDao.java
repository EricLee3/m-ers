package kr.co.asnet.migam.repository.agent;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.SensMeta;

/**
 * 자동 수행 작업 목록 DAO 인터페이스
 */
public interface SensBasicDao {


	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<SensBasic> selectSensBasicList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<SensBasic> selectSensBasicList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<SensBasic> selectSensBasicList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<SensBasic> selectSensBasicList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<SensBasic> selectSensBasicList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<SensBasic> selectSensBasicList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 자동 수행 작업 목록 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	public List<SensBasic> selectNameList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 상담원 그룹 정보를 입력합니다.
	 * 
	 * @param agentGroup
	 * @return
	 *  성공하면 해당 그룹의 아이디를 반환합니다.
	 *  실패하면, NULL을 반환합니다.
	 */
	public String insertSensBasic(SensBasic sensBasic);
	
	public String insertSensMeta(SensMeta sensMeta);
	
	public String insertSensMap(SensMeta sensMeta);
	public String insertSensMap_update(SensMeta sensMeta);
	
	/**
	 * 주어진 상담원 그룹의 고유 번호를 기반으로 해당 상담원 그룹 정보를 반환합니다. 
	 * 
	 * @param groupId
	 * @return
	 *  domain.AgentGroup 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public SensBasic selectSensBasic(String groupId);
	
	

	/**
	 * 상담원 그룹 정보를 수정합니다.
	 * 
	 * @param agentGroup
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateSensBasic(SensBasic sensBasic);
	
	
	
	
	/**
	 * 상담원 삭제
	 * 
	 * @param agentIndex
	 * @return
	 */
	public int deleteSensBasic(String index);
	
	/**
	 * 주어진 상담원 그룹의 고유 번호를 기반으로 해당 상담원 그룹 정보를 반환합니다. 
	 * 
	 * @param groupId
	 * @return
	 *  domain.AgentGroup 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public SensBasic selectAgentGroup(String groupId);
	
	public SensBasic selectName(String groupId);
	
	
	
}