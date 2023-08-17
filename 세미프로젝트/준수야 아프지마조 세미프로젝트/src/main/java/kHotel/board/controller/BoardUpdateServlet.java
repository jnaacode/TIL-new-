package kHotel.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.vo.Board;
import kHotel.member.model.service.CBookService;

@WebServlet("/board/qna/update")
public class BoardUpdateServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int type = Integer.parseInt(req.getParameter("type"));
		int cp = Integer.parseInt(req.getParameter("cp"));
		int boardNo = Integer.parseInt(req.getParameter("no"));
		
		// update시 필요한 놈들
		String boardTitle = req.getParameter("boardTitle");
		String boardContent = req.getParameter("boardContent");
		String boardDate = req.getParameter("boardDate");
		String memberId = req.getParameter("memberId");
		
		// 객체 생성
		Board board = new Board();
		
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardContent(boardContent);
		board.setBoardDate(boardDate);
		board.setMemberNo(boardNo);
		board.setMemberId(memberId);
		
		board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\n"));
		
		req.setAttribute("board", board);
		
		String path = "/WEB-INF/views/board/postEdit.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
}
