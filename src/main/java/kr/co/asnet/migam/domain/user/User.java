package kr.co.asnet.migam.domain.user;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 사용자 도메인 클래스
 * Updated 2016-06-15
 * 참고 사항 :
 *  - role : 'ADMIN', 'BOARD-POLICY' 등과 같이 특정 리소스에 대한 권한이 다수개의 문자열이 들어감
 *  
 */
@SuppressWarnings("serial")
public class User extends BaseDomain { 
	// 가장 기본적인 정보들
	private int index;
	private String userId;
	private String passwd;
	private String userName;
	private int status;
	private String role;
	private Date createDate;
	private Date visitDate;
	private String phone;
	private String org;
	private String position;
	private int alarmCount;
	
    public User() {
		super();
		index = 0;
		userId = "";
		passwd = "";
		userName = "";
		status = 0;
		role = "";
		createDate = null;
		visitDate = null;
		phone = "";
		org = "";
		position = "";
		alarmCount = 0;
	}

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the visitDate
	 */
	public Date getVisitDate() {
		return visitDate;
	}

	/**
	 * @param visitDate the visitDate to set
	 */
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the org
	 */
	public String getOrg() {
		return org;
	}

	/**
	 * @param org the org to set
	 */
	public void setOrg(String org) {
		this.org = org;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the alarmCount
	 */
	public int getAlarmCount() {
		return alarmCount;
	}

	/**
	 * @param alarmCount the alarmCount to set
	 */
	public void setAlarmCount(int alarmCount) {
		this.alarmCount = alarmCount;
	}

}