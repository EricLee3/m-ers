package kr.co.asnet.migam.domain.agent;

import java.util.List;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 알람코드 관리를 위한 도메인 클래스 <br>
 * Updated 2016-12-09
 * 참고 사항 :
 *	Index는 0부터 시작해야 합니다. 
 *  ( Agent.groupIndex = 0 인경우 수속 그룹이 없는 것으로 생각하기 때문입니다. )   
 */
@SuppressWarnings("serial")
public class AlarmCode extends BaseDomain {
	// 가장 기본적인 정보들
	private int index;
	private String alarmCode;
	private String alarmLv;
	private String alarmDesc;
	private String useFlag;
	private String visualFlag;
	private String audioFlag;
	
    public AlarmCode() {
		super();
		index = 0;
		alarmCode = "";
		alarmLv="";
		alarmDesc = "";
		useFlag = "";
		visualFlag = "";
		audioFlag = "";
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getAlarmCode() {
		return alarmCode;
	}

	public void setAlarmCode(String alarmCode) {
		this.alarmCode = alarmCode;
	}

	public String getAlarmLv() {
		return alarmLv;
	}

	public void setAlarmLv(String alarmLv) {
		this.alarmLv = alarmLv;
	}

	public String getAlarmDesc() {
		return alarmDesc;
	}

	public void setAlarmDesc(String alarmDesc) {
		this.alarmDesc = alarmDesc;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getVisualFlag() {
		return visualFlag;
	}

	public void setVisualFlag(String visualFlag) {
		this.visualFlag = visualFlag;
	}

	public String getAudioFlag() {
		return audioFlag;
	}

	public void setAudioFlag(String audioFlag) {
		this.audioFlag = audioFlag;
	}

	@Override
	public String toString() {
		return "AlarmCode [index=" + index + ", alarmCode=" + alarmCode + ", alarmLv=" + alarmLv + ", alarmDesc="
				+ alarmDesc + ", useFlag=" + useFlag + ", visualFlag="+ visualFlag + ", audioFlag="+ audioFlag +"]";
	}
		
}