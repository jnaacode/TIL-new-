package kHotel.member.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.CBookService;
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.Reservation;

@WebServlet("/book/*")
public class reservationController extends HttpServlet{

	// /book/roomChoice // 메인페이지에서 예약화면으로 forward 하는 요청
	// /book/reservationFinal // 결제 페이지 에서 조회하는 구문
	// /book/end // 결제 후 예약 내역 보여주는 페이지
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// GET방식 요청 처리
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring(  (contextPath + "/book/").length()  );
		
		CBookService service = new CBookService();
		
		HttpSession session = req.getSession();
		
		// 메인페이지에서 예약 화면으로 넘어가는 요청
		if(command.equals("roomChoice")) {
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			req.setAttribute("loginMember", loginMember);
			
			String path = "/WEB-INF/views/book/RoomChoice.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
		}
		
		
		// 예약 화면에서 선택하고 예약 확인 화면으로 넘어가는 요청
		if(command.equals("reservationFinal")) {
			String hotel = req.getParameter("C-hotel-choice");
			String room = req.getParameter("C-room-choice");
			String checkIn = req.getParameter("C-checkInTime");
			String checkOut = req.getParameter("C-checkOutTime");
			int person = Integer.parseInt( req.getParameter("C-adult") );
			person += Integer.parseInt( req.getParameter("C-children") );
			int MemberNo = Integer.parseInt( req.getParameter("memberNo") );
				
			Reservation reservation = new Reservation();
			
			reservation.setHotelName(hotel);
			reservation.setRoomName(room);
			reservation.setCheckInTime(checkIn);
			reservation.setCheckOutTime(checkOut);
			reservation.setBookPerson(person);
			reservation.setMemberNo(MemberNo);
			
			// 예약가능한 객실인지 확인
			// 객실 번호 먼저 받아오기 
			try {
				int roomNo = service.searchRoom(reservation);
				
				// 객실 번호 받아온 후 세팅 해주고
				reservation.setRoomNo(roomNo);
				
				// 객실 번호를 바탕으로 그 객실에 대한 가격 가져오기
				int roomPrice =  service.searchRoomPrice(reservation);
				
				// 그 객실에 대한 가격 세팅 해주고
				reservation.setRoomPrice(roomPrice);
				
				// 로그인한 사람이 쿠폰이 있는지 확인
				int couponCount = service.selectCouponCount(reservation);
				
				reservation.setCouponCount(couponCount);
				
				int money = service.selectMoney(reservation);
				
				reservation.setCouponSale(money);
				
				// 선택한 날짜에 예약이 되어있는지 확인
				int result = service.searchCheckInStatus(reservation); 
							
				if(result == 0) { // 선택한 날짜에 방이 있다면
					
					String path = "/WEB-INF/views/book/reservationFinal.jsp";
					
					RequestDispatcher dispatcher = req.getRequestDispatcher(path);
					
					req.setAttribute("reservation", reservation);
					
					dispatcher.forward(req, resp);
				
					
				}else { // 선택한 날짜에 방이 나갔다면
					
					session.setAttribute("message", "선택하신 날짜의 해당 객실은 이미 예약이 찼습니다.");
					
					resp.sendRedirect(req.getContextPath()+"/book/roomChoice");
	
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			// if(){} 성공하면 set 객실에 대한 모든 정보를 세팅 
			// 가능하면 set 객실가격 
			
			
			
		} 
		
		
		

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
	}
}
