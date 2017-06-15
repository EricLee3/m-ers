package kr.co.asnet.migam.domain.agent;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 각종 임계치 정보를 보관하기 위한 도메인클래스입니다.
 * Updated 2016-09-22
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class AlarmLimit extends BaseDomain {
	
	private String alarmIdx;
	private String criticalValue;
	private String majorValue;
	private String minorValue;
	private String cpuCri;
	private String diskCri;
	private String memoryCri;
	private String cpuMajor;
	private String diskMajor;
	private String memoryMajor;
	private String cpuMinor;
	private String diskMinor;
	private String memoryMinor;
	
	public AlarmLimit() {
		super();
		alarmIdx = "0";
		criticalValue = "0";
		majorValue = "0";
		minorValue = "0";
		cpuCri = "";
		diskCri = "";
		memoryCri = "";
		cpuMajor = "";
		diskMajor = "";
		memoryMajor = "";
		cpuMinor = "";
		diskMinor = "";
		memoryMinor = "";
	}

	public String getAlarmIdx() {
		return alarmIdx;
	}

	public void setAlarmIdx(String alarmIdx) {
		this.alarmIdx = alarmIdx;
	}

	public String getCriticalValue() {
		return criticalValue;
	}

	public void setCriticalValue(String criticalValue) {
		this.criticalValue = criticalValue;
	}

	public String getMajorValue() {
		return majorValue;
	}

	public void setMajorValue(String majorValue) {
		this.majorValue = majorValue;
	}

	public String getMinorValue() {
		return minorValue;
	}

	public void setMinorValue(String minorValue) {
		this.minorValue = minorValue;
	}


	public String getCpuCri() {
		return cpuCri;
	}

	public void setCpuCri(String cpuCri) {
		this.cpuCri = cpuCri;
	}

	public String getDiskCri() {
		return diskCri;
	}

	public void setDiskCri(String diskCri) {
		this.diskCri = diskCri;
	}

	public String getMemoryCri() {
		return memoryCri;
	}

	public void setMemoryCri(String memoryCri) {
		this.memoryCri = memoryCri;
	}

	public String getCpuMajor() {
		return cpuMajor;
	}

	public void setCpuMajor(String cpuMajor) {
		this.cpuMajor = cpuMajor;
	}

	public String getDiskMajor() {
		return diskMajor;
	}

	public void setDiskMajor(String diskMajor) {
		this.diskMajor = diskMajor;
	}

	public String getMemoryMajor() {
		return memoryMajor;
	}

	public void setMemoryMajor(String memoryMajor) {
		this.memoryMajor = memoryMajor;
	}

	public String getCpuMinor() {
		return cpuMinor;
	}

	public void setCpuMinor(String cpuMinor) {
		this.cpuMinor = cpuMinor;
	}

	public String getDiskMinor() {
		return diskMinor;
	}

	public void setDiskMinor(String diskMinor) {
		this.diskMinor = diskMinor;
	}

	public String getMemoryMinor() {
		return memoryMinor;
	}

	public void setMemoryMinor(String memoryMinor) {
		this.memoryMinor = memoryMinor;
	}

	@Override
	public String toString() {
		return "AlarmLimit [alarmIdx=" + alarmIdx + ", criticalValue=" + criticalValue + ", majorValue=" + majorValue
				+ ", minorValue=" + minorValue+ ", cpuCri=" + cpuCri + ", discCri=" + diskCri+ ", memoryCri=" + memoryCri+ ", cpuMajor=" + cpuMajor
				+ ", diskMajor=" + diskMajor+ ", memoryMajor=" + memoryMajor+ ", cpuMinor=" + cpuMinor+ ", diskMinor=" + diskMinor+ ", memoryMinor=" + memoryMinor+ "]";
	}


}