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
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.Reservation;

@WebServlet("/book/bookEnd")
public class ReservationEndServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			String hotelName = req.getParameter("hotelName");
			String roomName = req.getParameter("roomName");
			int roomNo = Integer.parseInt(req.getParameter("roomNo"));
			int bookPerson = Integer.parseInt(req.getParameter("bookPerson"));
			int roomPrice = Integer.parseInt(req.getParameter("roomPrice")); // 할인 전 금액
			int couponSale = Integer.parseInt(req.getParameter("C-rsv-coupon")); // 쿠폰 할인 금액
			int hotelPay = roomPrice-couponSale; // 총 금액
			String checkInDt = req.getParameter("checkInDt"); // 체크인 날
			String checkOutDt = req.getParameter("checkOutDt"); // 체크아웃 날
			String bank = req.getParameter("C-account"); // 결제 은행
			
			
			HttpSession session = req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			String memberName = loginMember.getMemberName();
			int memberNo = loginMember.getMemberNo();
			String memberTel = loginMember.getMemberTel();
			String memberEmail = loginMember.getMemberEmail();
			
			String payPlan = req.getParameter("C-payplan"); // 결제 테이블
			
			Reservation reserve = new Reservation();
			
			reserve.setHotelName(hotelName);
			reserve.setRoomName(roomName);
			reserve.setCheckInTime(checkInDt);
			reserve.setCheckOutTime(checkOutDt);
			reserve.setRoomNo(roomNo);
			reserve.setBookPerson(bookPerson);
			reserve.setRoomPrice(roomPrice);
			reserve.setCouponSale(couponSale);
			reserve.setHotelPay(hotelPay);
			reserve.setMemberName(memberName);
			reserve.setMemberTel(memberTel);
			reserve.setMemberEmail(memberEmail);
			reserve.setMemberNo(memberNo);
			reserve.setBank(bank);
			reserve.setPayPlan(payPlan);
			
			KMemberService service = new KMemberService();
			
			int result = service.bookEnd(reserve);
			
			String path = null;
			
			if(result>0) {
				req.setAttribute("reserve", reserve);
				path = "/WEB-INF/views/book/bookEnd.jsp";
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				
				dispatcher.forward(req, resp);
			} else {
				session.setAttribute("message", "예약 실패");
				resp.sendRedirect(req.getContextPath());
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
