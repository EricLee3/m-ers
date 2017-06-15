package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class SensConf extends BaseDomain {
	
	private String service_idx;
	private String name;
	private String kr_name;
	private String emotion_level;
	private String basic_idx;
	private String min;
	private String max;
	private String insert_date;
	private String update_date;
	private String description;
	private String indi_name;
	private String indi_min;
	private String indi_max;
	private String s_name;
	private String b_name;
	private int int_min;
	private int int_max;
	private String b_min;
	private String b_max;
	
    public SensConf() {
		super();
		service_idx="";
		name = "";
		kr_name = "";
		emotion_level = "";
		basic_idx = "";
		min = "";
		max = "";
		insert_date = "";
		update_date = "";
		description = "";
		indi_name = "";
		indi_min = "";
		indi_max = "";
		s_name = "";
		b_name = "";
		int_min = 0;
		int_max = 0;
		b_min = "";
		b_max = "";
	}


	public String getService_idx() {
		return service_idx;
	}


	public void setService_idx(String service_idx) {
		this.service_idx = service_idx;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getKr_name() {
		return kr_name;
	}


	public void setKr_name(String kr_name) {
		this.kr_name = kr_name;
	}


	public String getEmotion_level() {
		return emotion_level;
	}


	public void setEmotion_level(String emotion_level) {
		this.emotion_level = emotion_level;
	}


	public String getBasic_idx() {
		return basic_idx;
	}


	public void setBasic_idx(String basic_idx) {
		this.basic_idx = basic_idx;
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


	public String getUpdate_date() {
		return update_date;
	}


	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getIndi_name() {
		return indi_name;
	}


	public void setIndi_name(String indi_name) {
		this.indi_name = indi_name;
	}


	public String getIndi_min() {
		return indi_min;
	}


	public void setIndi_min(String indi_min) {
		this.indi_min = indi_min;
	}


	public String getIndi_max() {
		return indi_max;
	}


	public void setIndi_max(String indi_max) {
		this.indi_max = indi_max;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public String getB_name() {
		return b_name;
	}


	public void setB_name(String b_name) {
		this.b_name = b_name;
	}


	public int getInt_min() {
		return int_min;
	}


	public void setInt_min(int int_min) {
		this.int_min = int_min;
	}


	public int getInt_max() {
		return int_max;
	}


	public void setInt_max(int int_max) {
		this.int_max = int_max;
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
		return "SensConf [service_idx="+service_idx+", name=" + name + ", kr_name=" + kr_name + 
				", emotion_level=" + emotion_level + ", basic_idx=" + basic_idx + 
				", min=" + min + ", max=" + max + ", insert_date=" + insert_date+ 
				", update_date=" + update_date+", description=" + description+", indi_name=" + indi_name+", indi_min=" + indi_min+
				", indi_max=" + indi_max +", s_name=" + s_name +", b_name=" + b_name +", b_min=" + b_min+", b_max=" + b_max + "]";
	}

}