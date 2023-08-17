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

@WebServlet("/event/updown/coupon")
public class UpdownCouponServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		try {
			
			HttpSession session = req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			int memberNo = loginMember.getMemberNo();
			
			int result = new KBoardService().gameCoupon(memberNo);
			
			if(result>0) {
				//session.setAttribute("message", "성공! 쿠폰이 지급되었습니다.");
			} else {
				session.setAttribute("message", "게임 성공은 했는데 쿠폰 insert과정에 문제 발생..");
			}
			
			resp.getWriter().print(result);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
