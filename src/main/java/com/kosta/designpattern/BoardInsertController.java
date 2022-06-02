package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;

public class BoardInsertController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page = null;
		if(method.equals("GET")) {
			
		}else {
			
		}
		return page;
	}
}
