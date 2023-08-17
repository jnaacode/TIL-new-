package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.KMemberService;

@WebServlet("/member/reMain")
public class reMainServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String newPw = req.getParameter("newPw");
		
		String memberId = (String)req.getParameter("memberId");
		
		try {
			
			KMemberService service = new KMemberService();
			
			int result = service.newRePw(newPw, memberId);
			
			HttpSession session = req.getSession();
			
			
			if(result>0) {
				session.setAttribute("message", "비밀번호가 올바르게 변경되었습니다.");
			} else {
				session.setAttribute("message", "비밀번호가 올바르게 변경되지 않았습니다.");
				
			}
			resp.sendRedirect(req.getContextPath());
			
		} catch (Exception e) {
			
		}
		
	}

}
