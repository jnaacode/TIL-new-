package kHotel.admin.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kHotel.admin.model.dao.LAdminDAO;
import kHotel.admin.model.vo.LAdminPagination;
import kHotel.admin.model.vo.LAdminPay;
import kHotel.admin.model.vo.LAdminReport;
import kHotel.member.model.vo.LPagination;

public class LAdminService {
	
	private LAdminDAO dao = new LAdminDAO();

	
	/** 관리자 신고 Service
	 * @param type
	 * @param cp
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> selectAdminReportList(int type, int cp) throws Exception{
		
		Connection conn = getConnection();
		
		// 게시판 이름 조회
		String boardName = dao.selectBoardName(conn, type);
		
		// 관리자 신고게시판 전체 게시글 수 조회
		int listCount = dao.getListCount(conn);
		
		// 전체 게시글 수 + 현재 페이지를 이용해 페이지네이션 객체 생성
		LAdminPagination LAdminPagination = new LAdminPagination(cp, listCount);
		
		// 게시글 목록 조회
		List<LAdminReport> boardList = dao.selectBoardList(conn, LAdminPagination, type);
		
		// map객체에 담아주기
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("boardName", boardName);
		map.put("LAdminPagination", LAdminPagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		
		return map;
	}


	/** 결제 
	 * @param type
	 * @param cp
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> selectAdminPayList(int type, int cp) throws Exception{
		
		Connection conn = getConnection();
		
		// 관리자 결제게시판 전체 게시글 수 조회
		int listCount = dao.getPayListCount(conn);
		
		// 전체 게시글 수 + 현재 페이지를 이용해 페이지네이션 객체 생성
		LPagination LPagination = new LPagination(cp, listCount);
		
		// 게시글 목록 조회
		List<LAdminPay> boardList = dao.selectPayList(conn, LPagination, type);
		
		// map객체에 담아주기
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("LPagination", LPagination);
		map.put("boardList", boardList);
		
		close(conn);
		
		
		return map;
	}


	/** 결제 관리 Service
	 * @param calculateNo
	 * @return result
	 * @throws Exception
	 */
	public int agreePay(int calculateNo) throws Exception{
		
		Connection conn = getConnection();
		
		int result = dao.agreePay(conn, calculateNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		return result;
	}


	/** 결제 목록 조회 ajax Service
	 * @return adminPayList
	 * @throws Exception
	 */
	public List<LAdminPay> adminPayList() throws Exception{
		
		Connection conn = getConnection();
		
		
		List<LAdminPay> LadpList = dao.adminPayList(conn);
		
		close(conn);
		
		
		return LadpList;
	}

}
