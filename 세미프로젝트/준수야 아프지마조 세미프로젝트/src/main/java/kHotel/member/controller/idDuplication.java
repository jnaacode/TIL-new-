package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.member.model.service.JMemberService;

@WebServlet("/member/signUp/duplication")
public class idDuplication extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberId = req.getParameter("memberId");
		
		JMemberService service = new JMemberService();
		try {
			// 아이디 중복 검사
			int result = service.idDuplicheck(memberId); 
			
			resp.getWriter().print(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
