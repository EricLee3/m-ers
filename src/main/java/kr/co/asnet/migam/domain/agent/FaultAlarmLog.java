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
public class FaultAlarmLog extends BaseDomain {
	
	private String sys_id;
	private String sys_name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date happened_time;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date delete_time;
	private String code;
	private String detail;
	private String s_username;
	private String s_userid;
	
	public FaultAlarmLog() {
		super();
		sys_id = "";
		sys_name = "";
		happened_time = null;
		delete_time = null;
		code = "";
		detail = "";
		s_username = "";
		s_userid = "";
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


	public Date getHappened_time() {
		return happened_time;
	}


	public void setHappened_time(Date happened_time) {
		this.happened_time = happened_time;
	}


	public Date getDelete_time() {
		return delete_time;
	}


	public void setDelete_time(Date delete_time) {
		this.delete_time = delete_time;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public String getS_username() {
		return s_username;
	}


	public void setS_username(String s_username) {
		this.s_username = s_username;
	}


	public String getS_userid() {
		return s_userid;
	}


	public void setS_userid(String s_userid) {
		this.s_userid = s_userid;
	}


	@Override
	public String toString() {
		return "AlarmLog [sys_id=" + sys_id + ", sys_name=" + sys_name + ", happened_time=" + happened_time + ", delete_time=" + delete_time
				+ ", code=" + code + ", detail=" + detail + ", s_username=" + s_username + ", s_userid=" + s_userid + "]";
	}


}