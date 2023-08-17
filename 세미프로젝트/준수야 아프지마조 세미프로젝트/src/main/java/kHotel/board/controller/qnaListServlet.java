package kHotel.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.service.KBoardService;
import kHotel.board.model.vo.Board;
import kHotel.member.model.service.CBookService;

@WebServlet("/board/qna")
public class qnaListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) { // 쿼리스트링에 "cp"가 존재한다면
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			KBoardService service = new KBoardService();
			
			Map<String, Object> map = null;
			//Map<String, Object> map = service.qna(type,cp);
			
			
			if(req.getParameter("select") == null) { // 일반 목록 조회
				map = service.qna(type,cp);
				
			} else {
				String select = req.getParameter("select");
				String content = req.getParameter("sContent");
				
				
				map = service.qnaSearch(select, content, type, cp);
				
			}
			
			req.setAttribute("map", map);
			
			String path = "/WEB-INF/views/board/qnaList.jsp";		
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String boardtitle = req.getParameter("L-input-title");
		String boardContent = req.getParameter("L-textarea-text");
		int memberNo = Integer.parseInt(req.getParameter("memberNo"));
		
		CBookService service = new CBookService();
		
		HttpSession session = req.getSession();
		
		try {
			
			Board insert = new Board();
			
			insert.setBoardTitle(boardtitle);
			insert.setBoardContent(boardContent);
			insert.setMemberNo(memberNo);
			
			int result = service.insertBoard(insert);
			
			if(result > 0) {
				session.setAttribute("message", "게시글이 작성되었습니다.");
			}else {
				session.setAttribute("message", "게시글 작성에 실패하셨습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect(req.getContextPath() + "/board/qna?type=2&cp=1");
		
	}

}
