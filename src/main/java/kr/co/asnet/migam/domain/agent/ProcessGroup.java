package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class ProcessGroup extends BaseDomain {
	
	private String sys_id;
	private String sys_name;
	private String update_time;
	private String host_name;
	private String category;
	private String value;
	private String alarm_lv;
	
    public ProcessGroup() {
		super();
		sys_id = "";
		sys_name = "";
		update_time = "";
		host_name = "";
		category = "";
		value = "";
		alarm_lv = "";
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

	public String getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}


	public String getHost_name() {
		return host_name;
	}


	public void setHost_name(String host_name) {
		this.host_name = host_name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}

	public String getAlarm_lv() {
		return alarm_lv;
	}


	public void setAlarm_lv(String alarm_lv) {
		this.alarm_lv = alarm_lv;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProcessGroup [sys_id=" + sys_id + ", sys_name=" + sys_name + ", update_time=" + update_time + ", host_name="
				+ host_name + ", category=" + category + ", value=" + value + ", alarm_lv=" + alarm_lv + "]";
	}

}