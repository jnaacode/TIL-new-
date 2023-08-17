package kHotel.board.model.dao;

import static kHotel.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import kHotel.board.model.vo.Board;


public class LBoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public LBoardDAO() {
		try {
			prop = new Properties();
			
			String filePath =   LBoardDAO.class.getResource("/kHotel/sql/LBoard-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 게시글 상세페이지 DAO
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoardDetail(Connection conn, int boardNo) throws Exception{
		
		Board board = new Board();
		
		try {
			
			String sql = prop.getProperty("selectBoardDetail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
			}
			
			
			
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return board;
	}

	public int deleteBoard(Connection conn, int no) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			result = pstmt.executeUpdate();
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

}
