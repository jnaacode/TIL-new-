package kHotel.board.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;

import kHotel.board.model.dao.LBoardDAO;
import kHotel.board.model.vo.Board;

public class LBoardService {
	
	LBoardDAO dao = new LBoardDAO();


	/** 게시글 상세페이지 Service
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board selectBoardDetail(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		Board board = dao.selectBoardDetail(conn, boardNo);
		
		close(conn);
		
		return board;
	}


	/** 게시글 삭제 Service
	 * @param type
	 * @return result
	 * @throws Exception
	 */
	public int deleteBoard(int no) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, no);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		return result;
	}

}
