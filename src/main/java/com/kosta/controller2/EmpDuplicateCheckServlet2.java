package com.kosta.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.EmpService;

/**
 * Servlet implementation class EmpDuplicateCheckServlet
 */
@WebServlet("/emp/duplicateCheck2.do")
public class EmpDuplicateCheckServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("dataEmail");
		//if(email==null) return ;
		//System.out.println("email: "+ email);
		
		//DB�� ���� id�� �����ϴ��� üũ�Ѵ� ??empService-> empDAO->DB
		EmpService service = new EmpService();
		int count = service.selectByEmail(email);
		System.out.println("count"+count);
		PrintWriter out = response.getWriter();
		out.print(count);
		//0�̸� ��ϵ� �� X -> ��� ���� 
		//1�̸� ��ϵ� �� O -> ��� �Ұ�
		/*
		EmpService service = new EmpService();
		EmpVO emp2 = service.selectByEmail(email);
		PrintWriter out = response.getWriter();
		out.print(emp2==null?0:1);
		 */
	}
	

}
