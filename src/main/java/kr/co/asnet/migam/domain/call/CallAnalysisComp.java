package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 콜 분석(Analysis-Result)을 위한 도메인 클래스 <br>
 * CallAnalysis.java 를 사용하지만, 이 클래스는 콜 상세조회 그래프를 그릴 때 시간 비교를 위해 사용 <br> 
 * Updated 2016-10-18 <br>
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class CallAnalysisComp extends BaseDomain implements Comparable<CallAnalysisComp> {
	// 가장 기본적인 정보들
	private int index;
	private String jobId;
	private String agentId;
	private String groupId;
	private String agentName;
	private int callParty;
	private int callDuration;
	private int agentResult;
	private String agentResultString;
	private int agentSegmentCount;
	private String agentStartPos;
	private String agentEndPos;
	private String agentSegmentData;
	private int customerResultFlag;
	private int customerFailCode;
	private int customerResult;
	private String	customerResultString;
	private int customerSegmentCount;
	private String	customerStartPos;
	private String	customerEndPos;
	private String	customerSegmentData;
	private Date createDate;
	private float startPos;
	private float endPos;
	private String	segmentData;

    public CallAnalysisComp() {
		super();
		index = 0;
		jobId = "";
		agentId = "";
		groupId = "";
		agentName = "";
		callParty = 0;
		callDuration = 0;
		agentResult = 0;
		agentResultString = "";
		agentSegmentCount = 0;
		agentStartPos = "";
		agentEndPos = "";
		agentSegmentData = "";
		customerResultFlag = 0;
		customerFailCode = 0;
		customerResult = 0;
		customerResultString = "";
		customerSegmentCount = 0;
		customerStartPos = "";
		customerEndPos = "";
		customerSegmentData = "";
		createDate = null;
		this.startPos = startPos;
		this.endPos = endPos;
		this.segmentData = segmentData;
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

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	/**
	 * @return the callParty
	 */
	public int getCallParty() {
		return callParty;
	}

	/**
	 * @param callParty the callParty to set
	 */
	public void setCallParty(int callParty) {
		this.callParty = callParty;
	}

	public int getCallDuration() {
		return callDuration;
	}

	public void setCallDuration(int callDuration) {
		this.callDuration = callDuration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	/**
	 * @return the startPos
	 */
	public float getStartPos() {
		return startPos;
	}

	/**
	 * @param startPos the startPos to set
	 */
	public void setStartPos(float startPos) {
		this.startPos = startPos;
	}

	/**
	 * @return the endPos
	 */
	public float getEndPos() {
		return endPos;
	}

	/**
	 * @param endPos the endPos to set
	 */
	public void setEndPos(float endPos) {
		this.endPos = endPos;
	}

	/**
	 * @return the segmentData
	 */
	public String getSegmentData() {
		return segmentData;
	}

	/**
	 * @param segmentData the segmentData to set
	 */
	public void setSegmentData(String segmentData) {
		this.segmentData = segmentData;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CallAnalysisComp callAnalysisComp) {
		//float compareStartPos = ((CallAnalysisComp) startPos).getStartPos();
		return (int) ( this.startPos - callAnalysisComp.getStartPos() );
	}



}