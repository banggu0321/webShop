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
		System.out.println(deptid); //�����о����
		
		int idept = Integer.parseInt(deptid);
		DeptService dService = new DeptService(); //�߿�
		DeptDTO dept = dService.selectById(idept); //
		
		if(dept != null){
			request.setAttribute("deptname", dept.getDepartment_name());
			request.setAttribute("mid", dept.getManager_id());
			request.setAttribute("loc", dept.getLocation_id());
		}
		
		request.setAttribute("dept", dept); //(jsp������ �̸�,���ϳ���)
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>�Ķ���ͷ� ���� �μ���ȣ : "+deptid+"</h1>");*/
		
		/*
		 * //request�� ����� 
		 * request.setAttribute("deptname", "���ߺ�");
		 * request.setAttribute("mid", 102); 
		 * request.setAttribute("loc", 1700);
		 */
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/dept/deptDetail.jsp");
		rd.forward(request, response); //��û�ް� �����ϱ�
	}

}
