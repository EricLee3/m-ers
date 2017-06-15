package kr.co.asnet.migam.service.user;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.user.User;

/**
 * 사용자 정보 인터페이스
 */
public interface UserService {

	/**
	 * 데이터베이스에 새로운 회원 정보를 추가합니다. 비밀번호는 SHA256으로 암호화됩니다.
	 * @param user
	 * 	user.index = 0 또는  null값으로 전달됩니다.
	 * 
	 * @return int  
	 *  새로 추가된 사용자의 index를 반환합니다.
	 */
	public int insertUser(User user);


	/**
	 * 지정된 번호(index)에 해당하는 User객체를 반환합니다. 
	 * @param index
	 * @return
	 */
	public User getUser(int index);

	/**
	 * 주어진 조건에 따라 User 객체 목록을 반환합니다.
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<User> getUserList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 사용자 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int countUserList(SearchDTO searchDTO);

	/**
	 * 사용자 정보를 업데이트합니다. 
	 * 만일 비밀번호가 null이거나 ''(blank) 라면, 비번은 업데이트하지 않습니다. 
	 * @param user
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateUser(User user);
	
	
	
	/**
	 * 사용자 정보를 업데이트합니다. 
	 * 만일 비밀번호가 null이거나 ''(blank) 라면, 비번은 업데이트하지 않습니다. 
	 * @param user
	 * @return
	 *  성공하면 1을 반환합니다. 실패하면 0을 반환합니다.
	 */
	public int updateUserTime(User user);
	
	

	/**
	 * 사용자 삭제
	 * 
	 * @param index
	 * @return
	 */
	public Boolean deleteUser(String index);

	/**
	 * 주어진 사용자 정보로 로그인 합니다.
	 * 
	 * @param user
	 * @return
	 */
	public int login(User user);

	/**
	 * 현재 로그인된 사용자 정보를 로그아웃 처리 합니다. 
	 */
	public void logout();
	
	/**
	 * 지정된 사용자 아이디와 패스워드가 정확한 지 확인하여 결과값을 반환합니다.
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public boolean isCorrectPassword(String userId, String password);

	/**
	 * 존재하는 ID 인지 조회합니다.
	 * 
	 * @param userId
	 * @return
	 */
	public boolean isDuplicatedUserId(String userId);
	
	/**
	 * 지정된 userId의 비밀번호를 password를 SHA 암호화하여 초기화 합니다.
	 * 
	 * @param userId
	 * @param password
	 * @return
	 */
	public int updatePassword(String userId, String password);
	
}


