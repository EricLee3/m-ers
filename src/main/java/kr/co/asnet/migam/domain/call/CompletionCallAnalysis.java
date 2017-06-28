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
public class CompletionCallAnalysis extends BaseDomain {
	// 가장 기본적인 정보들
	private String idx 									;
	private String job_id               ;
	private String indicator_start_pos  ;
	private String indicator_result     ;
	private String indicator_name       ;
	private String indicator_kor_name   ;
	private String indicator_end_pos    ;
	private String call_party           ;

    public CompletionCallAnalysis() {
		super();
		idx 				  ="";
		job_id                ="";
		indicator_start_pos   ="";
		indicator_result      ="";
		indicator_name        ="";
		indicator_kor_name    ="";
		indicator_end_pos     ="";
		call_party            ="";

	}
    
    
	public String getIdx() {
		return idx;
	}



	public void setIdx(String idx) {
		this.idx = idx;
	}



	public String getJob_id() {
		return job_id;
	}



	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}



	public String getIndicator_start_pos() {
		return indicator_start_pos;
	}



	public void setIndicator_start_pos(String indicator_start_pos) {
		this.indicator_start_pos = indicator_start_pos;
	}



	public String getIndicator_result() {
		return indicator_result;
	}



	public void setIndicator_result(String indicator_result) {
		this.indicator_result = indicator_result;
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



	public String getIndicator_end_pos() {
		return indicator_end_pos;
	}



	public void setIndicator_end_pos(String indicator_end_pos) {
		this.indicator_end_pos = indicator_end_pos;
	}



	public String getCall_party() {
		return call_party;
	}



	public void setCall_party(String call_party) {
		this.call_party = call_party;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "completionCallAnalysis [idx=" + idx + ", job_id=" + job_id + ", indicator_start_pos=" + indicator_start_pos + ", indicator_end_pos=" + indicator_end_pos 
				+ ", indicator_result=" + indicator_result+ ", indicator_name=" + indicator_name + ", indicator_kor_name=" + indicator_kor_name 
				+ ", call_party=" + call_party + "]";
	}

}