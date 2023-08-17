package kHotel.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.board.model.service.LBoardService;


@WebServlet("/board/qna/boardDelete")
public class BoardDeleteServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
		
			int type = Integer.parseInt(req.getParameter("type"));
			int no = Integer.parseInt(req.getParameter("no"));
			
			LBoardService service = new LBoardService();
			
			int result = service.deleteBoard(no);
			
			HttpSession session = req.getSession();
			
			String path = null;
			
			
			if(result > 0) {
				
				session.setAttribute("message", "게시글 삭제에 성공하셨습니다.");
				
				path = req.getContextPath() +  "/board/qna?type=" + type;
				//path = "/semiProject/board/qna?type=" + type;
				
			}else {
				
				session.setAttribute("message", "게시글 삭제에 실패하셨습니다.");
				path = req.getHeader("referer");
				
			}
			
			resp.sendRedirect(path);
		
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
			
		}
		
		
		

		
		
	}
}
