package kr.co.asnet.migam.domain.user;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 세션 사용자 도메인 클래스
 */
@SuppressWarnings("serial")
@Component("sessionUser")
@Scope(value = "session")
public class SessionUser implements Serializable {
	private boolean superUser;
	private boolean admin;
	private boolean login;
	private boolean approval;
	private boolean accessOnlyPC;
	private User currentUser;
	private Date loginTime;

	private static final Logger logger = LoggerFactory.getLogger(SessionUser.class);
	
	/**
	 * SessionUser가 처음 생성될 때, 해당 사용자에 대한 정보가 지정되지 않으므로, 모든 값을 False 또는 Null로 초기화 합니다.
	 */
	public SessionUser() {
		super();
		//System.out.println(":::::SessionUser::::::");
		logoutSessionUser();
	}
	
	/**
	 * 현재 사용자의 정보를 강제로 초기화 합니다. 
	 */
	public void logoutSessionUser() {
		//System.out.println(":::::logoutSessionUser::::::");
		this.superUser = false;
		this.login = false;
		this.admin = false;
		this.currentUser = null;
	}

	/**
	 * 회원가입이 승인된 사용자일 경우 true를 반환합니다.
	 * 
	 * @return
	 */
	public boolean isApproval() {
		if (currentUser != null && currentUser.getStatus() == 1) {
			this.approval = true;
		} else {
			this.approval = false;
		}
		return approval;
	}

	/**
	 * 로그인한 회원인 경우 true 를 반환합니다.
	 * 
	 * @return
	 */
	public boolean isSuperUser() {
		this.superUser = false;
		if (currentUser != null) {
			if ( StringUtils.containsIgnoreCase(currentUser.getRole(), "SUPERUSER") == true ) this.superUser = true;
		} 
		return superUser;
	}

	/**
	 * 관리자인 경우 true 를 반환합니다.
	 * 
	 * @return
	 */
	public boolean isAdmin() {
		this.admin = false;
		if (currentUser != null) {
			if ( StringUtils.containsIgnoreCase(currentUser.getRole(), "ADMIN") == true ) this.admin = true;
		} 
		return this.admin;
	}
	
	public boolean isLogin() {
		this.login = false;
		if (currentUser != null) {
			if( currentUser.getIndex() > 0 ) this.login = true;
		} 
		return this.login;
	}

	/**
	 * 현재 세션사용자와 동일한 경우 true 를 반환합니다.
	 * 
	 * @param dbUser
	 * @return
	 */
	public boolean isOwner(User dbUser) {
		boolean flag = false;
		if (dbUser != null && currentUser.getIndex() == dbUser.getIndex()) {
			flag = true;
		}
		return flag;
	}

	public User getCurrentUser() {
		if(currentUser == null) currentUser = new User();
		return currentUser;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * 지정된 사용자를 
	 * @param user
	 */
	public void saveUser(User user) {
		//System.out.println("::::::saveUser:::::::");
		this.currentUser = user;
		this.superUser = this.isSuperUser();
		this.login = this.isLogin();
		this.admin = this.isAdmin();
		this.loginTime = new Date();
	}

	public void removeUser() {
		//System.out.println("::::::removeUser:::::::");
		this.saveUser(new User());
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SessionUser [superUser=" + superUser + ", admin=" + admin + ", login=" + login + ", approval=" + approval
				+ ", accessOnlyPC=" + accessOnlyPC + ", currentUser=" + currentUser + ", loginTime=" + loginTime + "]";
	}

	
}
