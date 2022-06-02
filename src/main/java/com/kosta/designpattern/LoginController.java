package com.kosta.designpattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.kosta.dto.UserVO;
import com.kosta.model.UserService;

public class LoginController implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String method = request.getMethod();
		String page = null;
		if(method.equals("GET")) {
			page = "loginForm.jsp";
		}else {
			String id = request.getParameter("userid");
			String pass = request.getParameter("userpass");
			
			UserService service = new UserService();
			UserVO user = service.selectById(id, pass);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String path = (String)session.getAttribute("reqPath");
			System.out.println("path="+path);
			
			if(user == null) {
				//�α��� ���н� �ٽ� �α����ϵ��� �����Ѵ�.
				//response.sendRedirect("login.do"); //get������� ����
			}else {
				if(path==null)
					path = request.getContextPath() + "/index.jsp";
				//response.sendRedirect(path);
			}
			
		}
		return page;
	}
}
