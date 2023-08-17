package kHotel.member.model.service;

import static kHotel.common.JDBCTemplate.*;

import java.sql.Connection;

import kHotel.member.model.dao.LHotelDAO;
import kHotel.member.model.vo.LikeList;

public class LHotelService {
	
	LHotelDAO dao = new LHotelDAO();
	
	
	/** ********************찜하기 1번 객실 Service
	 * @param lk
	 * @return result
	 * @throws Exception
	 */
	public int likeplus1(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo (객실 번호) 받아오기
		int roomNo = dao.searchRoomNo(conn, lk);
		
		// 받아온 객실번호와 사용자 번호로 찜목록에 추가
		int result = dao.insertLikeList(conn, lk, roomNo);
		
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		
		return result;
	}


	/** 찜삭제 1번 객실 Service
	 * @param lk
	 * @return
	 * @throws Exception
	 */
	public int likeDel1(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo (객실 번호) 받아오기
		int roomNo = dao.searchRoomNo(conn, lk);

		
		// 받아온 객실번호와 사용자 번호로 찜목록에서 삭제
		int result = dao.deleteLikeList(conn, lk, roomNo);
		
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
				
		return result;
	}

	
	
	/** !!!!!!!!!!!!!!!!!!!찜 여부 확인 Service
	 * @param lk
	 * @return count
	 * @throws Exception
	 */
	public int likeCount(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo (객실 번호) 받아오기 1번객실에 대한 조회
		int roomNo = dao.searchRoomNo(conn, lk);
		
		// 객실이 찜이 되었는지 확인
		int count = dao.likeCount(conn, lk, roomNo);
				
		if(count > 0) commit(conn);
		else			rollback(conn);
		
		return count;
	}
	
	
	

	/** *********************찜하기 2번 객실 Service
	 * @param lk
	 * @return result
	 * @throws Exception
	 */
	public int likeplus2(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo 2번 객실 (객실 번호) 받아오기
		int roomNo2 = dao.searchRoomNo2(conn, lk);
		
		// 받아온 객실번호와 사용자 번호로 찜목록에 추가
		int result = dao.insertLikeList2(conn, lk, roomNo2);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		
		return result;
	}



	/** 찜삭제 2번 객실 Service
	 * @param lk
	 * @return result
	 * @throws Exception
	 */
	public int likeDel2(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo 2번 객실 (객실 번호) 받아오기
		int roomNo2 = dao.searchRoomNo2(conn, lk);

		
		// 받아온 객실번호와 사용자 번호로 찜목록에서 삭제
		int result = dao.deleteLikeList2(conn, lk, roomNo2);
		
		
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		
				
		return result;
	}


	/** !!!!!!!!!!!!!!!!!!!찜 여부 확인2 Service
	 * @param lk
	 * @return count2
	 * @throws Exception
	 */
	public int likeCount2(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo (객실 번호) 받아오기 1번객실에 대한 조회
		int roomNo2 = dao.searchRoomNo2(conn, lk);
		
		// 객실이 찜이 되었는지 확인
		int count2 = dao.likeCount2(conn, lk, roomNo2);
				
		if(count2 > 0) commit(conn);
		else			rollback(conn);
		
		return count2;
	}


	/** ********************찜하기 3번 객실 Service
	 * @param lk
	 * @return result
	 * @throws Exception
	 */
	public int likeplus3(LikeList lk) throws Exception{
		
Connection conn = getConnection();
		
		// roomNo (객실 번호) 받아오기
		int roomNo3 = dao.searchRoomNo3(conn, lk);
		
		// 받아온 객실번호와 사용자 번호로 찜목록에 추가
		int result = dao.insertLikeList3(conn, lk, roomNo3);
		
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		
		return result;
	}


	
	/** 찜삭제 3번 객실 Service
	 * @param lk
	 * @return result
	 * @throws Exception
	 */
	public int likeDel3(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo 2번 객실 (객실 번호) 받아오기
		int roomNo3 = dao.searchRoomNo3(conn, lk);

		
		// 받아온 객실번호와 사용자 번호로 찜목록에서 삭제
		int result = dao.deleteLikeList3(conn, lk, roomNo3);
		
		
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		
				
		return result;
	}


	
	/** !!!!!!!!!!!!!!!!!!!찜 여부 확인2 Service
	 * @param lk
	 * @return count2
	 * @throws Exception
	 */
	public int likeCount3(LikeList lk) throws Exception{
		
		Connection conn = getConnection();
		
		// roomNo (객실 번호) 받아오기 1번객실에 대한 조회
		int roomNo3 = dao.searchRoomNo3(conn, lk);
		
		// 객실이 찜이 되었는지 확인
		int count3 = dao.likeCount3(conn, lk, roomNo3);
				
		if(count3 > 0) commit(conn);
		else			rollback(conn);
		
		return count3;
	}
	
	

}
