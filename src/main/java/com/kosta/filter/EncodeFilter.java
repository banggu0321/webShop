package com.kosta.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodeFilter
 */
//@WebFilter("/*")  ��� ��û
@WebFilter("*.do")
public class EncodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodeFilter() {
        System.out.println("EncodeFilter ����");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("EncodeFilter �Ҹ�");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("utf-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		System.out.println("---------EncodeFilter-------");
		System.out.println("getContextPath : "+req.getContextPath()); 	//��� : /webShop
		System.out.println("getRequestURL : "+req.getRequestURL()); 	//��� : http://localhost:9090/webShop/first/test1
		System.out.println("getRequestURI : "+req.getRequestURI()); 	//��� : /webShop/first/test1
		System.out.println("getServletPath : "+req.getServletPath()); 	//��� : /first/test1
		System.out.println("getServerPort : "+req.getServerPort()); 	//��� : 9090
		System.out.println("---------EncodeFilter END-------");

		// pass the request along the filter chain
		//��û���ͱ��
		chain.doFilter(request, response);
		//�������ͱ��
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("EncodeFilter �ʱ�ȭ");
	}

}
