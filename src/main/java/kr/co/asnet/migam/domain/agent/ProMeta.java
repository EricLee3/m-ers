package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class ProMeta extends BaseDomain {
	
	private String profile_meta_idx;
	private String name;
	private String service_idx;
	private String insert_date;
	private String description;
	private String basic_idx;
	private String svc_meta_idx; 
	private String service_name;
	private String min; 
	private String max;
	
    public ProMeta() {
		super();
		profile_meta_idx = "";
		name = "";
		service_idx = "";
		insert_date = "";
		basic_idx = "";
		svc_meta_idx = "";
		service_name = "";
		min = "";
		max = "";
	}

	
	
	

	public String getProfile_meta_idx() {
		return profile_meta_idx;
	}





	public void setProfile_meta_idx(String profile_meta_idx) {
		this.profile_meta_idx = profile_meta_idx;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getService_idx() {
		return service_idx;
	}





	public void setService_idx(String service_idx) {
		this.service_idx = service_idx;
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





	public String getBasic_idx() {
		return basic_idx;
	}





	public void setBasic_idx(String basic_idx) {
		this.basic_idx = basic_idx;
	}








	public String getSvc_meta_idx() {
		return svc_meta_idx;
	}





	public void setSvc_meta_idx(String svc_meta_idx) {
		this.svc_meta_idx = svc_meta_idx;
	}





	public String getService_name() {
		return service_name;
	}





	public void setService_name(String service_name) {
		this.service_name = service_name;
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





	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProMeta [profile_meta_idx="+profile_meta_idx+", name=" + name + ", service_idx=" + service_idx + ", insert_date=" + insert_date+", "
				+ ", description=" + description +", basic_idx=" + basic_idx +",svc_meta_idx=" + svc_meta_idx  +",service_name=" + service_name+
				",min=" + min +",max=" + max+"]";
	}

}