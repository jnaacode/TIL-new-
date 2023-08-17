package kHotel.board.model.dao;

import static kHotel.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kHotel.admin.model.vo.LAdminReport;
import kHotel.board.model.vo.Board;
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.PPagination;

public class ReviewDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public ReviewDAO() {
		try {
			prop = new Properties();
			
			String filePath =   ReviewDAO.class.getResource("/kHotel/sql/PHotel-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 리뷰 내용 
	 * @param conn
	 * @param pagination 
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> boardCount(Connection conn, PPagination pagination) throws Exception{
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			int start = (pagination.getCurrentPage()-1) * pagination.getLimit() +1;
			
			int end = start + pagination.getLimit() -1;
			
			String sql = prop.getProperty("selectReview1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				
				board.setMemberNo(rs.getInt("MEMBER_NO"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setRoomName(rs.getString("ROOM_NM"));
				board.setHotelTitle(rs.getString("HOTEL_TITLE"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				board.setImageRename(rs.getNString("IMG_REVIEW_RENAME"));
				board.setBoardContent(rs.getString("BOARD_CONTENT"));
				board.setReviewStar(rs.getInt("REVIEW_STAR"));
				board.setTagContent(rs.getString("TAG_CONTENT"));
				board.setBoardNo(rs.getInt("BOARD_NO"));
				
				boardList.add(board);
				
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		
		return boardList;
		
	}
	
	/** 페이지네이션 하기 위해서 쿠폰리스트 얻어오기
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int selectReview(Connection conn) throws Exception {
		
		int listCount = 0;
		
		try {
			String sql = prop.getProperty("selectReview");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if( rs.next() ) {
				listCount = rs.getInt(1);
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return listCount;
	}


	/** 리뷰 내용 등록하기 
	 * @param conn
	 * @param report
	 * @return
	 * @throws Exception
	 */
	public int declar(Connection conn, LAdminReport report) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("declar");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, report.getMemberNo());
			pstmt.setInt(2, report.getBoardNo());
			pstmt.setString(3, report.getReportContent());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 리뷰 삭제
	 * @param conn
	 * @param loginMember
	 * @param boardNo
	 * @return
	 */
	public int deleteReview(Connection conn, Member loginMember, int no) throws Exception {
		
	
		int result = 0; 
		try {
			
			String sql = prop.getProperty("deleteReview");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			//pstmt.setInt(2, loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

		


	public Board boardReviewShow(Connection conn, int boardNo) throws Exception {
		
		Board boardShow = new Board();
		
		try {
			
			String sql = prop.getProperty("showReview");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
		
				boardShow.setMemberNo(rs.getInt("MEMBER_NO"));
				boardShow.setMemberId(rs.getString("MEMBER_ID"));
				boardShow.setRoomName(rs.getString("ROOM_NM"));
				boardShow.setHotelTitle(rs.getString("HOTEL_TITLE"));
				boardShow.setBoardDate(rs.getString("BOARD_DT"));
				boardShow.setImageRename(rs.getNString("IMG_REVIEW_RENAME"));
				boardShow.setBoardContent(rs.getString("BOARD_CONTENT"));
				boardShow.setReviewStar(rs.getInt("REVIEW_STAR"));
				boardShow.setTagContent(rs.getString("TAG_CONTENT"));
				boardShow.setBoardNo(rs.getInt("BOARD_NO"));
			
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardShow;
	}
	
}
