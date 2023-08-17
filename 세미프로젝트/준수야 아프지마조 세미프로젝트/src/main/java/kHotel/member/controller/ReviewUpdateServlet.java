package kHotel.member.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import kHotel.common.MyRenamePolicy;
import kHotel.member.model.service.JMemberService;
import kHotel.member.model.vo.Member;
import kHotel.member.model.vo.Reservation;
import kHotel.member.model.vo.Review;
import kHotel.member.model.vo.ReviewImg;

@WebServlet("/member/mypage/review4")
public class ReviewUpdateServlet extends HttpServlet{
	


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int bookNo = Integer.parseInt(req.getParameter("no"));
			
			HttpSession session = req.getSession();
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			JMemberService service = new JMemberService();
			
			String path = null;

			// -------------------------------------------------------------------
			
			// 저장되는 이미지 크기
			int maxSize = 1024 * 1024 * 100;

			// 최상위 경로
			String root = session.getServletContext().getRealPath("/");

			// 파일이 저장되는 경로
			String folderPath = "/resources/images/reviewImg/";

			// reviewImg 폴더 까지의 경로
			String filePath = root + folderPath;

			String encoding = "UTF-8";
			MultipartRequest mpReq = new MultipartRequest(req, filePath, maxSize, encoding, new MyRenamePolicy());
			
			Enumeration<String> files = mpReq.getFileNames();

			// 지정된 파일명 변경 정책에 맞게 이름이 바뀐 파일이 저장됨
			String reviewImg = null;
			ReviewImg image = new ReviewImg();
			while(files.hasMoreElements()) {
				
				String name = files.nextElement();
				String rename = mpReq.getFilesystemName(name);
				
				reviewImg = req.getParameter("reviewImg");
			
				
				
				if (rename != null) {
					
					
					image.setRename(folderPath + rename);
					/* image.setImageLevel(Integer.parseInt(name)); */
					
				}
			}
			
			
			/* String reviewImg = folderPath + mpReq.getFilesystemName("JreviewImage"); */
			
			


			
			int delete = Integer.parseInt(mpReq.getParameter("Jdelete"));

			if (delete == 0) {

				/* reviewImg = null; */
			}
			
			// 이미지 정보
			
			
			
		    // --------------------------------------------------------------------
			
			// 리뷰 등록
			String content = mpReq.getParameter("reviewContent");
			
			int star = Integer.parseInt(mpReq.getParameter("rating")); 
			
			
			// -----------------------------------------------------------------
			
			// 태그 등록
			String[] tag = mpReq.getParameterValues("tag");
			String realTag = null;
			
				
				if(!tag[0].equals("")) {
						
					realTag = String.join(",,", tag);
				}
			
			
			// -----------------------------------------------------------------
			
			String userId = loginMember.getMemberId();
		
			
			Review rv = new Review();
			
			rv.setContent(content);
			rv.setUserId(userId);
			rv.setStar(star);
			rv.setTag(realTag);
			rv.setBookNo(bookNo);
			
			int memberNo = loginMember.getMemberNo();
			
			rv.setMemberNo(memberNo);
			
			
			int result = service.reviewUpdate(rv, image);
			
			String message = null;
			
			if(result > 0) {
				
				message = "작성 성공";
				
				path = req.getContextPath() + "/board/review/show?no=" + rv.getBoardNo();
				
			}else {
				
				path = req.getHeader("referer");
				
				message = "작성 실패";
				
			}
			
			session.setAttribute("message", message);
			resp.sendRedirect(path);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
