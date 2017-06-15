package kr.co.asnet.migam.domain.config;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 라이선스 설정 정보를 보관하기 위한 도메인클래스입니다.
 * Updated 2016-10-03
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class License extends BaseDomain {
	
	private int realtimeService;
	private int nonrealtimeService;
	private int customerStress;
	private int agentStress;
	private int realtimeChannel;
	private int nonrealtimeChannel;
	
	public License() {
		super();
		realtimeService = 0;
		nonrealtimeService = 0;
		customerStress = 0;
		agentStress = 0;
		realtimeChannel = 0;
		nonrealtimeChannel = 0;

	}

	/**
	 * @return the realtimeService
	 */
	public int getRealtimeService() {
		return realtimeService;
	}

	/**
	 * @param realtimeService the realtimeService to set
	 */
	public void setRealtimeService(int realtimeService) {
		this.realtimeService = realtimeService;
	}

	/**
	 * @return the nonrealtimeService
	 */
	public int getNonrealtimeService() {
		return nonrealtimeService;
	}

	/**
	 * @param nonrealtimeService the nonrealtimeService to set
	 */
	public void setNonrealtimeService(int nonrealtimeService) {
		this.nonrealtimeService = nonrealtimeService;
	}

	/**
	 * @return the customerStress
	 */
	public int getCustomerStress() {
		return customerStress;
	}

	/**
	 * @param customerStress the customerStress to set
	 */
	public void setCustomerStress(int customerStress) {
		this.customerStress = customerStress;
	}

	/**
	 * @return the agentStress
	 */
	public int getAgentStress() {
		return agentStress;
	}

	/**
	 * @param agentStress the agentStress to set
	 */
	public void setAgentStress(int agentStress) {
		this.agentStress = agentStress;
	}

	/**
	 * @return the realtimeChannel
	 */
	public int getRealtimeChannel() {
		return realtimeChannel;
	}

	/**
	 * @param realtimeChannel the realtimeChannel to set
	 */
	public void setRealtimeChannel(int realtimeChannel) {
		this.realtimeChannel = realtimeChannel;
	}

	/**
	 * @return the nonrealtimeChannel
	 */
	public int getNonrealtimeChannel() {
		return nonrealtimeChannel;
	}

	/**
	 * @param nonrealtimeChannel the nonrealtimeChannel to set
	 */
	public void setNonrealtimeChannel(int nonrealtimeChannel) {
		this.nonrealtimeChannel = nonrealtimeChannel;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "License [realtimeService=" + realtimeService + ", nonrealtimeService=" + nonrealtimeService
				+ ", customerStress=" + customerStress + ", agentStress=" + agentStress + ", realtimeChannel="
				+ realtimeChannel + ", nonrealtimeChannel=" + nonrealtimeChannel + "]";
	}

}