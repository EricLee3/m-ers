package kr.co.asnet.migam.tags;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import kr.co.asnet.migam.utils.Const;

/**
 * 커스텀 태그 라이브러리용 함수 클래스
 */
public class Functions {

	/**
	 * line break 를 BR 태그로 변경합니다.
	 * 
	 * @param str
	 * @return
	 */
	public static String newLineToBr(String str) {
		str = str.replaceAll("\r\n", "<br />");
		str = str.replaceAll("\r", "<br />");
		str = str.replaceAll("\n", "<br />");
		return str;
	}

	/**
	 * HTML 을 ESCAPE 문자로 변경합니다.
	 * 
	 * @param str
	 * @return
	 */
	public static String escapeHTML(String str) {
		if (str == null) return "";
		return StringEscapeUtils.escapeHtml4(str);
	}

	/**
	 * 첨부 이미지 경로를 반환합니다.
	 * 
	 * @param path
	 * @param index
	 * @param ext
	 * @return
	 */
	public static String getImagePath(String path, int index, String ext) {
		return String.format("%s/%d.%s", path, index, ext);
	}
	
	/**
	 * 첨부 썸네일 이미지 경로를 반환합니다.
	 * 
	 * @param path
	 * @param index
	 * @return
	 */
	public static String getThumbnailPath(String path, int index) {
		return String.format("%s/%s%d.%s", path, "thumb_", index, "jpg");
	}

	/**
	 * 문자열을 byte 단위로 잘라서 반환합니다.
	 * 
	 * - 0x0001 ~ 0x007F 범위의 문자는 1 바이트<br/>
	 * - 0x0080 ~ 0x07FF 범위의 문자는 2 바이트<br/>
	 * 
	 * @param str
	 * @param byteSize
	 * @param suffix
	 * @return
	 */
	public static String ellipsis(String str, int byteSize, String suffix) {
		if (str == null) return "";

		int rSize = 0;
		int len = 0;

		if (str.getBytes().length > byteSize) {
			for (; rSize < str.length(); rSize++) {
				if (str.charAt(rSize) > 0x007F) len += 2;
				else len++;

				if (len > byteSize) break;
			}
			str = str.substring(0, rSize) + suffix;
		}

		return str;
	}

/**
	 * 
	 * HTML 문자열을 입력받아 HTML 태그를 모두 제거한 문자열만 반환합니다.<br/>
	 * 1. 치환되는 순서를 변경하면 반환값이 달라질 수 있습니다.<br/>
	 * 2. HTML 태그가 아니라도 '<', '>' 를 사용하는 문자열이 제거 될 수 있습니다.
	 * 2-1. <h2> 같은 것이 제거되지 않아서 변경하였습니다.
	 * @author mypace
	 * @param html
	 * @return
	 */
	public static String stripHtml(String html) {
		if (html == null) return "";
		Matcher m;

		// 1. html 주석 제거
		Pattern comment = Pattern.compile("<!--[^>](.*?)-->");
		m = comment.matcher(html);
		html = m.replaceAll("");

		// 2. doctype 제거
		Pattern doctype = Pattern.compile("<!DOCTYPE[^>]*>");
		m = doctype.matcher(html);
		html = m.replaceAll("");

		// 3. meta tag 제거
		Pattern meta = Pattern.compile("<meta[^>]*(/)?>");
		m = meta.matcher(html);
		html = m.replaceAll("");

		// 4. title tag 제거
		Pattern title = Pattern.compile("<title[^>]*>.*</title>", Pattern.DOTALL);
		m = title.matcher(html);
		html = m.replaceAll("");

		// 5. script 제거
		Pattern script = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);
		m = script.matcher(html);
		html = m.replaceAll("");

		// 6. css 제거
		Pattern style = Pattern.compile("<style[^>]*>.*</style>", Pattern.DOTALL);
		m = style.matcher(html);
		html = m.replaceAll("");

		// 7. html tag 제거 (주의 : <, > 를 사용하는 html이 아닌 것도 제거됨.)
		// Pattern tag = Pattern.compile("<(/)?([a-zA-Z]*)(\\s)*([a-zA-Z]*=[^>]*)?(\\s)*(/)?>");
		// m = tag.matcher(html);
		// html = m.replaceAll("");
		String htmlTagPattern = "<[/]*([\\w]*)(\\s)*([a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
		html = StringUtils.replacePattern(html, htmlTagPattern, "");

		// 8. html character entity 제거 (ex> &nbsp; &amp; &gt;)
		Pattern entity = Pattern.compile("&[^;]+;");
		m = entity.matcher(html);
		html = m.replaceAll("");

		// 9. line break 제거
		html = html.replaceAll("\r|\n", "");

		return html.trim();
	}

	/**
	 * 두 날짜의 차이를 반환합니다.
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public static int dateCompare(Date start, Date end) {
		int diffDay = 0;
		int mil = 24 * 60 * 60 * 1000;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(start);
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
			start = cal.getTime();

			cal.setTime(end);
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
			end = cal.getTime();

			long diff = end.getTime() - start.getTime();
			diffDay = (int) (diff / mil);

			// 나머지가 있는 경우 보상값
			if ((diff % mil) > 0) {
				diffDay++;
			} else if ((diff % mil) < 0) {
				diffDay--;
			}
		} catch (Exception e) {

		}
		return diffDay;
	}
	
	/**
	 * 주어진 HTML 형식의 문서에서 모든 태그를 제거하고, 순수한 Text중 100글자를 반환하는 함수입니다.
	 * 이 함수는 Tag-lib에서 사용되지 않고, 직접 호출됩니다. 
	 * @param content
	 * @return
	 */
	public static String getSummary(String content) {
		String summaryText = StringUtils.substring(stripHtml(content), 0, Const.SUMMARY_LENGTH);
		return summaryText;
	}
	
	/** 
	 * 주어진 resourceRole에 현 사용자의 userRole이 포함되어 있는지 검사하여 있으면 권함이 있다고 인정한다.
	 * 단, userRole에 'ADMIN'이 포함된 경우 무조건 권한이 있는 것으로 한다.
	 * 
	 * @param resourceRole 쓰기 권한을 위해 필요한 권한 이름[ ADMIN, MEMBER, POLICY(등과 같은 보드의 NIC) 등이 ','로 구분되어 들어감]
	 * @param userRole 현 사용자의 권한 이름
	 * @return 권한이 있으면 1을 반환한다.
	 */
	public static boolean hasBoardPermission(String resourceRole, String userRole) {
		boolean resultPermission = false;
		if(StringUtils.isBlank(resourceRole) || StringUtils.isBlank(userRole)) return false;
		if(StringUtils.contains(userRole, "ADMIN")) {
			resultPermission = true;
		} else {
			String[] userRoleList = StringUtils.split(resourceRole, ",");
			for(String role : userRoleList) {
				if(StringUtils.contains(resourceRole, role)) resultPermission = true;
			}
		}
		return resultPermission;
	}
	
}
