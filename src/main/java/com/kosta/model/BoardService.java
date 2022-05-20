package com.kosta.model;

import java.sql.Date;
import java.util.List;

import com.kosta.dto.BoardEmpVO;
import com.kosta.dto.BoardVO;

public class BoardService {
	BoardDAO boardDAO = new BoardDAO();
	
	//b.bno, b.title, b.content, e.FIRST_NAME ||' '|| e.LAST_NAME fullname
	public List<BoardEmpVO> selectAllJoin() {
		return boardDAO.selectAllJoin();
	}
	//1. 모든 게시판 조회
	public List<BoardVO> selectAll() {
		return boardDAO.selectAll();
	}
	//2. 조건조회 (해당 Bno)
	public BoardVO selectByBoardNo(int post_no) {
		return boardDAO.selectByBoardNo(post_no);
	}
	//3. 조건조회 (해당 writer)
	public List<BoardVO> selectByWriter(int writer_id) {
		return boardDAO.selectByWriter(writer_id);
	}
	//4. 조건조회 (해당 title) SQL_SELECT_TITLE
	public List<BoardVO> selectByTitle(String title) {
		return boardDAO.selectByTitle(title);
	}
	//5. 조건조회 (해당 regdate) SQL_SELECT_REGDATE between ? and ?
	public List<BoardVO> selectByRegDate(Date sdate, Date edate) {
		return boardDAO.selectByRegDate(sdate, edate);
	}
	//INSERT
	public int boardInsert(BoardVO post) {
		return boardDAO.boardInsert(post);
	}
	//UPDATE
	public int boardUpdate(BoardVO post) {
		return boardDAO.boardUpdate(post);
	}
	//DELETE
	public int boardDelete(int writer_id) {
		return boardDAO.boardDelete(writer_id);
	}
}
