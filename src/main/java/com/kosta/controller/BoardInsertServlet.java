package com.kosta.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.BoardVO;
import com.kosta.model.BoardService;
import com.kosta.util.UploadFileHelper;

@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//�Է� form�����ֱ�
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext�� ����� ���� ���
		ServletContext app = getServletContext();
		String my = (String)app.getAttribute("myname");
		System.out.println("app�� ����� ���� " + my);
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardInsert.jsp");
		rd.forward(request, response);
	}
	//�Էµ� data�� DB�� �����ϱ�
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//filter�� ó���� -> request.setCharacterEncoding("utf-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer = Integer.parseInt(request.getParameter("writer"));
		Map<String, Object> map = (Map<String, Object>)UploadFileHelper.uploadFile("uploads", request);
		List<String> fileNames = (List<String>) map.get("photos");
		String pic = fileNames.get(0);
	
		
		BoardVO board = new BoardVO(0,title,content,writer,null,null);
		board.setPic(pic);
		
		System.out.println(board);
		BoardService service = new BoardService();
		int result = service.boardInsert(board); //������ �� 1,0
		
		//Redirect : �ּ�â�� �ٲ۴�
		//forward : ��û �ּ�â�� �ٲ��� �ʴ´�. ��û�� ������ �ٸ� �����̴�.
		
		response.sendRedirect("boardlist.do");
		
		/*
		 * 
		 String message = "insert����";
		 if(result>0) message="insert����";
		 request.setAttribute("message", message);
		 * RequestDispatcher rd; 
		 * rd = request.getRequestDispatcher("result.jsp");
		 * rd.forward(request, response);
		 */
	}

}
