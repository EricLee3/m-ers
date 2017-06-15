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
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.SensMeta;

/**
 * 자동 수행 작업 목록 DAO 인터페이스
 */
public interface ProMetaDao {


	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<ProMeta> selectProMetaList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<ProMeta> selectProMetaList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<ProMeta> selectProMetaList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<ProMeta> selectProMetaList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<ProMeta> selectProMetaList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<ProMeta> selectProMetaList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 자동 수행 작업 목록 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);
	public int selectCount_pro(SearchDTO searchDTO);
	public int selectCount_sc(SearchDTO searchDTO);
	
	
	public List<ProMeta> selectSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProMeta> selectIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public ProMeta selectProMeta(String groupId);
	
	public ProMeta selectProMeta2(String groupId);
	
	public ProMeta selectProIdx(String groupId);
	
	public int updateProMeta(ProMeta ProMeta);
	
	public int deleteProMeta(String index);
	
	public int deleteProMeta2(String index);
	
	public ProMeta selectName(String groupId);
	
	public String insertProMeta(ProMeta proMeta);
	
}