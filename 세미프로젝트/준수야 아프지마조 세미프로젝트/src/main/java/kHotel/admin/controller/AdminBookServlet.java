package kHotel.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kHotel.member.model.service.CBookService;
import kHotel.member.model.vo.Reservation;

@WebServlet("/admin/*")
public class AdminBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring(  (contextPath + "/admin/").length()  );


		CBookService service = new CBookService();
		
		try {
			
			if(command.equals("bookList")) {


				List<Reservation> rsvList = service.selectRsvList();

				String path = "/WEB-INF/views/admin/AdminReservation.jsp";

				RequestDispatcher dispatcher = req.getRequestDispatcher(path);

				req.setAttribute("rsvList", rsvList);

				dispatcher.forward(req, resp);
			}

			if(command.equals("bookListbefore")) {



				List<Reservation> rsvList2 = service.selectRsvList2();

				String path = "/WEB-INF/views/admin/AdminReservationbefore.jsp";

				RequestDispatcher dispatcher = req.getRequestDispatcher(path);

				req.setAttribute("rsvList2", rsvList2);

				dispatcher.forward(req, resp);

			}

			if(command.equals("delete")) {
				
				int bookNo = Integer.parseInt( req.getParameter("bookNo") );
				
				int result = service.deleteReservation(bookNo);

				resp.getWriter().print(result);

			} 
			
			if(command.equals("selectbookList")) {
				
				List<Reservation> rsvList = service.selectRsvList();

				
				new Gson().toJson(rsvList, resp.getWriter());
				
				
			}

		}catch (Exception e) {

			e.printStackTrace();

		}


	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
