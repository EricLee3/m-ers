package kr.co.asnet.migam.domain.config;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 자동 수행 작업을 위한 도메인 클래스
 * Updated 2016-09-22
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class Batch extends BaseDomain {
	
	private int index;
	private String jobId;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private String recordStart;
	private String recordEnd;
	private String groupId;
	private String agentId;
	private String triggerTime;
	private int repeat;
	private int status;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	private String jobName;
	
	public Batch() {
		super();
		index = 0;
		jobId = "";
		startTime = null;
		endTime = null;
		recordStart = "";
		recordEnd = "";
		groupId="";
		agentId = "";
		triggerTime = "";
		repeat = 0;
		status = 0;
		createDate = null;
		jobName = "";
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

	public Date getStartTime() throws Exception {
		return this.startTime;
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

	public String getRecordStart() {
		return recordStart;
	}

	public void setRecordStart(String recordStart) {
		this.recordStart = recordStart;
	}

	public String getRecordEnd() {
		return recordEnd;
	}

	public void setRecordEnd(String recordEnd) {
		this.recordEnd = recordEnd;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getAgentId() {
		return agentId;
	}

	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	public String getTriggerTime() {
		return triggerTime;
	}

	public void setTriggerTime(String triggerTime) {
		this.triggerTime = triggerTime;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	@Override
	public String toString() {
		return "Batch [index=" + index + ", jobId=" + jobId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", recordStart=" + recordStart + ", recordEnd=" + recordEnd + ", groupId=" + groupId + ", agentId="
				+ agentId + ", triggerTime=" + triggerTime + ", repeat=" + repeat + ", status=" + status
				+ ", createDate=" + createDate + ", jobName=" + jobName
				+ "]";
	}

	

}