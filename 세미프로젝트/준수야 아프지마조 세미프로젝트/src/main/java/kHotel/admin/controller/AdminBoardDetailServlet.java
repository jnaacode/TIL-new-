package kHotel.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.service.HBoardService;
import kHotel.board.model.vo.Board;
import kHotel.common.Util;
import kHotel.member.model.service.CBookService;

@WebServlet("/admin/AdminBoardList/detail")
public class AdminBoardDetailServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
		
		Board board = new Board();
		
		HBoardService service = new HBoardService();
		
		try {
			
			board.setBoardNo(boardNo);
		
			board = service.BoardDetail(boardNo);
			
			req.setAttribute("board", board);
					
			String path = "/WEB-INF/views/admin/AdminBoardDetail.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
			
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
		
		String boardTitle = req.getParameter("L-input-title");
		String boardContent = req.getParameter("L-textarea-text");
		String memberId = req.getParameter("memberId");
		
		
		
		
		// 리다이렉트 주소 
		String path = null;
		
		// service 호출
		CBookService service = new CBookService();
		
		// 객체 생성
		Board board = new Board();
		
		// 세션 얻어오기
		HttpSession session = req.getSession();
		
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setMemberId(memberId);
		
		try {

			
			int result = service.updateAdminboard(board);
			
			
			if(result > 0) {

				session.setAttribute("message", "공지사항이 수정되었습니다.");
				
				path ="detail?no=" + boardNo;
				
			}else {
				session.setAttribute("message", "공지사항 수정 실패");
				
				path ="detail?no=" + boardNo;
			}
		
			resp.sendRedirect(path);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
