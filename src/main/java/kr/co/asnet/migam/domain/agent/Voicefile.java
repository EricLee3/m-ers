package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class Voicefile extends BaseDomain {
	private String idx;
	private String call_id;
	private String agent_id;
	private String group_id;
	private String call_type;
	private String realtimeness;
	private String bm_agent;
	private String bm_customer;
	private String agent_no;
	private String customer_no;
	private String agent_voice_filename;
	private String agent_emo_profile;
	private String customer_voice_filename;
	private String emtion_analysis_state;
	private String start_date;
	
	
    public Voicefile() {
		super();
		idx = "";
		call_id = "";
		agent_id = "";
		group_id = "";
		call_type = "";
		realtimeness = "";
		bm_agent = "";
		bm_customer = "";
		agent_no = "";
		customer_no = "";
		agent_voice_filename = "";
		agent_emo_profile = "";
		customer_voice_filename = "";
		emtion_analysis_state = "";
		start_date = "";

	}
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getCall_id() {
		return call_id;
	}
	public void setCall_id(String call_id) {
		this.call_id = call_id;
	}
	public String getAgent_id() {
		return agent_id;
	}
	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getCall_type() {
		return call_type;
	}
	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}
	public String getRealtimeness() {
		return realtimeness;
	}
	public void setRealtimeness(String realtimeness) {
		this.realtimeness = realtimeness;
	}
	public String getBm_agent() {
		return bm_agent;
	}
	public void setBm_agent(String bm_agent) {
		this.bm_agent = bm_agent;
	}
	public String getBm_customer() {
		return bm_customer;
	}
	public void setBm_customer(String bm_customer) {
		this.bm_customer = bm_customer;
	}
	public String getAgent_no() {
		return agent_no;
	}
	public void setAgent_no(String agent_no) {
		this.agent_no = agent_no;
	}
	public String getCustomer_no() {
		return customer_no;
	}
	public void setCustomer_no(String customer_no) {
		this.customer_no = customer_no;
	}
	public String getAgent_voice_filename() {
		return agent_voice_filename;
	}
	public void setAgent_voice_filename(String agent_voice_filename) {
		this.agent_voice_filename = agent_voice_filename;
	}
	
	public String getAgent_emo_profile() {
		return agent_emo_profile;
	}

	public void setAgent_emo_profile(String agent_emo_profile) {
		this.agent_emo_profile = agent_emo_profile;
	}

	public String getCustomer_voice_filename() {
		return customer_voice_filename;
	}
	public void setCustomer_voice_filename(String customer_voice_filename) {
		this.customer_voice_filename = customer_voice_filename;
	}
	public String getEmtion_analysis_state() {
		return emtion_analysis_state;
	}
	public void setEmtion_analysis_state(String emtion_analysis_state) {
		this.emtion_analysis_state = emtion_analysis_state;
	}
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Voicefile [idx="+idx+", call_id=" + call_id + ", agent_id=" + agent_id + ", group_id=" + group_id + ", call_type=" + call_type + ", realtimeness=" + realtimeness + ", bm_agent=" + bm_agent 
				+", bm_customer=" + bm_customer + ", agent_no=" + agent_no +", customer_no=" + customer_no +", agent_voice_filename=" + agent_voice_filename +", customer_voice_filename=" + customer_voice_filename +",agent_emo_profile="+agent_emo_profile+ ",emtion_analysis_state=" + emtion_analysis_state + ",start_date=" + start_date+"]";
	}

}