package kHotel.board.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import kHotel.board.model.dao.LBoardDAO;
import kHotel.board.model.dao.LReplyDAO;
import kHotel.board.model.vo.Reply;
import kHotel.common.Util;

public class LReplyService {

	LReplyDAO dao = new LReplyDAO();
	
	/** 댓글 목록 조회 Service
	 * @param boardNo
	 * @return rList
	 * @throws Exception
	 */
	public List<Reply> selectReplyList(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		List<Reply> rList = dao.selectReplyList(conn, boardNo);
		
		close(conn);
		
		
		
		return rList;
	}

	/** 댓글 작성 Service
	 * @param reply
	 * @return result
	 * @throws Exception
	 */
	public int insertReply(Reply reply) throws Exception{
		
		Connection conn = getConnection();
		
		// 유틸에 넣어둔 필터 XSS
		reply.setReplyContent( Util.XSSHanding ( reply.getReplyContent() ) );
		
		// 개행문자 처리
		reply.setReplyContent( Util.newLineHandling ( reply.getReplyContent() ) );
		
		
		int result = dao.insertReply(conn, reply);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		
		return result;
	}

	/** 댓글 삭제 Service
	 * @param replyNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReply(int replyNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteReply(conn, replyNo);
		
		if(result > 0) commit(conn);
		else		   rollback(conn);
		
		
		return result;
	}

	/** 댓글 수정 Service
	 * @param replyNo
	 * @param replyContent
	 * @return result
	 * @throws Exception
	 */
	public int updateReply(int replyNo, String replyContent) throws Exception{
		
		Connection conn = getConnection();
		
		replyContent = Util.XSSHanding(replyContent);
		
		replyContent = Util.newLineHandling(replyContent);
		
		int result = dao.updateReply(conn, replyNo, replyContent);
		
		if(result > 0) 	commit(conn);
		else			rollback(conn);
		
		return result;
	}

}
