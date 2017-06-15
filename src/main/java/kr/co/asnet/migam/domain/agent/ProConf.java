package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class ProConf extends BaseDomain {
	
	private String p_profile_idx;
	private String p_profile_meta_idx;
	private String p_insert_date;
	private String p_update_date;
	private String p_description;
	private String s_script_idx;
	private String s_script;
	private String s_svc_meta_idx;
	private String s_profile_idx;
	private String s_min;
	private String s_max;
	private String s_description;
	private String name;
	private String service_idx;
	private String p_name;
	private String s_name;
	private String sv_min;
	private String sv_max;
	private String basic_name;
	private String count;
	
    public ProConf() {
		super();
		p_profile_idx="";
		p_profile_meta_idx = "";
		p_insert_date = "";
		p_update_date = "";
		p_description = "";
		s_script_idx = "";
		s_script = "";
		s_svc_meta_idx = "";
		s_profile_idx = "";
		s_min = "";
		s_max = "";
		s_description = "";
		name = "";
		service_idx = "";
		p_name = "";
		s_name = "";
		sv_min = "";
		sv_max = "";
		basic_name = "";
		count = "";
	}

	
	public String getP_profile_idx() {
		return p_profile_idx;
	}



	public void setP_profile_idx(String p_profile_idx) {
		this.p_profile_idx = p_profile_idx;
	}



	public String getP_profile_meta_idx() {
		return p_profile_meta_idx;
	}



	public void setP_profile_meta_idx(String p_profile_meta_idx) {
		this.p_profile_meta_idx = p_profile_meta_idx;
	}



	public String getP_insert_date() {
		return p_insert_date;
	}



	public void setP_insert_date(String p_insert_date) {
		this.p_insert_date = p_insert_date;
	}



	public String getP_update_date() {
		return p_update_date;
	}



	public void setP_update_date(String p_update_date) {
		this.p_update_date = p_update_date;
	}



	public String getP_description() {
		return p_description;
	}



	public void setP_description(String p_description) {
		this.p_description = p_description;
	}



	public String getS_script_idx() {
		return s_script_idx;
	}



	public void setS_script_idx(String s_script_idx) {
		this.s_script_idx = s_script_idx;
	}



	public String getS_script() {
		return s_script;
	}



	public void setS_script(String s_script) {
		this.s_script = s_script;
	}



	public String getS_svc_meta_idx() {
		return s_svc_meta_idx;
	}



	public void setS_svc_meta_idx(String s_svc_meta_idx) {
		this.s_svc_meta_idx = s_svc_meta_idx;
	}



	public String getS_profile_idx() {
		return s_profile_idx;
	}



	public void setS_profile_idx(String s_profile_idx) {
		this.s_profile_idx = s_profile_idx;
	}



	public String getS_min() {
		return s_min;
	}



	public void setS_min(String s_min) {
		this.s_min = s_min;
	}



	public String getS_max() {
		return s_max;
	}



	public void setS_max(String s_max) {
		this.s_max = s_max;
	}



	public String getS_description() {
		return s_description;
	}



	public void setS_description(String s_description) {
		this.s_description = s_description;
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


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public String getSv_min() {
		return sv_min;
	}


	public void setSv_min(String sv_min) {
		this.sv_min = sv_min;
	}


	public String getSv_max() {
		return sv_max;
	}


	public void setSv_max(String sv_max) {
		this.sv_max = sv_max;
	}

	public String getBasic_name() {
		return basic_name;
	}


	public void setBasic_name(String basic_name) {
		this.basic_name = basic_name;
	}


	public String getCount() {
		return count;
	}


	public void setCount(String count) {
		this.count = count;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SensConf [p_profile_idx="+p_profile_idx+", p_profile_meta_idx=" + p_profile_meta_idx + ", p_insert_date=" + p_insert_date + 
				", p_update_date=" + p_update_date + ", p_description=" + p_description + 
				", s_script_idx=" + s_script_idx + ", s_script=" + s_script + ", s_svc_meta_idx=" + s_svc_meta_idx+ 
				", s_profile_idx=" + s_profile_idx+", s_min=" + s_min+", s_max=" + s_max+", s_description=" + s_description+
				", name=" + name+", service_idx=" + service_idx+", p_name=" + p_name+", s_name=" + s_name+
				", sv_min=" + sv_min+", sv_max=" + sv_max+", basic_name=" + basic_name+", count=" + count+"]";
	}

}