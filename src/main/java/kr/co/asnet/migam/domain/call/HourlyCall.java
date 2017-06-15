package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 시간대별 통화 통계를 위한 도메인 클래스
 * Updated 2016-09-25
 * 참고 사항 :
 *  시간대별, 날짜별, 월별 통계를 각각 도메인 클래스로 만들어 놓습니다. (  AgentStat 클래스와 중복될 수 있습니다. )
 *  데이터베이스 테이블 : mecs5_agent_stat_hourly 
 */
@SuppressWarnings("serial")
public class HourlyCall extends BaseDomain {
	private Date statTime;
	private String agentId;
	private int totalCount;
	private int successCount;
	private int failCount;
	private int angryCount;
	private int stressCount;
	private int incrementCount;
	private int decrementCount;
	
    public HourlyCall() {
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

	public Date getStatTime() {
		return statTime;
	}

	public void setStatTime(Date statTime) {
		this.statTime = statTime;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getAngryCount() {
		return angryCount;
	}

	public void setAngryCount(int angryCount) {
		this.angryCount = angryCount;
	}

	public int getStressCount() {
		return stressCount;
	}

	public void setStressCount(int stressCount) {
		this.stressCount = stressCount;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public int getIncrementCount() {
		return incrementCount;
	}

	public void setIncrementCount(int incrementCount) {
		this.incrementCount = incrementCount;
	}

	public int getDecrementCount() {
		return decrementCount;
	}

	public void setDecrementCount(int decrementCount) {
		this.decrementCount = decrementCount;
	}

	@Override
	public String toString() {
		return "HourlyCall [statTime=" + statTime + ", agentId=" + agentId + ", totalCount=" + totalCount
				+ ", successCount=" + successCount + ", failCount=" + failCount + ", angryCount=" + angryCount
				+ ", stressCount=" + stressCount + ", incrementCount=" + incrementCount + ", decrementCount="
				+ decrementCount + "]";
	}

}