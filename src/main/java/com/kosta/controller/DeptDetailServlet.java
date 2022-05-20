package com.kosta.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.DeptDTO;
import com.kosta.model.DeptService;

/**
 * Servlet implementation class DeptDetailServlet
 */
@WebServlet("/html/dept.do")
public class DeptDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String deptid = request.getParameter("dept_id"); 
		System.out.println(deptid); //변수읽어오기
		
		int idept = Integer.parseInt(deptid);
		DeptService dService = new DeptService(); //중요
		DeptDTO dept = dService.selectById(idept); //
		
		if(dept != null){
			request.setAttribute("deptname", dept.getDepartment_name());
			request.setAttribute("mid", dept.getManager_id());
			request.setAttribute("loc", dept.getLocation_id());
		}
		
		request.setAttribute("dept", dept); //(jsp파일의 이름,파일내부)
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>파라메터로 받은 부서번호 : "+deptid+"</h1>");*/
		
		/*
		 * //request에 저장됨 
		 * request.setAttribute("deptname", "개발부");
		 * request.setAttribute("mid", 102); 
		 * request.setAttribute("loc", 1700);
		 */
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/dept/deptDetail.jsp");
		rd.forward(request, response); //요청받고 응답하기
	}

}
