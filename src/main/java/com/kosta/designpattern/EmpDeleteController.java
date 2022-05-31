package com.kosta.designpattern;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kosta.dto.DeptDTO;
import com.kosta.dto.EmpVO;
import com.kosta.dto.JobVO;
import com.kosta.model.DeptService;
import com.kosta.model.EmpService;
import com.kosta.util.DateUtil;

public class EmpDeleteController implements Command{

	@Override
	public String execute(HttpServletRequest request) {
		int empid = Integer.parseInt(request.getParameter("emp_id"));
		
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		request.setAttribute("message", result>0?"삭제성공":"삭제실패");
		
		return "redirect:emplist.do";
		//return "result.jsp";
	}
}
