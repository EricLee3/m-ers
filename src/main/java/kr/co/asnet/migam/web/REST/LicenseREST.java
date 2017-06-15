package kr.co.asnet.migam.web.REST;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.config.License;
import kr.co.asnet.migam.service.config.LicenseService;

/**
 * 라이선스 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/config")
public class LicenseREST {
	private final Logger logger = LoggerFactory.getLogger(LicenseREST.class);

	@Autowired
	private LicenseService licenseService;
	
	/**
	 * 라이선스 설정값을 DB에 업데이트 하기 위한 엔드포인트 입니다. 
	 * @param license
	 * @param model
	 * @return
	 *  성공하면, license 정보를 JSON형태로 반환 합니다.
	 */
	@RequestMapping(value = "/updateLicense", method = RequestMethod.POST)
	public ResponseEntity<License> updateLicense(License license, Model model) {
		 //logger.debug(license.toString());
		int licenseIndex = licenseService.updateLicense(license);
		if(licenseIndex > 0) {
			return new ResponseEntity<License>(license, HttpStatus.OK);
		} else {
			return new ResponseEntity<License>(HttpStatus.NO_CONTENT);
		}
	}

}
