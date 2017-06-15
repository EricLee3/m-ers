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
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.domain.agent.ProMeta;
import kr.co.asnet.migam.domain.agent.SensConf;
import kr.co.asnet.migam.domain.agent.SensMeta;

/**
 * 자동 수행 목록 정보 인터페이스
 */
public interface SensConfService {

	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<SensConf> getSensConfList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<SensConf> getSensConfList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<SensConf> getSensConfList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<SensConf> getSensConfList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<SensConf> getSensConfList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<SensConf> getSensConfList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동수행목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countSensConfList(SearchDTO searchDTO);
	
	public int countSensConfList2(SearchDTO searchDTO);
	
	public List<SensConf> getSvIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> getIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> getSensChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> getSensConf(PageDTO pageDTO, SearchDTO searchDTO,String orderby);
	
	public int updateSensConf(SensConf sensConf);
	
	public Boolean deleteSensConf(SensConf sensConf);
	
	public Boolean deleteSensConf2(String index);
	
	public String insertSensConf(SensConf sensConf);

	public List<SensConf> getProChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<SensConf> getLevelList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public int countLevel(SearchDTO searchDTO);
	
	
	public int countDupMinMax(SensConf sensConf);
}


