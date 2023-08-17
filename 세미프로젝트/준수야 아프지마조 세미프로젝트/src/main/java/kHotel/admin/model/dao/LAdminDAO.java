package kHotel.admin.model.dao;

import static kHotel.common.JDBCTemplate.*;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kHotel.admin.model.dao.LAdminDAO;
import kHotel.admin.model.vo.LAdminPagination;
import kHotel.admin.model.vo.LAdminPay;
import kHotel.admin.model.vo.LAdminReport;
import kHotel.member.model.vo.LPagination;

public class LAdminDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public LAdminDAO() {
		
		try {
			
			prop = new Properties();
			
			String filePath = LAdminDAO.class.getResource("/kHotel/sql/LAdmin-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/** 게시판 이름 조회 DAO
	 * @param conn
	 * @param type
	 * @return boardName
	 * @throws Exception
	 */
	public String selectBoardName(Connection conn, int type) throws Exception{
		
		String boardName = null;
		
		try {
			String sql = prop.getProperty("selectBoardName");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, type);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardName = rs.getString(1);
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		return boardName;
	}

	/** 신고 게시판 게시글 수 조회 DAO
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn) throws Exception {
		
		int listCount = 0;
		
		try {
			String sql = prop.getProperty("getListCount");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		
		return listCount;
	}

	/** 게시글 목록 조회 DAO
	 * @param conn
	 * @param lAdminPagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<LAdminReport> selectBoardList(Connection conn, LAdminPagination lAdminPagination, int type) throws Exception{
		
		List<LAdminReport> boardList = new ArrayList<LAdminReport>();
		
		try {
			
			String sql = prop.getProperty("selectBoardList");
			
			int start = (lAdminPagination.getCurrentPage() - 1) * lAdminPagination.getLimit() + 1;
			
			int end = start + lAdminPagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				LAdminReport ar = new LAdminReport();
				
				ar.setBoardNo( rs.getInt("BOARD_NO"));
				ar.setReportContent(rs.getString("REPORT_CONTENT"));
				ar.setReportPerson(rs.getString("MEMBER_ID"));
				ar.setReportDt(rs.getString("BOARD_DT"));
				
				
				boardList.add(ar);
				
			}
			
			
		}finally {
			
			close(rs);
			close(pstmt);
			
		}
		
		
		
		return boardList;
	}
	
	
	
	/** 결제 목록 수 DAO
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int getPayListCount(Connection conn) throws Exception{
		
		int listCount = 0;
		
		try {
			String sql = prop.getProperty("getPayListCount");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
			
		}finally {
			close(rs);
			close(stmt);
			
		}
		
		return listCount;
	}
	

	/** 결제 목록 조회 DAO
	 * @param conn
	 * @param lPagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<LAdminPay> selectPayList(Connection conn, LPagination LPagination, int type) throws Exception {
		
		List<LAdminPay> boardList = new ArrayList<>();
		
		try {
			
			String sql = prop.getProperty("selectPayList");
			
			int start = (LPagination.getCurrentPage() - 1) * LPagination.getLimit() + 1;
			
			int end = start + LPagination.getLimit() - 1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				LAdminPay lp = new LAdminPay();
				
				lp.setCalculateNo( rs.getInt("CALCULATE_NO"));
				lp.setCalculateWay( rs.getString("CALCULATE_WAY") );
				lp.setCalculatePrice( rs.getInt("CALCULATE_PRICE"));
				lp.setMemberId(rs.getString("MEMBER_ID"));
				lp.setCalculateSt(rs.getString("CALCULATE_ST"));
				lp.setCheckInDt(rs.getString("CHECKIN_DT"));
				lp.setBookNo(rs.getInt("BOOK_NO"));
				
				boardList.add(lp);
			}
			
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;
	}

	/** 결제 관리 DAO
	 * @param conn
	 * @param calculateNo
	 * @return result
	 * @throws Exception
	 */
	public int agreePay(Connection conn, int calculateNo) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("agreePay");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, calculateNo);
			
			result = pstmt.executeUpdate();
		
		}finally {
			
			close(pstmt);
			
		}
		
		
		return result;
	}

	/** 결제 목록 조회 ajax DAO
	 * @param conn
	 * @return LadpList
	 * @throws Exception
	 */
	public List<LAdminPay> adminPayList(Connection conn) throws Exception{

		List<LAdminPay> LadpList = new ArrayList<LAdminPay>();
		
		try {
			
			String sql = prop.getProperty("adminPayList");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				LAdminPay lp = new LAdminPay();
				
				lp.setCalculateNo(rs.getInt("CALCULATE_NO"));
				lp.setCalculateWay( rs.getString("CALCULATE_WAY") );
				lp.setCalculatePrice( rs.getInt("CALCULATE_PRICE"));
				lp.setMemberId(rs.getString("MEMBER_ID"));
				lp.setCalculateSt(rs.getString("CALCULATE_ST"));
				lp.setCheckInDt(rs.getString("CHECKIN_DT"));
				
				
				LadpList.add(lp);
				
			}
			
			
			
		}finally {
			close(rs);
			close(stmt);
		}
		
		
		
		
		return LadpList;
	}



	

}
