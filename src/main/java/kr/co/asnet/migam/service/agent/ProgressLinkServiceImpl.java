/**
 * 
 */
package kr.co.asnet.migam.service.agent;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.ProConf;
import kr.co.asnet.migam.domain.agent.ProgressLink;
import kr.co.asnet.migam.repository.agent.ProConfDao;
import kr.co.asnet.migam.repository.agent.ProgressLinkDao;

/**
 * @author asnet
 * 자동 수행 작업 목록
 */
@Service("progressLinkService")
public class ProgressLinkServiceImpl implements ProgressLinkService { 
	
	@Inject
	private ProgressLinkDao progressLinkDao; 
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.BatchService#getBatchList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 * 10개
	 */
	@Override
	public List<ProgressLink> getprogressbar(ProgressLink progressLink) {
		return progressLinkDao.selectProgressLingList(progressLink);
	}


	@Override
	public int phone_up(ProgressLink progressLink) {
		// 
		return progressLinkDao.updatephone(progressLink);
	}
	
	
	@Override
	public int call_type_up(ProgressLink progressLink) {
		// 
		return progressLinkDao.updatecalltype(progressLink);
	}
	
}
