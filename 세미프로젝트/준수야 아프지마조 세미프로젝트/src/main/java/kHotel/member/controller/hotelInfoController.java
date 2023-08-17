package kHotel.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kHotel.member.model.service.LHotelService;
import kHotel.member.model.vo.LikeList;

@WebServlet("/hotelinfo/*")
public class hotelInfoController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = uri.substring(  (contextPath + "/hotelinfo/").length()  );
		
		if(command.equals("main")) {
			String path = "/WEB-INF/views/hotel/hotelinfo.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		}
		// 호텔 강남
		if(command.equals("hotel1")) {
			String path = "/WEB-INF/views/hotel/hotelinfo2_1.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		}
		// 강남 객실
		if(command.equals("gangnam")) {
			String path = "/WEB-INF/views/hotel/hotelroominfo.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
			
		}
		// 호텔 종로
		if(command.equals("hotel2")) {
			String path = "/WEB-INF/views/hotel/hotelinfo2_2.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		}
		// 종로 객실
		if(command.equals("jongro")) {
			String path = "/WEB-INF/views/hotel/hotelroominfo2.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		}
		// 호텔 당산
		if(command.equals("hotel3")) {
			String path = "/WEB-INF/views/hotel/hotelinfo2_3.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		}
		// 당산 객실
		if(command.equals("dangsan")) {
			String path = "/WEB-INF/views/hotel/hotelroominfo3.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			
			dispatcher.forward(req, resp);
		}
		
		
		
		
		
		// *************************찜하기 강남 1번!**********************************
		if(command.equals("likeplus1")) {
			
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			String roomNm1 = req.getParameter("roomNm1");
			String hotelNm1 = req.getParameter("hotelNm1");
			
			
			LHotelService service = new LHotelService();
			
			LikeList lk = new LikeList();
			lk.setMemberNo(memberNo);
			lk.setRoomNm1(roomNm1);
			lk.setHotelNm1(hotelNm1);
			
			
			try {
				
				int result = service.likeplus1(lk);
				
				if(result > 0) {
					
					resp.getWriter().print(result);
					
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		// 찜삭제 강남 1번
		if(command.equals("likeDel1")) {
			
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			String roomNm1 = req.getParameter("roomNm1");
			String hotelNm1 = req.getParameter("hotelNm1");
			
			LHotelService service = new LHotelService();
			
			LikeList lk = new LikeList();
			lk.setMemberNo(memberNo);
			lk.setRoomNm1(roomNm1);
			lk.setHotelNm1(hotelNm1);
			
			try {
				
				int result = service.likeDel1(lk);
				
				if(result > 0) {
					
					resp.getWriter().print(result);
					
				}
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		

		// !!!!!!!!!!!!!!!!!!!!!!!!찜 여부 확인 !!!!!!!!!!!!!!!!!!!!!!!!!
		if(command.equals("likeDisplay")) {
			
			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			String roomNm1 = req.getParameter("roomNm1");
			String roomNm2 = req.getParameter("roomNm2");
			String roomNm3 = req.getParameter("roomNm3");
			String hotelNm1 = req.getParameter("hotelNm1");
			
			LHotelService service = new LHotelService();
			
			LikeList lk = new LikeList();
			lk.setMemberNo(memberNo);
			lk.setRoomNm1(roomNm1);
			lk.setRoomNm2(roomNm2);
			lk.setRoomNm3(roomNm3);
			lk.setHotelNm1(hotelNm1);
			
			try {
				
				LikeList countList = new LikeList();
				
				// likelist테이블에 값이 있는지 없는지 확인해서 찜하기에 스타일 추가해야함
				int count = service.likeCount(lk);
				int count2 = service.likeCount2(lk);
				int count3 = service.likeCount3(lk);
				
				
				countList.setCount(count);
				countList.setCount2(count2);
				countList.setCount3(count3);
					
				
				new Gson().toJson(countList, resp.getWriter());
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		// *************************찜하기 강남 2번!********************************
		if (command.equals("likeplus2")) {

			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			String roomNm2 = req.getParameter("roomNm2");
			String hotelNm1 = req.getParameter("hotelNm1");

			LHotelService service = new LHotelService();

			LikeList lk = new LikeList();
			lk.setMemberNo(memberNo);
			lk.setRoomNm2(roomNm2);
			lk.setHotelNm1(hotelNm1);
			
			

			try {
				
				int result = service.likeplus2(lk);
				

				if (result > 0) {

					resp.getWriter().print(result);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 찜삭제 강남 2번
		if (command.equals("likeDel2")) {

			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			String roomNm2 = req.getParameter("roomNm2");
			String hotelNm1 = req.getParameter("hotelNm1");

			LHotelService service = new LHotelService();

			LikeList lk = new LikeList();
			lk.setMemberNo(memberNo);
			lk.setRoomNm2(roomNm2);
			lk.setHotelNm1(hotelNm1);
			

			try {

				int result = service.likeDel2(lk);

				if (result > 0) {

					resp.getWriter().print(result);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		
		// ******************찜하기 강남 3번!******************************
		if (command.equals("likeplus3")) {

			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			String roomNm3 = req.getParameter("roomNm3");
			String hotelNm1 = req.getParameter("hotelNm1");

			LHotelService service = new LHotelService();

			LikeList lk = new LikeList();
			lk.setMemberNo(memberNo);
			lk.setRoomNm3(roomNm3);
			lk.setHotelNm1(hotelNm1);

			try {

				int result = service.likeplus3(lk);

				if (result > 0) {

					resp.getWriter().print(result);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// 찜삭제 강남 3번
		if (command.equals("likeDel3")) {

			int memberNo = Integer.parseInt(req.getParameter("memberNo"));
			String roomNm3 = req.getParameter("roomNm3");
			String hotelNm1 = req.getParameter("hotelNm1");

			LHotelService service = new LHotelService();

			LikeList lk = new LikeList();
			lk.setMemberNo(memberNo);
			lk.setRoomNm3(roomNm3);
			lk.setHotelNm1(hotelNm1);

			try {

				int result = service.likeDel3(lk);

				if (result > 0) {

					resp.getWriter().print(result);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
