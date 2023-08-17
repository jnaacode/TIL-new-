package kHotel.board.model.dao;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kHotel.admin.model.vo.HAdminBoard;
import kHotel.board.model.vo.AnnouncementDetail;
import kHotel.board.model.vo.Board;
import kHotel.common.Util;
import kHotel.member.model.vo.LPagination;

import static kHotel.common.JDBCTemplate.*;

public class HBoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public HBoardDAO() {
		try {
			prop = new Properties();
			
			String filePath =   HBoardDAO.class.getResource("/kHotel/sql/HBoard-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/** 게시글 이름 조회
	 * @param conn
	 * @param type
	 * @return boardName
	 * @throws Exception
	 */
	public String selectBoardName(Connection conn, int type) throws Exception{
		
		String boardName = null;
		
		try {
			
			String sql = prop.getProperty("selectBoardName");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardName = rs.getString(1);
			}
			
		}finally {
			close(rs);
			close(pstmt);
			
		}
		
		return boardName;
	}


	/** 게시글 수 조회
	 * @param conn
	 * @param type
	 * @return ListCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int type) throws Exception{
		
		int listCount = 0;
		
		try {
			
			String sql = prop.getProperty("getListCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}


	/** 글 목록 조회
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> checkBoardList(Connection conn, LPagination pagination, int type) throws Exception{
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			
			String sql = prop.getProperty("checkBoardList");
			
			int start = (pagination.getCurrentPage()-1) * pagination.getLimit() +1;
			
			int end = start + pagination.getLimit() -1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				
				boardList.add(board);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}


	/** 게시글 조회
	 * @param conn
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public AnnouncementDetail checkBoardDetail(Connection conn, int boardNo) throws Exception{
		
		AnnouncementDetail detail = null;
		
		try {
			
			String sql = prop.getProperty("selectBoardDetail");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				detail = new AnnouncementDetail();
				
				detail.setBoardNo(rs.getInt(1));
				detail.setBoardTitle(rs.getString(2));
				detail.setBoardContent(rs.getString(3));
				detail.setBoardDate(rs.getString(4));
				detail.setMemberNo(rs.getInt(5));
				detail.setMemberName(rs.getString(6));
				
				
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return detail;
	}


	/** 공지사항 목록 조회
	 * @param conn
	 * @return boardList
	 * @throws Exception
	 */
	public List<HAdminBoard> selectBoardList(Connection conn) throws Exception{
		
		List<HAdminBoard> boardList = new ArrayList<HAdminBoard>();
		
		try {
			String sql = prop.getProperty("selectBoardList");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while( rs.next() ) {
				
				HAdminBoard board = new HAdminBoard();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberName(rs.getString("MEMBER_NM"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				
				
				boardList.add(board);
								
			}
			
			
		} finally {
			
			close(rs);
			close(stmt);
		}
		
		return boardList;
	}

	/** 공지사항 상세페이지
	 * @param conn
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board BoardDetail(Connection conn, int boardNo) throws Exception{
		
		Board board = new Board();
		
		try {
			
			String sql = prop.getProperty("BoardDetail");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();

			
			if(rs.next()) {
				
				
			board.setBoardNo(rs.getInt(1));
			board.setBoardTitle(rs.getString(2));	
			board.setMemberId(rs.getString(3));
			board.setBoardDate(rs.getString(4));
			board.setBoardContent(rs.getString(5));
			
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
		}
		
		return board;
	}


	/** 공지사항 수정
	 * @param conn
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Connection conn, Board board) throws Exception{
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("updateBoardtest");
			
			pstmt = conn.prepareStatement(sql);
					
			pstmt.setString(1,board.getBoardTitle());
			pstmt.setString(2,board.getBoardContent());
			pstmt.setInt(3, board.getBoardNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		
		return result;	
	}

	/** 공지사항 작성
	 * @param conn 
	 * @param boardContent 
	 * @param boardTitle 
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Connection conn, Board board) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertBoard");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getBoardTitle() );
			pstmt.setString(2, board.getBoardContent() );
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}




}
