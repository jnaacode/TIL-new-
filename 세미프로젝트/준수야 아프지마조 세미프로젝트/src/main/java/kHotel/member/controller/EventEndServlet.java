package kHotel.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.member.model.service.EventService;
import kHotel.member.model.vo.Event;

@WebServlet("/eventEnd")
public class EventEndServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			EventService service = new EventService();
			
			List<Event> eventEndList = service.eventEndList();
			
			req.setAttribute("eventEndList", eventEndList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		
		}

		String path = "/WEB-INF/views/event/eventEnd.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);

	
	}


}
