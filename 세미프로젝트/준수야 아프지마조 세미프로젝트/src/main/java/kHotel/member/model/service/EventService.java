package kHotel.member.model.service;

import java.sql.Connection;
import java.util.List;
import static kHotel.common.JDBCTemplate.commit;
import static kHotel.common.JDBCTemplate.rollback;
import static kHotel.common.JDBCTemplate.*;

import kHotel.member.model.dao.EventDAO;
import kHotel.member.model.vo.Event;

public class EventService {

	private EventDAO dao =  new EventDAO();
	
	/**이벤트 조회
	 * @return eventList
	 * @throws Exception
	 */
	public List<Event> eventList() throws Exception{
		
		Connection conn = getConnection();
		
		List<Event> eventList = dao.eventList(conn);
		
		close(conn);
		
		return eventList;
	}

	/**이벤트 종료 조회
	 * @return eventEndList
	 * @throws Exception
	 */
	public List<Event> eventEndList() throws Exception{
		
		Connection conn = getConnection();
		
		List<Event> eventEndList = dao.eventEndList(conn);
		
		close(conn);
		
		return eventEndList;
	}

}
