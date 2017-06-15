package kr.co.asnet.migam.domain.agent;

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
public class ResourceLog extends BaseDomain {
	
	private String sysId;
	private String sysName;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	private Date updateTime;
	private String hostName;
	private String cateGory;
	private String vaLue;
	private String alarmLv;
	
	public ResourceLog() {
		super();
		sysId = "";
		sysName = "";
		startTime = null;
		endTime = null;
		updateTime = null;
		hostName = "";
		cateGory = "";
		vaLue="";
		alarmLv = "";

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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	
	public String getCateGory() {
		return cateGory;
	}

	public void setCateGory(String cateGory) {
		this.cateGory = cateGory;
	}

	public String getVaLue() {
		return vaLue;
	}

	public void setVaLue(String vaLue) {
		this.vaLue = vaLue;
	}

	public String getAlarmLv() {
		return alarmLv;
	}

	public void setAlarmLv(String alarmLv) {
		this.alarmLv = alarmLv;
	}

	@Override
	public String toString() {
		return "ResourceLog [sysId=" + sysId + ", sysName=" + sysName + ", startTime=" + startTime + ", endTime="
				+ endTime + ", updateTime=" + updateTime + ", hostName=" + hostName + ", cateGory=" + cateGory
				+ ", vaLue=" + vaLue + ", alarmLv=" + alarmLv + "]";
	}


}