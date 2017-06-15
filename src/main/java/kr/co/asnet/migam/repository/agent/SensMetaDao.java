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
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.SensMeta;

/**
 * 자동 수행 작업 목록 DAO 인터페이스
 */
public interface SensMetaDao {


	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<SensMeta> selectSensMetaList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<SensMeta> selectSensMetaList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<SensMeta> selectSensMetaList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<SensMeta> selectSensMetaList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<SensMeta> selectSensMetaList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<SensMeta> selectSensMetaList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 자동 수행 작업 목록 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);


	
	public List<SensMeta> selectSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensMeta> selectSvIndiList_chk(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensMeta> selectIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public SensMeta selectSensMeta(String groupId);
	
	public SensMeta selectSensMeta2(String groupId);
	
	public int updateSensMeta(SensMeta sensMeta);
	
	public int deleteSensMeta(String index);
	
	public int deleteSensMeta2(String index);
	public int selectCount_sc(SearchDTO searchDTO);
	
	public int selectCount_sv(SearchDTO searchDTO);
	
}