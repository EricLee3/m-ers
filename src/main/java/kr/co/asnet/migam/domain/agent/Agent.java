package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br> 
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class Agent extends BaseDomain {
	
	private int index;
	private String agentNumber;
	private String agentId;
	private String agentName;
	private String agentIp;
	private int isAudit;
	private int isAuditBatch;
	private String groupId;
	private int callStatus;
	private int stressCount;
	private int angryCount;
	private String profile_name_agent;
	private String profile_name_cus;
	private String agent_profile_id;
	private String customer_profile_id;
	
	private String groupName;
	
    public Agent() {
		super();
		index = 0;
		agentNumber = "";
		agentId = "";
		agentName = "";
		agentIp = "";
		isAudit = 0;
		isAuditBatch = 0;
		groupId="";
		callStatus=0;
		stressCount = 0;
		angryCount = 0;
		groupName = "";
		profile_name_agent = "";
		profile_name_cus = "";
		agent_profile_id = "";
		customer_profile_id = "";
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
	 * @return the agentNumber
	 */
	public String getAgentNumber() {
		return agentNumber;
	}

	/**
	 * @param agentNumber the agentNumber to set
	 */
	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
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
	 * @return the agentIp
	 */
	public String getAgentIp() {
		return agentIp;
	}

	/**
	 * @param agentIp the agentIp to set
	 */
	public void setAgentIp(String agentIp) {
		this.agentIp = agentIp;
	}

	/**
	 * @return the isAudit
	 */
	public int getIsAudit() {
		return isAudit;
	}

	/**
	 * @param isAudit the isAudit to set
	 */
	public void setIsAudit(int isAudit) {
		this.isAudit = isAudit;
	}

	/**
	 * @return the isAuditBatch
	 */
	public int getIsAuditBatch() {
		return isAuditBatch;
	}

	/**
	 * @param isAuditBatch the isAuditBatch to set
	 */
	public void setIsAuditBatch(int isAuditBatch) {
		this.isAuditBatch = isAuditBatch;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the callStatus
	 */
	public int getCallStatus() {
		return callStatus;
	}

	/**
	 * @param callStatus the callStatus to set
	 */
	public void setCallStatus(int callStatus) {
		this.callStatus = callStatus;
	}

	public int getStressCount() {
		return stressCount;
	}

	public void setStressCount(int stressCount) {
		this.stressCount = stressCount;
	}

	public int getAngryCount() {
		return angryCount;
	}

	public void setAngryCount(int angryCount) {
		this.angryCount = angryCount;
	}
	
	

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getProfile_name_agent() {
		return profile_name_agent;
	}

	public void setProfile_name_agent(String profile_name_agent) {
		this.profile_name_agent = profile_name_agent;
	}

	public String getProfile_name_cus() {
		return profile_name_cus;
	}

	public void setProfile_name_cus(String profile_name_cus) {
		this.profile_name_cus = profile_name_cus;
	}
	
	
	
	public String getAgent_profile_id() {
		return agent_profile_id;
	}

	public void setAgent_profile_id(String agent_profile_id) {
		this.agent_profile_id = agent_profile_id;
	}

	public String getCustomer_profile_id() {
		return customer_profile_id;
	}

	public void setCustomer_profile_id(String customer_profile_id) {
		this.customer_profile_id = customer_profile_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agent [index=" + index + ", agentNumber=" + agentNumber + ", agentId=" + agentId + ", agentName="
				+ agentName + ", agentIp=" + agentIp + ", isAudit=" + isAudit + ", isAuditBatch=" + isAuditBatch
				+ ", groupId=" + groupId + ", callStatus=" + callStatus + ", stressCount=" + stressCount
				+ ", angryCount=" + angryCount + ", groupName=" + groupName 
				+ ", profile_name_agent=" + profile_name_agent + ", profile_name_cus=" + profile_name_cus
				+ ", agent_profile_id=" + agent_profile_id + ", customer_profile_id=" + customer_profile_id + "]";
	}

	
	

}