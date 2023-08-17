package kHotel.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kHotel.member.model.service.KMemberService;

@WebServlet("/member/idSearch")
public class IdSearchServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nmInput = req.getParameter("nmInput");
		String pnoInput = req.getParameter("pnoInput");
		
		try {
			
			KMemberService service = new KMemberService();
			
			String result = service.idSearch(nmInput, pnoInput);
			
			new Gson().toJson(result, resp.getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
