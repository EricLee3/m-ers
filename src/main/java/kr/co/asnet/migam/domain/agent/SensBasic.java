package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class SensBasic extends BaseDomain {
	
	private String basic_idx;
	private String name;
	private String type;
	private String min;
	private String max;
	private String insert_date;
	private String description;
	private String kr_name;
	
    public SensBasic() {
		super();
		basic_idx = "";
		name = "";
		type = "";
		min = "";
		max = "";
		insert_date = "";
		description = "";
		kr_name = "";
	}

	public String getBasic_idx() {
		return basic_idx;
	}





	public void setBasic_idx(String basic_idx) {
		this.basic_idx = basic_idx;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
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
	

	public String getKr_name() {
		return kr_name;
	}

	public void setKr_name(String kr_name) {
		this.kr_name = kr_name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SensMeta [basic_idx="+basic_idx+", name=" + name + ", type=" + type + ", min=" + min + ", max=" + max + 
				", insert_date=" + insert_date+", description=" + description+", kr_name=" + kr_name +"]";
	}

}