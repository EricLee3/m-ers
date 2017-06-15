package kr.co.asnet.migam.domain.agent;

import kr.co.asnet.migam.domain.BaseDomain;

/**
 * 에이전트(전화 상담원)을 위한 도메인 클래스<br>
 * Updated 2016-09-15
 * 참고 사항 : 없음
 *  
 */
@SuppressWarnings("serial")
public class Recognition_job extends BaseDomain {
	private String idx;
	private String job_id;
	private String start_time;
	private String end_time;
	private String record_start_time;
	private String record_end_time;
	private String group_id;
	private String agent_id;
	private String job_trigger_time;
	private String day_repeat;
	private String status;
	private String insert_date;
	private String job_name;
	
    public Recognition_job() {
		super();
		idx = "";
		job_id="";
		start_time="";
		end_time="";
		record_start_time="";
		record_end_time="";
		group_id="";
		agent_id="";
		job_trigger_time="";
		day_repeat="";
		status="";
		insert_date="";
		job_name = "";

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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getRecord_start_time() {
		return record_start_time;
	}

	public void setRecord_start_time(String record_start_time) {
		this.record_start_time = record_start_time;
	}

	public String getRecord_end_time() {
		return record_end_time;
	}

	public void setRecord_end_time(String record_end_time) {
		this.record_end_time = record_end_time;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(String agent_id) {
		this.agent_id = agent_id;
	}

	public String getJob_trigger_time() {
		return job_trigger_time;
	}

	public void setJob_trigger_time(String job_trigger_time) {
		this.job_trigger_time = job_trigger_time;
	}

	public String getDay_repeat() {
		return day_repeat;
	}

	public void setDay_repeat(String day_repeat) {
		this.day_repeat = day_repeat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}


	public String getJob_name() {
		return job_name;
	}


	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Recognition_job [idx="+idx+", job_id=" + job_id + ", start_time=" + start_time + ", end_time=" + end_time + ", record_start_time=" + record_start_time + ", record_end_time=" + record_end_time + ", group_id=" + group_id 
				+", agent_id=" + agent_id + ", job_trigger_time=" + job_trigger_time +", day_repeat=" + day_repeat +", status=" + status +", insert_date=" + insert_date+", job_name=" + job_name+"]";
	}

}