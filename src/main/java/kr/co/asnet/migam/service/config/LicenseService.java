package kr.co.asnet.migam.service.config;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.License;

/**
 * 라이선스 정보 인터페이스
 */
public interface LicenseService {

	/**
	 * 현재 Database에 등록된 License값을 가져온다. 
	 * @return
	 */
	public License getLicense();

	/**
	 * 라이선스 설정 정보를 업데이트합니다. 
	 * @param license
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateLicense(License license);

}


