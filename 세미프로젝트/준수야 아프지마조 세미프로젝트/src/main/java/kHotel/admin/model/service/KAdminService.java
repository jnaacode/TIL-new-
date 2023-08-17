package kHotel.admin.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import kHotel.admin.model.dao.KAdminDAO;
import kHotel.board.model.vo.Board;
import kHotel.board.model.vo.Event;
import kHotel.board.model.vo.EventImage;
import kHotel.common.Util;

public class KAdminService {
	
	KAdminDAO dao = new KAdminDAO();

	/** faq 목록 조회(관리자)service
	 * @param type
	 * @return fList
	 * @throws Exception
	 */
	public List<Board> fList(int type) throws Exception {
		
		Connection conn = getConnection();
		
		List<Board> fList = dao.fList(conn, type);
		
		close(conn);
		
		return fList;
	}

	/** 이벤트 작성 service
	 * @param event
	 * @param imageList
	 * @return eventNo
	 * @throws Exception
	 */
	public int insertEvent(Event event, List<EventImage> imageList) throws Exception {
		
		Connection conn= getConnection();
		
		// 1. 게시글 번호 얻어오기
		int eventNo = dao.setEventNo(conn);
		
		event.setEventNo(eventNo);
		
		// 2. XSS
		event.setEventTitle(Util.XSSHanding(event.getEventTitle()));
		event.setEventContent(Util.XSSHanding(event.getEventContent()));
		
		event.setEventContent(Util.newLineHandling(event.getEventContent()));
		
		
		
		// 3. 게시글 삽입
		int result = dao.insertEvent(conn, event);
		
		if(result > 0) {
			// 4. 이미지 삽입
			for(EventImage image : imageList) {
				image.setEventNo(eventNo);
				
				result = dao.insertEventImage(conn, image);
				
				if(result == 0) break;
			}
			
			
		}
		
		
		if(result >0) commit(conn);
		else		  rollback(conn);
		
		close(conn);
		
		
		return eventNo;
	}

	/** 게시글 수정 service
	 * @param event
	 * @param deleteList
	 * @param imageList
	 * @return result
	 * @throws Exception
	 */
	public int updateEvent(Event event, String deleteList, List<EventImage> imageList) throws Exception {
		
		
		Connection conn = getConnection();
		
		// 1. XSS
		event.setEventTitle(Util.XSSHanding(event.getEventTitle()));
		event.setEventContent(Util.XSSHanding(event.getEventContent()));
		
		event.setEventContent(Util.newLineHandling(event.getEventContent()));
		
		// 2. 게시글 수정(내용, 제목)
		int result = dao.updateContent(conn, event);
		
		if(result>0) { // 게시글 내용 수정이 성공했을 경우
			
			for(EventImage image : imageList) {
				image.setEventNo(event.getEventNo());
				
				result = dao.updateImage(conn, image);
				
				if(result == 0) { // update가 아니면 insert해라
					result = dao.insertEventImage(conn, image);
				}
			}
			
			if(!deleteList.equals("")) { // 삭제할 이미지가 있다면
				result = dao.deleteImage(conn, deleteList, event.getEventNo());
			}
		}
		
		if(result>0)	commit(conn);
		else			rollback(conn);
		
		return result;
	}

	/** 이벤트 삭제 service
	 * @param eventNo
	 * @return result
	 * @throws Exception
	 */
	public int deleteEvent(int eventNo) throws Exception {
		
		Connection conn = getConnection();
		
		int result = dao.deleteEvent(conn, eventNo);
		
		if(result>0)	commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}

}
