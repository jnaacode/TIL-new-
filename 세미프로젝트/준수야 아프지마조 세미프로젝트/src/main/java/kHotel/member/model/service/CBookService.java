package kHotel.member.model.service;

import static kHotel.common.JDBCTemplate.commit;
import static kHotel.common.JDBCTemplate.rollback;
import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kHotel.board.model.vo.Board;
import kHotel.common.Util;
import kHotel.member.model.dao.CBookDAO;
import kHotel.member.model.vo.CPagination;
import kHotel.member.model.vo.LPagination;
import kHotel.member.model.vo.Reservation;

public class CBookService {

	private CBookDAO dao = new CBookDAO();


	/** 객실 조회 Service
	 * @param reservation
	 * @return roomNo
	 * @throws Exception
	 */
	public int searchRoom(Reservation reservation) throws Exception {
		
		Connection conn = getConnection();
		
		int roomNo = dao.searchRoom(conn,reservation);
		
		close(conn);
		
		return roomNo;
		
	}


	/** 객실 가격 정보 Service 
	 * @param reservation
	 * @return roomPrice
	 * @throws Exception
	 */
	public int searchRoomPrice(Reservation reservation) throws Exception{
		
		Connection conn = getConnection();
		
		int roomPrice = dao.searchRoomPrice(conn,reservation);
		
		close(conn);
		
		return roomPrice;
	}


	/** 예약 가능한 객실인지 확인하는 Service
	 * @param reservation
	 * @return result
	 * @throws Exception
	 */
	public int searchCheckInStatus(Reservation reservation) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.searchCheckInStatus(conn, reservation);
		
		close(conn);
		
		return result;
	}


	/** 관리자 예약 리스트 보여주는 Service
	 * @return rsvList
	 * @throws Exception
	 */
	public List<Reservation> selectRsvList() throws Exception {
		
		Connection conn = getConnection();
		
		
		List<Reservation> rsvList = dao.selectRsvList(conn);
		
		close(conn);
		
		return rsvList;
	}


	/** 관리자 이전 예약 리스트 보여주는 Service
	 * @return rsvList2
	 * @throws Exception
	 */
	public List<Reservation> selectRsvList2() throws Exception{
		
		Connection conn = getConnection();
		
		List<Reservation> rsvList2 = dao.selectRsvList2(conn);
		
		close(conn);
		
		return rsvList2;
	}


	/** 예약 취소 Service
	 * @param bookNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReservation(int bookNo) throws Exception {
		
		Connection conn = getConnection();
		
		int delete = dao.deleteCalculate(conn, bookNo);
		
		int	result = dao.deleteReservation(conn, bookNo);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		close(conn);
		
		
		return result;
	}


	/** 게시글 작성 Service
	 * @param insert
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Board insert) throws Exception {
		
		Connection conn = getConnection();
		
		insert.setBoardTitle( Util.XSSHanding( insert.getBoardTitle() ));
		insert.setBoardContent( Util.XSSHanding( insert.getBoardContent() ));
		insert.setBoardContent(Util.newLineHandling(insert.getBoardContent()));
		
		int result = dao.insertBoard(conn,insert);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
	}


	/** 게시글 수정 Service
	 * @param board
	 * @param type 
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Board board, int type) throws Exception{
		
		Connection conn = getConnection();
		
		board.setBoardTitle(Util.XSSHanding(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHanding(board.getBoardContent()));
		board.setBoardContent(Util.newLineHandling(board.getBoardContent()));
		
		int result = dao.updateBoard(conn,board,type);
		
		if(result > 0)	commit(conn);
		else			rollback(conn);
		
		return result;
	}


	/** 쿠폰 조회 Service
	 * @param memberNo 
	 * @param cp 
	 * @return couponList
	 * @throws Exception
	 */
	public Map<String, Object> selectCouponList(int memberNo, int cp) throws Exception {
		
		Connection conn = getConnection();
		
		int listCount = dao.selectCoupon(conn);
		
		CPagination pagination = new CPagination(cp,listCount);
		
		List<Reservation> couponList = dao.selectCouponList(conn,memberNo,pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("couponList", couponList);
		
		
		close(conn);
		
		return	map;
	}


	/** 쿠폰이 있는지 확인하는 Service(쿠폰의 갯수로)
	 * @param reservation
	 * @return couponCount
	 * @throws Exception
	 */
	public int selectCouponCount(Reservation reservation) throws Exception {
		
		Connection conn = getConnection();
		
		int couponCount = dao.selectCouponCount(conn, reservation);
		
		close(conn);
		
		return couponCount;
	}


	/** 쿠폰 가격 가져오는 Service
	 * @param reservation
	 * @return money
	 * @throws Exception
	 */
	public int selectMoney(Reservation reservation) throws Exception{
		
		Connection conn = getConnection();
		
		int money = dao.selectMoney(conn, reservation);
		
		close(conn);
		
		return money;
	}


	/** 회원 탈퇴 Service
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 */
	public int deleteMember(int memberNo, String memberPw) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteMember(conn, memberPw, memberNo);
		
		if(result > 0) 	commit(conn);
		else 			rollback(conn);
		
		
		close(conn);
		
		return result;
		
	}


	/** 공지사항 삭제 Service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteAdminBoard(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteAdminBoard(conn, boardNo);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		return result;
	}


	/** 공지사항 수정 service
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int updateAdminboard(Board board) throws Exception{
		
		Connection conn = getConnection();
		
		board.setBoardTitle(Util.XSSHanding(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHanding(board.getBoardContent()));
		board.setBoardContent(Util.newLineHandling(board.getBoardContent()));
		
		int result = dao.updateAdminboard(conn, board);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
	
		return result;
	}


	/** 찜 목록을 가져오는 Service
	 * @param memberNo
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectlikeList(int memberNo, int cp) throws Exception{
		
		Connection conn = getConnection();
		
		int listCount = dao.selectLikePage(conn,memberNo);
		
		CPagination pagination = new CPagination(cp,listCount);
		
		List<Reservation> likeList = dao.selectlikeList(conn,memberNo,pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("likeList", likeList);
		
		close(conn);
		
		return	map;
	}

	
}
