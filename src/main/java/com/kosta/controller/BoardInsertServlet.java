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
    
	//입력 form보여주기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletContext에 저장된 정보 얻기
		ServletContext app = getServletContext();
		String my = (String)app.getAttribute("myname");
		System.out.println("app에 저장된 정보 " + my);
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("boardInsert.jsp");
		rd.forward(request, response);
	}
	//입력된 data를 DB에 저장하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//filter로 처리함 -> request.setCharacterEncoding("utf-8");

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
		int result = service.boardInsert(board); //보내기 후 1,0
		
		//Redirect : 주소창을 바꾼다
		//forward : 요청 주소창을 바꾸지 않는다. 요청과 응답이 다른 문서이다.
		
		response.sendRedirect("boardlist.do");
		
		/*
		 * 
		 String message = "insert실패";
		 if(result>0) message="insert성공";
		 request.setAttribute("message", message);
		 * RequestDispatcher rd; 
		 * rd = request.getRequestDispatcher("result.jsp");
		 * rd.forward(request, response);
		 */
	}

}
