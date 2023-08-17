package kHotel.admin.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.admin.model.service.LAdminService;


@WebServlet("/admin/report")
public class AdminReportServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			LAdminService service = new LAdminService();
			
			Map<String, Object> map = service.selectAdminReportList(type, cp);
			
			req.setAttribute("map", map);
			
			
			String path = "/WEB-INF/views/admin/report(admin).jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
