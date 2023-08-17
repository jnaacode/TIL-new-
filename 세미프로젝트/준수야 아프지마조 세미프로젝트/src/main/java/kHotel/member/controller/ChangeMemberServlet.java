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

@WebServlet("/member/mypage/changeMember")
public class ChangeMemberServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/mypage/changeMember.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("L-name");
		String email = req.getParameter("L-email");
		String tel = req.getParameter("L-tel");
		
		String[] address = req.getParameterValues("L-address");
		
		String Laddress = null;
		
		if(address[0].length() > 0) {
			Laddress = String.join(",,", address);
		}
		
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)(session.getAttribute("loginMember"));
		
		int memberNo = loginMember.getMemberNo();
		
		Member member = new Member();
		
		member.setMemberName(name);
		member.setMemberEmail(email);
		member.setMemberTel(tel);
		member.setMemberAddress(Laddress);
		member.setMemberNo(memberNo);
		
		try {
			
			LMemberService service = new LMemberService();
			
			int result = service.changeMember(member);
			
			if(result > 0) {
				
				session.setAttribute("message", "회원 정보가 수정되었습니다.");
				
				loginMember.setMemberName(name);
				loginMember.setMemberEmail(email);
				loginMember.setMemberTel(tel);
				loginMember.setMemberAddress(Laddress);
				
				resp.sendRedirect(req.getContextPath() + "/member/mypage");
				
			}else {
				session.setAttribute("message", "회원 정보 수정에 실패하였습니다.");
				
				resp.sendRedirect("changeMember");
				
			}
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
