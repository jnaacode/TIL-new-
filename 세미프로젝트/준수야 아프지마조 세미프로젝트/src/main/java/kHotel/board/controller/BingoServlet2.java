package kHotel.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.JMemberService;
import kHotel.member.model.vo.Member;

@WebServlet("/event/bingoIn")
public class BingoServlet2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		int count = Integer.parseInt(req.getParameter("result2"));
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		JMemberService service = new JMemberService();
		try {
			String path = null;

			if(count == 3) {
				
				int result = service.couponIn(count, loginMember);
			
			
			
			if(result > 0) {
				session.setAttribute("message", "쿠폰이 증정되었습니다.");
				
				path = req.getContextPath() + "/event";
			}else {
				session.setAttribute("message", "쿠폰 증정 실패 다시 시도바람");
				
				path = req.getContextPath() + "/event";
			}
			
			}
			
			resp.sendRedirect(path);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
