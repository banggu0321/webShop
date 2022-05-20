package com.kosta.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kosta.dto.BoardEmpVO;
import com.kosta.dto.BoardVO;
import com.kosta.util.DBUtil;

public class BoardDAO {
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	static final String SQL_SELECT_ALL = "SELECT * FROM tbl_board ORDER BY 1";
	static final String SQL_SELECT_POST = "SELECT * FROM tbl_board WHERE bno =?";
	static final String SQL_SELECT_WRITER = "SELECT * FROM TBL_BOARD WHERE writer =?";
	static final String SQL_SELECT_TITLE = "SELECT * FROM TBL_BOARD WHERE title=?";
	static final String SQL_SELECT_REGDATE = "SELECT * FROM TBL_BOARD WHERE regdate between ? and ?";
	static final String SQL_INSERT = "INSERT INTO tbl_board values(seq_bno.nextval,?,?,?,sysdate,sysdate)";
	static final String SQL_UPDATE = "UPDATE tbl_board SET title =?, content=?, updatedate=sysdate WHERE bno=?";
	static final String SQL_DELETE = "DELETE FROM tbl_board WHERE bno=?";
	static final String SQL_BOARDEMP = "SELECT b.bno, b.title, b.content, e.FIRST_NAME ||' '|| e.LAST_NAME fullname"
			+ "FROM TBL_BOARD b JOIN EMPLOYEES e ON (b.writer = e.EMPLOYEE_ID)";
	//b.bno, b.title, b.content, e.FIRST_NAME ||' '|| e.LAST_NAME fullname
	public List<BoardEmpVO> selectAllJoin() {
		List<BoardEmpVO> postlist = new ArrayList<>();
		BoardEmpVO board = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_BOARDEMP);
			rs = pst.executeQuery();
			while(rs.next()) {
				board = new BoardEmpVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				postlist.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return postlist;
	}
	//1. 모든 게시판 조회
	public List<BoardVO> selectAll() {
		List<BoardVO> postlist = new ArrayList<BoardVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {
				postlist.add(makepost(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return postlist;
	}
	private BoardVO makepost(ResultSet rs) throws SQLException {
		BoardVO post = new BoardVO();
		post.setBno(rs.getInt("BNO"));
		post.setContent(rs.getString("CONTENT"));
		post.setRegdate(rs.getDate("REGDATE"));
		post.setTitle(rs.getString("TITLE"));
		post.setUpdatedate(rs.getDate("UPDATEDATE"));
		post.setWriter(rs.getInt("WRITER"));
		return post;
	}
	//2. 조건조회 (해당 Bno)
		public BoardVO selectByBoardNo(int post_no) {
			BoardVO post = null;
			conn = DBUtil.getConnection();
			try {
				pst = conn.prepareStatement(SQL_SELECT_POST);
				pst.setInt(1, post_no);
				rs = pst.executeQuery();
				while(rs.next()) {
					post= makepost(rs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBUtil.dbClose(rs, pst, conn);
			}
			return post;
		}
	//3. 조건조회 (해당 writer)
	public List<BoardVO> selectByWriter(int writer_id) {
		List<BoardVO> postlist = new ArrayList<BoardVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_WRITER);
			pst.setInt(1, writer_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				postlist.add(makepost(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return postlist;
	}
	//4. 조건조회 (해당 title) SQL_SELECT_TITLE
	public List<BoardVO> selectByTitle(String title) {
		List<BoardVO> postlist = new ArrayList<BoardVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_TITLE);
			pst.setString(1, title);
			rs = pst.executeQuery();
			while(rs.next()) {
				postlist.add(makepost(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return postlist;
	}
	//5. 조건조회 (해당 regdate) SQL_SELECT_REGDATE between ? and ?
	public List<BoardVO> selectByRegDate(Date sdate, Date edate) {
		List<BoardVO> postlist = new ArrayList<BoardVO>();
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_SELECT_REGDATE);
			pst.setDate(1, sdate);
			pst.setDate(2, edate);
			rs = pst.executeQuery();
			while(rs.next()) {
				postlist.add(makepost(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return postlist;
	}
	//INSERT
	public int boardInsert(BoardVO post) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_INSERT);
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getContent());
			pst.setInt(3, post.getWriter());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
	//UPDATE
	public int boardUpdate(BoardVO post) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_UPDATE);
			pst.setString(1, post.getTitle());
			pst.setString(2, post.getContent());
			pst.setInt(3, post.getBno());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
	//DELETE
	public int boardDelete(int writer_id) {
		int result = 0;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setInt(1, writer_id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(rs, pst, conn);
		}
		return result;
	}
}
