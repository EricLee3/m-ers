package kr.co.asnet.migam.repository.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.AgentCall;

/**
 * 일간 통계 내역을 조회하기 위한 Repository 클래스입니다.
 * 
 * Updated 2016-09-28
 */
public interface AgentCallDao {
	/**
	 * 콜별리포트의 차트 작성을 위해 필요한 정보를 반환합니다.
	 * 
	 * @param searchDTO / startDate, endDate를 사용하고 - searchGroup:agentGroup, searchId:agentId로 사용합니다.
	 * @param orderby
	 * @return
	 */
	public List<AgentCall> selectAgentCallListForChart(SearchDTO searchDTO, String orderby);
}
