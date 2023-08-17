package kHotel.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.CBookService;
import kHotel.member.model.vo.Member;

@WebServlet("/member/mypage/likePage")
public class likePageServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cp = 1;
		
		if(req.getParameter("cp") != null) { 
			cp = Integer.parseInt(req.getParameter("cp"));
		}
		
		CBookService service = new CBookService();
		
		HttpSession session = req.getSession();
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		int MemberNo = loginMember.getMemberNo();
		
		Map<String, Object> map = null;
		
		try {
			
			map = service.selectlikeList(MemberNo,cp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("map", map);
		
		String path = "/WEB-INF/views/mypage/likePage.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}

}