package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class AnalResult extends BaseDomain {
	
	private String job_id;
	private String call_party;
	private String indicator_name;
	private String indicator_kor_name;
	private String indicator_start_pos;
	private String indicator_end_pos;
	private String indicator_result;
	

	
    public AnalResult() {
		super();
		job_id = "";
		call_party = "";
		indicator_name = "";
		indicator_kor_name = "";
		indicator_start_pos = "";
		indicator_end_pos = "";
		indicator_result = "";
	}

	
	

	public String getJob_id() {
		return job_id;
	}




	public void setJob_id(String job_id) {
		this.job_id = job_id;
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




	public String getIndicator_start_pos() {
		return indicator_start_pos;
	}




	public void setIndicator_start_pos(String indicator_start_pos) {
		this.indicator_start_pos = indicator_start_pos;
	}




	public String getIndicator_end_pos() {
		return indicator_end_pos;
	}




	public void setIndicator_end_pos(String indicator_end_pos) {
		this.indicator_end_pos = indicator_end_pos;
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
		return "SensMeta [job_id="+job_id+", call_party=" + call_party + ", indicator_name=" + indicator_name + 
				", indicator_kor_name=" + indicator_kor_name + ", indicator_start_pos=" + indicator_start_pos+", "
				+ "indicator_end_pos=" + indicator_end_pos +", indicator_result=" + indicator_result + "]";
	}

}