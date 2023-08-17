package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kHotel.member.model.service.JMemberService;
import kHotel.member.model.vo.Member;

@WebServlet("/member/mypage/reviewCancel")
public class ReviewCancel extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		JMemberService service = new JMemberService();

		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		
		try {
			
			int result = service.reviewCancel(bookNo, loginMember);
			
			if(result > 0) {
				session.setAttribute("message", "예약이 취소되었습니다.");
				
			}
			else {
				session.setAttribute("message", "예약이 취소에 실패하셨습니다.");
				
			}
			
			resp.sendRedirect( req.getContextPath() + "/member/mypage/reservations1");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
