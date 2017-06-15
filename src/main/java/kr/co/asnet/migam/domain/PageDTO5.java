package kr.co.asnet.migam.domain;

/**
 * 페이징 도메인 클래스
 */
public class PageDTO5 { 
	public static final int DEFAULT_PAGE = 1;
	public static final int DEFAULT_ITEM_PER_PAGE = 5;
	public static final int DEFAULT_PAGE_PER_GROUP= 10;

	private int startRow;
	private int endRow;
	private int page;
	private int pagePerGroup;
	private int itemPerPage;

	public PageDTO5() {
		this.page = DEFAULT_PAGE;
		this.itemPerPage = DEFAULT_ITEM_PER_PAGE;
		this.pagePerGroup = DEFAULT_PAGE_PER_GROUP;
		this.process();
	}

	public PageDTO5(int page) {
		this.page = page;
		this.itemPerPage = DEFAULT_ITEM_PER_PAGE;
		this.pagePerGroup = DEFAULT_PAGE_PER_GROUP;
		this.process();
	}

	public PageDTO5(int page, int itemPerPage) {
		this.page = page;
		this.itemPerPage = itemPerPage;
		this.pagePerGroup = DEFAULT_PAGE_PER_GROUP;
		this.process();
	}

	private void process() {
		this.startRow = itemPerPage * (page - 1);
		this.endRow = startRow + itemPerPage;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}



	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
		this.process();
	}

	/**
	 * @return the pagePerGroup
	 */
	public int getPagePerGroup() {
		return pagePerGroup;
	}

	/**
	 * @param pagePerGroup the pagePerGroup to set
	 */
	public void setPagePerGroup(int pagePerGroup) {
		this.pagePerGroup = pagePerGroup;
		this.process();
	}

	/**
	 * @return the itemPerPage
	 */
	public int getItemPerPage() {
		return itemPerPage;
	}

	/**
	 * @param itemPerPage the itemPerPage to set
	 */
	public void setItemPerPage(int itemPerPage) {
		this.itemPerPage = itemPerPage;
		this.process();
	}

	@Override
	public String toString() {
		return "PageDTO [startRow=" + startRow + ", endRow=" + endRow + ", page=" + page + ", pagePerGroup=" + pagePerGroup + ", itemPerPage=" + itemPerPage + "]";
	}
	
	public String toUrlString() {
		return "page=" + page;
	}

}
