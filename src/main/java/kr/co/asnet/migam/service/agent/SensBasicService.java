package kr.co.asnet.migam.service.agent;

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
 * 자동 수행 목록 정보 인터페이스
 */
public interface SensBasicService {

	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<SensBasic> getSensBasicList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<SensBasic> getSensBasicList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<SensBasic> getSensBasicList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<SensBasic> getSensBasicList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<SensBasic> getSensBasicList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<SensBasic> getSensBasicList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동수행목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countSensBasicList(SearchDTO searchDTO);
	
	public List<SensBasic> getNameList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param sensBasic
	 * 	agentGroup.id는 반드시 고유한 값으로 지정되어야 합니다. 
	 * 
	 * @return String  
	 *   성공적으로 추가된 경우, 해당 AgentGroup의 id를 반환합니다.
	 *   실패한 경우에는 null을 반환합니다. ( 오류 정보는 logger를 확인해 주십시오 ) 
	 */
	public String insertSensBasic(SensBasic sensBasic);
	
	public String insertSensMeta(SensMeta sensMeta);
	
	public String insertSensMap(SensMeta sensMeta);
	public String insertSensMap_update(SensMeta sensMeta);
	
	/**
	 * 지정된 아이디(groupId)에 해당하는 AgentGroup객체를 반환합니다. 
	 * @param groupId
	 * @return
	 */
	public SensBasic getSensBasic(String groupId);
	
	
	/**
	 * 상담원 크룹 정보를 업데이트합니다. 
	 * @param agentGroup
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateSensBasic(SensBasic sensBasic);
	
	

	/**
	 * 감성기초 삭제
	 * 
	 * @param index
	 * @return
	 */
	public Boolean deleteSensBasic(String index);
	
	
	/**
	 * 존재하는 ID 인지 조회합니다.
	 * 
	 * @param groupId
	 * @return
	 */
	public boolean isDuplicatedGroupId(String groupId);
	
	public boolean isDuplicatedName(String groupId);
	
	
	
	
}


