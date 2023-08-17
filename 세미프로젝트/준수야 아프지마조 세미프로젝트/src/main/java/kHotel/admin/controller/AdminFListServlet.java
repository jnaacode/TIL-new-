package kHotel.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kHotel.admin.model.service.KAdminService;
import kHotel.board.model.vo.Board;

@WebServlet("/admin/selectFaqList")
public class AdminFListServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int type = Integer.parseInt(req.getParameter("type"));
			
			System.out.println(type);
			
			
			KAdminService service = new KAdminService();
			
			List<Board> fList = service.fList(type);
			
			new Gson().toJson(fList, resp.getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
