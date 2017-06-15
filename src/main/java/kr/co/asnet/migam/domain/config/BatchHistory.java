package kr.co.asnet.migam.domain.config;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 자동 수행 작업 내역을 위한 도메인 클래스
 * Updated 2016-09-29
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class BatchHistory extends BaseDomain {
	
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
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date jobEndTime;
	private int repeat;
	private int totalRecord;
	private int failRecord;
	private String description;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createDate;
	private String jobName;
	
	public BatchHistory() {
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
		jobEndTime = null;
		repeat = 0;
		totalRecord = 0;
		failRecord = 0;
		description = "";
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

	public Date getJobEndTime() {
		return jobEndTime;
	}

	public void setJobEndTime(Date jobEndTime) {
		this.jobEndTime = jobEndTime;
	}

	public int getRepeat() {
		return repeat;
	}

	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getFailRecord() {
		return failRecord;
	}

	public void setFailRecord(int failRecord) {
		this.failRecord = failRecord;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "BatchHistory [index=" + index + ", jobId=" + jobId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", recordStart=" + recordStart + ", recordEnd=" + recordEnd + ", groupId=" + groupId + ", agentId="
				+ agentId + ", triggerTime=" + triggerTime + ", jobEndTime=" + jobEndTime + ", repeat=" + repeat
				+ ", totalRecord=" + totalRecord + ", failRecord=" + failRecord + ", description=" + description
				+ ", createDate=" + createDate + ", jobName =" + jobName + "]";
	}

}