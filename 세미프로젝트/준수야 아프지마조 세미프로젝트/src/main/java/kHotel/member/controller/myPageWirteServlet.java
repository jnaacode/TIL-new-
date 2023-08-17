package kHotel.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kHotel.member.model.service.BoardService;
import kHotel.member.model.vo.Board;
import kHotel.member.model.vo.Member;

@WebServlet("/member/mypage/mypageWirte")
public class myPageWirteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BoardService service = new BoardService();
		try {

			HttpSession session =req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			int memberNo = loginMember.getMemberNo();
			
			List<Board> boardList = service.searchBoardList(memberNo);
			
			String path = "/WEB-INF/views/mypage/mypage(wirte).jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			req.setAttribute("boardList", boardList);
			
			dispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
