package kr.co.asnet.migam.repository.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.asnet.migam.domain.agent.ProgressLink;


/**
 * 사용자 DAO 구현 클래스
 */

@Repository(value = "ProgressLinkDao")
public class ProgressLinkDaoMapper implements ProgressLinkDao { 
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;

	@Override
	public List<ProgressLink> selectProgressLingList(ProgressLink progressLink) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("progressLink", progressLink);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.agent.ProgressLinkDaoMapper.selectProgressLingList", parameters);
	}


}
