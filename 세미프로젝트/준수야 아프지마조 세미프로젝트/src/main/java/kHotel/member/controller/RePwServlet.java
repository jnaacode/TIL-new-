package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.member.model.service.KMemberService;
import kHotel.member.model.vo.Member;

@WebServlet("/member/rePw")
public class RePwServlet extends HttpServlet {
	// 비밀번호 변경(로그인전)을 눌렀을 때
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String inputName = req.getParameter("pInputNm");
		String inputPno = req.getParameter("pInputPno");
		String inputId = req.getParameter("pInputId");
		
		try {
			
			KMemberService service = new KMemberService();
			
			Member mem = new Member();
			
			mem.setMemberName(inputName);
			mem.setMemberPno(inputPno);
			mem.setMemberId(inputId);
			
			int result = service.rePw(mem);
			
			resp.getWriter().print(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
