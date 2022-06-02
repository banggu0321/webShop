package com.kosta.designpattern;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;

public class BoardListController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		BoardService service = new BoardService();
		List<BoardVO> blist = service.selectAll();
		
		request.setAttribute("boardDatas", blist); //�����������,java���ϳ���
		request.setAttribute("boardSize", blist.size());
		
		return "boardList.jsp";
	}
}
