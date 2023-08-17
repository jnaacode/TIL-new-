package kHotel.member.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kHotel.board.model.vo.Board;
import kHotel.member.model.vo.CPagination;
import kHotel.member.model.vo.Reservation;

import static kHotel.common.JDBCTemplate.*;

public class CBookDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	// 기본 생성자
		public CBookDAO() {
			try {
				prop = new Properties();
				
				String filePath =  CBookDAO.class.getResource("/kHotel/sql/CBook-sql.xml").getPath(); 
				
				prop.loadFromXML(new FileInputStream(filePath));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/** 객실 조회 DAO
		 * @param conn
		 * @param reservation
		 * @throws Exception
		 */
		public int searchRoom(Connection conn, Reservation reservation) throws Exception{
			
			int roomNo = 0;
			
			try {
				String sql = prop.getProperty("selectRoomNo");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, reservation.getHotelName() );
				pstmt.setString(2, reservation.getRoomName() );
				
				rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					roomNo = ( rs.getInt("ROOM_NO") );
				}
				
				
				
			} finally {
				close(rs);
				close(pstmt);
			}
			
			
			
			return roomNo;
			
		}

		/** 객실 가격 조회 DAO
		 * @param conn
		 * @param reservation
		 * @return roomPrice
		 * @throws Exception
		 */
		public int searchRoomPrice(Connection conn, Reservation reservation) throws Exception {
			int roomPrice = 0;
			
			try {
				String sql = prop.getProperty("selectRoomPrice");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, reservation.getRoomName() );
				
				rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					roomPrice = rs.getInt("ROOM_PRICE") ;
				}
				
				
			} finally {
				close(rs);
				close(pstmt);
			}
			return roomPrice;
		}

		/** 예약 가능한 객실인지 확인 DAO
		 * @param conn
		 * @param reservation
		 * @return result
		 * @throws Exception
		 */
		public int searchCheckInStatus(Connection conn, Reservation reservation) throws Exception {
			int result = 0;
			
			try {
				String sql = prop.getProperty("reservationCheck");
				
				 pstmt = conn.prepareStatement(sql);
				 
				 pstmt.setString(1, reservation.getCheckInTime() );
				 pstmt.setString(2, reservation.getCheckOutTime() );
				 pstmt.setInt(3, reservation.getRoomNo() );
				 rs = pstmt.executeQuery();
				 
				 if( rs.next() ) {
					 result = rs.getInt(1);
				 }
				
			} finally {
				close(rs);
				close(pstmt);
			}
			return result;
		}

		/** 관리자 예약 리스트 보여주는 DAO
		 * @param conn
		 * @return rsvList
		 * @throws Exception
		 */
		public List<Reservation> selectRsvList(Connection conn) throws Exception{
			
			List<Reservation> rsvList = new ArrayList<Reservation>();
			
			try {
				String sql = prop.getProperty("selectrsvList");
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				
				while( rs.next() ) {
					Reservation rsv = new Reservation();
					
					rsv.setBookNo( rs.getInt(1) );
					rsv.setCheckInTime( rs.getString(2) );
					rsv.setCheckOutTime(rs.getString(3) );
					rsv.setRoomName( rs.getString(4) );
					rsv.setMemberName( rs.getString(5) );
					rsv.setHotelName( rs.getString(6));
					
					
					rsvList.add(rsv);
				}
				
			} finally {
				close(rs);
				close(stmt);
			}
			
			
			return rsvList;
		}

		/** 관리자 이전 예약 리스트 보여주는 DAO
		 * @param conn
		 * @return rsvList
		 * @throws Exception
		 */
		public List<Reservation> selectRsvList2(Connection conn) throws Exception {
			
			List<Reservation> rsvList2 = new ArrayList<Reservation>();

			try {
				String sql = prop.getProperty("selectrsvList2");

				stmt = conn.createStatement();

				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					
					Reservation rsv2 = new Reservation();

					rsv2.setBookNo(rs.getInt(1));
					rsv2.setCheckInTime(rs.getString(2));
					rsv2.setCheckOutTime(rs.getString(3));
					rsv2.setRoomName(rs.getString(4));
					rsv2.setMemberName(rs.getString(5));
					rsv2.setHotelName(rs.getString(6));

					rsvList2.add(rsv2);
				}

			} finally {
				close(rs);
				close(stmt);
			}

			return rsvList2;
		}

		/** 예약 취소 DAO
		 * @param bookNo
		 * @return result
		 * @throws Exception
		 */
		
		public int deleteReservation(Connection conn, int bookNo) throws Exception{
			int result = 0;
			
			try {
				String sql = prop.getProperty("deleteReservation");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, bookNo); 
				
				result = pstmt.executeUpdate();
				
			} finally {
				close(pstmt);
			}
			
			return result;
		}

		/** 게시글 작성 DAO
		 * @param conn
		 * @param insert
		 * @return result
		 * @throws Exception
		 */
		public int insertBoard(Connection conn, Board insert) throws Exception {
			
			int result = 0;
			
			try {
				
				String sql = prop.getProperty("insertBoard");
				
				pstmt= conn.prepareStatement(sql);
				
				pstmt.setString(1, insert.getBoardTitle());
				pstmt.setString(2, insert.getBoardContent());
				pstmt.setInt(3, insert.getMemberNo());
				
				result = pstmt.executeUpdate();

			} finally {
				close(pstmt);
			}
			
			
			return result;
		}

		/** 게시글 수정 DAO
		 * @param conn
		 * @param board
		 * @param type 
		 * @return result
		 * @throws Exception
		 */
		public int updateBoard(Connection conn, Board board, int type) throws Exception{
			int result = 0;
			
			try {
				String sql = prop.getProperty("updateBoard");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, board.getBoardTitle() );
				pstmt.setString(2, board.getBoardContent() );
				pstmt.setInt(3, board.getBoardNo() );
				pstmt.setInt(4, type);
				
				result = pstmt.executeUpdate();
				
				/*SET BOARD_TITLE = ?, BOARD_CONTENT = ?
				WHERE BOARD_NO = ?
				AND BOARD_CD = ?*/
				
			} finally {
				close(pstmt);
			}
			
			
			return result;
		}

		/** 쿠폰 조회 DAO
		 * @param conn
		 * @param memberNo 
		 * @param pagination 
		 * @return couponList
		 * @throws Exception
		 */
		public List<Reservation> selectCouponList(Connection conn, int memberNo, CPagination pagination) throws Exception {
			
			List<Reservation> couponList = new ArrayList<Reservation>();
			
			try {
				int start = (pagination.getCurrentPage()-1) * pagination.getLimit() +1;
				
				int end = start + pagination.getLimit() -1;
				
				String sql = prop.getProperty("selectCouponList");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, memberNo);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rs = pstmt.executeQuery();
				
				while( rs.next() ) {
					
					Reservation coupon = new Reservation();
					
					coupon.setCouponName(rs.getString("COUPON_NM"));
					coupon.setCouponDate(rs.getString("COUPON_DT"));
					
					couponList.add(coupon);
					
				}
				
			} finally {
				close(rs);
				close(pstmt);
			}
			
			
			return couponList;
		}

		/** 쿠폰이 있는지 확인하는 Service(쿠폰의 갯수로)
		 * @param conn
		 * @param reservation
		 * @return couponCount
		 * @throws Exception
		 */
		public int selectCouponCount(Connection conn, Reservation reservation) throws Exception {
			int couponCount = 0;
			
			try {
				String sql = prop.getProperty("selectCouponCount");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, reservation.getMemberNo() );
				
				rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					reservation.setCouponCount(rs.getInt(1));
					
					couponCount = reservation.getCouponCount();
				}
			
			} finally {
				close(rs);
				close(pstmt);
			}
			
			
			return couponCount;
		}

		/** 가격 조회 DAO
		 * @param conn
		 * @param reservation
		 * @return money
		 * @throws Exception
		 */
		public int selectMoney(Connection conn, Reservation reservation) throws Exception {
			int money = 0;
			
			try {
				String sql = prop.getProperty("selectMoney");
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					reservation.setCouponSale(rs.getInt(1));
					
					money = reservation.getCouponSale();
				}
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return money;
		}

		/** 회원 탈퇴 DAO
		 * @param conn
		 * @param memberPw
		 * @param memberNo
		 * @return result
		 * @throws Exception
		 */
		public int deleteMember(Connection conn, String memberPw, int memberNo) throws Exception {
			
			int result = 0;
			
			try {
				String sql = prop.getProperty("deleteMember");

				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, memberNo);
				pstmt.setString(2, memberPw);
				
				result = pstmt.executeUpdate();
				
			} finally {
				close(pstmt);
			}
			
			return result;
		}

		/** 페이지네이션 하기 위해서 쿠폰리스트 얻어오기
		 * @param conn
		 * @return listCount
		 * @throws Exception
		 */
		public int selectCoupon(Connection conn) throws Exception {
			int listCount = 0;
			
			try {
				String sql = prop.getProperty("selectCoupon");
				
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

		/** 공지사항 삭제 DAO
		 * @param conn
		 * @param boardNo
		 * @return result
		 * @throws Exception
		 */
		public int deleteAdminBoard(Connection conn, int boardNo) throws Exception {
			
			int result = 0;
			
			try {
				
				String sql = prop.getProperty("deleteadminBoard");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, boardNo);
				
				result = pstmt.executeUpdate();
				
				
			} finally {
				close(pstmt);
			}
			
			return result;
		}

		/** 공지사항 수정 dao
		 * @param conn
		 * @param board
		 * @return result
		 * @throws Exception
		 */
		public int updateAdminboard(Connection conn, Board board) throws Exception {
			int result = 0;
			
			 try {
				String sql = prop.getProperty("updateAdminboard");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, board.getBoardTitle());
				pstmt.setString(2, board.getBoardContent());
				pstmt.setInt(3, board.getBoardNo());
				
				result = pstmt.executeUpdate();
				 
			} finally {
				close(pstmt);
			}
			
			return result;
		}

		/** 찜목록 가져오는 DAO
		 * @param conn
		 * @param memberNo
		 * @return listCount
		 * @throws Exception
		 */
		public int selectLikePage(Connection conn, int memberNo) throws Exception {
			
			int listCount = 0;
			
			try {
				String sql = prop.getProperty("selectLikeList");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, memberNo);
				
				rs = pstmt.executeQuery();
				
				if( rs.next() ) {
					listCount = rs.getInt(1);
				}
				
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return listCount;
		}

		/** 찜목록
		 * @param conn
		 * @param memberNo
		 * @param pagination
		 * @throws Exception
		 * @return likeList
		 */
		public List<Reservation> selectlikeList(Connection conn, int memberNo, CPagination pagination) throws Exception {
			
			List<Reservation> likeList = new ArrayList<Reservation>();
			
			try {
				int start = (pagination.getCurrentPage()-1) * pagination.getLimit() +1;
				
				int end = start + pagination.getLimit() -1;
				
				String sql = prop.getProperty("selectlikeList");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, memberNo);
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
				
				rs = pstmt.executeQuery();
				
				while( rs.next() ) {
					
					Reservation rsv = new Reservation();
					
					rsv.setHotelName(rs.getString("HOTEL_TITLE"));
					rsv.setRoomName(rs.getString("ROOM_NM"));
					rsv.setRoomPrice(rs.getInt("ROOM_PRICE"));
					rsv.setRoomImage(rs.getString("ROOM_IMG"));
					
					likeList.add(rsv);
				
					
				}
			} finally {
				close(rs);
				close(pstmt);
			}
			
			return likeList;
		}
		
		/** 관리자 예약 지우기 전에 자식레코드 calculate먼저 지우기
		 * @param conn 
		 * @param bookNo
		 * @return result
		 * @throws Exception
		 */
		public int deleteCalculate(Connection conn, int bookNo) throws Exception {
			
			int result = 0;
			
			try {
				String sql = prop.getProperty("deleteCalculate");
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, bookNo);
				
				result = pstmt.executeUpdate();
				
			} finally {
				close(pstmt);
			}
			
			
			return result;
		}
		
}

