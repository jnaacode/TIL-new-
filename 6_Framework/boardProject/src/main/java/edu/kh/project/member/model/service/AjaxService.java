package edu.kh.project.member.model.service;

public interface AjaxService {

	/**이메일로 닉네임 조회
	 * @param email
	 * @return nickname
	 */
	String selectNickname(String email);

	/**닉네임으로 전화번호 조회
	 * @param nickname
	 * @return tel
	 */
	String selectMemebrTel(String nickname);

	/**이메일 중복 확인
	 * @param email
	 * @return count
	 */
	int checkEmail(String email);

	int checkNickname(String nickname);

}
