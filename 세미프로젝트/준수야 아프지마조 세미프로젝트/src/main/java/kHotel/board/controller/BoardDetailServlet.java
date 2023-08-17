package kHotel.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.service.LBoardService;
import kHotel.board.model.service.LReplyService;
import kHotel.board.model.vo.Board;
import kHotel.board.model.vo.Reply;
import kHotel.member.model.service.CBookService;

@WebServlet("/board/qna/boardDetail")
public class BoardDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			// 게시판 번호(no쿼리스트링으로 받아와서 사용)로 게시판 정보 조회
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			
			LBoardService service = new LBoardService();
			
			Board board = service.selectBoardDetail(boardNo);
			
			
			if(board != null) {
				LReplyService rService = new LReplyService();
				
				List<Reply> rList = rService.selectReplyList(boardNo);
				
				req.setAttribute("rList", rList);
				
			}
			
			
			
			
			req.setAttribute("board", board);
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 상세게시글로 다시 넘길떄 필요한 아이
				int type = Integer.parseInt(req.getParameter("type"));
				int cp = Integer.parseInt(req.getParameter("cp"));
				int boardNo = Integer.parseInt(req.getParameter("no"));
				
				// update시 필요한 놈들
				String boardTitle = req.getParameter("L-input-title");
				String boardContent = req.getParameter("L-textarea-text");
				String boardDate = req.getParameter("boardDate");
				// String memberNo = req.getParameter("memberNo");
				
				
				// 주소 저장 
				String path = null;
				
				// 서비스 
				CBookService service = new CBookService();
				
				// 객체 생성
				Board board = new Board();
				
				// 세션 부여
				HttpSession session = req.getSession();
				
				board.setBoardNo(boardNo);
				board.setBoardTitle(boardTitle);
				board.setBoardContent(boardContent);
				board.setBoardDate(boardDate);
				
				
		
				
				try {
					
					int result = service.updateBoard(board,type);
					
					board.setBoardContent(board.getBoardContent().replaceAll("<br>", "\n"));

					
					if(result > 0) {
						session.setAttribute("message", "게시글이 수정되었습니다.");
							
						path ="boardDetail?type="+ type + "&cp=" + cp + "&no=" + boardNo;
						
					// boardDetail?type=2&cp=1&no=26

					}else {
						session.setAttribute("message", "게시글 수정 실패");
						
						path ="boardDetail?type="+ type + "&cp=" + cp + "&no=" + boardNo;
					}
					
					resp.sendRedirect(path); 
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	
	}
}
