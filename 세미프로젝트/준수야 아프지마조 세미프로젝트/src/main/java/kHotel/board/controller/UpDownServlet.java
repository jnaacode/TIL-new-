package kHotel.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.service.KBoardService;
import kHotel.member.model.vo.Member;

@WebServlet("/event/updown")
public class UpDownServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			HttpSession session = req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			int memberNo = loginMember.getMemberNo();
			
			String result = new KBoardService().updown(memberNo);
			
			if(result.equals("N")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/event/updowngame.jsp");
				dispatcher.forward(req, resp);
			} else {
				session.setAttribute("message", "하루에 한 번만 참여할 수 있습니다.");
				resp.sendRedirect(req.getHeader("referer"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
