package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.JMemberService;
import kHotel.member.model.vo.Member;

@WebServlet("/member/signUp")
public class SignUpServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/signUp.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberName = req.getParameter("memberName");
		String[] pno = req.getParameterValues("memberPno");
		String memberTel = req.getParameter("memberTel");
		String memberEmail = req.getParameter("memberEmail");
		String[] address = req.getParameterValues("memberAddress");
		
		HttpSession session = req.getSession();
		
		String memberPno = null;
		String memberAddress = null;
		
		if(!address[0].equals("")) {
			memberAddress = String.join(",,", address);
		}
		
		if(!pno[0].equals("")) {
			memberPno = String.join("-", pno);
		}
		
		Member member = new Member();
		
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);
		member.setMemberName(memberName);
		member.setMemberPno(memberPno);
		member.setMemberTel(memberTel);
		member.setMemberEmail(memberEmail);
		member.setMemberAddress(memberAddress);
		
		try {
			
			JMemberService jservice = new JMemberService();
			
			
			int result = jservice.signUp(member);
			
			
			if(result > 0) { // 성공
				
				int event = jservice.insertEventCheck();
				
				session.setAttribute("message", "KHOTEL에 회원이 되신 걸 환영합니다!");
				
			}else {	// 실패
				session.setAttribute("message", "회원가입을 실패하였습니다. 다시 시도해 주세요.");
			}
			
			resp.sendRedirect( req.getContextPath() );
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
