package kHotel.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kHotel.board.model.service.HBoardService;

@WebServlet("/board")
public class AnnouncementServlet extends HttpServlet  {
	
	 
	   @Override
	   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      try {
	         
	    	  String typeParam = req.getParameter("type");
	    	  int type = 0; // 기본값 설정 (적절한 기본값으로 변경 가능)
	    	  if (typeParam != null && !typeParam.isEmpty()) {
	    	      type = Integer.parseInt(typeParam);
	    	  } else {
	    	      // type 값이 없는 경우에 대한 처리 (기본값을 설정하거나 오류 처리 등)
	    	  }
	    	  
	         
	         int cp = 1;
	         
	         if(req.getParameter("cp") != null) {
	            cp = Integer.parseInt(req.getParameter("cp"));
	         }
	               
	         
	         HBoardService service = new HBoardService();
	         
	         Map<String, Object> map = service.checkBoardList(type,cp);
	            
	         
	            
	         
	         req.setAttribute("map", map);
	         
	         String path = "/WEB-INF/views/board/boardList.jsp";
	         
	         RequestDispatcher dispatcher = req.getRequestDispatcher(path);
	         dispatcher.forward(req, resp);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	   }

	}