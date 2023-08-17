package kHotel.board.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kHotel.admin.model.vo.HAdminBoard;
import kHotel.board.model.dao.HBoardDAO;
import kHotel.board.model.vo.AnnouncementDetail;
import kHotel.board.model.vo.Board;
import kHotel.common.Util;
import kHotel.member.model.vo.LPagination;

public class HBoardService {
	
	private HBoardDAO dao = new HBoardDAO();

	/** 게시글 이름 조회
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> checkBoardList(int type, int cp) throws Exception{
		
		Connection conn = getConnection();
		
		String boardName = dao.selectBoardName(conn, type); //
		
		int listCount = dao.getListCount(conn, type); //
		
		LPagination pagination = new LPagination(cp, listCount); //listCount
		
		List<Board> boardList = dao.checkBoardList(conn, pagination, type); // type
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		
		return map;
	}


	/** 게시글 조회
	 * @param boardNo
	 * @return detail
	 * @throws Exception
	 */
	public AnnouncementDetail checkBoardDetail(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		AnnouncementDetail detail = dao.checkBoardDetail(conn, boardNo);
		
	
		return detail;
		
	}

	/** 공지사항 목록 조회
	 * @return boardList
	 * @throws Exception
	 */
	public List<HAdminBoard> selectBoardList() throws Exception {
		
		Connection conn = getConnection();
		
		List<HAdminBoard> boardList = dao. selectBoardList(conn);
		
		close(conn);
		
		return boardList;
	}



	/** 공지사항 상세페이지
	 * @param boardNo
	 * @return board
	 * @throws Exception
	 */
	public Board BoardDetail(int boardNo) throws Exception{
		
		Connection conn = getConnection();
		
		Board board = dao.BoardDetail(conn, boardNo);
		
		close(conn);
		
		return board;
	}


	/** 공지사항 수정
	 * @param board
	 * @return result
	 * @throws Exception
	 */
	public int updateBoard(Board board) throws Exception {
		
	    Connection conn = getConnection();
	    
	    board.setBoardTitle(Util.XSSHanding(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHanding(board.getBoardContent()));
		board.setBoardContent(Util.newLineHandling(board.getBoardContent()));
	    
	    int result = dao.updateBoard(conn, board);
	
	    if (result > 0) commit(conn);   
	    else 			rollback(conn);

	    return result;
	}

	/** 공지사항 작성
	 * @param boardContent 
	 * @param boardTitle 
	 * @return result
	 * @throws Exception
	 */
	public int insertBoard(Board board) throws Exception {
		
		Connection conn = getConnection();
		
		board.setBoardTitle(Util.XSSHanding(board.getBoardTitle()));
		board.setBoardContent(Util.XSSHanding(board.getBoardContent()));
		
		board.setBoardContent(Util.newLineHandling(board.getBoardContent()));
		
		int result = dao.insertBoard(conn , board);
				
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}







}