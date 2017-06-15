/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AlarmCode;
import kr.co.asnet.migam.repository.agent.AlarmCodeDao;

/**
 * @author byonghee
 * 상담원 그룹 정보 구현 클래스 
 */
@Service("alarmCodeService")
public class AlarmCodeServiceImpl implements AlarmCodeService { 

	@Inject
	private AlarmCodeDao alarmCodeDao;
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#insertAlarmCode(kr.co.asnet.migam.domain.agent.AlarmCode)
	 */
	@Override
	public String insertAlarmCode(AlarmCode alarmCode) {
		return alarmCodeDao.insertAlarmCode(alarmCode);	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agentAlarmCodepService#getAlarmCode(java.lang.String)
	 */
	@Override
	public AlarmCode getAlarmCode(String groupId) {
		return alarmCodeDao.selectAlarmCode(groupId);	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#getAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<AlarmCode> getAlarmCodeList(PageDTO2 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmCodeDao.selectAlarmCodeList(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#getAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 5개
	 */
	@Override
	public List<AlarmCode> getAlarmCodeList5(PageDTO5 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmCodeDao.selectAlarmCodeList5(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#getAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 15개
	 */
	@Override
	public List<AlarmCode> getAlarmCodeList15(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmCodeDao.selectAlarmCodeList15(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#getAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 25개
	 */
	@Override
	public List<AlarmCode> getAlarmCodeList25(PageDTO25 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmCodeDao.selectAlarmCodeList25(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#getAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 50개
	 */
	@Override
	public List<AlarmCode> getAlarmCodeList50(PageDTO50 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmCodeDao.selectAlarmCodeList50(pageDTO, searchDTO, orderby);
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#getAlarmCodeList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 100개
	 */
	@Override
	public List<AlarmCode> getAlarmCodeList100(PageDTO100 pageDTO, SearchDTO searchDTO, String orderby) {
		return alarmCodeDao.selectAlarmCodeList100(pageDTO, searchDTO, orderby);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#countAlarmCodeList(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countAlarmCodeList(SearchDTO searchDTO) {
		return alarmCodeDao.selectCount(searchDTO);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#updateAlarmCode(kr.co.asnet.migam.domain.agent.AlarmCode)
	 */
	@Override
	public int updateAlarmCode(AlarmCode alarmCode) {
		return alarmCodeDao.updateAlarmCode(alarmCode);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#deleteAlarmCode(java.lang.String)
	 */
	@Override
	public Boolean deleteAlarmCode(String alarmCode) {
		return alarmCodeDao.deleteAlarmCode(alarmCode) > 0 ? true : false;	
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.agent.AlarmCodeService#deleteAlarmCode(java.lang.String)
	 */
	@Override
	public boolean isDuplicatedAlarmCode(String alarmCode) {
		return alarmCodeDao.selectAlarmCode(alarmCode) != null ? true : false;	
	}

	@Override
	public List<AlarmCode> getProcessList(PageDTO pageDTO,
			SearchDTO searchDTO, String orderby) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
