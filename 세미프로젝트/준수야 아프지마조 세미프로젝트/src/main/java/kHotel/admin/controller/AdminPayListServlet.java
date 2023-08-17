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

import kHotel.admin.model.service.LAdminService;
import kHotel.admin.model.vo.LAdminPay;


@WebServlet("/admin/payList")
public class AdminPayListServlet extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			
			LAdminService service = new LAdminService();
			
			List<LAdminPay> LadpList = service.adminPayList();
						
			new Gson().toJson(LadpList, resp.getWriter());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
