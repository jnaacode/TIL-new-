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

@WebServlet("/admin/pay")
public class AdminPayServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			
			int cp = 1;
			
			if(req.getParameter("cp") != null) {
				cp = Integer.parseInt(req.getParameter("cp"));
			}
			
			LAdminService service = new LAdminService();
			
			Map<String, Object> map = service.selectAdminPayList(type, cp);
			
			req.setAttribute("map", map);
			
			String path = "/WEB-INF/views/admin/AdminPay.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int calculateNo = Integer.parseInt( req.getParameter("calculateNo"));
			
			LAdminService service = new LAdminService();
			
			int result = service.agreePay(calculateNo);
			
			
			if(result > 0) {
				resp.getWriter().print(result);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
