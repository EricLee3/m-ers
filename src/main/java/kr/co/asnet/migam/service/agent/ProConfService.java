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
public interface ProConfService {

	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<ProConf> getProConfList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<ProConf> getProConfList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<ProConf> getProConfList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<ProConf> getProConfList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<ProConf> getProConfList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<ProConf> getProConfList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 자동수행목록 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countProConfList(SearchDTO searchDTO);
	public int countProConfList2(SearchDTO searchDTO);
	
	public List<ProConf> getProNameList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> getIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> getProChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> getProChkList_update(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> getProConf(PageDTO pageDTO, SearchDTO searchDTO,String orderby);
	
	public int updateProConf(ProConf proConf);
	
	public Boolean deleteProConf(ProConf proConf);
	
	public Boolean deleteProConf_script(ProConf proConf);
	
	public Boolean deleteProConf2(String index);
	
	public String insertProConf(ProConf proConf);
	
	public String insertProConf_S(ProConf proConf);

	public int countDupMinMax(ProConf proConf);
	
	public List<ProConf> getProConfName(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
}


