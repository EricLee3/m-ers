package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class AlarmStatGroup extends BaseDomain {
	
	private String sys_id;
	private String sys_name;
	private String alarm_code;
	private String alarmed_time;
	private String alarm_flag;
	private String alarm_lv;
	private String alarm_detail;
	private String audio_flag;
	
    public AlarmStatGroup() {
		super();
		sys_id = "";
		sys_name = "";
		alarm_code = "";
		alarmed_time = "";
		alarm_flag = "";
		alarm_lv = "";
		alarm_detail = "";
		audio_flag = "";
	}

	public String getSys_id() {
		return sys_id;
	}

	public void setSys_id(String sys_id) {
		this.sys_id = sys_id;
	}

	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}
	public String getAlarm_code() {
		return alarm_code;
	}

	public void setAlarm_code(String alarm_code) {
		this.alarm_code = alarm_code;
	}
	public String getAlarmed_time() {
		return alarmed_time;
	}

	public void setAlarmed_time(String alarmed_time) {
		this.alarmed_time = alarmed_time;
	}

	public String getAlarm_flag() {
		return alarm_flag;
	}

	public void setAlarm_flag(String alarm_flag) {
		this.alarm_flag = alarm_flag;
	}
	public String getAlarm_lv() {
		return alarm_lv;
	}
	public void setAlarm_lv(String alarm_lv) {
		this.alarm_lv = alarm_lv;
	}
	public String getAlarm_detail() {
		return alarm_detail;
	}
	public void setAlarm_detail(String alarm_detail) {
		this.alarm_detail = alarm_detail;
	}
	
	public String getAudio_flag() {
		return audio_flag;
	}

	public void setAudio_flag(String audio_flag) {
		this.audio_flag = audio_flag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlarmStatGroup [sys_id=" + sys_id + ", sys_name=" + sys_name + ", alarm_code=" + alarm_code + ", alarmed_time="
				+ alarmed_time + ", alarm_flag=" + alarm_flag + ", alarm_lv=" + alarm_lv + ", alarm_detail=" + alarm_detail + ", audio_flag=" + audio_flag + "]";
	}

}