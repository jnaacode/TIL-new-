package kHotel.admin.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kHotel.admin.model.service.KAdminService;
import kHotel.board.model.service.KBoardService;
import kHotel.board.model.vo.Event;
import kHotel.board.model.vo.EventImage;
import kHotel.common.MyRenamePolicy;
import kHotel.member.model.vo.Member;

@WebServlet("/admin/eventWrite")
public class AdminEventWriteServlet extends HttpServlet {

	// 사이드바에서 이벤트 선택할 시
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			
			 String mode = req.getParameter("mode");
			 
			 
			 
			 if(mode.equals("update")) {
				 // 무슨 게시글 수정할지
				 int eventNo = Integer.parseInt(req.getParameter("no"));
				 
				 // 수정 화면에 들어갈 내용
				 Event event = new KBoardService().selectEventDetail(eventNo);
				 
				 // 개행문자 처리
				 event.setEventContent(event.getEventContent().replaceAll("<br>", "\n"));
				 
				 req.setAttribute("event", event);
			 
			 }
			 String path = "/WEB-INF/views/admin/AdminEventWrite.jsp";
			 
			 req.getRequestDispatcher(path).forward(req, resp);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 찐 글 등록
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			// multiPartRequest
			// 최대 용량, 이미지 저장 경로, 파일명, 인코딩 설정
			int maxSize = 1024 * 1024 * 80;

			HttpSession session = req.getSession();
			String root = session.getServletContext().getRealPath("/");
			String folderPath = "/resources/images/event/";
			String filePath = root + folderPath;

			String encoding = "UTF-8";

			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());

			Enumeration<String> files = mpReq.getFileNames();

			List<EventImage> imageList = new ArrayList<>();

			while (files.hasMoreElements()) { // 다음 요소가 있을 때

				String name = files.nextElement();

				String rename = mpReq.getFilesystemName(name);

				String original = mpReq.getOriginalFileName(name);

				if (original != null) { // 실제로 파일이 담겨있는 경우
					EventImage image = new EventImage();

					image.setImageRename(folderPath + rename);
					image.setImageLevel(Integer.parseInt(name));

					imageList.add(image);
				}

			}

			// 글 제목, 내용, 회원번호(관리자이지만 혹시 몰라서)
			String title = mpReq.getParameter("K-title");
			String content = mpReq.getParameter("K-content");
			String date = mpReq.getParameter("K-date");

			Member loginMember = (Member) session.getAttribute("loginMember");
			int memberNo = loginMember.getMemberNo();

			Event event = new Event();

			event.setEventTitle(title);
			event.setEventContent(content);
			event.setEventDt(date);

			KAdminService service = new KAdminService();

			String mode = mpReq.getParameter("mode");
			

			if (mode.equals("insert")) {
				
				int eventNo = service.insertEvent(event, imageList);

				String path = null;

				if (eventNo > 0) {
					session.setAttribute("message", "게시글이 등록되었습니다.");
					path = req.getContextPath() + "/event/detail?no=" + eventNo;
					
				} else {
					session.setAttribute("message", "게시글 등록 실패");
					path = "eventWrite?mode=insert";
				}

				resp.sendRedirect(path);

			}

			if (mode.equals("update")) {
				
				int eventNo = Integer.parseInt(mpReq.getParameter("no")); // 어떤 게시글 수정할 건지
				
				String deleteList = mpReq.getParameter("deleteList"); // 이미지 변경사항(삭제) 목록
							
				event.setEventNo(eventNo);
				
				int result = service.updateEvent(event, deleteList, imageList);
				
				String path = null;
				String message = null;
				
				if(result>0) {
					message = "수정 성공";
					path = req.getContextPath() + "/event/detail?no=" + eventNo;
				} else {
					message = "수정 실패";
					path = req.getHeader("referer");
				}
				
				session.setAttribute("message", message);
				resp.sendRedirect(path);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
