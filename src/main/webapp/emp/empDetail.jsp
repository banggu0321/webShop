<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원의 상세내역</h1>
<p>직원번호: ${emp.employee_id}</p>
<p>first name: ${emp.first_name}</p>
<p>last name: ${emp.last_name}</p>
<p>email: ${emp.email}</p>
<p>phone: ${emp.phone_number }</p>
<p>commission: ${emp.commission_pct }</p>
<p>manager_id: ${emp.manager_id }</p>
<p>department_id: ${emp.department_id}</p>
<p>job_id: ${emp.job_id }</p>
<p>입사일: ${emp.hire_date}</p>
<p>급여: ${emp.salary }</p>
</body>
</html>