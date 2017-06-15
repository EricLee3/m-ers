package kr.co.asnet.migam.repository.user;

import java.util.List;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.user.User;

/**
 * 사용자 DAO 인터페이스
 */
public interface UserDao {
	/**
	 * 사용자 정보를 입력합니다.
	 * 
	 * @param user
	 * @return
	 */
	public int insertUser(User user);

	/**
	 * 주어진 사용자의 고유 번호를 기반으로 해당 사용자 정보를 반환합니다. 
	 * 
	 * @param userIndex
	 * @return
	 *  domain.User 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public User selectUser(int userIndex);

	/**
	 * 주어진 사용자의 이름를 기반으로 해당 사용자 정보를 반환합니다. 
	 * 
	 * @param userName
	 * @return
	 *  domain.User 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public User selectUserByName(String userName);
	
	/**
	 * 주어진 사용자의 아이디를 기반으로 해당 사용자 정보를 반환합니다. 
	 * 
	 * @param userId
	 * @return
	 *  domain.User 인스턴스를 반환합니다.
	 *  만일, 대상 데이터가 없는 경우네는  NULL 을 반환합니다.
	 */
	public User selectUserById(String userId);

	/**
	 * 사용자 정보를 수정합니다.
	 * 
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * 지정된 사용자(고유번호, 알람카운트만 사옹)의 알람 카운트를 변경합니다. 
	 * 
	 * @param user
	 * @return
	 */
	public int updateAlarmCount(User user);

	/**
	 * 사용자 리스트를 조회합니다.
	 * 
	 * @param pageDTO
	 * @param searchDTO
	 * @param orderby
	 * @return
	 */
	public List<User> selectUserList(PageDTO pageDTO, SearchDTO searchDTO, String orderby);

	/**
	 * 사용자 수 카운트
	 * 
	 * @param searchDTO
	 * @return
	 */
	public int selectCount(SearchDTO searchDTO);

	/**
	 * 사용자 삭제
	 * 
	 * @param userIndex
	 * @return
	 */
	public int deleteUser(String userIndex);
	
	/**
	 * 지정된 사용자(고유번호, 알람카운트만 사옹)의 알람 카운트를 변경합니다. 
	 * 
	 * @param user
	 * @return
	 */
	public int updateUserTime(User user);
	

}
