package kHotel.member.controller;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.EventService;
import kHotel.member.model.service.JMemberService;
import kHotel.member.model.vo.Event;
import kHotel.member.model.vo.Member;

@WebServlet("/event")
public class EventServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		try {
			EventService service = new EventService();

			List<Event> eventList = service.eventList();

			req.setAttribute("eventList", eventList);
			
			
			String path = "/WEB-INF/views/event/event.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
}
