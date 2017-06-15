/**
 * 
 */
package kr.co.asnet.migam.service.config;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.License;
import kr.co.asnet.migam.repository.config.LicenseDao;

/**
 * @author kwonsy
 *
 */
@Service("licenseService")

public class LicenseServiceImpl implements LicenseService {

	@Inject
	LicenseDao licenseDao;

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.LicenseService#getLicense()
	 */
	@Override
	public License getLicense() {
		return licenseDao.selectLicense();
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.LicenseService#updateLicense(kr.co.asnet.migam.domain.config.License)
	 */
	@Override
	public int updateLicense(License license) {
		return licenseDao.updateLicense(license);
	}

}
