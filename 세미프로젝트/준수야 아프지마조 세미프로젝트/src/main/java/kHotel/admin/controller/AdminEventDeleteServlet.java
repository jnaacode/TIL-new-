package kHotel.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.admin.model.service.KAdminService;

@WebServlet("/admin/event/delete")
public class AdminEventDeleteServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int eventNo = Integer.parseInt(req.getParameter("no"));
			
			int result = new KAdminService().deleteEvent(eventNo);
			
			String path = null;
			String message = null;
			
			HttpSession session = req.getSession();
			
			if(result>0) {
				message = "게시글을 삭제하였습니다";
				path = req.getContextPath() + "/event";
			} else {
				message ="게시글 삭제 실패";
				path = req.getHeader("referer");
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
