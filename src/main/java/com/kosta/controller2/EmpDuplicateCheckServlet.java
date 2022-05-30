package com.kosta.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.dto.EmpVO;
import com.kosta.model.EmpService;

/**
 * Servlet implementation class EmpDuplicateCheckServlet
 */
@WebServlet("/emp/duplicateCheck.do")
public class EmpDuplicateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
		if(empid==null) return ;
		int i_empid = Integer.parseInt(empid);
		System.out.println("emp_id : " + empid);
		//DB�� ���� id�� �����ϴ��� üũ�Ѵ� ??empService-> empDAO->DB
		EmpService service = new EmpService();
		EmpVO emp = service.selectById(i_empid);
		PrintWriter out = response.getWriter();
		out.print(emp==null?0:1);
		
	}
	

}
