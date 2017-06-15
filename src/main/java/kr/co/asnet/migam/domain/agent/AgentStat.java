package kr.co.asnet.migam.domain.agent;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 상담원별 통계 조회를 위한 도메인 클래스 <br>
 * Updated 2016-09-15 <br>
 * 참고 사항 :
 *  DB 테이블에는 3개의 개별 테이블로 되어 있으나,도메인 클래스는 1개로 통합하고, term 항목을 추가합니다.
 */
@SuppressWarnings("serial")
public class AgentStat extends BaseDomain {
	// 가장 기본적인 정보들
	private int index;
	private int term; // 1:hourly, 2:daily, 3:monthly
	private String agentId;
	private Date statTime;
	private int totalCount;
	private int successCount;
	private int failCount;
	private int angryCount;
	private int stressCount;
	private int incrementCount;
	private int decrementCount;
	
    public AgentStat() {
		super();
		index = 0;
		term = 1;
		agentId="";
		totalCount = 0;
		successCount = 0;
		failCount = 0;
		angryCount = 0;
		stressCount = 0;
		incrementCount = 0;
		decrementCount = 0;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
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
		return "AgentStat [index=" + index + ", term=" + term + ", agentId=" + agentId + ", statTime=" + statTime
				+ ", totalCount=" + totalCount + ", successCount=" + successCount + ", failCount=" + failCount
				+ ", angryCount=" + angryCount + ", stressCount=" + stressCount + ", incrementCount=" + incrementCount
				+ ", decrementCount=" + decrementCount + "]";
	}
	
}