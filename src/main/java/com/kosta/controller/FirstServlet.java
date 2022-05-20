package com.kosta.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet({"/FirstServlet","/first","/first2.do","/kosta/first3.do"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FirstServlet() {
        System.out.println("FirstServlet������ ����(���ʿ�û�� 1ȸ)");
    }
	public void init(ServletConfig config) throws ServletException {
		System.out.println("FirstServlet init����(���ʿ�û�� 1ȸ)");
	}
	public void destroy(){
		System.out.println("FirstServlet destroy����(server������)");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doGet����(get��û��)");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("get ��û Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet doPost����");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("post ��û Served at: ").append(request.getContextPath());
		//doGet(request, response);
	}

}
