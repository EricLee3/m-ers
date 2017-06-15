package kr.co.asnet.migam.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.asnet.migam.domain.PageDTO;

/**
 * 페이지 네비게이션용 Tag
 * 
 * 변수 설명
 *  - itemCount : 결과에 포함된 아이템의 총 갯수
 *  - itemPerPage : 한 페이지에 표시되는 아이템의 숫자
 *  - pagePerGroup : 페이지가 많은 경우에, 한 '화면'에 표시되는 페이지(번호)의 목록을 그룹이라고 하며, 그룹당 포함되는 페이지의 수
 *  - 앞 그룹으로 이동 방식 : 앞 그룹의 첫 페이지로 이동
 *  - 다음 그룹으로 이동 방식 : (현재 그룹 * 그룹당 페이지 수)+1 / 이 것이 다음 그룹의 첫 페이지 이므로 이 페이지로 이동.
 * @author byonghee
 */
public class Pagination extends SimpleTagSupport {
	private final Logger logger = LoggerFactory.getLogger(SimpleTagSupport.class);
	private int itemCount;
	private int itemPerPage; // 한 페이지당 표시되는 아이템 수
	private int pagePerGroup; // 하단에 표시되는 페이지 수, 예 5 라면 : ◁  1. 2. 3. 4. 5. ▷ 와 같이 표시됨  
	private int page;

	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * @param itemPerPage the itemPerPage to set
	 */
	public void setItemPerPage(int itemPerPage) {
		this.itemPerPage = itemPerPage;
	}

	/**
	 * @param pagePerGroup the pagePerGroup to set
	 */
	public void setPagePerGroup(int pagePerGroup) {
		this.pagePerGroup = pagePerGroup;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}

	private int getFirstPageOfGroup(int groupNumber) {
		return ((groupNumber-1) * this.pagePerGroup +1);
	}

	@Override
	public void doTag() throws JspException, IOException { 
		
		if (page == 0) page = PageDTO.DEFAULT_PAGE;
		if (itemPerPage == 0) itemPerPage = PageDTO.DEFAULT_ITEM_PER_PAGE;
		if (pagePerGroup == 0) pagePerGroup = PageDTO.DEFAULT_PAGE_PER_GROUP;

		int pageCount = ((itemCount - 1) / itemPerPage) + 1;
		int groupCount = ((pageCount - 1 ) / pagePerGroup ) + 1;
		int currentGroup = ((page-1) / pagePerGroup ) + 1;
		int previousGroupPage = Math.max( 1, getFirstPageOfGroup(currentGroup-1) ); // 앞 그룹의 첫 페이지
		int nextGroupPage = ( getFirstPageOfGroup(currentGroup+1) ); // 다음 그룹의 첫 페이지 
		
		int startPage = getFirstPageOfGroup(currentGroup);
		int endPage = Math.min(startPage + pagePerGroup - 1, pageCount);
		StringBuilder pageNavigation = new StringBuilder();
		
		// 앞의 그룹으로 이동하기 버튼
		if(currentGroup<=1) { 
			// pageNavigation.append("disabled \"><</li>"); 
		} else { 
			pageNavigation.append("<li ").append(" data-page=\"").append(previousGroupPage).append("\" class=\"paginate_button previous ");
			pageNavigation.append("\"><a href=\"#\" data-page=\"").append(previousGroupPage).append("\" tabindex=\"0\">");
			pageNavigation.append("<");
			pageNavigation.append("</a></li>");
		}
		
		// 현재 그룹에 포함된 페이지 번호들 표시하기, 현재 페이지는 클릭 불가
		for (int i = startPage; i <= endPage; i++) {
			pageNavigation.append("<li ").append(" data-page=\"").append(i).append("\" class=\"paginate_button previous ");
			if (page == i) pageNavigation.append("active ");
			pageNavigation.append("\"><a href=\"#\" data-page=\"").append(i).append("\" tabindex=\"0\">");
			pageNavigation.append(i);
			pageNavigation.append("</a></li>");
		}

		// 다음 그룹으로 이동하기 버튼
		if(currentGroup>=groupCount) {
			// pageNavigation.append("disabled \">></li>"); 
		} else {
			pageNavigation.append("<li ").append(" data-page=\"").append(nextGroupPage).append("\" class=\"paginate_button previous ");
			pageNavigation.append("\"><a href=\"#\" data-page=\"").append(nextGroupPage).append("\" tabindex=\"0\">");
			pageNavigation.append(">");
			pageNavigation.append("</a></li>");
		}

		JspWriter writer = getJspContext().getOut();
		writer.write(pageNavigation.toString());
	}
}