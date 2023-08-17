package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.member.model.vo.Reservation;

@WebServlet("/member/mypage/review")
public class ReviewWriteServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = "/WEB-INF/views/mypage/review.jsp";
		
		
		String hotelName = req.getParameter("hotelName");
		String roomName = req.getParameter("roomName");
		int bookNo = Integer.parseInt(req.getParameter("bookNo"));
		
		Reservation rv = new Reservation();
		
		rv.setHotelName(hotelName);
		rv.setRoomName(roomName);
		rv.setBookNo(bookNo);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		req.setAttribute("rv", rv);
		
		dispatcher.forward(req, resp);
	}

}
