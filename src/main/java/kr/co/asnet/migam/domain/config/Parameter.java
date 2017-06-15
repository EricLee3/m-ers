package kr.co.asnet.migam.domain.config;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 각종 임계치 정보를 보관하기 위한 도메인클래스입니다.
 * Updated 2016-09-22
 * 참고 사항 :
 *  
 */
@SuppressWarnings("serial")
public class Parameter extends BaseDomain {
	
	private float agentStress;
	private float customerAngry;
	private int stressCount;
	private int angryCount;
	private String userId;
	private String title;
	private Date createDate;
	
	public Parameter() {
		super();
		agentStress = 0;
		customerAngry = 0;
		stressCount = 0;
		angryCount = 0;
		userId = "";
		title = "";
		createDate = null;
	}

	/**
	 * @return the agentStress
	 */
	public float getAgentStress() {
		return agentStress;
	}

	/**
	 * @param agentStress the agentStress to set
	 */
	public void setAgentStress(float agentStress) {
		this.agentStress = agentStress;
	}

	/**
	 * @return the customerAngry
	 */
	public float getCustomerAngry() {
		return customerAngry;
	}

	/**
	 * @param customerAngry the customerAngry to set
	 */
	public void setCustomerAngry(float customerAngry) {
		this.customerAngry = customerAngry;
	}

	/**
	 * @return the stressCount
	 */
	public int getStressCount() {
		return stressCount;
	}

	/**
	 * @param stressCount the stressCount to set
	 */
	public void setStressCount(int stressCount) {
		this.stressCount = stressCount;
	}

	/**
	 * @return the angryCount
	 */
	public int getAngryCount() {
		return angryCount;
	}

	/**
	 * @param angryCount the angryCount to set
	 */
	public void setAngryCount(int angryCount) {
		this.angryCount = angryCount;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parameter [agentStress=" + agentStress + ", customerAngry=" + customerAngry + ", stressCount="
				+ stressCount + ", angryCount=" + angryCount + ", userId=" + userId + ", title=" + title
				+ ", createDate=" + createDate + "]";
	}

}