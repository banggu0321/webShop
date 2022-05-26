package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletScopeTest")
public class ServletScopeTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		//1. server�� ����ִ� ���� (started) ��� JSP/Servlet���� ���ٰ���
		ServletContext application = getServletContext();
		//2. Browser�� ����ִ� ���� ��� JSP/Servlet���� ���ٰ���
		HttpSession sess = req.getSession();
		//3. HttpServletRequest request : 
		//��û�� ����ִ� ����(��û�� �ٲ����ʴ� ����) JSP/Servlet���� ���ٰ���
		
		application.setAttribute("appVar", "ServletContext�� server�� ����ִ� ���� (started) ��� JSP/Servlet���� ���ٰ���");
		sess.setAttribute("sessionVar", "HttpSession�� Browser�� ����ִ� ���� ��� JSP/Servlet���� ���ٰ���");
		req.setAttribute("requestVar", "HttpServletRequest request : ��û�� ����ִ� ����(��û�� �ٲ����ʴ� ����) JSP/Servlet���� ���ٰ���");
		application.setAttribute("myphone","1");
		sess.setAttribute("myphone","2");
		req.setAttribute("myphone","3");
		
		/*
		���� API�� ���ε��� �Ӽ��� ���� ���� ����
		1. ServletContext�Ӽ��� ���ø����̼� ��ü�� ��� ����
		2. HttpSession�Ӽ��� ����ڸ� ���ٰ���
		3. HttpServletResquest �Ӽ��� �ش� ��û/���信 ���ؼ� �� �������� �̿��ؼ�
			�α��λ�������,��ٱ���,MVC�� Model�� View�� ���� ������ ������ ���� ����� ����
		*/
		RequestDispatcher rd;
		rd = req.getRequestDispatcher("jsp/scopeTest.jsp");
		rd.forward(req, response);
	}

}
