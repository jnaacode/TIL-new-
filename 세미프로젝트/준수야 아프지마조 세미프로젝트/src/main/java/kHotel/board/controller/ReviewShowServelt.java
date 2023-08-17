package kHotel.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.admin.model.vo.LAdminReport;
import kHotel.board.model.service.ReviewService;
import kHotel.board.model.vo.Board;
import kHotel.board.model.vo.Reply;
import kHotel.member.model.vo.Member;

@WebServlet("/board/review/*")
public class ReviewShowServelt extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring((contextPath + "/board/review/").length());
		ReviewService service = new ReviewService();

		try {

			if (command.equals("show")) {

				int boardNo = Integer.parseInt(req.getParameter("no"));
				

				Board boardShow = service.boardReviewShow(boardNo);

				String path = "/WEB-INF/views/board/reviewShow.jsp";

				req.setAttribute("board", boardShow);


				RequestDispatcher dispatcher = req.getRequestDispatcher(path);

				dispatcher.forward(req, resp);

			}

			if (command.equals("declar")) {

				String replyContent = req.getParameter("Ppcontent");
				int boardNo = Integer.parseInt(req.getParameter("boardNo"));
				int memberNo = Integer.parseInt(req.getParameter("memberNo"));

				LAdminReport report = new LAdminReport();
				report.setBoardNo(boardNo);
				report.setMemberNo(memberNo);
				report.setReportContent(replyContent);

				int result = service.declar(report);


				resp.getWriter().print(result);

			}

			if (command.equals("delete")) {
				HttpSession session = req.getSession();

				Member loginMember = (Member) session.getAttribute("loginMember");

				int no = Integer.parseInt(req.getParameter("no"));
				

				int result = service.deleteReview(loginMember, no);
				
				String path = null;
				
				
				if(result>0) {
					session.setAttribute("message","리뷰가 삭제 되었습니다.");
					path = req.getContextPath() + "/board/review/list?";
					
				}else {
					session.setAttribute("message", "리뷰 삭제가 실패되었습니다.");
					path = req.getHeader("referer");
					
				}
				
				resp.sendRedirect(path);

			}
			
			if (command.equals("list")) {

				int cp = 1;

				if (req.getParameter("cp") != null) {
					cp = Integer.parseInt(req.getParameter("cp"));
				}

				Map<String, Object> map = service.boardReview(cp);

				String path = "/WEB-INF/views/board/reviewMain.jsp";

				req.setAttribute("map", map);


				RequestDispatcher dispatcher = req.getRequestDispatcher(path);

				dispatcher.forward(req, resp);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
