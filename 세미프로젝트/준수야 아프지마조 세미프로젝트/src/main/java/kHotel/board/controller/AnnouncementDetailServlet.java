package kHotel.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.board.model.service.HBoardService;
import kHotel.board.model.service.LReplyService;
import kHotel.board.model.vo.AnnouncementDetail;
import kHotel.board.model.vo.Reply;


@WebServlet("/board/detail")
public class AnnouncementDetailServlet extends HttpServlet {
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			int boardNo = Integer.parseInt(req.getParameter("no"));
			
			HBoardService service = new HBoardService();
			
			AnnouncementDetail detail = service.checkBoardDetail(boardNo);
			
			if(detail != null) {
				List<Reply> rList = new LReplyService().selectReplyList(boardNo);
				
				req.setAttribute("rList", rList);
			}
			
			req.setAttribute("detail", detail);
			
			String path = "/WEB-INF/views/board/boardDetail.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
		}catch (Exception e){
			e.printStackTrace();
			
		}
		
	}


}
