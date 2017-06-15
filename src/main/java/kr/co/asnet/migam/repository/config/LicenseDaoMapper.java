package kr.co.asnet.migam.repository.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.License;

/**
 * 라이선스 DAO 구현 클래스
 */
@Repository(value = "licenseDao")
public class LicenseDaoMapper implements LicenseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(LicenseDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.LicenseDaoMapper.selectLicense()
	 */
	@Override
	public License selectLicense() {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.config.LicenseDaoMapper.selectLicense");
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.config.LicenseDao#updateLicense(kr.co.asnet.migam.domain.config.License)
	 */
	@Override
	public int updateLicense(License license) {
		return sqlSession.update("kr.co.asnet.migam.repository.config.LicenseDaoMapper.updateLicense", license);
	}

}
