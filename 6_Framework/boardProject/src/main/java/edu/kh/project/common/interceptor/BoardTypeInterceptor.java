package edu.kh.project.common.interceptor;

import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import edu.kh.project.board.model.service.BoardService;

// Interceptor : 요청/ 응답을 가로채는 객체
// Client <-> Filter <-> Dispatcher Servlet <-> Interceptor <-> Controller

public class BoardTypeInterceptor implements HandlerInterceptor{

	@Autowired
	private BoardService service;
	
	/*
	 * preHandle  (전처리): Dispatcher Servlet -> Controller 사이 
	 * postHandle (후처리): Controller -> Dispatcher Servlet 사이
	 * afterCompletion (뷰 완성 후) : View Resolver -> Dispatcher Servlet 사이
	 * 
	 * 
	 * */
	
	// 전처리 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		// application scope 내장 객체 얻어오기 -> 인터셉터가 처리해야 하는 데이터나 설정 정보가 애플리케이션 전반에 걸쳐서 유지되어야 할 필요가 있어 가져온다.
		ServletContext application = request.getServletContext();
		
		// application scope에 BOARD_TYPE이 조회되어 세팅이 되지 않았다면 
		// -> 서버가 시작 후 누구도 요청한 적이 없을 경우
		
		if(application.getAttribute("boardTypeList")==null) {
			
			// 조회 서비스 호출
			System.out.println("BOARD_TYPE 조회 서비스 호출");
			
			// Object로 설정한 이유 :SELECT * FROM "BOARD_TYPE"; 했을때 결과에 int형 String형 두개가 있어서
			// dto가 없기 때문에 Map를 쓴다.
			List<Map<String,Object>> boardTypeList = service.selectBoardTypeList();
			System.out.println(boardTypeList);
			
			// application scope에 세팅
			application.setAttribute("boardTypeList", boardTypeList);
		}
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
