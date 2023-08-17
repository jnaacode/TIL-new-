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
import kHotel.member.model.vo.Review;
import kHotel.member.model.vo.ReviewImg;

public class JMemberDAO {
	
	public JMemberDAO() {
		
		try {
			prop = new Properties();
			
			String filePath =   JMemberDAO.class.getResource("/kHotel/sql/JHotel-sql.xml").getPath(); 
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop = new Properties();


	/** 회원가입 DAO
	 * @param conn
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Connection conn, Member member) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("signUp11");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberPno());
			pstmt.setString(5, member.getMemberTel());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberAddress());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		return result;
	}


	/** 리뷰 등록 DAO
	 * @param conn
	 * @param reviewImg
	 * @param rv
	 * @return reuslt
	 * @throws Exception
	 */
	public int reviewUpdate(Connection conn, Review rv) throws Exception {
		
		int result = 0;
		
		try {
			String sql = prop.getProperty("reviewUpdate");
			
			pstmt = conn.prepareStatement(sql);
			
			
			 pstmt.setString(1, rv.getContent()); 
			pstmt.setInt(2, rv.getMemberNo());
			 pstmt.setInt(3, rv.getStar()); 
			 pstmt.setInt(4, rv.getBookNo()); 
			
			
			result = pstmt.executeUpdate();
		}finally {

			close(pstmt);
			
		}
		return result;
	}

	/** 현재 예약 내역
	 * @param conn
	 * @param memberNo
	 * @return rv
	 * @throws Exception
	 */
	public List<Reservation> reservationUp(Connection conn, int memberNo) throws Exception {
List<Reservation> rvList = new ArrayList<Reservation>();
		
		try {
			
			String sql = prop.getProperty("reservationUp");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				
				Reservation rv = new Reservation();
				
				rv.setBookNo( rs.getInt(1));
				rv.setHotelName( rs.getString(2) );
				rv.setRoomName( rs.getString(3));
				rv.setCheckInTime(rs.getString(4));
				rv.setCheckOutTime( rs.getString(5));
				rv.setCalSt(rs.getString(6));
				rv.setRoomImage(rs.getString(7));
				
				rvList.add(rv);
			}
			
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return rvList;
	}

	/** 이전 예약 DAO
	 * @param conn
	 * @param memberNo
	 * @return rv
	 * @throws Exception
	 */
	public List<Reservation> reservation(Connection conn, int memberNo) throws Exception {
		
		List<Reservation> rvList = new ArrayList<Reservation>();
		
		try {
			
			String sql = prop.getProperty("reservation");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				
				Reservation rv = new Reservation();
				
				rv.setBookNo( rs.getInt(1));
				rv.setHotelName( rs.getString(2) );
				rv.setRoomName( rs.getString(3));
				rv.setCheckInTime(rs.getString(4));
				rv.setCheckOutTime( rs.getString(5));
				rv.setRoomImage( rs.getString(6) );
				
				rvList.add(rv);
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		return rvList;
	}
	
	
	
	


	/** 다음 게시글 번호 얻어오는 DAO
	 * @param conn
	 * @param rv 
	 * @return boardNO
	 * @throws Exception
	 */
	public int nextBoardNo(Connection conn, Review rv) throws Exception {
		int boardNo = 0;
		
		try {
			String sql = prop.getProperty("nextBoardNo");

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rv.getContent());
			
			rs = pstmt.executeQuery();
			
			if(rs.next() ) {
				
				boardNo = rs.getInt(1);
				
			}
			
			
			
		}finally {
			close(pstmt);
			
		}
		return boardNo;
	}


	/** 이미지 등록 DAO
	 * @param conn 
	 * @param image
	 * @param rv
	 * @return result
	 * @throws Exception
	 */
	public int reviewImg(Connection conn, ReviewImg image, Review rv) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("reviewImg");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, image.getRename());
			pstmt.setInt(2, rv.getBoardNo());
			
			result = pstmt.executeUpdate();
			
			
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}

 
	

	public int tagUpdate1(Connection conn, Review rv) throws Exception {

		int result = 0;
		
		try {
			String sql = prop.getProperty("tagUpdate1");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rv.getTag());
			pstmt.setInt(2, rv.getBoardNo());
			
			result = pstmt.executeUpdate();
		}finally {
			
			close(pstmt);
			
		}
		return result;
	}
	
	
	


	/** MemberNo 가져오기
	 * @param conn
	 * @param loginMember
	 * @return memberNo
	 * @throws Exception
	 */
	public int getMemberNo(Connection conn, Member loginMember) throws Exception {
		int memberNo = 0;
		
		try {
			String sql = prop.getProperty("getMemberNo");
			
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


	/** 현재 예약 취소 DAO
	 * @param conn
	 * @param memberNo
	 * @param bookNo
	 * @return result
	 * @throws Exception
	 */
	public int reviewCancel(Connection conn, int memberNo, int bookNo) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("reviewCancel");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			pstmt.setInt(2, memberNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		return result;
	}


	/** 결제 정보 지우기 DAO
	 * @param conn
	 * @param memberNo
	 * @param bookNo
	 * @return result
	 * @throws Exceptione
	 */
	public int deleteCalculate(Connection conn, int memberNo, int bookNo)throws Exception {
		int result = 0;
		try {
			String sql = prop.getProperty("deleteCalculate");
			
			pstmt  = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
			
		}
		return result;
	}


	/** 리뷰 수정을 위한 boardNo 가져오기
	 * @param conn
	 * @param rvUpdate
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int getBoardNo(Connection conn, Review rvUpdate2, Member loginMember) throws Exception {
		int boardNo = 0;
		
		try {
			String sql = prop.getProperty("getBoardNo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rvUpdate2.getContent());
			pstmt.setString(2, loginMember.getMemberId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				boardNo = rs.getInt(1);
			}
			
			
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardNo;
	}


	/** 리뷰 수정 DAO
	 * @param conn
	 * @param rvUpdate
	 * @param loginMember
	 * @param updateReview 
	 * @return result
	 * @throws Exception
	 */
	public int reviewAlter(Connection conn, Review rvUpdate2, Member loginMember, Review updateReview) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("reviewAlter");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updateReview.getContent());
			pstmt.setInt(2, updateReview.getStar());
			pstmt.setInt(3, updateReview.getBoardNo());
			pstmt.setInt(4, loginMember.getMemberNo());
			pstmt.setInt(5, rvUpdate2.getStar());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
			
		}
		return result;
	}


	/** 회원 가입을 했을 떄 이벤트 참여 여부를 N으로 넣는 DAO
	 * @param conn
	 * @param memberNo 
	 * @param member
	 * @return event
	 * @throws Exception
	 */
	public int insertEventCheck(Connection conn, int memberNo) throws Exception {
		int event = 0;
		
		try {
			String sql = prop.getProperty("insertEventCheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			event = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return event;
	}


	/** 새로운 멤버의 번호를 가져오는 DAO
	 * @param conn
	 * @return
	 */
	public int selectMemberNo(Connection conn) throws Exception {
		int memberNo = 0;
		
		try {
			String sql = prop.getProperty("memberNextNo");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if( rs.next() ) {
				memberNo = rs.getInt(1);
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		
		return memberNo;
	}


	/** 리뷰 이미지 수정
	 * @param conn
	 * @param updateReview
	 * @param rvUpdate 
	 * @return result
	 * @throws Exception
	 */
	public int imgUpdate(Connection conn, Review updateReview, Review rvUpdate2) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("imgUpdate");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updateReview.getRename());
			pstmt.setInt(2,updateReview.getBoardNo());
			pstmt.setString(3, rvUpdate2.getReviewImg());
			
			
			
			result = pstmt.executeUpdate();
			
		}finally {
			close(pstmt);
		}
		return result;
	}


	/** 태그 수정
	 * @param conn
	 * @param updateReview
	 * @param rvUpdate2
	 * @return result
	 * @throws Exception
	 */
	public int tagUpdate(Connection conn, Review updateReview, Review rvUpdate2) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("tagUpdate");
			
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setString( 1, updateReview.getTag());
			pstmt.setInt(2, updateReview.getBoardNo());
			pstmt.setString(3, rvUpdate2.getTag());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		
		
		return result;
	}


	/** 빙고게임 후 쿠폰 증정
	 * @param conn 
	 * @param count
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int couponIn(Connection conn, int count, Member loginMember) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("couponIn");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
					
		}finally {
			close(pstmt);
			
		}
		return result;
	}


	/** 아이디 중복 검사
	 * @param conn 
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDuplicheck(Connection conn, String memberId) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("idDuplicheck");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				result = rs.getInt(1);
			}
			
		}finally {
			close(pstmt);
		}
		
		return result;
	}


	/** 이벤트 참여여부
	 * @param conn 
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int flUpdate(Connection conn, Member loginMember) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("flUpdate");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMember.getMemberNo());
			
			result = pstmt.executeUpdate();
			
		}finally {
			
			close(pstmt);
		}
		return result;
	}


	/** 게임 참여 여부 가져오기
	 * @param conn
	 * @param loginMember
	 * @return eventLF
	 * @throws Exception
	 */
	public String eventFL(Connection conn, Member loginMember) throws Exception{
		
		String eventFL = "";
		
		try {
			String sql = prop.getProperty("eventFL");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, loginMember.getMemberNo());
			
			rs = pstmt.executeQuery();
			
			
			if( rs.next() ) {
				
				eventFL = rs.getString(1);
			}
			
		}finally {
			
		}
		return eventFL;
	}


	


	


}
