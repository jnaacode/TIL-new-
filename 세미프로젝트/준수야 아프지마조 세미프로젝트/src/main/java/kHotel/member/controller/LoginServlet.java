package kHotel.member.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kHotel.member.model.service.KMemberService;
import kHotel.member.model.vo.Member;

@WebServlet("/member/login")
public final class LoginServlet extends HttpServlet {
	
	// 헤더에서 로그인 버튼 눌렀을 때
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/login.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
	
	// 로그인창에서 로그인 버튼 눌렀을 때
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputId = req.getParameter("inputId");
		
		String inputPw = req.getParameter("inputPw");
		
		Member mem = new Member();
		
		mem.setMemberId(inputId);
		mem.setMemberPw(inputPw);
		
		try {
			
			KMemberService service = new KMemberService();
			
			Member loginMember = service.login(mem);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) { // 로그인 성공
				
				if(loginMember.getSecessionFlag() == 'Y') { // 탈퇴한 회원인 경우
					session.setAttribute("message", "탈퇴한 회원입니다");
					resp.sendRedirect(req.getContextPath()+"/member/login");
				} else { 
					
					session.setAttribute("loginMember", loginMember);
					session.setMaxInactiveInterval(3600);
					
					// 아이디 저장 체크박스 
					
					Cookie c = new Cookie("saveId", inputId);
					
					// 아이디 저장이 체크된 경우
					if(req.getParameter("K-saveId") != null) {
						// 쿠키 파일을 30일 동안 유지
						c.setMaxAge(60*60*24*30);
						
					} else {
						
						c.setMaxAge(0);
					}
					
					c.setPath(req.getContextPath());
					// -> /kHotel로 시작하는 주소에서만 쿠키 적용
					
					resp.addCookie(c); 
					
					//--------------------------------------
					
					// 쿠키는 왜 String만 담을 수 있나요... 객체도 담고 싶은데 껴주세요ㅠㅠ
					
					// 객체를 문자열로 변환해 쿠키에 담는 방법도 있지만 보안상 이슈로 비추천
					// -> 토큰(사용자 식별 문자열)을 이용하자
//					if (req.getParameter("K-auto-login") != null) { // 자동로그인 체크되어 있을 때
//						
//		                String autoLoginToken = UUID.randomUUID().toString(); // 랜덤한 값으로 토큰 생성
//		                // 토큰을 쿠키에 저장
//		                Cookie autoLoginCookie = new Cookie("autoLogin", autoLoginToken);
//		                autoLoginCookie.setMaxAge(60 * 60 * 24 * 30); // 30일
//		                autoLoginCookie.setPath(req.getContextPath());
//		                resp.addCookie(autoLoginCookie);
//		            } else { // 체크 해제
//		            	Cookie[] cookies = req.getCookies(); // 모든 쿠키 다 가져오기
//		            	
//		            	// 바로 autoLoginCookie의 maxAge를 0으로 설정하고 싶지만
//		            	// 위의 if 괄호 밖이라서 autoLoginCookie를 사용 못함
//		            	if(cookies != null) {
//		            		for(Cookie cook : cookies) { // cookie 하나씩 접근해서
//		            			if(cook.getName().equals("autoLogin")) {
//		            				cook.setMaxAge(0);
//		            				cook.setPath(req.getContextPath());
//		            				resp.addCookie(cook);
//		            				break;
//		            			}
//		            		}
//		            	}
//		            }
					
					// 쿠키 우효기간만 설정하고 토큰 유효기간은 아직 설정하지 않음
					// -> 라이브러리 사용할지..?
					
					
					// 그냥 쿠키에 객체 저장해볼게요..
					
//					if (req.getParameter("K-auto-login") != null) { // 자동로그인 체크되어 있는 경우
//						
//						// 객체 직렬화
//						ByteArrayOutputStream bos = new ByteArrayOutputStream();
//				        ObjectOutputStream oos = new ObjectOutputStream(bos);
//				        oos.writeObject(loginMember);
//				        oos.flush();
//				        byte[] objectBytes = bos.toByteArray();
//				        oos.close();
//				        
//				        // 인코딩 후 쿠키에 저장
//				        String encodedAuto = java.util.Base64.getEncoder().encodeToString(objectBytes);
//				        Cookie autoCookie = new Cookie("myObjectCookie", encodedAuto);
//				        resp.addCookie(autoCookie);
//					}
					
					
					// ----------------- 관리자인지 일반회원인지 분류
					
					if(loginMember.getMemberAdmin() == 'N'){ // 일반 회원일 때
						resp.sendRedirect(req.getContextPath());
					} else { // 관리자일 때
						String path = req.getContextPath() + "/admin/memberAdmin?type=1";
						
						resp.sendRedirect(path);
						
					}
					
				}
				
			} else {
				session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
				resp.sendRedirect(req.getContextPath()+"/member/login");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
