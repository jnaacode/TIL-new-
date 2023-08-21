package com.ncs.test.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;

@Controller
@RequestMapping("/login")
@SessionAttributes("loginMember")
public class MemberController {
	
	@Autowired
	private MemberService service;

	
	@PostMapping("/login")
	public String memberLogin(String memberId, String memberPw,RedirectAttributes ra,RequestAttribute ra,@SessionAttribute("loginMember")) {
		
		Member loginMember = new Member(memberId, memberPw);
		int result = service.memberLogin(loginMember);

		String path = "redirect:";
		String message = null;
	
		
		if(result>0) {
			
			loginMember.setMemberId(memberId);
			loginMember.setMemberPwd(memberPw);
			
			path += "/";
			
		}else {
			
			ra.ad("message","로그인 실패");
			path += "/login"
		}
		
		
	}

}
