package kHotel.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.service.HBoardService;
import kHotel.board.model.vo.Board;
import kHotel.common.Util;

@WebServlet("/admin/AdminBoardList/Edit")
public class AdminBoardEditServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(req.getParameter("no"));
		
		String boardTitle = req.getParameter("boardTitle");
		String boardDate = req.getParameter("boardDate");
		String boardContent = req.getParameter("boardContent");
		String memberId = req.getParameter("memberId");

		HBoardService service = new HBoardService();
		
		Board board = new Board();
		
		HttpSession session = req.getSession();
		
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardDate(boardDate);
		board.setMemberId(memberId);
		
		board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\n"));
		
		String path = "/WEB-INF/views/admin/AdminBoardEdit.jsp";
		
		req.setAttribute("board", board);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
	
	

}
