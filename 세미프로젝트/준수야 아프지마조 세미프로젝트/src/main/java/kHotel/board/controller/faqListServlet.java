package kHotel.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.board.model.service.KBoardService;
import kHotel.board.model.vo.Board;

@WebServlet("/board/faq")
public class faqListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			KBoardService service = new KBoardService();
			
			List<Board> boardList = service.faqList(type);
			
			
			req.setAttribute("boardList", boardList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String path = "/WEB-INF/views/admin/AdminFaqList.jsp";		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);

	}

}
