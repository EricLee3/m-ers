package kr.co.asnet.migam.domain.agent;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 알람 이력을 위한 도메인 클래스
 * Updated 2016-12-08
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class AlarmLog extends BaseDomain {
	
	private String sysId;
	private String sysName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private String alarmCode;
	private Date alarmedTime;
	private Date releaseTime;
	private String alarmFlag;
	private String alarmLv;
	private String alarmDetail;
	
	public AlarmLog() {
		super();
		sysId = "";
		sysName = "";
		startTime = null;
		endTime = null;
		alarmedTime = null;
		releaseTime = null;
		alarmFlag = "";
		alarmLv = "";
		alarmDetail="";
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
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

	public String getAlarmCode() {
		return alarmCode;
	}

	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}

	public Date getAlarmedTime() {
		return alarmedTime;
	}

	public void setAlarmedTime(Date alarmedTime) {
		this.alarmedTime = alarmedTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getAlarmFlag() {
		return alarmFlag;
	}

	public void setAlarmFlag(String alarmFlag) {
		this.alarmFlag = alarmFlag;
	}

	public String getAlarmLv() {
		return alarmLv;
	}

	public void setAlarmLv(String alarmLv) {
		this.alarmLv = alarmLv;
	}

	public String getAlarmDetail() {
		return alarmDetail;
	}

	public void setAlarmDetail(String alarmDetail) {
		this.alarmDetail = alarmDetail;
	}

	@Override
	public String toString() {
		return "AlarmLog [sysId=" + sysId + ", sysName=" + sysName + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", alarmCode=" + alarmCode + ", alarmedTime=" + alarmedTime + ", releaseTime=" + releaseTime
				+ ", alarmFlag=" + alarmFlag + ", alarmLv=" + alarmLv + ", alarmDetail=" + alarmDetail + "]";
	}


}