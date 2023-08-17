package kHotel.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName ="loginFilter",
			urlPatterns = {"/book/*", // 예약 관련 
							"/board/write"/*게시글작성*/, "/board/qna/update"/*게시글수정*/,
							"/member/review3"/*리뷰작성*/, "/admin/*" /*관리자 전체*/,
							"/event/bingo", "/event/updown" /*빙고, 업다운 막기*/,
							"/board/admin/*" /*관리자 게시판*/, "/member/mypage/*" /*마이페이지*/,
							""}  )
public class loginFilter extends HttpFilter implements Filter {
       

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("로그인 필터 생성");
	}
	
	public void destroy() {
		System.out.println("로그인 필터가 변경되어 파괴 -> 이후 재생성");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		// 최상위 부모 SerlvetRequest 자식 HttpServletRequest 다운캐스팅
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		// 로그인한 회원이 있는지 확인하기 위해서 세션 얻어오기
		HttpSession session = req.getSession();
		
		if(session.getAttribute("loginMember") != null) { // 로그인한 사람이 있다면 if문 수행
			
			// 로그인한 회원이 있다면 다음 필터로 이동한다 다음 필터가 없다면 Servlet으로 이동
			chain.doFilter(request, response);
			
		}else { // 로그인한 회원이 없다면 else문 수행
			
			// footer에서 session에서 담아둔 message 가져와서 로그인한 회원이 없다면 메세지 띄워주기
			session.setAttribute("message", "로그인 후 이용해주세요.");
			
			// 메세지 띄워준 후 메인페이지로 이동 시킴 req.getContextPath()
			resp.sendRedirect( req.getContextPath()+"/member/login" ); 
			
		}
		
	}


}
