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
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensConf;
import kr.co.asnet.migam.domain.agent.SensMeta;

/**
 * 자동 수행 작업 목록 DAO 인터페이스
 */
public interface SensConfDao {


	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<SensConf> selectSensConfList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<SensConf> selectSensConfList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<SensConf> selectSensConfList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<SensConf> selectSensConfList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<SensConf> selectSensConfList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<SensConf> selectSensConfList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 자동 수행 작업 목록 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	public int selectCount2(SearchDTO searchDTO);
	
	public List<SensConf> selectSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> selectIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> selectSensChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> selectSensConf(PageDTO pageDTO, SearchDTO searchDTO,String orderby);
	
	
	public int updateSensConf(SensConf sensConf);
	
	public int deleteSensConf(SensConf sensConf);
	
	public int deleteSensConf2(String index);
	
	public String insertSensConf(SensConf sensConf);

	public List<SensConf> selectProChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> selectLevelList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public int selectLevel(SearchDTO searchDTO);
	
	public int selectDupMinMax(SensConf sensConf);
	
}