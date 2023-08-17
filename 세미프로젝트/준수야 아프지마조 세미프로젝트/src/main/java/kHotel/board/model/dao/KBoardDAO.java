package kHotel.board.model.dao;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static kHotel.common.JDBCTemplate.*;

import kHotel.board.model.vo.Board;
import kHotel.board.model.vo.Event;
import kHotel.board.model.vo.EventImage;
import kHotel.member.model.vo.LPagination;

public class KBoardDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public KBoardDAO() {
		try {
			prop = new Properties();
			
			String filePath =   KBoardDAO.class.getResource("/kHotel/sql/KBoard-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 특정 게시판 이름 조회 DAO
	 * @param conn
	 * @param type
	 * @return boardName
	 * @throws Exception
	 */
	public String getBoardName(Connection conn, int type) throws Exception {
		
		String boardName = null;
		
		try {
			
			String sql = prop.getProperty("getBoardName");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				boardName = rs.getString(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardName;
	}


	/** 특정 게시판 글 수 조회 DAO
	 * @param conn
	 * @param type
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, int type) throws Exception {
		
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

	/** 특정 게시판 글 목록 조회 DAO
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(Connection conn, LPagination pagination, int type) throws Exception{
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			
			String sql = prop.getProperty("selectBoardList");
			
			// sql between에 넣을 숫자
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
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				
				boardList.add(board);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return boardList;
	}

	/** qna 검색 DAO(검색된 글 수 조회)
	 * @param select
	 * @param content
	 * @param conn
	 * @param type
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(String select, String content, Connection conn, int type) throws Exception {
		
		int listCount = 0;
		
		try {
			
			// String sql = prop.getProperty("qnaListCount");
			String sql = "SELECT COUNT(*) FROM BOARD "+ "WHERE "+ select +  " LIKE '%" + content + "%' AND BOARD_CD = " + type;
			
			//pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, select);
			//pstmt.setString(2, content);
			
			//rs = pstmt.executeQuery();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}

	/** qna 검색 조회(검색 조건에 맞는 글 목록 조회)DAO
	 * @param select
	 * @param content
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return searchBoardList
	 * @throws Exception
	 */
	public List<Board> selectBoardList(String select, String content, Connection conn, LPagination pagination,
			int type) throws Exception {
		
		List<Board> searchBoardList = new ArrayList<Board>();
		
		try {
			
			//String sql = prop.getProperty("searchBoardList");
			
			// sql between에 넣을 숫자
			int start = (pagination.getCurrentPage()-1) * pagination.getLimit() +1;
			
			int end = start + pagination.getLimit() -1;
			
			// na ul go si peo . . . . . . . . . . 
			String sql = "SELECT * FROM("
					+ "		    SELECT ROWNUM RNUM, A.* FROM( "
					+ "		        SELECT BOARD_NO, BOARD_TITLE, MEMBER_ID, "
					+ "		                TO_CHAR(BOARD_DT,'YYYY-MM-DD') AS BOARD_DT "
					+ "		        FROM BOARD "
					+ "		        JOIN MEMBER USING (MEMBER_NO) "
					+ "		        WHERE BOARD_CD = " + type
					+ "		        AND BOARD_ST = 'N' "
					+ "                AND " + select + " LIKE '%" + content + "%' "
					+ "		        ORDER BY BOARD_NO DESC "
					+ "		    ) A "
					+ "		) "
					+ "		WHERE RNUM BETWEEN " +  start +  " AND  " +  end;
			
			
			/*
			 * pstmt = conn.prepareStatement(sql);
			 * 
			 * pstmt.setInt(1, type); pstmt.setString(2, select); pstmt.setString(3,
			 * content); pstmt.setInt(4, start); pstmt.setInt(5, end);
			 * 
			 * rs = pstmt.executeQuery();
			 */
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				
				searchBoardList.add(board);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return searchBoardList;
		
	}

	/** qna 검색 게시글 수(내용 + 제목) DAO
	 * @param content
	 * @param conn
	 * @param type
	 * @return listCount
	 * @throws Exception
	 */
	public int AgetgetListCount(String content, Connection conn, int type) throws Exception {
		
		int listCount = 0;
		
		try {
			
			// String sql = prop.getProperty("qnaListCount");
			String sql = "SELECT COUNT(*) FROM BOARD "+ "WHERE (BOARD_TITLE LIKE '%" + content + "%' OR BOARD_CONTENT LIKE '%"
							+ content + "%') AND BOARD_CD = " + type;
			
			//pstmt = conn.prepareStatement(sql);
			
			//pstmt.setString(1, select);
			//pstmt.setString(2, content);
			
			//rs = pstmt.executeQuery();
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
		
	}

	/** qna 검색 게시글 목록(내용 + 제목) DAO
	 * @param content
	 * @param conn
	 * @param pagination
	 * @param type
	 * @return searchBoardList
	 */
	public List<Board> selectBoardList(String content, Connection conn, LPagination pagination, int type) throws Exception {
		List<Board> searchBoardList = new ArrayList<Board>();
		
		try {
			
			
			// sql between에 넣을 숫자
			int start = (pagination.getCurrentPage()-1) * pagination.getLimit() +1;
			
			int end = start + pagination.getLimit() -1;
			
			String sql = "SELECT * FROM("
					+ "		    SELECT ROWNUM RNUM, A.* FROM( "
					+ "		        SELECT BOARD_NO, BOARD_TITLE, MEMBER_ID, "
					+ "		                TO_CHAR(BOARD_DT,'YYYY-MM-DD') AS BOARD_DT "
					+ "		        FROM BOARD "
					+ "		        JOIN MEMBER USING (MEMBER_NO) "
					+ "		        WHERE BOARD_CD = " + type
					+ "		        AND BOARD_ST = 'N' "
					+ "                AND (BOARD_TITLE LIKE '%" + content + "%' OR BOARD_CONTENT LIKE '%"
					+ 						 content + "%') "
					+ "		        ORDER BY BOARD_NO DESC "
					+ "		    ) A "
					+ "		) "
					+ "		WHERE RNUM BETWEEN " +  start +  " AND  " +  end;
			
			
			/*
			 * pstmt = conn.prepareStatement(sql);
			 * 
			 * pstmt.setInt(1, type); pstmt.setString(2, select); pstmt.setString(3,
			 * content); pstmt.setInt(4, start); pstmt.setInt(5, end);
			 * 
			 * rs = pstmt.executeQuery();
			 */
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardNo(rs.getInt("BOARD_NO"));
				board.setBoardTitle(rs.getString("BOARD_TITLE"));
				board.setMemberId(rs.getString("MEMBER_ID"));
				board.setBoardDate(rs.getString("BOARD_DT"));
				
				searchBoardList.add(board);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return searchBoardList;
	}

	/** faq 목록, 상세 조회 DAO
	 * @param conn
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> faqList(Connection conn, int type) throws Exception {
		
		List<Board> boardList = new ArrayList<Board>();
		
		try {
			
			String sql = prop.getProperty("faqList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Board board = new Board();
				
				board.setBoardTitle(rs.getString(1));
				board.setBoardDate(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setBoardNo(rs.getInt(4));
				
				boardList.add(board);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}

	/** faq 삭제 DAO
	 * @param conn
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteFaq(Connection conn, int boardNo) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("deleteFaq");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 이벤트 상세조회 DAO
	 * @param conn
	 * @param eventNo
	 * @return event
	 * @throws Exception
	 */
	public Event selectEventDetail(Connection conn, int eventNo) throws Exception {
		
		Event event = null;
		
		try {
			
			String sql = prop.getProperty("selectEventDetail");
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				event = new Event();
				
				event.setEventTitle(rs.getString(1));
				event.setEventContent(rs.getString(2));
				event.setEventDt(rs.getString(3));
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return event;
	}

	/** 이벤트 상세조회 이미지 DAO
	 * @param conn
	 * @param eventNo
	 * @return imageList
	 * @throws Exception
	 */
	public List<EventImage> selelctImageList(Connection conn, int eventNo) throws Exception {
		
		List<EventImage> imageList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectImageList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EventImage image = new EventImage();
				
				image.setImageNo(rs.getInt(1));
				image.setImageRename(rs.getString(2));
				image.setImageLevel(rs.getInt(3));
				image.setEventNo(rs.getInt(4));
				
				imageList.add(image);
			}
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return imageList;
	}

	/** 업다운 FL 검사 service
	 * @param memberNo
	 * @param conn
	 * @return result
	 * @throws Exception
	 */
	public String updown(int memberNo, Connection conn) throws Exception {
		
		String result = null;
		
		try {
			
			String sql = prop.getProperty("updownFL");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getString(1);
			}
			
		} finally {
			
		}
		
		return result;
	}

	/** 게임 쿠폰 DAO
	 * @param conn
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int gameCoupon(Connection conn, int memberNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("gameCoupon");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 업다운 페이지 접속 시 FL -> Y로 업데이트 DAO
	 * @param conn
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updownFl(Connection conn, int memberNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updownFl");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	
}
