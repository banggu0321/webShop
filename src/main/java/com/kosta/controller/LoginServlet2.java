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
		//get요청은 주소창에 파라메터가 자동으로 인코딩되어 넘어온다. 한글 깨짐없음
		//post요청은 요청 문서의 body에 파라메타가 인코딩 X 넘어온다. 한글깨짐
		request.setCharacterEncoding("utf-8");//post에서만 필요
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
		//응답문서의 타입과 인코딩 방식을 응답문서만들기 전에 setting한다.
		response.setContentType("text/html;charset=utf-8");
		//응답문서만들기
		PrintWriter out = response.getWriter();
		out.write("<h1>로그인에 성공</h1>");
		out.write("<h2>DB접속 후 다시 수정하기</h2>");
		*/
		
		//Servlet이 실행결과를 JSP에 위임한다. 주소창은 변경되지 않는다.

	}
	
}
