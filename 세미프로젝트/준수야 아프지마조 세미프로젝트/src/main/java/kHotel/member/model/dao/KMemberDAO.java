package kHotel.member.model.dao;

import static kHotel.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.Reservation;

public class KMemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public KMemberDAO() {
		try {
			prop = new Properties();
			
			String filePath =   KMemberDAO.class.getResource("/kHotel/sql/KMember-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 로그인 DAO
	 * @param conn
	 * @param mem
	 * @return loginMember
	 * @throws Exception
	 */
	public Member login(Connection conn, Member mem) throws Exception {
		
		Member loginMember = null;
		
		try {
			
			String sql = prop.getProperty("login");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginMember = new Member();
				
				loginMember.setMemberNo(rs.getInt("MEMBER_NO"));
				loginMember.setMemberId(rs.getString("MEMBER_ID"));
				loginMember.setMemberName(rs.getString("MEMBER_NM"));
				loginMember.setMemberPno(rs.getString("MEMBER_PNO"));
				loginMember.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				loginMember.setMemberTel(rs.getString("MEMBER_TEL"));
				loginMember.setMemberAddress(rs.getString("MEMBER_ADD"));
				loginMember.setMemberAdmin(rs.getString("MEMBER_ADMIN").charAt(0));
				loginMember.setSecessionFlag(rs.getString("SECESSION_FL").charAt(0));
				
			}
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return loginMember;
	}

	/** 아이디 찾기 DAO
	 * @param conn
	 * @param idInput
	 * @param pwInput
	 * @return result
	 * @throws Exception
	 */
	public String idSearch(Connection conn, String nmInput, String pnoInput) throws Exception {
		
		String result = null;
		
		try {
			
			String sql = prop.getProperty("idSearch");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nmInput);
			pstmt.setString(2, pnoInput);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString(1);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return result;
	}

	/** 임시비번 정보 확인 DAO
	 * @param conn
	 * @param inputName
	 * @param inputPno
	 * @param inputId
	 * @return memberNo 
	 * @throws Exception
	 */
	public int rightInfo(Connection conn, String inputName, String inputPno, String inputId) throws Exception {
		
		int memberNo = 0;
		
		try {
			String sql = prop.getProperty("rightInfo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, inputName);
			pstmt.setString(2, inputPno);
			pstmt.setString(3, inputId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberNo = rs.getInt(1);
			}
			
		} finally {
			
		}
		return memberNo;
	}


	/** 비밀번호 변경 전 회원정보 확인 DAO
	 * @param conn
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int rePw(Connection conn, Member mem) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("rePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getMemberName());
			pstmt.setString(2, mem.getMemberPno());
			pstmt.setString(3, mem.getMemberId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return result;
	}

	/** 비밀번호 변경(로그인 전)DAO
	 * @param conn
	 * @param newPw
	 * @return result
	 * @throws Exception
	 */
	public int newRePw(Connection conn, String newPw, String memberId) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("newRePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw);
			
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
			
		} finally {
			
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** 예약 번호 구하기 DAO
	 * @param conn
	 * @return bookNo
	 * @throws Exception
	 */
	public int bookNo(Connection conn) throws Exception  {
		
		int bookNo = 0;
		
		try {
			
			String sql = prop.getProperty("bookNo");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				bookNo = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return bookNo;
	}

	/** 예약 테이블에 데이터 insert DAO
	 * @param conn
	 * @param reserve
	 * @return result 
	 * @throws Exception
	 */
	public int reservation(Connection conn, Reservation reserve) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("reservation");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reserve.getBookNo());
			pstmt.setString(2, reserve.getCheckInTime());
			pstmt.setString(3, reserve.getCheckOutTime());
			pstmt.setInt(4, reserve.getBookPerson());
			pstmt.setInt(5, reserve.getMemberNo());
			pstmt.setInt(6, reserve.getRoomNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 결제 테이블 insert
	 * @param conn
	 * @param reserve
	 * @return result
	 * @throws Exception
	 */
	public int calculate(Connection conn, Reservation reserve) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("calculate");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reserve.getPayPlan());
			pstmt.setInt(2, reserve.getHotelPay());
			pstmt.setString(3, reserve.getBank());
			pstmt.setInt(4, reserve.getBookNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 쿠폰 사용한 경우 상태 변경 DAO
	 * @param conn
	 * @param reserve
	 * @return result
	 * @throws Exception
	 */
	public int coupon(Connection conn, Reservation reserve) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("coupon");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reserve.getMemberNo());
			pstmt.setInt(2, reserve.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

	

}
