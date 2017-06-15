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
public class HisLog extends BaseDomain {
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date change_date;
	private String user_id;
	private String user_name;
	private String user_ip;
	private String menu;
	private String detail;
	
	public HisLog() {
		super();
		change_date = null;
		user_id = "";
		user_name = "";
		user_ip = "";
		menu = "";
		detail = "";
	}

	

	public Date getChange_date() {
		return change_date;
	}



	public void setChange_date(Date change_date) {
		this.change_date = change_date;
	}



	public String getUser_id() {
		return user_id;
	}



	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}



	public String getUser_name() {
		return user_name;
	}



	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



	public String getUser_ip() {
		return user_ip;
	}



	public void setUser_ip(String user_ip) {
		this.user_ip = user_ip;
	}



	public String getMenu() {
		return menu;
	}



	public void setMenu(String menu) {
		this.menu = menu;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	@Override
	public String toString() {
		return "AlarmLog [change_date=" + change_date + ", user_id=" + user_id + ", user_name=" + user_name + ", user_ip=" + user_ip
				+ ", menu=" + menu + ", detail=" + detail + "]";
	}


}