package kHotel.board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kHotel.admin.model.vo.LAdminReport;
import kHotel.board.model.dao.ReviewDAO;
import kHotel.board.model.vo.Board;
import kHotel.common.Util;
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.PPagination;

import static kHotel.common.JDBCTemplate.*;
		

public class ReviewService {
	
	ReviewDAO dao = new ReviewDAO(); 


	/** 리뷰 내용 전체 조회 
	 * @param cp 
	 * @return map
	 * @throws Exception
	 */
	public Map<String, Object> boardReview(int cp) throws Exception {
		
		Connection conn = getConnection();
		
		// 리뷰 내용 
		int listCount = dao.selectReview(conn);
		
		// 페이지네이션
		PPagination pagination = new PPagination(cp,listCount);
		
		//리뷰 내용 전체 조회 
		List<Board> boardList = dao.boardCount(conn,pagination);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		close(conn);
	
		
		return map;
	}


	/** 리뷰 내용 등록하기 
	 * @param report
	 * @return result 
	 * @throws Exception
	 */
	public int declar(LAdminReport report) throws Exception {
		
		Connection conn = getConnection();
		
		report.setReportContent(Util.XSSHanding(report.getReportContent()));
		report.setReportContent(Util.newLineHandling(report.getReportContent()));
		
		int result = dao.declar(conn,report);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		
		return result;
	}


	/** 리뷰 삭제 
	 * @param loginMember
	 * @param boardNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteReview(Member loginMember, int no) throws Exception{
		

		Connection conn = getConnection();
		
		int result = dao.deleteReview(conn,loginMember,no);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
				
		return result;
	}


	/** 리뷰 상세보기 
	 * @param boardNo
	 * @return boardShow
	 * @throws Exception
	 */
	public Board boardReviewShow(int boardNo) throws Exception{
	
		Connection conn = getConnection();

		Board boardShow = dao.boardReviewShow(conn,boardNo);
		
		close(conn);
		
		return boardShow;

	}

}
