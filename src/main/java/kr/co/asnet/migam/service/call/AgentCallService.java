package kr.co.asnet.migam.service.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.AgentCall;

/**
 * 일간 Call 정보를 제공하기 위한 서비스  인터페이스
 */
public interface AgentCallService {

	/**
	 * 주어진 조건에 따라  AgentCall객체 목록을 반환합니다.
	 * 단, 본 메소드는 차트를 그리는 것에 필요한 정보를 제공합니다.
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<AgentCall> getAgentCallListForChart(PageDTO2 pageDTO2, SearchDTO searchDTO, String orderby);
	
	public int selectAgentMonitorStatCount(SearchDTO searchDTO);
}
