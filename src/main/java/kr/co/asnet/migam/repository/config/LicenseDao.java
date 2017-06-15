package kr.co.asnet.migam.repository.config;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.License;

/**
 * 라이선스 값을 가져오기 위한  DAO 인터페이스
 */
public interface LicenseDao {
	/**
	 * 현재 Database에 저장된 라이선스(License)값을 반환합니다.
	 */
	public License selectLicense();
	
	/**
	 * 라이선스 정보를 수정합니다.
	 * 
	 * @param license
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateLicense(License license);

}
