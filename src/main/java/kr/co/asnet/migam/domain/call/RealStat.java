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
public class RealStat extends BaseDomain {
	private String agentId;
	private String groupId;
	private int callStatus;
	private Date recognitionTime;
	private Date startTime;
	private Date endTime;
	private int callDuration;
	private int callType;
	private String agentNumber;
	private String agentName;
	private String customerNumber;
	private String agentWavePath;
	private String customerWavePath;
	private String agentScript;
	private String customerScript;
	private String groupName;
	private String agentProfileId;
	private String agentProfileName;
	private String customerProfileId;
	private String customerProfileName;
	
    public RealStat() {
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
		agentName = "";
		customerNumber = "";
		agentWavePath = "";
		customerWavePath = "";
		agentScript = "";
		customerScript = "";
		groupName = "";
		agentProfileId = "";
		agentProfileName = "";
		customerProfileId = "";
		customerProfileName = "";
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


	public String getAgentName() {
		return agentName;
	}


	public void setAgentName(String agentName) {
		this.agentName = agentName;
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


	public String getAgentScript() {
		return agentScript;
	}


	public void setAgentScript(String agentScript) {
		this.agentScript = agentScript;
	}


	public String getCustomerScript() {
		return customerScript;
	}


	public void setCustomerScript(String customerScript) {
		this.customerScript = customerScript;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getAgentProfileId() {
		return agentProfileId;
	}


	public void setAgentProfileId(String agentProfileId) {
		this.agentProfileId = agentProfileId;
	}


	public String getAgentProfileName() {
		return agentProfileName;
	}


	public void setAgentProfileName(String agentProfileName) {
		this.agentProfileName = agentProfileName;
	}


	public String getCustomerProfileId() {
		return customerProfileId;
	}


	public void setCustomerProfileId(String customerProfileId) {
		this.customerProfileId = customerProfileId;
	}


	public String getCustomerProfileName() {
		return customerProfileName;
	}


	public void setCustomerProfileName(String customerProfileName) {
		this.customerProfileName = customerProfileName;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RealTime [agentId=" + agentId + ", groupId=" + groupId + ", callStatus=" + callStatus
				+ ", recognitionTime=" + recognitionTime + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", callDuration=" + callDuration + ", callType=" + callType + ", agentNumber=" + agentNumber
				+ ", customerNumber=" + customerNumber + ", agentWavePath=" + agentWavePath + ", customerWavePath="+ customerWavePath 
				+ ", agentScript=" + agentScript + ", customerScript=" + customerScript
				+ ", agentName=" + agentName + ", groupName=" + groupName 
				+ ", agentProfileId=" + agentProfileId + ", agentProfileName=" + agentProfileName
				+ ", customerProfileId=" + customerProfileId + ", customerProfileName=" + customerProfileName
				+ "]";
	}
	
	

}