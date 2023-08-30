package com.ncs.test.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@SessionAttributes("loginMember")
@Controller
public class MemberController {

   @Autowired
   private MemberService service;

   @PostMapping("login")
   public String memberLogin(Member member
                     ,Model model) {
      
      Member loginMember = service.memberLogin(member);
      
      System.out.println(loginMember);
      
      if(loginMember != null) {
         
         model.addAttribute("loginMember",loginMember);
         return "redirect:/";
      }else {
         
         model.addAttribute("msg","메세지실패");
         return "errorPage";
      }
      
   
   }

}