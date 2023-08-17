package kHotel.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.board.model.service.KBoardService;

@WebServlet("/admin/faqDelete")
public class AdminFaqServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int boardNo = Integer.parseInt(req.getParameter("boardNo"));
			
			KBoardService service = new KBoardService();
			
			int result = service.deleteFaq(boardNo);
			
			resp.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
