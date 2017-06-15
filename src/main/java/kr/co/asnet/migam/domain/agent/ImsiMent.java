package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class ImsiMent extends BaseDomain {
	
	private String ment_flag;
	private String ment;
	private String dname;
	private String resultval;

	
    public ImsiMent() {
		super();
		ment_flag = "";
		ment = "";
		dname="";
		resultval="";

	}

	

	public String getMent_flag() {
		return ment_flag;
	}



	public void setMent_flag(String ment_flag) {
		this.ment_flag = ment_flag;
	}



	public String getMent() {
		return ment;
	}



	public void setMent(String ment) {
		this.ment = ment;
	}



	public String getDname() {
		return dname;
	}



	public void setDname(String dname) {
		this.dname = dname;
	}





	public String getResultval() {
		return resultval;
	}



	public void setResultval(String resultval) {
		this.resultval = resultval;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ImsiMent [ment_flag="+ment_flag+", ment=" + ment + ", dname=" + dname + ", resultval=" + resultval + "]";
	}

}