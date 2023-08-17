package kHotel.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.service.KBoardService;
import kHotel.member.model.vo.Member;

@WebServlet("/event/updown/fl")
public class UpDownFLServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			int memberNo = loginMember.getMemberNo();
			
			int result = new KBoardService().updownFl(memberNo);
			
//			if(result>0) {
//				session.setAttribute("message", "0넘었다");
//			} else {
//				session.setAttribute("message", "y로 못 바꾸었다.....");
//			}
//			
			resp.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
