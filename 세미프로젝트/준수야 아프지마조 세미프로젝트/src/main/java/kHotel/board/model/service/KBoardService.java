package kHotel.board.model.service;

import java.sql.Connection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kHotel.board.model.dao.KBoardDAO;
import kHotel.board.model.vo.Board;
import kHotel.board.model.vo.Event;
import kHotel.board.model.vo.EventImage;
import kHotel.member.model.vo.LPagination;
import kHotel.member.model.vo.Member;

import static kHotel.common.JDBCTemplate.*;

public class KBoardService {
	
	KBoardDAO dao = new KBoardDAO();

	/** qna 리스트 service
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> qna(int type, int cp) throws Exception {
		
		Connection conn = getConnection();
		
		// 1. 게시판 이름 조회(관리자 헤더 때문)
		String boardName = dao.getBoardName(conn, type);
		
		// 2-1. 특정 게시판 전체 게시글 수 조회 DAO 호출
		int listCount = dao.getListCount(conn, type);
		
		// 2-2. 전체 게시글 수 + 현재 페이지(cp)를 이용해 페이지네이션 객체 생성
		LPagination pagination = new LPagination(cp, listCount);
		
		// 3. 게시글 목록 조회
		List<Board> boardList = dao.selectBoardList(conn, pagination, type);
		
		// 4. Map 객체를 생성하여 1,2,3 결과 객체를 모두 저장
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardName);
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		return map;
	}

	/** qna 검색 service
	 * @param select
	 * @param content
	 * @param type
	 * @param cp
	 * @return searchMap
	 * @throws Exception
	 */
	public Map<String, Object> qnaSearch(String select, String content, int type, int cp) throws Exception {
		
		Connection conn = getConnection();
		
		int listCount = 0;
		
		// 1. 검색 조건에 맞는 전체 글 수 조회
		if(select.equals("1")) {
			listCount = dao.AgetgetListCount(content, conn, type);
		} else {
			listCount = dao.getListCount(select, content, conn, type);
		}
		
		
		// 2. 전체 글 수 + 페이지네이션...?
		LPagination pagination = new LPagination(cp, listCount); // 오류나면 여기부터 확인해바..
		
		// 3. 게시글 목록 조회
		List<Board> boardList = null;
		if(select.equals("1")) {
			boardList = dao.selectBoardList(content, conn, pagination, type);
		} else {
			boardList = dao.selectBoardList(select, content, conn, pagination, type);
		}
		
		// 4. map에 모든 결과 저장
		Map<String, Object> searchMap = new HashMap<String, Object>();
		
		searchMap.put("pagination", pagination);
		searchMap.put("boardList", boardList);
		
		close(conn);
		
		
		return searchMap;
	}

	/** faq 목록, 상세 조회 service
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<Board> faqList(int type) throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> boardList = dao.faqList(conn, type);
		
		close(conn);
		
		return boardList;
	}

	/** faq 삭제 service
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteFaq(int boardNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteFaq(conn, boardNo);
		
		if(result>0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 이벤트 상세조회 service
	 * @param eventNo
	 * @return event
	 * @throws Exception
	 */
	public Event selectEventDetail(int eventNo) throws Exception {
		
		Connection conn = getConnection();
		
		Event event = dao.selectEventDetail(conn, eventNo);
		
		if(event!=null) {
			List<EventImage> imageList = dao.selelctImageList(conn, eventNo);
			event.setImageList(imageList);
		}
		
		close(conn);
		
		return event;
	}

	/** 업다운 FL 검사 service
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public String updown(int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		String result = dao.updown(memberNo, conn);
		
		close(conn);
		
		
		return result;
	}

	/** 게임 쿠폰 service
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int gameCoupon(int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		// 쿠폰 넣기
		int result = dao.gameCoupon(conn, memberNo);
		
		
		if(result>0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

	/** 업다운 페이지 접속 시 FL -> Y로 업데이트 service
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int updownFl(int memberNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.updownFl(conn, memberNo);
		
		if(result>0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		
		return result;
	}

}
