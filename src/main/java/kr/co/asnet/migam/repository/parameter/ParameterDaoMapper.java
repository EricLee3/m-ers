package kr.co.asnet.migam.repository.parameter;

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
import kr.co.asnet.migam.domain.config.Parameter;

/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "parameterDao")
public class ParameterDaoMapper implements ParameterDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ParameterDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.ParameterDaoMapper.selectParameter()
	 */
	@Override
	public Parameter selectParameter() {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.parameter.ParameterDaoMapper.selectParameter");
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.parameter.ParameterDao#updateParameter(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public int updateParameter(Parameter parameter) {
		return sqlSession.update("kr.co.asnet.migam.repository.parameter.ParameterDaoMapper.updateParameter", parameter);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.parameter.ParameterDao#insertParameterHistory(kr.co.asnet.migam.domain.config.Parameter)
	 */
	@Override
	public String insertParameterHistory(Parameter parameter) {
		int resultCode = sqlSession.insert("kr.co.asnet.migam.repository.parameter.ParameterDaoMapper.insertParameterHistory", parameter);
		if (resultCode > 0) return parameter.getTitle();
		else return null; 
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.parameter.ParameterDao#selectParameterHistoryList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<Parameter> selectParameterHistoryList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.parameter.ParameterDaoMapper.selectParameterHistoryList", parameters);
	}
}
