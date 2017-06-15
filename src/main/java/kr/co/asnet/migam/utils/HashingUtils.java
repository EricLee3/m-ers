package kr.co.asnet.migam.utils;
 
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MD5, SHA256 해싱 (단방향 암호화) 유틸리티 클래스
 */
public class HashingUtils {
	private static final Logger logger = LoggerFactory.getLogger(HashingUtils.class);

	/**
	 * MD5로 해싱하여 반환한다.
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] hashingMD5(String str) {
		byte[] byteMD5 = null;
		try {
			if (str != null) {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(str.getBytes());
				byteMD5 = md.digest();
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("", e);
		}
		return byteMD5;
	}

	/**
	 * MD5로 해싱하여 반환한다.
	 * 
	 * @param str
	 * @return
	 */
	public static String hashingMD5String(String str) {
		String MD5 = null;
		try {
			byte[] byteMD5 = HashingUtils.hashingMD5(str);

			if (byteMD5 != null) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteMD5.length; i++) {
					sb.append(Integer.toString((byteMD5[i] & 0xff) + 0x100, 16).substring(1));
				}
				MD5 = sb.toString();
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return MD5;
	}

	/**
	 * SHA256로 해싱하여 반환한다.
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] hashingSHA256(String str) {
		byte[] byteSHA256 = null;
		try {
			if (str != null) {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				md.update(str.getBytes());
				byteSHA256 = md.digest();
			}
		} catch (NoSuchAlgorithmException e) {
			logger.error("", e);
		}
		return byteSHA256;
	}

	/**
	 * SHA256로 해싱하여 반환한다.
	 * 
	 * @param str
	 * @return
	 */
	public static String hashingSHA256String(String str) {
		String SHA256 = null;
		try {
			byte[] byteSHA256 = HashingUtils.hashingSHA256(str);

			if (byteSHA256 != null) {
				// ## convert the byte to hex format method 1
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteSHA256.length; i++) {
					sb.append(Integer.toString((byteSHA256[i] & 0xff) + 0x100, 16).substring(1));
				}
				SHA256 = sb.toString();

				// ## convert the byte to hex format method 2
				// StringBuffer hexString = new StringBuffer();
				// for (int i = 0; i < byteSHA256.length; i++) {
				// String hex = Integer.toHexString(0xff & byteSHA256[i]);
				// if (hex.length() == 1) hexString.append('0');
				// hexString.append(hex);
				// }
			}

		} catch (Exception e) {
			logger.error("", e);
		}
		return SHA256;
	}
}
