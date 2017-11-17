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
import kr.co.asnet.migam.domain.PageDTO2;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.call.MonthlyCall;

/**
 * @author kwonsy
 *
 */

@Repository(value = "monthlyCallDao")
public class MonthlyCallDaoMapper implements MonthlyCallDao {

	private static final Logger logger = LoggerFactory.getLogger(MonthlyCallDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.MonthlyCallDao#selectMonthlyCallList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<MonthlyCall> selectMonthlyCallList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.MonthlyCallDaoMapper.selectMonthlyCallList", parameters);
	}


	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.call.MonthlyCallDao#selectMonthlyCallListforChart(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<MonthlyCall> selectMonthlyCallListForChart(PageDTO2 pageDTO2,SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO2);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.call.MonthlyCallDaoMapper.selectMonthlyCallListForChart", parameters);
	}
	
	
	@Override
	public int selectMonthMonitorStatCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.call.MonthlyCallDaoMapper.selectMonthMonitorStatCount", parameters);
	}

}
