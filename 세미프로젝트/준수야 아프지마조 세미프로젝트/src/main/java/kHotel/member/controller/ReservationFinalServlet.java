package kHotel.member.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.CBookService;
import kHotel.member.model.vo.Book;


@WebServlet("/book/reservationFinal")
public class ReservationFinalServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookHotel = req.getParameter("C-hotel-choice");
		String bookRoom = req.getParameter("C-room-choice");
		String checkinTime = req.getParameter("C-checkInTime");
		String checkOutTime = req.getParameter("C-checkOutTime");
		
		int adult = 0;
		
		if(adult > 0) {
			adult = Integer.parseInt(req.getParameter("C-adult"));
		}
		
		int child = 0;
		
		if(child > 0) {
			child = Integer.parseInt(req.getParameter("C-children"));
			
		}
		
		Book book = new Book();
		
		book.setBookHotel(bookHotel);
		book.setBookRoom(bookRoom);
		book.setCheckInTime(checkinTime);
		book.setCheckOutTime(checkOutTime);
		book.setAdult(adult);
		book.setChild(child);
		
		try {
			
			CBookService service = new CBookService();
			
			int result = service.reservationFinal(book);
					
			if(result > 0) { // 성공
				
				String path = "/WEB-INF/views/book/reservationFinal.jsp";
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				
				req.setAttribute("book", book);
				
				dispatcher.forward(req, resp);
				
			}else { // 실패
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
