package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.LMemberService;
import kHotel.member.model.vo.Member;

@WebServlet("/member/mypage/changePw")
public class ChanegePwServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/mypage/changePw.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String currentPw = req.getParameter("currentPw");
		String newPw = req.getParameter("newPw");
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		int memberNo = loginMember.getMemberNo();
		
		try {
			
			LMemberService service = new LMemberService();
			
			int result = service.changePw(currentPw, newPw, memberNo);
			
			String path = null;
			
			if(result > 0) {
				
				session.setAttribute("message", "비밀번호 변경에 성공하셨습니다.");
				
				resp.sendRedirect(req.getContextPath() + "/member/mypage");
				
			}else{
				
				session.setAttribute("message", "현재 비밀번호가 일치하지 않습니다.");
				
				path = "changePw"; 
				
				resp.sendRedirect(path);
			}
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
}
