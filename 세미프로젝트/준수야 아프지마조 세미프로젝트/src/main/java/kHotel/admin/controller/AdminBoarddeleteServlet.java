package kHotel.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.CBookService;

@WebServlet("/admin/AdminBoardList/delete")
public class AdminBoarddeleteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
		
		CBookService service = new CBookService();
		
		HttpSession session = req.getSession();
		
		try {
			
			int result = service.deleteAdminBoard(boardNo);
			
			if(result > 0 ) {
				
				session.setAttribute("message", "공지사항이 삭제되었습니다.");
				resp.sendRedirect(req.getContextPath() + "/admin/AdminBoardList");
				
			}else {
				session.setAttribute("message", "공지사항 삭제 실패!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
