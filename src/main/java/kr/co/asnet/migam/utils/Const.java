package kr.co.asnet.migam.utils;

import java.util.HashMap; 
import java.util.Map;

/**
 * 모든 상수를 저장하기 위한 클래스입니다.
 * @author byonghee
 *
 */
public class Const {

	public static final int SUMMARY_LENGTH=200;
	public static final Map<Integer, String> SERVICE_TYPE;
	static{
		SERVICE_TYPE = new HashMap<Integer, String>();
	};
	
	public Const() {
		// TODO Auto-generated constructor stub
	}
	
	public static final int EXCELDOWNLOAD_CALLREPORT = 1;
	public static final int EXCELDOWNLOAD_CUSTOMERREPORT = 2;
	public static final int EXCELDOWNLOAD_STATHOURLY = 3;
	public static final int EXCELDOWNLOAD_STATDAILY = 4;
	public static final int EXCELDOWNLOAD_STATMONTHLY = 5;
	public static final int EXCELDOWNLOAD_STATAGENT = 6;
	public static final int EXCELDOWNLOAD_STATPERFORMANCE = 7;
	
	public static final int USERSTATUS_OK=1;
	public static final int USERSTATUS_WAIT=0;
	public static final int USERSTATUS_REJECT=2;
	public static final int USERSTATUS_NONE=9;
	public static final Map<Integer, String> USERSTATUS_MESSAGE;
	static{
		USERSTATUS_MESSAGE = new HashMap<Integer, String>();
		USERSTATUS_MESSAGE.put(USERSTATUS_OK, "정상적으로 로그인 되었습니다.");
		USERSTATUS_MESSAGE.put(USERSTATUS_WAIT, "회원가입 신청이 접수되어, 현재 논의 단계에 있습니다. 논의의 결과는 빠른 시일내에 이메일로 알려드겠습니다.");
		USERSTATUS_MESSAGE.put(USERSTATUS_REJECT, "회원가입 신청이 접수되었으나, 논의 결과 회원 가입이 거절되었습니다. 추가적인 정보를 원하시면, office@esckorea.org로 연락주십시오. ");
		USERSTATUS_MESSAGE.put(USERSTATUS_NONE, "해당하는 정보가 없습니다. 확인하시고 다시 입력해 주십시오.");
	};	

}
