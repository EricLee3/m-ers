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
public interface ProConfDao {


	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<ProConf> selectProConfList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 5개
	 */
	public List<ProConf> selectProConfList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 15개
	 */
	public List<ProConf> selectProConfList15(PageDTO15 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 25개
	 */
	public List<ProConf> selectProConfList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 50개
	 */
	public List<ProConf> selectProConfList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 100개
	 */
	public List<ProConf> selectProConfList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby);
	
	/**
	 * 자동 수행 작업 목록 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	public int selectCount2(SearchDTO searchDTO);
	
	public List<ProConf> selectProNameList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> selectIndiList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> selectProChkList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> selectProChkList_update(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<ProConf> selectProConf(PageDTO pageDTO, SearchDTO searchDTO,String orderby);
	
	
	public int updateProConf(ProConf proConf);
	
	public int deleteProConf(ProConf proConf);
	
	public int deleteProConf_script(ProConf proConf);
	
	public int deleteProConf2(String index);
	
	public String insertProConf(ProConf proConf);

	public String insertProConf_S(ProConf proConf);
	
	public int selectDupMinMax(ProConf proConf);
	
	public List<ProConf> selectProConfName(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby);
	
}