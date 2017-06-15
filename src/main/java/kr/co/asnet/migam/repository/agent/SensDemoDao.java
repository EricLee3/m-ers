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
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.domain.agent.AnalResult;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.ImsiMent;
import kr.co.asnet.migam.domain.agent.Recognition_job;
import kr.co.asnet.migam.domain.agent.Voicefile;


/**
 * 자동 수행 작업 목록 DAO 인터페이스
 */
public interface SensDemoDao {


	/**
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<ImsiMent> selectImsiMentList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	public String insertVoicefile(Voicefile voicefile);

	public String insertRecognition_job(Recognition_job recognition_job);

	public int selectCount(SearchDTO searchDTO);
	
	public int selectCountFailCode(SearchDTO searchDTO);
	
	public List<AnalResult> selectAnalResultList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<ImsiMent> selectdemo_excel(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
}