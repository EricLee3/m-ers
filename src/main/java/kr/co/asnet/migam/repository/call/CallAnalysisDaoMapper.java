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
import kr.co.asnet.migam.domain.call.CallAnalysis;

/**
 * @author byonghee
 *
 */

@Repository(value = "callAnalysisDao")
public class CallAnalysisDaoMapper implements CallAnalysisDao {

	private static final Logger logger = LoggerFactory.getLogger(CallAnalysisDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAnalysisDao#selectCallAnalysisList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<CallAnalysis> selectCallAnalysisList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAnalysisDaoMapper.selectCallAnalysisList", parameters);
	}


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAnalysisDao#selectCallAnalysisCount(kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int selectCallAnalysisCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.call.CallAnalysisDaoMapper.selectCount", parameters);
	}


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAnalysisDao#selectCallAnalysis(int)
	 */
	@Override
	public CallAnalysis selectCallAnalysis(int index) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.call.CallAnalysisDaoMapper.selectCallAnalysis", index);	
	}


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAnalysisDao#selectAgentDailyAngryCallForDashBoard(int)
	 */
	@Override
	public List<CallAnalysis> selectAgentDailyAngryCallForDashBoard(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CallAnalysisDaoMapper.selectDailyAngryCallForDashBoard", parameters);
	}
	
}
