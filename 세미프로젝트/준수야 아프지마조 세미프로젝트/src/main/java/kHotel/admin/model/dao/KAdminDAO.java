package kHotel.admin.model.dao;

import static kHotel.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kHotel.board.model.vo.Board;
import kHotel.board.model.vo.Event;
import kHotel.board.model.vo.EventImage;

public class KAdminDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public KAdminDAO() {
		try {
			prop = new Properties();
			
			String filePath =   KAdminDAO.class.getResource("/kHotel/sql/KAdmin-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** faq 목록 조회(관리자) DAO
	 * @param conn
	 * @param type
	 * @return fList
	 * @throws Exception
	 */
	public List<Board> fList(Connection conn, int type) throws Exception {
		
		List<Board> fList = new ArrayList<Board>();
		
		try {
			
			String sql = prop.getProperty("fList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board board = new Board();
				
				board.setBoardTitle(rs.getString(1));
				board.setBoardDate(rs.getString(2));
				board.setBoardContent(rs.getString(3));
				board.setBoardNo(rs.getInt(4));
				
				fList.add(board);
			}
			
		} finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return fList;
	}

	/** 이벤트 번호 조회 DAO
	 * @param conn
	 * @return eventNo
	 * @throws Exception
	 */
	public int setEventNo(Connection conn) throws Exception {
		
		int eventNo = 0;
		
		try {
			
			String sql = prop.getProperty("setEventNo");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()) {
				eventNo = rs.getInt(1);
				
			}
			
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return eventNo;
	}

	/** 이벤트 게시글 삽입 DAO
	 * @param conn
	 * @param event
	 * @return result 
	 * @throws Exception
	 */
	public int insertEvent(Connection conn, Event event) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertEvent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, event.getEventNo());
			pstmt.setString(2, event.getEventTitle());
			pstmt.setString(3, event.getEventContent());
			pstmt.setString(4, event.getEventDt());
			
			result = pstmt.executeUpdate();
			
			//TO_CHAR(ENROLL_DT,'YYYY-MM-DD HH24:MI:SS')
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 이벤트 이미지 삽입 DAO
	 * @param conn
	 * @param imageList
	 * @return result 
	 * @throws Exception
	 */
	public int insertEventImage(Connection conn, EventImage image) throws Exception {
		
		int result = 0;
		
		try {
					
			String sql = prop.getProperty("insertEventImage");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, image.getImageRename());
			pstmt.setInt(2, image.getImageLevel());
			pstmt.setInt(3, image.getEventNo());
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 이벤트 수정(내용, 제목) DAO
	 * @param conn
	 * @param event
	 * @return result
	 * @throws Exception
	 */
	public int updateContent(Connection conn, Event event) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateContent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, event.getEventTitle());
			pstmt.setString(2, event.getEventContent());
			pstmt.setString(3, event.getEventDt());
			pstmt.setInt(4, event.getEventNo());
			
			result = pstmt.executeUpdate();

			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 이벤트 이미지 수정(update) DAO
	 * @param conn
	 * @param image
	 * @return result
	 * @throws Exception
	 */
	public int updateImage(Connection conn, EventImage image) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("updateImage");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, image.getImageRename());
			pstmt.setInt(2, image.getEventNo());
			pstmt.setInt(3, image.getImageLevel());
			
			result = pstmt.executeUpdate();

			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	/** 이벤트 수정 이미지 삭제 DAO
	 * @param conn
	 * @param deleteList
	 * @param eventNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteImage(Connection conn, String deleteList, int eventNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteImage") + deleteList + ")";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			result = pstmt.executeUpdate();

		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/** 이벤트 삭제 DAO
	 * @param conn
	 * @param eventNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteEvent(Connection conn, int eventNo) throws Exception {
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteEvent");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, eventNo);
			
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	

}
