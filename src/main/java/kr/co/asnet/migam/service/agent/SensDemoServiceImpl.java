/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
import kr.co.asnet.migam.domain.agent.AlarmLog;
import kr.co.asnet.migam.domain.agent.AnalResult;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.SensBasic;
import kr.co.asnet.migam.domain.agent.ImsiMent;
import kr.co.asnet.migam.domain.agent.Recognition_job;
import kr.co.asnet.migam.domain.agent.SensMeta;
import kr.co.asnet.migam.domain.agent.Voicefile;
import kr.co.asnet.migam.repository.agent.AlarmLogDao; 
import kr.co.asnet.migam.repository.agent.FaultAlarmLogDao;
import kr.co.asnet.migam.repository.agent.SensDemoDao;


/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("SensDemoService")
public class SensDemoServiceImpl implements SensDemoService { 
	
	@Inject
	private SensDemoDao SensDemoDao; 
	
	@Override
	public List<ImsiMent> getImsiMentList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		// TODO Auto-generated method stub
		return SensDemoDao.selectImsiMentList(pageDTO, searchDTO, orderby);
	}
	
	@Override
	public List<AnalResult> getAnalResultList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		// TODO Auto-generated method stub
		return SensDemoDao.selectAnalResultList(pageDTO, searchDTO, orderby);
	}
	

	@Override
	public String insertVoicefile(Voicefile voicefile) {
		// TODO Auto-generated method stub
		return SensDemoDao.insertVoicefile(voicefile);
	}

	@Override
	public String insertRecognition_job(Recognition_job recognition_job) {
		// TODO Auto-generated method stub
		return SensDemoDao.insertRecognition_job(recognition_job);
	}
	
	@Override
	public int countAgentList(SearchDTO searchDTO) {
		return SensDemoDao.selectCount(searchDTO);
	}

	@Override
	public int countAgentFailCode(SearchDTO searchDTO) {
		return SensDemoDao.selectCountFailCode(searchDTO);
	}
	
	@Override
	public List<ImsiMent> gettdemo_excel(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		// TODO Auto-generated method stub
		return SensDemoDao.selectdemo_excel(pageDTO, searchDTO, orderby);
	}
	
}
