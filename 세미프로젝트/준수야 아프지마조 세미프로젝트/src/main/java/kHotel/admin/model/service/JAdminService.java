package kHotel.admin.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;

import kHotel.admin.model.dao.JAdminDAO;
import kHotel.admin.model.vo.HAdminBoard;
import kHotel.admin.model.vo.PAdminMemebr;
import kHotel.common.Util;
import kHotel.member.model.vo.Member;

public class JAdminService {

	JAdminDAO dao = new JAdminDAO();
	
	/** FAQ 작성
	 * @param loginMember
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int FAQUpdate(Member loginMember, HAdminBoard board) throws Exception {
		
		Connection conn = getConnection();
		
		// memberNo 가져오기
		int memberNo = dao.getMemberNo(conn ,loginMember);
		
		// 1) XSS 방지 처리(내용)
				board.setBoardTitle( Util.XSSHanding(board.getBoardTitle()));
				
				// 2) 개행 문자 처리 (내용)
				board.setBoardContent(Util.newLineHandling(board.getBoardContent()));
		
		// FAQ 작성
		int result = dao.FAQUpdate(conn, memberNo, board);
		
		
		
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		
		return result;
	}

	/** FAQ 수정
	 * @param before
	 * @param after
	 * @param loginMember
	 * @return result
	 * @throws Exception
	 */
	public int FAQAlter(HAdminBoard before, HAdminBoard after, Member loginMember) throws Exception {
		
		Connection conn = getConnection();
		
		// boardNo 가져오기
		int boardNo = dao.getFAQBoardNo(conn , before , loginMember);
		
		// 1) XSS 방지 처리(내용)
		after.setBoardTitle(Util.XSSHanding(after.getBoardTitle()));
				
		// 2) 개행 문자 처리(내용)
		after.setBoardTitle(Util.XSSHanding(after.getBoardTitle()));
		
		after.setBoardContent(Util.newLineHandling(after.getBoardContent()));
		
		int result = dao.FAQAlter(conn, before, loginMember, after, boardNo);
		
	
		
		if(result > 0)commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
