package kr.co.asnet.migam.domain.call;

import java.util.Date;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 콜 분석(Analysis-Result)을 위한 도메인 클래스 <br>
 * Updated 2016-09-23 <br>
 * 참고 사항 :
 * 테이블 : mecs5_analysis_result 
 */
@SuppressWarnings("serial")
public class RealindState extends BaseDomain {
	// 가장 기본적인 정보들
	private String agent_id							;
	private String call_party					  ;
	private String indicator_name			  ;
	private String indicator_kor_name	  ;
	private String indicator_level			;
	private String indicator_result	    ;

    public RealindState() {
		super();
		agent_id						="";
		call_party					="";
		indicator_name			="";	
		indicator_kor_name	="";
		indicator_level		  ="";  
		indicator_result	  ="";

	}
    


	public String getAgent_id() {
		return agent_id;
	}



	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}



	public String getCall_party() {
		return call_party;
	}



	public void setCall_party(String call_party) {
		this.call_party = call_party;
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



	public String getIndicator_result() {
		return indicator_result;
	}



	public void setIndicator_result(String indicator_result) {
		this.indicator_result = indicator_result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "realindState [agent_id=" + agent_id + ", call_party=" + call_party + ", indicator_name=" + indicator_name + ", indicator_kor_name=" + indicator_kor_name 
				+ ", indicator_level=" + indicator_level+ ", indicator_result=" + indicator_result + "]";
	}

}