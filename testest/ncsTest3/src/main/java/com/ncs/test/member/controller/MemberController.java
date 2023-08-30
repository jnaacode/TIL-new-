package com.ncs.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
@SessionAttributes({"result"})
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/")
	public String inDupCheck() {
		return "index";
	}
	
	@PostMapping( value ="/idDupCheck",produces = "application/json charset=UTF-8")
	@ResponseBody
	public String idDupCheck(@RequestParam("id") String memberId
							,Model model){
		
		int result = service.idDupCheck(memberId);
		
		String result2 = null;

		if(result>0) {
			result2 = "true";
		}
		return result2;
		
	}

}
