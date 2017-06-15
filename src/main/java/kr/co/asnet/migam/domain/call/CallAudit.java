package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 실시간 통화(Call-Stat)을 위한 도메인 클래스 <br>
 * Updated 2016-09-15 <br>
 * 참고 사항 :
 * 연관 테이블 : MECS5_REALTIME_STATE 
 **/
@SuppressWarnings("serial")
public class CallAudit extends BaseDomain {
	private String agentId;
	private String groupId;
	private int callStatus;
	private Date recognitionTime;
	private Date startTime;
	private Date endTime;
	private int callDuration;
	private int callType;
	private String agentNumber;
	private String customerNumber;
	private String agentWavePath;
	private String customerWavePath;
	private float agentCriticalValue;
	private float customerCriticalValue;
	private int agentStressCount;
	private int customerAngryCount;
	private String agentState;
	private String customerState;
	
	private int index;
	private String agentName;
	private String groupName;
	
    public CallAudit() {
		super();
		agentId = "";
		groupId = "";
		callStatus = 0;
		recognitionTime = null;
		startTime = null;
		endTime = null;
		callDuration = 0;
		callType = 0;
		agentNumber = "";
		customerNumber = "";
		agentWavePath = "";
		customerWavePath = "";
		agentCriticalValue = 0;
		customerCriticalValue = 0;
		agentStressCount = 0;
		customerAngryCount = 0;
		agentState = "";
		customerState = "";
		
		index = 0;
		agentName = "";
		groupName = "";
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public int getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(int callStatus) {
		this.callStatus = callStatus;
	}

	public Date getRecognitionTime() {
		return recognitionTime;
	}

	public void setRecognitionTime(Date recognitionTime) {
		this.recognitionTime = recognitionTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
	}

	public String getAgentNumber() {
		return agentNumber;
	}

	public void setAgentNumber(String agentNumber) {
		this.agentNumber = agentNumber;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getAgentWavePath() {
		return agentWavePath;
	}

	public void setAgentWavePath(String agentWavePath) {
		this.agentWavePath = agentWavePath;
	}

	public String getCustomerWavePath() {
		return customerWavePath;
	}

	public void setCustomerWavePath(String customerWavePath) {
		this.customerWavePath = customerWavePath;
	}

	public float getAgentCriticalValue() {
		return agentCriticalValue;
	}

	public void setAgentCriticalValue(float agentCriticalValue) {
		this.agentCriticalValue = agentCriticalValue;
	}

	public float getCustomerCriticalValue() {
		return customerCriticalValue;
	}

	public void setCustomerCriticalValue(float customerCriticalValue) {
		this.customerCriticalValue = customerCriticalValue;
	}

	public int getAgentStressCount() {
		return agentStressCount;
	}

	public void setAgentStressCount(int agentStressCount) {
		this.agentStressCount = agentStressCount;
	}

	public int getCustomerAngryCount() {
		return customerAngryCount;
	}

	public void setCustomerAngryCount(int customerAngryCount) {
		this.customerAngryCount = customerAngryCount;
	}

	public String getAgentState() {
		return agentState;
	}

	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}

	public String getCustomerState() {
		return customerState;
	}

	public void setCustomerState(String customerState) {
		this.customerState = customerState;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CallAudit [agentId=" + agentId + ", groupId=" + groupId + ", callStatus=" + callStatus
				+ ", recognitionTime=" + recognitionTime + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", callDuration=" + callDuration + ", callType=" + callType + ", agentNumber=" + agentNumber
				+ ", customerNumber=" + customerNumber + ", agentWavePath=" + agentWavePath + ", customerWavePath="
				+ customerWavePath + ", agentCriticalValue=" + agentCriticalValue + ", customerCriticalValue="
				+ customerCriticalValue + ", agentStressCount=" + agentStressCount + ", customerAngryCount="
				+ customerAngryCount + ", agentState=" + agentState + ", customerState=" + customerState + ", index="
				+ index + ", agentName=" + agentName + ", groupName=" + groupName + "]";
	}
	
	

}