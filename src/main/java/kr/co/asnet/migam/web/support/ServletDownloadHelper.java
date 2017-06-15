package kr.co.asnet.migam.web.support;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component("servletDownloadHelper")
public class ServletDownloadHelper {
	private Logger log = LoggerFactory.getLogger(ServletDownloadHelper.class);

	/**
	 * 파일 다운로드
	 * 
	 * @param request
	 * @param response
	 * @param file
	 * @param filename
	 * @param expires
	 * @throws ServletException
	 * @throws IOException
	 */
	public void download(HttpServletRequest request, HttpServletResponse response, File file, String filename) throws ServletException, IOException {
		if (file == null || !file.exists() || file.length() <= 0 || file.isDirectory()) {
			log.warn(file.getAbsolutePath() + " File Not Found.");
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			response.getWriter().close();
			return;
		}

		InputStream is = null;
		try {
			is = new FileInputStream(file);
			responseSetting(request, response, is, filename, file.length());
		} finally {
			file.delete();
			IOUtils.closeQuietly(is);
		}
	}

	/**
	 * response 헤더 설정
	 * 
	 * @param request
	 * @param response
	 * @param is
	 * @param filename
	 * @param filesize
	 * @param expires
	 * @throws ServletException
	 * @throws IOException
	 */
	private static void responseSetting(HttpServletRequest request, HttpServletResponse response, InputStream is, String filename, long filesize) throws ServletException,
			IOException {
		String mimetype = request.getSession().getServletContext().getMimeType(filename);
		if (mimetype == null || mimetype.length() == 0) mimetype = "application/octet-stream";
		response.setContentType(mimetype + "; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8") + ";");
		response.setHeader("Content-Length", "" + filesize);
		response.setHeader("Content-Transfer-Encoding", "binary;");

		boolean isFuckingIE = false;
		String requestSch = request.getScheme();
		if ("https".equals(requestSch)) {
			String userAgent = request.getHeader("User-Agent") != null ? request.getHeader("User-Agent") : "";
			if (userAgent.indexOf("MSIE 6") > -1 || userAgent.indexOf("MSIE 7") > -1 || userAgent.indexOf("MSIE 8") > -1) {
				isFuckingIE = true;
			}
		}
		if (isFuckingIE) {
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "");
			response.setHeader("Expires", "0");
		} else {
			response.setHeader("Cache-Control", "no-cache, no-store");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Expires", "0");
		}
		responseWrite(response, is);
	}

	/**
	 * ServletOutputStream 으로 파일 쓰기
	 * 
	 * @param response
	 * @param is
	 * @throws IOException
	 */
	private static void responseWrite(HttpServletResponse response, InputStream is) throws IOException {
		byte[] buffer = new byte[2048];
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(response.getOutputStream());
			int read = 0;

			while ((read = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, read);
			}
		} finally {
			IOUtils.closeQuietly(bos);
			IOUtils.closeQuietly(bis);
		}
	}
}
