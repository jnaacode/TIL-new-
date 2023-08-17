package kHotel.member.controller;

import java.io.IOException;
import java.util.Enumeration;

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
import kHotel.member.model.vo.Review;
import kHotel.member.model.vo.ReviewImg;

@WebServlet("/board/review/reviewAlter")
public class ReviewAlter2 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		
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
			
			reviewImg = req.getParameter("updateImg2");
		
			
			
			if (rename != null) {
				
				
				image.setRename(folderPath + rename);
				
			}
		}
		
		// --------- 작성된 리뷰 정보 ----------------
		
		String memberId = mpReq.getParameter("memberId");
		String hotelName = mpReq.getParameter("hotelName");
		String roomName = mpReq.getParameter("roomName");
		String pic = mpReq.getParameter("pic");
		String tag = mpReq.getParameter("tag");
		String content = mpReq.getParameter("content");
		
		int star = Integer.parseInt(mpReq.getParameter("star"));
		
		
		
		Review rvUpdate2 = new Review();
		
		rvUpdate2.setUserId(memberId);
		rvUpdate2.setHotelName(hotelName);
		rvUpdate2.setRoomName(roomName);
		rvUpdate2.setReviewImg(pic);
		rvUpdate2.setTag(tag);
		rvUpdate2.setContent(content);
		rvUpdate2.setStar(star);
		// ----------------------------------------------
		
		
		// ------------수정 할 게시글 정보------------------------
	
		int boardNo = Integer.parseInt(mpReq.getParameter("no"));
		
		
		String updateImg = image.getRename();
		
		if(image.getRename() == null) {
			updateImg = rvUpdate2.getReviewImg();
		}
		
		String updateContent = mpReq.getParameter("updateContent");
		int updateStar = Integer.parseInt(mpReq.getParameter("updateStar"));
		String[] tag2 = mpReq.getParameterValues("updateTag");
		
		String updateTag = null;
		
		if(!tag2[0].equals("")) {
			updateTag = String.join(",,", tag2);
		}
		
		
		Review updateReview = new Review();
		updateReview.setBoardNo(boardNo);
		updateReview.setRename(updateImg);
		updateReview.setContent(updateContent);
		updateReview.setStar(updateStar);
		updateReview.setTag(updateTag);
		
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		
		JMemberService service = new JMemberService();
		
		
		try {
			
			int result = service.reviewAlter(rvUpdate2, loginMember ,updateReview);
			
			updateReview.setContent( updateReview.getContent().replaceAll("<br>", "\n") );

			if(result > 0) {
				session.setAttribute("message", "리뷰가 수정되었습니다.");
				
				
				
				resp.sendRedirect(req.getContextPath() + "/board/review/show?no=" + updateReview.getBoardNo() );
				
				
				
			}else {
				session.setAttribute("message", "리뷰 수정이 실패되었습니다. 다시 시도해 주세요.");
				resp.sendRedirect(req.getContextPath() + "/board/review/show?no=" + updateReview.getBoardNo() );
				
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
