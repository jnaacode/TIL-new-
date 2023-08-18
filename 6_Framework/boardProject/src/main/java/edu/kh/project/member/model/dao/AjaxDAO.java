package edu.kh.project.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.dto.Member;

@Repository // DB연결 의미 + bean 등록 
public class AjaxDAO {

	@Autowired // bean중에서 타입이 같은 객체를 의존성주입(DI)
	private SqlSessionTemplate sqlSession;

	
	/** 이메일로 닉네임 조회 
	 * @param email
	 * @return nickname
	 */
	public String selectNickname(String email) {
		return sqlSession.selectOne("ajaxMapper.selectNickname",email);
	}



	/**닉네임으로 전화번호 조회
	 * @param nickname
	 * @return tel
	 */
	public String selectMemebrTel(String nickname) {
		return sqlSession.selectOne("ajaxMapper.selectMemebrTel",nickname);
	}



	/**이메일 중복 검사
	 * @param email
	 * @return
	 */
	public int checkEmail(String email) {
		return sqlSession.selectOne("ajaxMapper.checkEmail",email);
	}



	/** 닉네임 중복 검사
	 * @param nickname
	 * @return count
	 */
	public int checkNickname(String nickname) {
		return sqlSession.selectOne("ajaxMapper.checkNickname",nickname);
	}



	/** 회원 정보 조회 
	 * @param email
	 * @return Member
	 */
	public Member selectMember(String email) {
		return sqlSession.selectOne("ajaxMapper.selectMember",email);
	}


	/**이메일이 일부라도 일치하는 모든 회원
	 * @param input
	 * @return List
	 */
	public List<Member> selectMemberList(String input) {
		return sqlSession.selectList("ajaxMapper.selectMemberList",input);
	}
	
}
