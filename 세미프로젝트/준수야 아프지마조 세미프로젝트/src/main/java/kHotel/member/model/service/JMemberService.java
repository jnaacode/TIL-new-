package kHotel.member.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import kHotel.common.Util;
import kHotel.member.model.dao.JMemberDAO;
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.Reservation;
import kHotel.member.model.vo.Review;
import kHotel.member.model.vo.ReviewImg;

public class JMemberService {

	JMemberDAO dao = new JMemberDAO();
	
	/** 회원가입 Service
	 * @param member
	 * @return result
	 * @throws Exception
	 */
	public int signUp(Member member) throws Exception {
		
		Connection conn = getConnection();
		
		
		int result = dao.signUp(conn, member);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		
		close(conn);
		
		return result;
	}

	/** 리뷰 등록 Service
	 * @param image
	 * @param rv
	 * @return result
	 * @throws Exception
	 */
	public int reviewUpdate( Review rv , ReviewImg image) throws Exception {
		
		Connection conn = getConnection();
		
		
		
		// 1) XSS 방지 처리(내용)
		rv.setContent( Util.XSSHanding(rv.getContent()));
		
		// 2) 개행 문자 처리 (내용)
		rv.setContent(Util.newLineHandling(rv.getContent()));
		
		// 리뷰 게시글 등록
		int result = dao.reviewUpdate(conn, rv );
		
		// 작성된 리뷰 게시글 번호 얻어오기
		int boardNo = dao.nextBoardNo(conn, rv);
		
		rv.setBoardNo(boardNo);
		
		if(result > 0) {
			
			// 리뷰 이미지 삽입
			result = dao.reviewImg( conn, image, rv);
			
			// 태그 삽입
			result = dao.tagUpdate1(conn, rv ) ;
		}
		
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 이전 예약 Service
	 * @param memberNo
	 * @return rv
	 * @throws Exception
	 */
	public List<Reservation> reservation(int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		 List<Reservation> rvList = dao.reservation(conn, memberNo);
		 
		
		
		 
		close(conn);
				
		return rvList;
	}

	/** 현재 예약 Service
	 * @param memberNo
	 * @return rv
	 * @throws Exception
	 */
	public List<Reservation> reservationUp(int memberNo) throws Exception {
		Connection conn = getConnection();
		
		 List<Reservation> rvList = dao.reservationUp(conn, memberNo);
		
		 
		close(conn);
				
		return rvList;
	}

	/** 현재 예약 취소 Service
	 * @param bookNo 
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int reviewCancel(int bookNo, Member loginMember) throws Exception {
		
		Connection conn = getConnection();
		
		
		
		// memberNo 얻어오기
		int memberNo = dao.getMemberNo(conn, loginMember);
		// 결제 정보 지우기
		int result = dao.deleteCalculate(conn ,memberNo, bookNo);
		
		// 현재 예약 취소
	     result = dao.reviewCancel(conn, memberNo, bookNo );
	    
	    if(result > 0 ) commit(conn);
	    else            rollback(conn);
	    
	    close(conn);
	    		
		return result;
	}

	/** 리뷰 수정 Service
	 * @param rvUpdate
	 * @param loginMember 
	 * @param updateReview 
	 * @return result
	 * @throws Exception
	 */
	public int reviewAlter(Review rvUpdate2, Member loginMember, Review updateReview) throws Exception {
		
		Connection conn = getConnection();
		
		// boardNo 얻어오기
		//int boardNo = dao.getBoardNo(conn, rvUpdate2 , loginMember);
		
		//updateReview.setBoardNo(boardNo);
		
				
		
		// 2) 개행 문자 처리(내용)
		updateReview.setContent(Util.newLineHandling(updateReview.getContent()));
		
		rvUpdate2.setContent(Util.newLineHandling(rvUpdate2.getContent()));
		
		// 게시글 수정
		int result = dao.reviewAlter(conn, rvUpdate2, loginMember, updateReview);
		
		
		if(result > 0) {
			
			// 이미지 수정
			result = dao.imgUpdate(conn, updateReview, rvUpdate2 );
			
			// 태그 수정
			result = dao.tagUpdate(conn, updateReview, rvUpdate2 );
		}
		
		if(result > 0 ) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 회원 가입을 했을 떄 이벤트 참여 여부를 N으로 넣는 Service
	 * @return event
	 * @throws Exception
	 */
	public int insertEventCheck() throws Exception {
		
		Connection conn = getConnection();
		
		// 새로운 멤버의 번호를 조회(수정한거야~)
		int memberNo = dao.selectMemberNo(conn);
		
		int event = dao.insertEventCheck(conn,memberNo);
		
		
		if(event > 0) commit(conn);
		else		  rollback(conn);
		
		return event;
	}

	/** 빙고게임 후 쿠폰 증정
	 * @param count
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int couponIn(int count, Member loginMember) throws Exception {
		
		Connection conn = getConnection();
		
		int result  = dao.couponIn( conn ,count, loginMember);
		
		if(result > 0 ) {
			
			result = dao.flUpdate(conn, loginMember);
		}
		
		if(result > 0)commit(conn);
		else		  rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 아이디 중복 검사
	 * @param memberId
	 * @return result
	 * @throws Exception
	 */
	public int idDuplicheck(String memberId) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.idDuplicheck(conn, memberId);
		
		if(result > 0)commit(conn);
		else          rollback(conn);
				
		close(conn);
		
		return result;
	}

	/** 게임 참여 여부
	 * @param loginMember
	 * @return eventFL
	 * @throws Exception
	 */
	public String eventFL(Member loginMember) throws Exception {
		
		Connection conn = getConnection();
		
		String eventFL = dao.eventFL(conn, loginMember);
		
		close(conn);
		
		return eventFL;
	}




}
