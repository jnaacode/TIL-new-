package kHotel.member.model.dao;

import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static kHotel.common.JDBCTemplate.*;

import kHotel.member.model.vo.Board;

public class BoardDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private Properties prop;

	// 기본 생성자
	public BoardDAO() {
		try {
			prop = new Properties();

			String filePath = BoardDAO.class.getResource("/kHotel/sql/PHotel-sql.xml").getPath();

			prop.loadFromXML(new FileInputStream(filePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * FAQ 보기
	 * 
	 * @param conn
	 * @param memberNo
	 * @return
	 * @throws Exception
	 */
	public List<Board> searchBoardList(Connection conn, int memberNo) throws Exception {

		List<Board> boardList = new ArrayList<Board>();

		try {

			String sql = prop.getProperty("searchBoardList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardDt(rs.getString(3));

				boardList.add(board);

				
			}

		} finally {
			close(pstmt);
			close(rs);

		}
		return boardList;
	}

	/**
	 * 리뷰 보기
	 * 
	 * @param conn
	 * @param memberNo
	 * @return memberNo
	 * @throws Exception
	 */
	public List<Board> searhQnaList(Connection conn, int memberNo) throws Exception {

		List<Board> boardList = new ArrayList<Board>();

		try {

			String sql = prop.getProperty("searchReviewList");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setBoardTitle(rs.getString(2));
				board.setBoardDt(rs.getString(3));

				boardList.add(board);

			}

		} finally {
			close(pstmt);
			close(rs);

		}

		return boardList;
	}

}
