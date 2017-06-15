package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 통화내역(Call-CDR)을 위한 도메인 클래스
 * Updated 2016-06-15
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class Call extends BaseDomain {
	// 가장 기본적인 정보들
	private int index;
	private String callId;
	private Date startTime;
	private Date endTime;
	private int length;
	private int type;
	private String groupId;
	private String agentId;
	private String agentNumber;
	private String agentName;
	private String agentIp;
	private String customerNumber;
	private String customerIp;
	private int isAudit;
	private int isAuditBatch;
	private String failReason;
	
    public Call() {
		super();
		index = 0;
		callId = "";
		length = 0;
		type = 1;
		groupId = "";
		agentId = "";
		agentNumber = "";
		agentName = "";
		agentIp = "";
		customerNumber = "";
		customerIp = "";
		isAudit = 0;
		isAuditBatch = 0;
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
	 * @return the callId
	 */
	public String getCallId() {
		return callId;
	}

	/**
	 * @param callId the callId to set
	 */
	public void setCallId(String callId) {
		this.callId = callId;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
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
	 * @return the customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the customerIp
	 */
	public String getCustomerIp() {
		return customerIp;
	}

	/**
	 * @param customerIp the customerIp to set
	 */
	public void setCustomerIp(String customerIp) {
		this.customerIp = customerIp;
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

	/**
	 * @return the failReason
	 */
	public String getFailReason() {
		return failReason;
	}

	/**
	 * @param failReason the failReason to set
	 */
	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Call [index=" + index + ", callId=" + callId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", length=" + length + ", type=" + type + ", groupId=" + groupId + ", agentId=" + agentId
				+ ", agentNumber=" + agentNumber + ", agentName=" + agentName + ", agentIp=" + agentIp
				+ ", customerNumber=" + customerNumber + ", customerIp=" + customerIp + ", isAudit=" + isAudit
				+ ", isAuditBatch=" + isAuditBatch + ", failReason=" + failReason + "]";
	}

    
}