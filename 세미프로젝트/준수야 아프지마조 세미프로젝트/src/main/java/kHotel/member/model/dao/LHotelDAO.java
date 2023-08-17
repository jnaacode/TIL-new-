package kHotel.member.model.dao;

import static kHotel.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import kHotel.member.model.vo.LikeList;

public class LHotelDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
	public LHotelDAO() {
		try {
			prop = new Properties();
			
			String filePath =   LMemberDAO.class.getResource("/kHotel/sql/LHotel-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/** -----------------------찜하기 1번 객실 번호 조회 DAO
	 * @param conn 
	 * @param lk
	 * @return roomNo
	 * @throws Exception
	 */
	public int searchRoomNo(Connection conn, LikeList lk) throws Exception{
		
		int roomNo = 0;
		
		try {
			
			String sql = prop.getProperty("searchRoomNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lk.getHotelNm1());
			pstmt.setString(2, lk.getRoomNm1());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				roomNo = rs.getInt("ROOM_NO");
			}
			
			
		}finally {

			close(rs);
			close(pstmt);
			
		}
		
		return roomNo;
	}


	/** ************************찜목록 추가 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo
	 * @return result
	 * @throws Exception
	 */
	public int insertLikeList(Connection conn, LikeList lk, int roomNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertLikeList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo);
			pstmt.setInt(2, lk.getMemberNo());
			
			result = pstmt.executeUpdate();
			
			
			
			
		}finally {
			close(pstmt);
			
		}
		
		
		return result;
	}


	/** 찜삭제 1번 객실 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteLikeList(Connection conn, LikeList lk, int roomNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteLikeList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo);
			pstmt.setInt(2, lk.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}


	/** !!!!!!!!!!!!!!!!!!!!!!!!찜 여부 확인 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo
	 * @return count
	 * @throws Exception
	 */
	public int likeCount(Connection conn, LikeList lk, int roomNo) throws Exception{
		
		int count = 0;
		
		try {
			
			String sql = prop.getProperty("likeCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lk.getMemberNo());
			pstmt.setInt(2, roomNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return count;
	}


	/** --------------찜하기 2번 객실 번호 조회 DAO
	 * @param conn
	 * @param lk
	 * @return roomNo2
	 * @throws Exception
	 */
	public int searchRoomNo2(Connection conn, LikeList lk) throws Exception{
		
		int roomNo2 = 0;
		
		try {
			
			String sql = prop.getProperty("searchRoomNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lk.getHotelNm1());
			pstmt.setString(2, lk.getRoomNm2());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				roomNo2 = rs.getInt("ROOM_NO");
			}
			
			
		}finally {

			close(rs);
			close(pstmt);
			
		}
		
		return roomNo2;
	}


	/** ******************객실 2번 찜목록 추가 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo2
	 * @return
	 * @throws Exception
	 */
	public int insertLikeList2(Connection conn, LikeList lk, int roomNo2) throws Exception{
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertLikeList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo2);
			pstmt.setInt(2, lk.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}


	/** 찜삭제 2번 객실 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo2
	 * @return result
	 * @throws Exception
	 */
	public int deleteLikeList2(Connection conn, LikeList lk, int roomNo2) throws Exception{

		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteLikeList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo2);
			pstmt.setInt(2, lk.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		
		
		return result;
		
	}


	/** !!!!!!!!!!!!!!!!!!!!!!!!!!찜 여부 확인2 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo2
	 * @return count2
	 * @throws Exception
	 */
	public int likeCount2(Connection conn, LikeList lk, int roomNo2) throws Exception{
		
		int count2 = 0;
		
		try {
			
			String sql = prop.getProperty("likeCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lk.getMemberNo());
			pstmt.setInt(2, roomNo2);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count2 = rs.getInt(1);
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return count2;
	}


	/** --------------찜하기 3번 객실 번호 조회 DAO
	 * @param conn
	 * @param lk
	 * @return roomNo3
	 * @throws Exception
	 */
	public int searchRoomNo3(Connection conn, LikeList lk) throws Exception{
		
		int roomNo3 = 0;
		
		try {
			
			String sql = prop.getProperty("searchRoomNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, lk.getHotelNm1());
			pstmt.setString(2, lk.getRoomNm3());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				roomNo3 = rs.getInt("ROOM_NO");
			}
			
			
		}finally {
			

			close(rs);
			close(pstmt);
			
		}
		
		return roomNo3;
	}


	
	
	/** ******************객실 3번 찜목록 추가 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo3
	 * @return
	 * @throws Exception
	 */
	public int insertLikeList3(Connection conn, LikeList lk, int roomNo3) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("insertLikeList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo3);
			pstmt.setInt(2, lk.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}


	
	/** 찜삭제 3번 객실 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo3
	 * @return result
	 * @throws Exception
	 */
	public int deleteLikeList3(Connection conn, LikeList lk, int roomNo3) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("deleteLikeList");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, roomNo3);
			pstmt.setInt(2, lk.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		
		return result;
	}

	/** !!!!!!!!!!!!!!!!!!!!!!!!!!찜 여부 확인3 DAO
	 * @param conn
	 * @param lk
	 * @param roomNo3
	 * @return count3
	 * @throws Exception
	 */
	public int likeCount3(Connection conn, LikeList lk, int roomNo3) throws Exception {
		int count3 = 0;
		
		try {
			
			String sql = prop.getProperty("likeCount");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lk.getMemberNo());
			pstmt.setInt(2, roomNo3);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count3 = rs.getInt(1);
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return count3;
	}

}
