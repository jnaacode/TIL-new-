package kHotel.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.JMemberService;
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.Reservation;

@WebServlet("/member/mypage/reservations1")
public class Reservations1Servlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	JMemberService service = new JMemberService();
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int memberNo = loginMember.getMemberNo();
		
		List<Reservation> rvList = new ArrayList<Reservation>();
		
		
		try {
			rvList = service.reservationUp(memberNo);
			
			String path = "/WEB-INF/views/mypage/reservations1.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			req.setAttribute("rvList", rvList);
			
			dispatcher.forward(req, resp);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
