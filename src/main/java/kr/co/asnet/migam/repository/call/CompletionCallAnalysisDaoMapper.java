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

/**
 * @author byonghee
 *
 */

@Repository(value = "completionCallAnalysisDao")
public class CompletionCallAnalysisDaoMapper implements CompletionCallAnalysisDao {

	private static final Logger logger = LoggerFactory.getLogger(CompletionCallAnalysisDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.CallAnalysisDao#selectCallAnalysisList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<CompletionCallAnalysis> selectCompletionCallAnalysisList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			System.out.println("pageDTO:"+pageDTO);
			System.out.println("searchDTO:"+searchDTO);
			System.out.println("orderby:"+orderby);
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.CompletionCallAnalysisDaoMapper.selectCompletionCallAnalysisList", parameters);
	}


}
