package kr.co.asnet.migam.repository.user;

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
import kr.co.asnet.migam.domain.user.User;

/**
 * 사용자 DAO 구현 클래스
 */
@Repository(value = "userDao")
public class UserDaoMapper implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoMapper.class);	
	@Inject
	@Named("sqlSession")
	public SqlSession sqlSession;

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.insertUser(kr.co.asnet.migam.domain.User)
	 */
	@Override
	public int insertUser(User user) {
		sqlSession.insert("kr.co.asnet.migam.repository.user.UserDaoMapper.insertUser", user);
		return user.getIndex(); 
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.selectUser(int)
	 */
	@Override
	public User selectUser(int userIndex) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.user.UserDaoMapper.selectUser", userIndex);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.selectUserById(String)
	 */
	@Override
	public User selectUserById(String userId) {
		return sqlSession.selectOne("kr.co.asnet.migam.repository.user.UserDaoMapper.selectUserById", userId);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.selectUserByName(String)
	 */
	@Override
	public User selectUserByName(String userName){
		return sqlSession.selectOne("kr.co.asnet.migam.repository.user.UserDaoMapper.selectUserByName", userName);
	}

	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.updateUser(kr.co.asnet.migam.domain.User)
	 */
	@Override
	public int updateUser(User user) {
		return sqlSession.update("kr.co.asnet.migam.repository.user.UserDaoMapper.updateUser", user);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.insertUser(kr.co.asnet.migam.domain.User)
	 */
	@Override
	public int selectCount(SearchDTO searchDTO) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("searchDTO", searchDTO);
		}
		return sqlSession.selectOne("kr.co.asnet.migam.repository.user.UserDaoMapper.selectCount", parameters);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.insertUser(kr.co.asnet.migam.domain.User)
	 */
	@Override
	public int deleteUser(String userIndex) {
		return sqlSession.delete("kr.co.asnet.migam.repository.user.UserDaoMapper.deleteUser", userIndex);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.UserDao#updateAlarmCount(kr.co.asnet.migam.domain.user.User)
	 */
	@Override
	public int updateAlarmCount(User user) {
		return sqlSession.update("kr.co.asnet.migam.repository.user.UserDaoMapper.updateAlarmCount", user);
	}

	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.UserDao#selectUserList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<User> selectUserList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		{
			parameters.put("pageDTO", pageDTO);
			parameters.put("searchDTO", searchDTO);
			parameters.put("orderby", orderby);
		}
		return sqlSession.selectList("kr.co.asnet.migam.repository.user.UserDaoMapper.selectUserList", parameters);
	}
	
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.repository.user.updateUser(kr.co.asnet.migam.domain.User)
	 */
	@Override
	public int updateUserTime(User user) {
		return sqlSession.update("kr.co.asnet.migam.repository.user.UserDaoMapper.updateUserTime", user);
	}
	
}
