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

import kHotel.admin.model.vo.PAdminMemebr;
import kHotel.member.model.vo.LPagination;

public class PAdminDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	public PAdminDAO() {

		try {

			prop = new Properties();

			String filePath = LAdminDAO.class.getResource("/kHotel/sql/PHotel-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 관리자 회원 목록 수 DAO (쓰는것)
	 * 
	 * @param conn
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn) throws Exception {

		int listCount = 0;

		try {

			String sql = prop.getProperty("listCountMember");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				listCount = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(stmt);
		}

		return listCount;
	}

	/**
	 * 신고 당한 회원 수 조회
	 * 
	 * @param conn
	 * @param memberNo
	 * @return listReportCount
	 * @throws Exception
	 */
	public int getListReportCount(Connection conn, int listCount, int member_no) throws Exception {

		int listReportCount = 0;

		try {

			String sql = prop.getProperty("listReportCount");

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member_no);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				listReportCount = rs.getInt(1);
			}

		} finally {
			close(pstmt);
			close(rs);
		}

		return listReportCount;
	}

	/**
	 * 관리자 회원 목록 조회
	 * 
	 * @param conn
	 * @param lPagination
	 * @param type
	 * @return boardList
	 * @throws Exception
	 */
	public List<PAdminMemebr> selectBoardList(Connection conn, LPagination lPagination, int type) throws Exception {

		List<PAdminMemebr> boardList = new ArrayList<PAdminMemebr>();

		try {
			String sql = prop.getProperty("selectBoardList");

			int start = (lPagination.getCurrentPage() - 1) * lPagination.getLimit() + 1;

			int end = start + lPagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				PAdminMemebr am = new PAdminMemebr();
				am.setMemberNo(rs.getInt("MEMBER_NO"));
				am.setMemberId(rs.getString("MEMBER_ID"));
				am.setMemebrTel(rs.getString("MEMBER_TEL"));
				am.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				am.setMemberAdd(rs.getString("MEMBER_ADD"));
				am.setSecessionFl(rs.getString("SECESSION_FL"));

				boardList.add(am);

			}

		} finally {
			close(rs);
			close(pstmt);
		}

		return boardList;
	}



	/**
	 * 아이디 검색 시 아이디 검색 결과 수 출력
	 * 
	 * @param conn
	 * @param pid
	 * @return listCount
	 * @throws Exception
	 */
	public int getListCount(Connection conn, String condition) throws Exception {

		int listCount = 0;

		try {

			String sql = prop.getProperty("searchIdCount") + condition;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				listCount = rs.getInt(1);
			}

		} finally {
			close(rs);
			close(stmt);

		}

		return listCount;

	}

	/**
	 * 아이디 검색 시 조건 조회
	 * 
	 * @param conn
	 * @param lPagination
	 * @param type
	 * @param condition
	 * @return boardList
	 * @throws Exception
	 */
	public List<PAdminMemebr> searchBoardList(Connection conn, LPagination lPagination, String condition, int type)
			throws Exception {

		List<PAdminMemebr> boardList = new ArrayList<PAdminMemebr>();

		try {

			String sql = prop.getProperty("searchId1") + condition + prop.getProperty("searchId2");

			int start = (lPagination.getCurrentPage() - 1) * lPagination.getLimit() + 1;
			int end = start + lPagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				PAdminMemebr am = new PAdminMemebr();
				am.setMemberNo(rs.getInt("MEMBER_NO"));
				am.setMemberId(rs.getString("MEMBER_ID"));
				am.setMemebrTel(rs.getString("MEMBER_TEL"));
				am.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				am.setMemberAdd(rs.getString("MEMBER_ADD"));
				am.setSecessionFl(rs.getString("SECESSION_FL"));

				boardList.add(am);

			}

		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardList;

	}

	public int adminDeleteMember(Connection conn, int memberNo, int type, LPagination lPagination) throws Exception{
		
		int result = 0;
		
		try {
			
			String sql = prop.getProperty("adminDeleteMember");
			
			int start = (lPagination.getCurrentPage() - 1) * lPagination.getLimit() + 1;
			int end = start + lPagination.getLimit() - 1;

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
			
		}
		
		return result;
	}

	

}