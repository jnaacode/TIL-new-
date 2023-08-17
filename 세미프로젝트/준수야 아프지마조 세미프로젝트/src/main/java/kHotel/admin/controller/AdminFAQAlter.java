package kHotel.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.admin.model.vo.HAdminBoard;
import kHotel.common.Util;
import kHotel.member.model.vo.Member;

@WebServlet("/board/admin/FAQUpate")
public class AdminFAQAlter extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String faqTitle = req.getParameter("title");
			String faqContent = req.getParameter("content");
			
			Util.newLineHandling(faqContent);
			
			HAdminBoard board = new HAdminBoard();
			
			board.setBoardTitle(faqTitle);
			board.setBoardContent(faqContent);
			
			board.setBoardContent( board.getBoardContent().replaceAll("<br>", "\n") );
			
			String path = "/WEB-INF/views/admin/FAQUpdate.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			req.setAttribute("faq", board);
			
			dispatcher.forward(req, resp);
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
