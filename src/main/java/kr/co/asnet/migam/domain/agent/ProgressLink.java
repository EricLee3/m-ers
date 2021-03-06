package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class ProgressLink extends BaseDomain {
	
	private String agent_id;
	private String indicator_name;
	private String indicator_kor_name;
	private String indicator_level;
	private String agent_script;
	private String customer_script;
	private String script_color;
	private String custom_num;
	private String call_type;
	
    public ProgressLink() {
		super();
		agent_id = "";
		indicator_name = "";
		indicator_kor_name="";
		indicator_level="";
		agent_script = "";
		customer_script = "";
		script_color = "";
		custom_num = "";
		call_type = "";
	}

	


	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getIndicator_name() {
		return indicator_name;
	}

	public void setIndicator_name(String indicator_name) {
		this.indicator_name = indicator_name;
	}

	public String getIndicator_kor_name() {
		return indicator_kor_name;
	}

	public void setIndicator_kor_name(String indicator_kor_name) {
		this.indicator_kor_name = indicator_kor_name;
	}

	public String getIndicator_level() {
		return indicator_level;
	}

	public void setIndicator_level(String indicator_level) {
		this.indicator_level = indicator_level;
	}

	public String getAgent_script() {
		return agent_script;
	}

	public void setAgent_script(String agent_script) {
		this.agent_script = agent_script;
	}

	public String getCustomer_script() {
		return customer_script;
	}

	public void setCustomer_script(String customer_script) {
		this.customer_script = customer_script;
	}


	public String getScript_color() {
		return script_color;
	}


	public void setScript_color(String script_color) {
		this.script_color = script_color;
	}


	public String getCustom_num() {
		return custom_num;
	}

	public void setCustom_num(String custom_num) {
		this.custom_num = custom_num;
	}


	public String getCall_type() {
		return call_type;
	}




	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
/*	@Override
	public String toString() {
		return "ImsiMent [agent_id="+agent_id+", custom_num="+custom_num+", indicator_name=" + indicator_name + ", indicator_kor_name=" + indicator_kor_name + ", indicator_level=" + indicator_level + ", agent_script=" + agent_script + ", customer_script=" + customer_script +   ", script_color=" + script_color +"]";
	}
*/
}