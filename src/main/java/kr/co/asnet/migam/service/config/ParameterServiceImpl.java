/**
 * 
 */
package kr.co.asnet.migam.service.config;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.Parameter;
import kr.co.asnet.migam.repository.parameter.ParameterDao;

/**
 * @author byonghee
 *
 */
@Service("parameterService")

public class ParameterServiceImpl implements ParameterService {

	@Inject
	ParameterDao parameterDao;
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#getParameter()
	 */
	@Override
	public Parameter getParameter() {
		return parameterDao.selectParameter();
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#updateParameter(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public int updateParameter(Parameter parameter) {
		return parameterDao.updateParameter(parameter);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#insertParameterHistory(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public String insertParameterHistory(Parameter parameter) {
		return parameterDao.insertParameterHistory(parameter);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.ParameterService#getParameterHistoryList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Parameter> getParameterHistoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return parameterDao.selectParameterHistoryList(pageDTO, searchDTO, orderby);
	}

}
