package com.kosta.filterListener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;

//@WebFilter("/*")
public class SessionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//���� ����
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		
		String path = req.getServletPath();
		System.out.println("��û�ּ� : " + path);
		
		if(!path.equals("/html/login.do")) {
			UserVO user = (UserVO)session.getAttribute("user");
			System.out.println(user);
							
			if(user==null) {
				session.setAttribute("reqPath", req.getContextPath() + path);
				System.out.println("�α������� ����..�������� �� �� ����");
				//�����ΰ� �ٶ����ϴ�.
				//session.setAttribute("reqPath", req.getContextPath() + "/index.jsp");
				resp.sendRedirect(req.getContextPath() + "/html/login.do");//�ּ�â �ٲٱ�
				return;
			}
		}else {
			
		}
		chain.doFilter(request, response);
	}
}
