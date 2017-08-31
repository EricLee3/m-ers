package kr.co.asnet.migam.repository.call;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.PageDTO100;
import kr.co.asnet.migam.domain.PageDTO25;
import kr.co.asnet.migam.domain.PageDTO5;
import kr.co.asnet.migam.domain.PageDTO50;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.call.RealStat;

/**
 * 실시간 통화(CallAudit)DAO 인터페이스
 */
public interface CallAuditDao {

	/**
	 * 상담원 정보를 입력합니다.
	 * 
	 * @param agentId
	 * @param groupId
	 * @param callStatus
	 * @return
	 */
	public int insertCallAudit(String agentId, String groupId, int callStatus);
	
	/**
	 * 주어진 상담원의 고유 번호를 기반으로 해당 실시간 통화(CallAudit)정보를 반환합니다. 
	 * 
	 * @param agentId
	 * @return
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public CallAudit selectCallAudit(String agentId);

	/**
	 * 실시간 통화(CallAudit)리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<CallAudit> selectCallAuditList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<RealStat> selectRealStatList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectGroupList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectAgentList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);
	
	public List<RealStat> selectRealStatList5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectGroupList5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectAgentList5(PageDTO5 pageDTO5, SearchDTO searchDTO, String orderby);
	
	public List<RealStat> selectRealStatList25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectGroupList25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectAgentList25(PageDTO25 pageDTO25, SearchDTO searchDTO, String orderby);
	
	public List<RealStat> selectRealStatList50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectGroupList50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectAgentList50(PageDTO50 pageDTO50, SearchDTO searchDTO, String orderby);
	
	public List<RealStat> selectRealStatList100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectGroupList100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby);
	public List<RealStat> selectAgentList100(PageDTO100 pageDTO100, SearchDTO searchDTO, String orderby);

	public int countgetRealStat(SearchDTO searchDTO);
	
	
	/**
	 * 실시간 통화(CallAudit)수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);
	
	/**
	 * 모니터링 대상 삭제
	 * 
	 * @param agentId
	 * @return
	 */
	public int deleteCallAudit(String agentId);
	
	/*
	 * 상담원 정보 부분수정 IOS
	 */
	public int patchCallAudit(Agent agent);

}
