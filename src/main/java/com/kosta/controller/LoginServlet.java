package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;
import com.kosta.model.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/html/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd =
		request.getRequestDispatcher("loginForm.jsp"); 
		rd.forward(request,response);
	}
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get��û�� �ּ�â�� �Ķ���Ͱ� �ڵ����� ���ڵ��Ǿ� �Ѿ�´�. �ѱ� ��������
		//post��û�� ��û ������ body�� �Ķ��Ÿ�� ���ڵ� X �Ѿ�´�. �ѱ۱���
		request.setCharacterEncoding("utf-8");//post������ �ʿ�
		String id = request.getParameter("userid");
		String pass = request.getParameter("userpass");
		
		UserService service = new UserService();
		UserVO user = service.selectById(id, pass);
		//Session�����ϱ� : �ٸ����������� ���¸� �˱� ���ؼ�(�α��ο��� �˰� ó������)
		//Cookie : �������� ���� ���� ->���ڸ�
		//Session : ������ ������ ����, ���������� session id���� ->��ü�������尡��
		
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		if(user == null) {
			//�α��� ���н� �ٽ� �α����ϵ��� �����Ѵ�.
			response.sendRedirect("login.do"); //get������� ����
		}else {
			String path = (String)session.getAttribute("reqPath");
			response.sendRedirect(path);
		}
		
		
		/*
		 * String email = request.getParameter("user_email"); 
		 * String address =
		 * request.getParameter("user_address");
		 * 
		 * System.out.println(id); System.out.println(pass); 
		 * System.out.println(email);
		 * System.out.println(address); 
		 * System.out.println(request.getMethod());
		 * System.out.println(request.getContextPath());
		 */
		
		/*
		//���乮���� Ÿ�԰� ���ڵ� ����� ���乮������� ���� setting�Ѵ�.
		response.setContentType("text/html;charset=utf-8");
		//���乮�������
		PrintWriter out = response.getWriter();
		out.write("<h1>�α��ο� ����</h1>");
		out.write("<h2>DB���� �� �ٽ� �����ϱ�</h2>");
		*/
		
		//Servlet�� �������� JSP�� �����Ѵ�. �ּ�â�� ������� �ʴ´�.
		/*
		 * RequestDispatcher rd =
		 * request.getRequestDispatcher("../jsp/loginResult.jsp"); rd.forward(request,
		 * response);
		 */
	}
	
}
