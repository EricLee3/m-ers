/**
 * 
 */
package kr.co.asnet.migam.repository.call;

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
import kr.co.asnet.migam.domain.call.CompletionCallAnalysis;
import kr.co.asnet.migam.domain.call.RealindState;

/**
 * @author byonghee
 *
 */

@Repository(value = "RealindStateDao")
public class RealindStateDaoMapper implements RealindStateDao {

	private static final Logger logger = LoggerFactory.getLogger(RealindStateDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAnalysisDao#selectCallAnalysisList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public RealindState selectRealindState(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
	
			parameters.put("agent_id", searchDTO.getSearchQuery());

		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.call.RealindStateDaoMapper.selectRealindState", parameters);
	}

	@Override
	public List<RealindState> selectRealindStateList(SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("agent_id", searchDTO.getSearchQuery());
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.RealindStateDaoMapper.selectRealindStateList", parameters);
	}

}
