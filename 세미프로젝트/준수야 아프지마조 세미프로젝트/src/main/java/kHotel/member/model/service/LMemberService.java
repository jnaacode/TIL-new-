package kHotel.member.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;

import kHotel.member.model.dao.LMemberDAO;
import kHotel.member.model.vo.Member;

public class LMemberService {
	
	LMemberDAO dao = new LMemberDAO();
	

	/** 비밀번호 변경 Service
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.changePw(conn, currentPw, newPw, memberNo);
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		
		return result;
	}


	/** 회원 정보 수정 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int changeMember(Member member) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.changeMember(conn, member);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		
		return result;
	}

}
