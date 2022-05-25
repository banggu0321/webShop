package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletContextTest")
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletContextTest() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ ���� �����ϱ�
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServletContext app = getServletContext();
		System.out.println("getContextPath : "+app.getContextPath());
		System.out.println("getMajorVersion : "+app.getMajorVersion());
		System.out.println("getMinorVersion : "+app.getMinorVersion());
		System.out.println("getRealPath : "+app.getRealPath("."));
		System.out.println("getRealPath : "+app.getRealPath("./board"));
		
		app.setAttribute("myname", "bang");
		request.setAttribute("myaddress", "����� ��õ�� ����");
		System.out.println("getAttribute : "+app.getAttribute("myname"));
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("jsp/contextTest.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
