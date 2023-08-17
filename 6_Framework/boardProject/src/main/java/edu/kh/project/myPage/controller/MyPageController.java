package edu.kh.project.myPage.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;

@SessionAttributes({"loginMember"})
// 1) Model에 세팅된 값의 Key와 {} 작성된 값이 일치하면 session scope로 이동
// 2) Session으로 올려둔 값을 해당 클래스에서 얻어와 사용 가능하게 함
//	  ->@SessionAttribute(Key)로 사용

@RequestMapping("/myPage") // /myPage로 시작하는 요청을 모두 받음
@Controller // 요청 / 응답을 제어 클래스 + Bean 등록
public class MyPageController {
	
	@Autowired // MyPageService의 자식 MyPageServiceImpl의존성 주입(DI)
	private MyPageService service;
	
	// 내 정보 페이지로 이동
	@GetMapping("/info")
	private String info() {
		// servlet-context.xml
		return "myPage/myPage-info";
	}
	
	// 내 정보 프로필로 이동
	@GetMapping("/profile")
	private String profile() {
		return "myPage/myPage-profile";
	}

	
	// 내 정보 비밀번호 변경 페이지로 이동
	@GetMapping("/changePw")
	private String changePw() {
		return "myPage/myPage-changePw";
	}
	
	// 내 정보 탈퇴 페이지로 이동
	@GetMapping("/secession")
	private String secession() {
		return "myPage/myPage-secession";
	}
	
	// 회원 정보 수정
	@PostMapping("/info")
	private String info(Member updateMember, String[] memberAddress
						,@SessionAttribute("loginMember")Member loginMember
						, RedirectAttributes ra) {
		
		// ---------------------- 매개 변수 설명 ----------------------
		// Member updateMember : 수정할 닉네임, 전화번호 담긴 커맨드 객체 
		// String [] memberAddress : name ="memberAddress"인 input 3개의 값 (주소)
		
		// @SessionAttribute("loginMember")Member loginMember
		// : 위에서 작성한 Session에서 얻어온 loginMember에 해당하는 객체를 
		// : 매개변수 Member loginMember에 저장 
		
		// RedirectAttributes : 리다이렉트 시 값 전달용 객체 (request)
		
		// ---------------------------------------------------------
		// 주소 하나로 합치기(a^^^b^^^c^^^)
		String addr = String.join("^^^", memberAddress);
		updateMember.setMemberAddress(addr);
		
		// 로그인한 회원의 번호를 updateMember에 추가 
		updateMember.setMemberNo(loginMember.getMemberNo());
		
		// DB에 회원 정보 수정(UPDATE) 서비스 호출 
		int result = service.updateInfo(updateMember);
		
		String message = null;
		
		if(result>0) {
			message = "회원정보가 수정되었습니다.";
				// Session에 로그인된 회원 정보도 수정(동기화) -> 안쓰면 DB만 바뀜
				loginMember.setMemberNickname(updateMember.getMemberNickname());
				loginMember.setMemberTel(updateMember.getMemberTel());
				loginMember.setMemberAddress(updateMember.getMemberAddress());
		
		}else {
			message = "회원정보 수정이 실패되었습니다.";
		}
			
		ra.addFlashAttribute("message",message);
		return "redirect:info"; // 상대경로(/myPage/info GET방식)	}
	}
	
	// 비밀번호 변경 
	@PostMapping("/changePw")
	public String changPw(String currentPw
						  ,String newPw
						  ,@SessionAttribute("loginMember") Member loginMember
						  ,RedirectAttributes ra) {
		
		// 로그인한 회원 번호 (DB에서 어떤 회원을 조회, 수정하는지 알아야 하니까)
		int memberNo = loginMember.getMemberNo();
		
		// 비밀번호 변경 서비스 호출 
		int result = service.changePw(currentPw,newPw,memberNo);
		
		String path = "redirect:";
		String message = null;
		
		if(result>0) { // 성공 
			message = "비밀번호가 변경되었습니다.";
			path += "info";
			
		}else {
			message = "현재 비밀번호가 일치하지 않습니다.";
			path += "changePw";
			
		}
		ra.addFlashAttribute("message",message);
		return path;
	}
	
	//회원 탈퇴 
	@PostMapping("/secession")
	public String secession(@SessionAttribute("loginMember") Member loginMember // 로그인한 회원의 회원 번호 얻어오기
							, String memberPw // 입력한 비밀번호 
							,SessionStatus stauts // 세션 관리 객체
							,HttpServletResponse resp // 서버 -> 클라이언트 응답하는 방법 제공 객체
							,RedirectAttributes ra // 리다이렉트시 request로 값 전달하는 객체
							) {
		
		
		//1. 로그인한 회원의 회원 번호 얻어오기
		int memberNo = loginMember.getMemberNo(); 
		
		//2. 회원 탈퇴 서비스 호출
		// - 비밀번호가 일치하면 MEMBER_DEL_FL -> 'Y' 바꾸고 1반환 
		// - 비밀번호가 일치하지 않으면 -> 0반환 
		int result = service.secession(memberNo,memberPw);
		
		String path = "redirect:";
		String message = null;
		
		//3. 탈퇴 성공 시 
		if(result>0) {
			
			// message : 탈퇴 되었습니다. 
			message = "탈퇴 되었습니다.";
			
			// - 메인페이지로 리다이렉트	
			path += "/";
			
			// - 로그아웃
			stauts.setComplete();
			
			// + 쿠키 삭제
			Cookie cookie = new Cookie("saveId","");
			
			// 같은 쿠키가 이미 존재하면 덮어쓰기 된다.
			cookie.setMaxAge(0); // 0초 생존 -> 삭제
			cookie.setPath("/"); // 요청 시 쿠키가 첨부되는 경로
			resp.addCookie(cookie); // 요청 객체를 통해서 클라이언트에게 전달
									// -> 클라이언트 컴퓨터에 파일로 생성된다.
			
			//4. 탈퇴 실패시 
		}else {
	
			// - message : 현재 비밀번호가 일치하지 않습니다. 
			message = "현재 비밀번호가 일치하지 않습니다. ";
			
			// - 회원 탈퇴 페이지로 리 다이렉트 	
			path += "secession";
		}
		

		ra.addFlashAttribute("message",message);
		return path;
	}
	

}
