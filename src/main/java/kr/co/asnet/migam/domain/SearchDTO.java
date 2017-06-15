package kr.co.asnet.migam.domain;

/**
 * 검색 도메인 클래스
 */
public class SearchDTO { 
	private String searchCondition;
	private String searchQuery;
	private String searchStatus;
	private String searchType;
	private String searchIndex;
	private String searchBoardIndex;
	private String searchIsNotice;
	private String searchIsEvent;
	private String searchIsBest;
	private String searchIsAudit;
	private String searchIsAuditBatch;
	private String searchGroup;
	private String searchId;
	private String startDate;
	private String endDate;

	public SearchDTO() {
		super();
		searchGroup = null;
		searchId = null;
	}

	public SearchDTO(String searchCondition, String searchQuery) {
		super();
		this.searchCondition = searchCondition;
		this.searchQuery = searchQuery;
	}

	/**
	 * @return the searchStatus
	 */
	public String getSearchStatus() {
		return searchStatus;
	}

	/**
	 * @param searchStatus the searchStatus to set
	 */
	public void setSearchStatus(String searchStatus) {
		this.searchStatus = searchStatus;
	}

	public SearchDTO(String searchCondition, String searchQuery, String startDate, String endDate) {
		super();
		this.searchCondition = searchCondition;
		this.searchQuery = searchQuery;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * @return the searchIndex
	 */
	public String getSearchIndex() {
		return searchIndex;
	}

	/**
	 * @param searchIndex the searchIndex to set
	 */
	public void setSearchIndex(String searchIndex) {
		this.searchIndex = searchIndex;
	}

	/**
	 * @return the searchBoardIndex
	 */
	public String getSearchBoardIndex() {
		return searchBoardIndex;
	}

	/**
	 * @param searchBoardIndex the searchBoardIndex to set
	 */
	public void setSearchBoardIndex(String searchBoardIndex) {
		this.searchBoardIndex = searchBoardIndex;
	}

	/**
	 * @return the searchIsNotice
	 */
	public String getSearchIsNotice() {
		return searchIsNotice;
	}

	/**
	 * @param searchIsNotice the searchIsNotice to set
	 */
	public void setSearchIsNotice(String searchIsNotice) {
		this.searchIsNotice = searchIsNotice;
	}

	/**
	 * @return the searchIsEvent
	 */
	public String getSearchIsEvent() {
		return searchIsEvent;
	}

	/**
	 * @param searchIsEvent the searchIsEvent to set
	 */
	public void setSearchIsEvent(String searchIsEvent) {
		this.searchIsEvent = searchIsEvent;
	}

	/**
	 * @return the searchIsBest
	 */
	public String getSearchIsBest() {
		return searchIsBest;
	}

	/**
	 * @param searchIsBest the searchIsBest to set
	 */
	public void setSearchIsBest(String searchIsBest) {
		this.searchIsBest = searchIsBest;
	}

	public String getSearchIsAudit() {
		return searchIsAudit;
	}

	public void setSearchIsAudit(String searchIsAudit) {
		this.searchIsAudit = searchIsAudit;
	}

	public String getSearchIsAuditBatch() {
		return searchIsAuditBatch;
	}

	public void setSearchIsAuditBatch(String searchIsAuditBatch) {
		this.searchIsAuditBatch = searchIsAuditBatch;
	}

	public String getSearchGroup() {
		return searchGroup;
	}

	public void setSearchGroup(String searchGroup) {
		this.searchGroup = searchGroup;
	}

	/**
	 * @return the searchId
	 */
	public String getSearchId() {
		return searchId;
	}

	/**
	 * @param searchId the searchId to set
	 */
	public void setSearchId(String searchId) {
		this.searchId = searchId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchDTO [searchCondition=" + searchCondition + ", searchQuery=" + searchQuery + ", searchStatus="
				+ searchStatus + ", searchType=" + searchType + ", searchIndex=" + searchIndex + ", searchBoardIndex="
				+ searchBoardIndex + ", searchIsNotice=" + searchIsNotice + ", searchIsEvent=" + searchIsEvent
				+ ", searchIsBest=" + searchIsBest + ", searchIsAudit=" + searchIsAudit + ", searchIsAuditBatch="
				+ searchIsAuditBatch + ", searchGroup=" + searchGroup + ", searchId=" + searchId + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}


}
