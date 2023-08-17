package kHotel.member.model.dao;

import static kHotel.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import kHotel.member.model.vo.Member;

public class LMemberDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public LMemberDAO() {
		try {
			prop = new Properties();
			
			String filePath =   LMemberDAO.class.getResource("/kHotel/sql/LMember-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 비밀번호 변경 DAO
	 * @param conn
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(Connection conn, String currentPw, String newPw, int memberNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("changePw");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, newPw);
			pstmt.setString(2, currentPw);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			
			close(pstmt);
			
		}
		
		
		return result;
	}

	/** 회원 정보 수정 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int changeMember(Connection conn, Member member) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("changeMember");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberTel());
			pstmt.setString(3, member.getMemberEmail());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setInt(5, member.getMemberNo());
			
			result  = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;
	}

}
