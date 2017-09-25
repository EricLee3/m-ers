package kr.co.asnet.migam.service.agent;

import java.util.List;

import kr.co.asnet.migam.domain.agent.ProgressLink;

/**
 * 자동 수행 목록 정보 인터페이스
 */
public interface ProgressLinkService {

	
	/**
	 * 주어진 조건에 따라 Batch 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 * 10개
	 */
	public List<ProgressLink> getprogressbar(ProgressLink progressLink);
	
	public int phone_up(ProgressLink progressLink);


	
}


