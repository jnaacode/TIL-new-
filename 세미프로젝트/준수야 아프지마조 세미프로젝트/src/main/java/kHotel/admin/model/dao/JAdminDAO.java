package kHotel.admin.model.dao;

import static kHotel.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import kHotel.admin.model.vo.HAdminBoard;
import kHotel.admin.model.vo.PAdminMemebr;
import kHotel.member.model.vo.Member;

public class JAdminDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public JAdminDAO() {
		try {
			prop = new Properties();
			
			String filePath =   JAdminDAO.class.getResource("/kHotel/sql/JHotel-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** FAQ작성 할 memberNo 가져오기
	 * @param conn
	 * @param loginMember
	 * @return memberNo
	 * @throws Exception
	 */
	public int getMemberNo(Connection conn, Member loginMember) throws Exception {
		int memberNo = 0;
		
		try {
			String sql = prop.getProperty("getMemberNo2");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginMember.getMemberId());
			
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				
				 memberNo = rs.getInt(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return memberNo;
	}

	/** FAQ 작성
	 * @param conn
	 * @param memberNo
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int FAQUpdate(Connection conn, int memberNo, HAdminBoard board) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("FAQUpdate");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		
		return result;
	}

	/** FAQ 수정에 필요한 boardNo 가져오기
	 * @param conn
	 * @param before
	 * @param loginMember
	 * @return boardNo
	 * @throws Exception
	 */
	public int getFAQBoardNo(Connection conn, HAdminBoard before, Member loginMember) throws Exception {
		int board = 0;
		
		try {
			String sql = prop.getProperty("getFAQBoardNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, before.getBoardTitle());
			pstmt.setInt(2, loginMember.getMemberNo());
			
			rs = pstmt.executeQuery();
			
			if(rs.next() ) {
				
				board = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return board;
	}

	/** FAQ 수정 DAO
	 * @param before
	 * @param loginMember
	 * @param after
	 * @param boardNo 
	 * @return result
	 * @throws Exception
	 */
	public int FAQAlter(Connection conn, HAdminBoard before, Member loginMember, HAdminBoard after, int boardNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("FAQAlter");
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, after.getBoardContent());
			pstmt.setString(2, after.getBoardTitle());
			pstmt.setInt(3, loginMember.getMemberNo());
			pstmt.setInt(4, boardNo);
			pstmt.setString(5, before.getBoardTitle());
			
			
			result = pstmt.executeUpdate();

		}finally {
			
			close(pstmt);
			
		}
		return result;
	}

}
