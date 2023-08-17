package kHotel.member.model.service;

import java.sql.Connection;


import kHotel.common.wrapper.EncryptWrapper;
import kHotel.member.model.dao.KMemberDAO;
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.Reservation;

import static kHotel.common.JDBCTemplate.*;

public class KMemberService {

	private KMemberDAO dao = new KMemberDAO();

	/**
	 * 로그인 service
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Member mem) throws Exception {

		Connection conn = getConnection();

		Member loginMember = dao.login(conn, mem);

		close(conn);

		return loginMember;
	}

	/**
	 * 아이디 찾기 service
	 * 
	 * @param idInput
	 * @param pwInput
	 * @return result
	 * @throws Exception
	 */
	public String idSearch(String nmInput, String pnoInput) throws Exception {

		Connection conn = getConnection();

		String result = dao.idSearch(conn, nmInput, pnoInput);

		close(conn);

		return result;
	}

	/** 비밀번호 변경 전 회원정보 확인 service
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int rePw(Member mem) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.rePw(conn, mem);
		
		close(conn);
		
		return result;
	}

	/** 비밀번호 변경(로그인 전)service
	 * @param newPw
	 * @return result
	 * @throws Exception
	 */
	public int newRePw(String newPw, String memberId) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.newRePw(conn, newPw, memberId);
		
		if(result>0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	/** 예약 끝 service
	 * @param reserve
	 * @return result
	 * @throws Exception
	 */
	public int bookEnd(Reservation reserve) throws Exception {
		
		Connection conn = getConnection();
		
		// 1. 예약 번호 구하기
		int bookNo = dao.bookNo(conn);
		reserve.setBookNo(bookNo);
		
		// 2. 구한 예약번호로 예약 테이블에 데이터 insert
		int result = dao.reservation(conn, reserve);
		
		if(result>0) {
			
			// 3. 예약번호 바탕으로 결제 테이블에 데이터 insert
			result = dao.calculate(conn, reserve);
			
			// 4. 쿠폰 테이블 update
			
			if(reserve.getCouponSale() == 30000) { // 쿠폰을 쓴 경우에
				result = dao.coupon(conn, reserve);
			}
		}
		
		if(result>0)	commit(conn);
		else			rollback(conn);
		
		return result;
	}

	

}
