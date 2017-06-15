package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class FaultAlarmStatGroup extends BaseDomain {
	
	private String sys_id;
	private String sys_name;
	private String code;
	private String happened_time;
	private String detail;

	
    public FaultAlarmStatGroup() {
		super();
		sys_id = "";
		sys_name = "";
		code = "";
		happened_time = "";
		detail = "";
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


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getHappened_time() {
		return happened_time;
	}


	public void setHappened_time(String happened_time) {
		this.happened_time = happened_time;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FaultAlarmStatGroup [sys_id="+sys_id+", sys_name=" + sys_name + ", code=" + code + ", happened_time=" + happened_time + ", detail=" + detail+"]";
	}

}