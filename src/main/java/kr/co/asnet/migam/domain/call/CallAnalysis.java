package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 콜 분석(Analysis-Result)을 위한 도메인 클래스 <br>
 * Updated 2016-09-23 <br>
 * 참고 사항 :
 * 테이블 : mecs5_analysis_result 
 */
@SuppressWarnings("serial")
public class CallAnalysis extends BaseDomain {
	// 가장 기본적인 정보들
	private int index;
	private String jobId;
	private String agentId;
	private String groupId;
	private String agentNumber;
	private String agentName;
	private String customerNumber;
	private Date recogTime;
	private int callType;
	private Date startTime;
	private Date endTime;
	private int callDuration;
	private int bmAgent;
	private int bmCustomer;
	private String mixedWavePath;
	private float agentCriticalValue;
	private float customerCriticalValue;
	// 테이블 변경에 따라서 새로 추가된 필드
	private int agentTransitionFlag;
	private int agentResultFlag;
	private int agentFailCode;
	private int agentResult;
	private String agentResultString;
	private String agentWavePath;
	private int agentSegmentCount;
	private String agentStartPos;
	private String agentEndPos;
	private String agentSegmentData;
	private int customerTransitionFlag;
	private int customerResultFlag;
	private int customerFailCode;
	private int customerResult;
	private String	customerResultString;
	private String	customerWavePath;
	private int customerSegmentCount;
	private String	customerStartPos;
	private String	customerEndPos;
	private String	customerSegmentData;
	//. 테이블 변경에 따라서 새로 추가된 필드
	private Date createDate;

    public CallAnalysis() {
		super();
		index = 0;
		jobId = "";
		agentId = "";
		groupId = "";
		agentNumber = "";
		agentName = "";
		customerNumber = "";
		recogTime = null;
		callType = 0;
		startTime  = null;
		endTime  = null;
		callDuration = 0;
		bmAgent = 0;
		bmCustomer = 0;
		mixedWavePath = "";
		agentCriticalValue  = 0;
		customerCriticalValue = 0;
		agentTransitionFlag = 0;
		agentResultFlag = 0;
		agentFailCode = 0;
		agentResult = 0;
		agentResultString = "";
		agentWavePath = "";
		agentSegmentCount = 0;
		agentStartPos = "";
		agentEndPos = "";
		agentSegmentData = "";
		customerTransitionFlag = 0;
		customerResultFlag = 0;
		customerFailCode = 0;
		customerResult = 0;
		customerResultString = "";
		customerWavePath = "";
		customerSegmentCount = 0;
		customerStartPos = "";
		customerEndPos = "";
		customerSegmentData = "";
		createDate = null;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
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

	public Date getRecogTime() {
		return recogTime;
	}

	public void setRecogTime(Date recogTime) {
		this.recogTime = recogTime;
	}

	public int getCallType() {
		return callType;
	}

	public void setCallType(int callType) {
		this.callType = callType;
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

	public int getBmAgent() {
		return bmAgent;
	}

	public void setBmAgent(int bmAgent) {
		this.bmAgent = bmAgent;
	}

	public int getBmCustomer() {
		return bmCustomer;
	}

	public void setBmCustomer(int bmCustomer) {
		this.bmCustomer = bmCustomer;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the mixedWavePath
	 */
	public String getMixedWavePath() {
		return mixedWavePath;
	}

	/**
	 * @param mixedWavePath the mixedWavePath to set
	 */
	public void setMixedWavePath(String mixedWavePath) {
		this.mixedWavePath = mixedWavePath;
	}

	/**
	 * @return the agentTransitionFlag
	 */
	public int getAgentTransitionFlag() {
		return agentTransitionFlag;
	}

	/**
	 * @param agentTransitionFlag the agentTransitionFlag to set
	 */
	public void setAgentTransitionFlag(int agentTransitionFlag) {
		this.agentTransitionFlag = agentTransitionFlag;
	}

	/**
	 * @return the agentResultFlag
	 */
	public int getAgentResultFlag() {
		return agentResultFlag;
	}

	/**
	 * @param agentResultFlag the agentResultFlag to set
	 */
	public void setAgentResultFlag(int agentResultFlag) {
		this.agentResultFlag = agentResultFlag;
	}

	/**
	 * @return the agentFailCode
	 */
	public int getAgentFailCode() {
		return agentFailCode;
	}

	/**
	 * @param agentFailCode the agentFailCode to set
	 */
	public void setAgentFailCode(int agentFailCode) {
		this.agentFailCode = agentFailCode;
	}

	/**
	 * @return the agentResult
	 */
	public int getAgentResult() {
		return agentResult;
	}

	/**
	 * @param agentResult the agentResult to set
	 */
	public void setAgentResult(int agentResult) {
		this.agentResult = agentResult;
	}

	/**
	 * @return the agentResultString
	 */
	public String getAgentResultString() {
		return agentResultString;
	}

	/**
	 * @param agentResultString the agentResultString to set
	 */
	public void setAgentResultString(String agentResultString) {
		this.agentResultString = agentResultString;
	}

	/**
	 * @return the agentWavePath
	 */
	public String getAgentWavePath() {
		return agentWavePath;
	}

	/**
	 * @param agentWavePath the agentWavePath to set
	 */
	public void setAgentWavePath(String agentWavePath) {
		this.agentWavePath = agentWavePath;
	}

	/**
	 * @return the agentSegmentCount
	 */
	public int getAgentSegmentCount() {
		return agentSegmentCount;
	}

	/**
	 * @param agentSegmentCount the agentSegmentCount to set
	 */
	public void setAgentSegmentCount(int agentSegmentCount) {
		this.agentSegmentCount = agentSegmentCount;
	}

	/**
	 * @return the agentStartPos
	 */
	public String getAgentStartPos() {
		return agentStartPos;
	}

	/**
	 * @param agentStartPos the agentStartPos to set
	 */
	public void setAgentStartPos(String agentStartPos) {
		this.agentStartPos = agentStartPos;
	}

	/**
	 * @return the agentEndPos
	 */
	public String getAgentEndPos() {
		return agentEndPos;
	}

	/**
	 * @param agentEndPos the agentEndPos to set
	 */
	public void setAgentEndPos(String agentEndPos) {
		this.agentEndPos = agentEndPos;
	}

	/**
	 * @return the agentSegmentData
	 */
	public String getAgentSegmentData() {
		return agentSegmentData;
	}

	/**
	 * @param agentSegmentData the agentSegmentData to set
	 */
	public void setAgentSegmentData(String agentSegmentData) {
		this.agentSegmentData = agentSegmentData;
	}

	/**
	 * @return the customerTransitionFlag
	 */
	public int getCustomerTransitionFlag() {
		return customerTransitionFlag;
	}

	/**
	 * @param customerTransitionFlag the customerTransitionFlag to set
	 */
	public void setCustomerTransitionFlag(int customerTransitionFlag) {
		this.customerTransitionFlag = customerTransitionFlag;
	}

	/**
	 * @return the customerResultFlag
	 */
	public int getCustomerResultFlag() {
		return customerResultFlag;
	}

	/**
	 * @param customerResultFlag the customerResultFlag to set
	 */
	public void setCustomerResultFlag(int customerResultFlag) {
		this.customerResultFlag = customerResultFlag;
	}

	/**
	 * @return the customerFailCode
	 */
	public int getCustomerFailCode() {
		return customerFailCode;
	}

	/**
	 * @param customerFailCode the customerFailCode to set
	 */
	public void setCustomerFailCode(int customerFailCode) {
		this.customerFailCode = customerFailCode;
	}

	/**
	 * @return the customerResult
	 */
	public int getCustomerResult() {
		return customerResult;
	}

	/**
	 * @param customerResult the customerResult to set
	 */
	public void setCustomerResult(int customerResult) {
		this.customerResult = customerResult;
	}

	/**
	 * @return the customerResultString
	 */
	public String getCustomerResultString() {
		return customerResultString;
	}

	/**
	 * @param customerResultString the customerResultString to set
	 */
	public void setCustomerResultString(String customerResultString) {
		this.customerResultString = customerResultString;
	}

	/**
	 * @return the customerWavePath
	 */
	public String getCustomerWavePath() {
		return customerWavePath;
	}

	/**
	 * @param customerWavePath the customerWavePath to set
	 */
	public void setCustomerWavePath(String customerWavePath) {
		this.customerWavePath = customerWavePath;
	}

	/**
	 * @return the customerSegmentCount
	 */
	public int getCustomerSegmentCount() {
		return customerSegmentCount;
	}

	/**
	 * @param customerSegmentCount the customerSegmentCount to set
	 */
	public void setCustomerSegmentCount(int customerSegmentCount) {
		this.customerSegmentCount = customerSegmentCount;
	}

	/**
	 * @return the customerStartPos
	 */
	public String getCustomerStartPos() {
		return customerStartPos;
	}

	/**
	 * @param customerStartPos the customerStartPos to set
	 */
	public void setCustomerStartPos(String customerStartPos) {
		this.customerStartPos = customerStartPos;
	}

	/**
	 * @return the customerEndPos
	 */
	public String getCustomerEndPos() {
		return customerEndPos;
	}

	/**
	 * @param customerEndPos the customerEndPos to set
	 */
	public void setCustomerEndPos(String customerEndPos) {
		this.customerEndPos = customerEndPos;
	}

	/**
	 * @return the customerSegmentData
	 */
	public String getCustomerSegmentData() {
		return customerSegmentData;
	}

	/**
	 * @param customerSegmentData the customerSegmentData to set
	 */
	public void setCustomerSegmentData(String customerSegmentData) {
		this.customerSegmentData = customerSegmentData;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CallAnalysis [index=" + index + ", jobId=" + jobId + ", agentId=" + agentId + ", groupId=" + groupId
				+ ", agentNumber=" + agentNumber + ", agentName=" + agentName + ", customerNumber=" + customerNumber
				+ ", recogTime=" + recogTime + ", callType=" + callType + ", startTime="
				+ startTime + ", endTime=" + endTime + ", callDuration=" + callDuration + ", bmAgent=" + bmAgent
				+ ", bmCustomer=" + bmCustomer + ", mixedWavePath=" + mixedWavePath + ", agentCriticalValue="
				+ agentCriticalValue + ", customerCriticalValue=" + customerCriticalValue + ", agentTransitionFlag="
				+ agentTransitionFlag + ", agentResultFlag=" + agentResultFlag + ", agentFailCode=" + agentFailCode
				+ ", agentResult=" + agentResult + ", agentResultString=" + agentResultString + ", agentWavePath="
				+ agentWavePath + ", agentSegmentCount=" + agentSegmentCount + ", agentStartPos=" + agentStartPos
				+ ", agentEndPos=" + agentEndPos + ", agentSegmentData=" + agentSegmentData
				+ ", customerTransitionFlag=" + customerTransitionFlag + ", customerResultFlag=" + customerResultFlag
				+ ", customerFailCode=" + customerFailCode + ", customerResult=" + customerResult
				+ ", customerResultString=" + customerResultString + ", customerWavePath=" + customerWavePath
				+ ", customerSegmentCount=" + customerSegmentCount + ", customerStartPos=" + customerStartPos
				+ ", customerEndPos=" + customerEndPos + ", customerSegmentData=" + customerSegmentData
				+ ", createDate=" + createDate + "]";
	}

}