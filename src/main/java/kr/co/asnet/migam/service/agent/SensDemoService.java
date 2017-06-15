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
import kr.co.asnet.migam.domain.agent.AnalResult;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.ImsiMent;
import kr.co.asnet.migam.domain.agent.Recognition_job;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.domain.agent.Voicefile;

/**
 * 자동 수행 목록 정보 인터페이스
 */
public interface SensDemoService {

	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<ImsiMent> getImsiMentList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public String insertVoicefile(Voicefile voicefile);
	
	public String insertRecognition_job(Recognition_job recognition_job);
	public int countAgentList(SearchDTO searchDTO);
	public int countAgentFailCode(SearchDTO searchDTO);
	
	public List<AnalResult> getAnalResultList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<ImsiMent> gettdemo_excel(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
}


