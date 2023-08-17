package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.CBookService;
import kHotel.member.model.vo.Member;

@WebServlet("/member/mypage/deleteMember")
public class DeleteMemberServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/mypage/deleteMember.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberPw = req.getParameter("C-deleteMember-Pw");
		
		HttpSession session =req.getSession();
		
		Member loginMember = (Member)( session.getAttribute("loginMember") );
		
		int memberNo = loginMember.getMemberNo();
		
		try {
			CBookService service = new CBookService();
			
			int result = service.deleteMember(memberNo,memberPw);
			
			String path = null; 
			
			if(result > 0) {
				
				session.invalidate(); 
				
				session = req.getSession(); 
				
				session.setAttribute("message", "탈퇴 되었습니다.");
				
				path = req.getContextPath() ; 
				
				Cookie c = new Cookie("saveId","");
				
				c.setMaxAge(0);
				
				c.setPath( req.getContextPath() ); 
				
				resp.addCookie(c);
				
			}else {
				session.setAttribute("message", "비밀번호가 일치하지 않습니다.");
				
				path = req.getContextPath() + "/member/mypage/deleteMember";
			}
			
			resp.sendRedirect(path);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
