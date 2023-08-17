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

@WebServlet("/board/admin/FAQUpate2")
public class AdminFAQAlter2 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
			
		// 수정 전 게시글 정보
		String title = req.getParameter("faq1");
		String content = req.getParameter("faq2");
		/* int boardNo = Integer.parseInt(req.getParameter("boardNo")); */
				
		
		HAdminBoard before = new HAdminBoard();
		
		before.setBoardTitle(title);
		before.setBoardContent(content);
		/*
		 * before.setBoardNo(boardNo);
		 */
		// 수정 후 게시글 정보
		String faqTitle = req.getParameter("faqTitle");
		String faqContent = req.getParameter("faqContent");
		
		
		HAdminBoard after = new HAdminBoard();
		
		after.setBoardTitle(faqTitle);
		after.setBoardContent(faqContent);
		
		JAdminService service = new JAdminService();
		
		int result = service.FAQAlter(before, after , loginMember); 
		
		String path = null;
		
		if(result > 0) {
			session.setAttribute("message", "FAQ 수정 완료");
			
			path = req.getContextPath() + "/board/faq?type=4";
			
		}else {
			session.setAttribute("message", "FAQ 수정 실패");
			
			path = req.getContextPath() + "/board/faq?type=4";
			
		}
		
		resp.sendRedirect(path);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
