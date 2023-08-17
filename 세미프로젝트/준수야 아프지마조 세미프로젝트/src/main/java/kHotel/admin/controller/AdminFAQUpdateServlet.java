package kHotel.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.admin.model.service.JAdminService;
import kHotel.admin.model.vo.HAdminBoard;
import kHotel.admin.model.vo.PAdminMemebr;
import kHotel.member.model.vo.Member;

@WebServlet("/admin/FAQUpdate")
public class AdminFAQUpdateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		// FAQ 게시글 정보
		String FAQTitle = req.getParameter("FAQTitle");
		String FAQContent = req.getParameter("FAQContent");
		
		// memberNo 가져오기 위해 
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		JAdminService service = new JAdminService();
		
		HAdminBoard board = new HAdminBoard();
		
		board.setBoardTitle(FAQTitle);
		board.setBoardContent(FAQContent);
		
		String path = null;
		
		try {
			
			int result = service.FAQUpdate(loginMember, board );
			
			
			if(result > 0) {
				session.setAttribute("message", "작성을 완료하셨습니다.");
				
				
				resp.sendRedirect(req.getContextPath() + "/board/faq?type=4");
				
				
			}else {
				session.setAttribute("message", "작성 실패, 다시 시도 해주세요.");
				
				path = "/WEB-INF/views/admin/AdminBoardManage.jsp";
				
				req.getRequestDispatcher(path).forward(req, resp);
				
			}
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
