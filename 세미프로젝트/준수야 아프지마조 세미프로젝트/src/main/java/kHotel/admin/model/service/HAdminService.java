package kHotel.admin.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kHotel.admin.model.dao.HAdminDAO;
import kHotel.board.model.dao.HBoardDAO;
import kHotel.board.model.vo.AnnouncementDetail;
import kHotel.board.model.vo.Board;
import kHotel.member.model.vo.LPagination;

public class HAdminService {
	
	private HAdminDAO dao = new HAdminDAO();

	/** 게시글 이름 조회
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> checkBoardList(int type, int cp) throws Exception{
		
		Connection conn = getConnection();
		
		String boardName = dao.selectBoardName(conn, type);
		
		int listCount = dao.getListCount(conn, type);
		
		LPagination pagination = new LPagination(cp, listCount);
		
		List<Board> boardList = dao.checkBoardList(conn, pagination, type);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		
		return map;
	}

	/** 게시글 검색
	 * @param type
	 * @param cp
	 * @param key
	 * @param query
	 * @return
	 */
	public Map<String, Object> searchBoardList(int type, int cp, String key, String query) {
		// TODO Auto-generated method stub
		return null;
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


}