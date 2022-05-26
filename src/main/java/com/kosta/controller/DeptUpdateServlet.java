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

@WebServlet("/dept/deptUpdate.do")
public class DeptUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//filter�� ó���� -> request.setCharacterEncoding("utf-8");
		
		int deparment_id = Integer.parseInt(request.getParameter("department_id")); 
		int manager_id = Integer.parseInt(request.getParameter("manager_id")); 
		int location_id = Integer.parseInt(request.getParameter("location_id")); 
		String department_name = request.getParameter("department_name");
		
		DeptDTO dept = new DeptDTO(deparment_id, department_name, manager_id, location_id);
		DeptService service = new DeptService();
		request.setAttribute("message", service.deptUpdate(dept)>0?"Update����":"Update����");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}
}
