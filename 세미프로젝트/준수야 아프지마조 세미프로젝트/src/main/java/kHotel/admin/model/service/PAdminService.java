package kHotel.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kHotel.admin.model.dao.PAdminDAO;
import kHotel.admin.model.vo.LAdminReport;
import kHotel.admin.model.vo.PAdminMemebr;
import kHotel.member.model.vo.LPagination;

import static kHotel.common.JDBCTemplate.*;

public class PAdminService {

	private PAdminDAO dao = new PAdminDAO();

	/**
	 * 어드민 멤버조회
	 * 
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> searchAdminMember(int type, int cp) throws Exception {

		Connection conn = getConnection();

		// 관리자 전체 게시글 수 조회
		int listCount = dao.getListCount(conn);

		// 전체 게시글 수 + 현재 페이지를 이용해 페이지네이션 객체 생성
		LPagination LPagination = new LPagination(cp, listCount);

		// 관리자 회원 목록 조회
		List<PAdminMemebr> boardList = dao.selectBoardList(conn, LPagination, type);
		for (int i = 0; i < boardList.size(); i++) {
			// 신고당한 수 조회
			int cnt = dao.getListReportCount(conn, listCount, boardList.get(i).getMemberNo());
			boardList.get(i).setReportCount(cnt);
		}

		// map객체에 담아주기
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("listCount", listCount);
		map.put("listReportCount", 0);
		map.put("LPagination", LPagination);
		map.put("boardList", boardList);

		return map;
	}

	/**
	 * 회원아이디 검색
	 * 
	 * @param pid
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> searchId(String Pid, int type, int cp) throws Exception {


		Connection conn = getConnection();

		// 게시판 이름 조회
		String condition = " AND MEMBER_ID LIKE '%" + Pid + "%' ";

		// 아이디 검색 시 아이디 검색 결과 수 출력
		int listCount = dao.getListCount(conn, condition);

		// 페이지네이션
		LPagination LPagination = new LPagination(cp, listCount);

		// 전체 회원수 조회
		List<PAdminMemebr> boardList = dao.searchBoardList(conn, LPagination, condition, type);
		for (int i = 0; i < boardList.size(); i++) {
			// 신고당한 수 조회
			int cnt = dao.getListReportCount(conn, listCount, boardList.get(i).getMemberNo());
			boardList.get(i).setReportCount(cnt);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("listCount", listCount);
		map.put("listReportCount", 0);
		map.put("LPagination", LPagination);
		map.put("boardList", boardList);

		return map;

	}

	/**
	 * 탈퇴
	 * 
	 * @param memberNo
	 * @param cp
	 * @param type
	 * @return result
	 * @throws Exception
	 */
	public int adminDeleteMember(int memberNo, int type, int cp) throws Exception {

		Connection conn = getConnection();

		// 관리자 전체 게시글 수 조회
		int listCount = dao.getListCount(conn);

		// 전체 게시글 수 + 현재 페이지를 이용해 페이지네이션 객체 생성
		LPagination LPagination = new LPagination(cp, listCount);

		int result = dao.adminDeleteMember(conn, memberNo,type,LPagination);
		

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}


		return result;
	}

}