package com.kosta.filterListener;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TimeCheckFilter
 */
@WebFilter("/*")
public class TimeCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TimeCheckFilter() {
        System.out.println("TimeCheckFilter ����");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("TimeCheckFilter �Ҹ�");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ��û
		long start = System.currentTimeMillis();
		
		chain.doFilter(request, response); //-->��û����
		// ����
		long end = System.currentTimeMillis();
		System.out.println("��û�����ϴµ� �ɸ� �ð� : " + (end-start) + "ms");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("TimeCheckFilter �ʱ�ȭ");
	}

}
