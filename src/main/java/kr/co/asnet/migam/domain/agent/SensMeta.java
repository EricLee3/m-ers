package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class SensMeta extends BaseDomain {
	
	private String svc_meta_idx;
	private String name;
	private String min;
	private String max;
	private String insert_date;
	private String description;
	private String b_name;
	
	private String i_name;
	private String basic_idx;
	private String kr_name;
	private String b_min;
	private String b_max;

	
    public SensMeta() {
		super();
		svc_meta_idx = "";
		name = "";
		min = "";
		max = "";
		insert_date = "";
		description = "";
		b_name = "";
		i_name = "";
		basic_idx = "";
		kr_name = "";
		b_min = "";
		b_max = "";
	}

	
	
	public String getSvc_meta_idx() {
		return svc_meta_idx;
	}



	public void setSvc_meta_idx(String svc_meta_idx) {
		this.svc_meta_idx = svc_meta_idx;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getMin() {
		return min;
	}



	public void setMin(String min) {
		this.min = min;
	}



	public String getMax() {
		return max;
	}



	public void setMax(String max) {
		this.max = max;
	}



	public String getInsert_date() {
		return insert_date;
	}



	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getI_name() {
		return i_name;
	}



	public void setI_name(String i_name) {
		this.i_name = i_name;
	}



	public String getBasic_idx() {
		return basic_idx;
	}



	public void setBasic_idx(String basic_idx) {
		this.basic_idx = basic_idx;
	}



	public String getB_name() {
		return b_name;
	}



	public void setB_name(String b_name) {
		this.b_name = b_name;
	}



	public String getKr_name() {
		return kr_name;
	}



	public void setKr_name(String kr_name) {
		this.kr_name = kr_name;
	}



	public String getB_min() {
		return b_min;
	}



	public void setB_min(String b_min) {
		this.b_min = b_min;
	}



	public String getB_max() {
		return b_max;
	}



	public void setB_max(String b_max) {
		this.b_max = b_max;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SensMeta [svc_meta_idx="+svc_meta_idx+", name=" + name + ", min=" + min + ", max=" + max + ", insert_date=" + insert_date+", "
				+ "description=" + description +", i_name=" + i_name +", basic_idx=" + basic_idx +", b_name=" + b_name +", kr_name=" + kr_name +  ", b_min=" + b_min + ", b_max=" + b_max + "]";
	}

}