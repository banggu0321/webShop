package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/html/login2.do")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get��û�� �ּ�â�� �Ķ���Ͱ� �ڵ����� ���ڵ��Ǿ� �Ѿ�´�. �ѱ� ��������
		//post��û�� ��û ������ body�� �Ķ��Ÿ�� ���ڵ� X �Ѿ�´�. �ѱ۱���
		request.setCharacterEncoding("utf-8");//post������ �ʿ�
		String id = request.getParameter("a");
		String pass = request.getParameter("b");
		String email = request.getParameter("c");
		String address = request.getParameter("d");		
		
		System.out.println(id);
		System.out.println(pass);
		System.out.println(email);
		System.out.println(address);
		System.out.println(request.getMethod());
		System.out.println(request.getContextPath());
		
		/*
		//���乮���� Ÿ�԰� ���ڵ� ����� ���乮������� ���� setting�Ѵ�.
		response.setContentType("text/html;charset=utf-8");
		//���乮�������
		PrintWriter out = response.getWriter();
		out.write("<h1>�α��ο� ����</h1>");
		out.write("<h2>DB���� �� �ٽ� �����ϱ�</h2>");
		*/
		
		//Servlet�� �������� JSP�� �����Ѵ�. �ּ�â�� ������� �ʴ´�.

	}
	
}
