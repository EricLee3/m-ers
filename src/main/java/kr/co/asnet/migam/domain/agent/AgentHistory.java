package kr.co.asnet.migam.domain.agent;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트에 관한 메모 등을 보관하기 위해 사용하는 도메인 클래스입니다. <br>
 * Updated 2016-09-15 <br>
 * 참고 사항 : 없음
 */
@SuppressWarnings("serial")
public class AgentHistory extends BaseDomain {
	private int index;
	private String agentId;
	private String description;
	private Date createDate;
	
    public AgentHistory() {
		super();
		index = 0;
		agentId="";
		description ="";
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
	 * @return the agentId
	 */
	public String getAgentId() {
		return agentId;
	}

	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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
		return "AgentHistory [index=" + index + ", agentId=" + agentId + ", description=" + description
				+ ", createDate=" + createDate + "]";
	}

	
}