package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 월별 통계를 위한 도메인 클래스
 * Updated 2016-09-28
 * 참고 사항 :
 *  시간대별, 날짜별, 월별 통계를 각각 도메인 클래스로 만들어 놓습니다. (  AgentStat 클래스와 중복될 수 있습니다. )
 *  데이터베이스 테이블 : mecs5_agent_stat_monthly
 *  데이터베이스 테이블 : mecs5_service_stat_monthly
 *  위 2개의 테이블을 모두 사용하며, 두 테이블의 차이점은  agentId 컬럼 유무입니다. ( agent_id 필드는 mecs5_agent_stat_monthly 테이블에만 있습니다.)
 */
@SuppressWarnings("serial")
public class MonthlyCall extends BaseDomain {
	private Date statTime;
	private String agentId;
	private int totalCount;
	private int successCount;
	private int failCount;
	private int angryCount;
	private int stressCount;
	private int incrementCount;
	private int decrementCount;
	
    public MonthlyCall() {
		super();
		statTime = null;
		totalCount = 0;
		angryCount = 0;
		stressCount = 0;
		successCount = 0;
		failCount = 0;
		incrementCount = 0;
		decrementCount = 0;
	}

	/**
	 * @return the statTime
	 */
	public Date getStatTime() {
		return statTime;
	}

	/**
	 * @param statTime the statTime to set
	 */
	public void setStatTime(Date statTime) {
		this.statTime = statTime;
	}

	/**
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * @return the successCount
	 */
	public int getSuccessCount() {
		return successCount;
	}

	/**
	 * @param successCount the successCount to set
	 */
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	/**
	 * @return the failCount
	 */
	public int getFailCount() {
		return failCount;
	}

	/**
	 * @param failCount the failCount to set
	 */
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	/**
	 * @return the angryCount
	 */
	public int getAngryCount() {
		return angryCount;
	}

	/**
	 * @param angryCount the angryCount to set
	 */
	public void setAngryCount(int angryCount) {
		this.angryCount = angryCount;
	}

	/**
	 * @return the stressCount
	 */
	public int getStressCount() {
		return stressCount;
	}

	/**
	 * @param stressCount the stressCount to set
	 */
	public void setStressCount(int stressCount) {
		this.stressCount = stressCount;
	}

	/**
	 * @return the incrementCount
	 */
	public int getIncrementCount() {
		return incrementCount;
	}

	/**
	 * @param incrementCount the incrementCount to set
	 */
	public void setIncrementCount(int incrementCount) {
		this.incrementCount = incrementCount;
	}

	/**
	 * @return the decrementCount
	 */
	public int getDecrementCount() {
		return decrementCount;
	}

	/**
	 * @param decrementCount the decrementCount to set
	 */
	public void setDecrementCount(int decrementCount) {
		this.decrementCount = decrementCount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MonthlyCall [statTime=" + statTime + ", agentId=" + agentId + ", totalCount=" + totalCount
				+ ", successCount=" + successCount + ", failCount=" + failCount + ", angryCount=" + angryCount
				+ ", stressCount=" + stressCount + ", incrementCount=" + incrementCount + ", decrementCount="
				+ decrementCount + "]";
	}

}