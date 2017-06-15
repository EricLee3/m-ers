package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 상담원별 통계를 위한 도메인 클래스 <br>
 * Updated 2016-09-28 <br>
 * 참고 사항 :
 *  데이터베이스 테이블 : mecs5_agent_stat_daily
 */
@SuppressWarnings("serial")
public class AgentCall extends BaseDomain {
	private Date statTime;
	private String agentId;
	private String agentName;
	private int totalCount;
	private int successCount;
	private int failCount;
	private int angryCount;
	private int stressCount;
	private int incrementCount;
	private int decrementCount;
	
    public AgentCall() {
		super();
		statTime = null;
		agentId = "";
		agentName = "";
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
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}

	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
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
		return "AgentCall [statTime=" + statTime + ", agentId=" + agentId + ", agentName=" + agentName + ", totalCount="
				+ totalCount + ", successCount=" + successCount + ", failCount=" + failCount + ", angryCount="
				+ angryCount + ", stressCount=" + stressCount + ", incrementCount=" + incrementCount
				+ ", decrementCount=" + decrementCount + "]";
	}

}