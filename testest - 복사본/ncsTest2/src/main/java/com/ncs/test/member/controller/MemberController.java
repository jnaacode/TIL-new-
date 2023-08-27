package com.ncs.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
@SessionAttributes({ "msg" })
public class MemberController {

	@GetMapping("/")
	public String signUp() {
		return "index";
	}
	@Autowired
	private MemberService service;

	@PostMapping("/signUp")
	public String signUp(Member member, Model model, RedirectAttributes ra) {

		int result = service.signUp(member);

		if (result > 0) {

			model.addAttribute("msg", "회원가입 성공");

		} else {
			model.addAttribute("msg", "회원가입 실패");
		}
		return "redirect:/";

	}

}
