package kHotel.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.board.model.service.KBoardService;
import kHotel.board.model.vo.Event;

@WebServlet("/event/detail")
public class EventDetailServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int eventNo = Integer.parseInt(req.getParameter("no"));
			
			KBoardService service = new KBoardService();
			
			Event event = service.selectEventDetail(eventNo);
			
			
			req.setAttribute("event", event);
			
			String path = "/WEB-INF/views/event/eventShow.jsp";
			
			req.getRequestDispatcher(path).forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
