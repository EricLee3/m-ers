package kr.co.asnet.migam.domain.agent;

import java.util.List;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트를 그룹핑하기 위한 도메인 클래스 <br>
 * Updated 2016-09-15
 * 참고 사항 :
 *	Group Index는 1부터 시작해야 합니다. 
 *  ( Agent.groupIndex = 0 인경우 수속 그룹이 없는 것으로 생각하기 때문입니다. )   
 */
@SuppressWarnings("serial")
public class AgentGroup extends BaseDomain {
	// 가장 기본적인 정보들
	private String groupId;
	private String groupName;
	private int agentCount;
	private String profile_name;
	private String profile_meta_idx;
	private String profile_name_agent;
	private String profile_name_cus;
	private String agent_profile_id;
	private String customer_profile_id;
	private List<Agent> agentList;
	
    public AgentGroup() {
		super();
		groupId = "";
		groupName = "";
		agentCount=0;
		profile_name = "";
		profile_meta_idx = "";
		profile_name_agent = "";
		profile_name_cus = "";
		agent_profile_id = "";
		customer_profile_id = "";
		agentList = null;
	}

	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the agentCount
	 */
	public int getAgentCount() {
		return agentCount;
	}

	/**
	 * @param agentCount the agentCount to set
	 */
	public void setAgentCount(int agentCount) {
		this.agentCount = agentCount;
	}

	/**
	 * @return the agentList
	 */
	public List<Agent> getAgentList() {
		return agentList;
	}

	/**
	 * @param agentList the agentList to set
	 */
	public void setAgentList(List<Agent> agentList) {
		this.agentList = agentList;
	}
	
	

	public String getProfile_name() {
		return profile_name;
	}

	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}

	public String getProfile_meta_idx() {
		return profile_meta_idx;
	}

	public void setProfile_meta_idx(String profile_meta_idx) {
		this.profile_meta_idx = profile_meta_idx;
	}
	
	

	public String getProfile_name_agent() {
		return profile_name_agent;
	}

	public void setProfile_name_agent(String profile_name_agent) {
		this.profile_name_agent = profile_name_agent;
	}

	public String getProfile_name_cus() {
		return profile_name_cus;
	}

	public void setProfile_name_cus(String profile_name_cus) {
		this.profile_name_cus = profile_name_cus;
	}

	public String getAgent_profile_id() {
		return agent_profile_id;
	}

	public void setAgent_profile_id(String agent_profile_id) {
		this.agent_profile_id = agent_profile_id;
	}

	public String getCustomer_profile_id() {
		return customer_profile_id;
	}

	public void setCustomer_profile_id(String customer_profile_id) {
		this.customer_profile_id = customer_profile_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AgentGroup [groupId=" + groupId + ", groupName=" + groupName + ", agentCount=" + agentCount+ 
				", profile_name=" + profile_name+ ", profile_meta_idx=" + profile_meta_idx +
				", profile_name_agent=" + profile_name_agent+ ", profile_name_cus=" + profile_name_cus +
				", agent_profile_id=" + agent_profile_id+ ", customer_profile_id=" + customer_profile_id +
				", agentList=" + agentList + "]";
	}

		
}