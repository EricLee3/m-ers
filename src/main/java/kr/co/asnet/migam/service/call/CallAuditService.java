package kr.co.asnet.migam.service.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO15;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.call.RealStat;

/**
 * 실시간 AuditCall 콜 정보 인터페이스
 */
public interface CallAuditService {

	
	/**
	 * 데이터베이스에 새로운 콜목록 정보를 추가합니다. 
	 * @param agentId
	 * @param groupId
	 * @param callStatus : default=0
	 * 
	 * @return int  
	 * 성공하면 1을 반환하고, 실패하면 0을 반환합니다.
	 */
	public int insertCallAudit(String agentId, String groupId, int callStatus);
	
	/**
	 * 지정된 상담원 아이디(agentId)에 해당하는 CallAudit를 반환합니다. 
	 * @param agentId
	 * @return
	 */
	public CallAudit getCallAudit(String agentId);

	/**
	 * 주어진 조건에 따라  CallAudit객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<CallAudit> getCallAuditList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<RealStat> getRealStat5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby);
	public List<RealStat> getGroup5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby);
	public List<RealStat> getAgent5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby);
	
	public List<RealStat> getRealStat(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<RealStat> getGroup(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<RealStat> getAgent(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	public List<RealStat> getRealStat25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby);
	public List<RealStat> getGroup25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby);
	public List<RealStat> getAgent25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby);

	public List<RealStat> getRealStat50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby);
	public List<RealStat> getGroup50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby);
	public List<RealStat> getAgent50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby);

	public List<RealStat> getRealStat100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby);
	public List<RealStat> getGroup100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby);
	public List<RealStat> getAgent100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby);

	
	public int countgetRealStat(SearchDTO searchDTO);
	
	/**
	 * 검색 조건에 맞는 CallAudit 객체의 갯수를 반환합니다.  
	 * @param searchDTO
	 * @return
	 */
	public int countCallAuditList(SearchDTO searchDTO);
	
	
	/**
	 * 모니터링 대상 상담원 삭제
	 * 
	 * @param agentId
	 * @return
	 */
	public int deleteCallAudit(String agentId);
}


