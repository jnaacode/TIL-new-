package kHotel.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.vo.Event;
import kHotel.member.model.service.JMemberService;
import kHotel.member.model.vo.Member;

@WebServlet("/event/bingo")
public class BingoServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JMemberService Jservice2 = new JMemberService();
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		try {
			
			// 이벤트 참여 여부 가져오기
			String eventFL = Jservice2.eventFL(loginMember);
			
			Event event = new Event();
			
			event.setBingoFl(eventFL);
			
			
			
			if(!event.getBingoFl().equals("Y")) {
				req.setAttribute("event", event);
				
				String path = "/WEB-INF/views/event/Bingo.jsp";
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				
				dispatcher.forward(req, resp);
				
			}else {
				session.setAttribute("message", "하루에 한 번만 참여할 수 있습니다.");
				
				resp.sendRedirect(req.getContextPath() + "/event");
			
			}
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
