<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td {
		border:1px solid black;
		border-collapse: collapse;
		padding: 10px;}
</style>
</head>
<body>
<h1>부서목록</h1>
<a href="deptInsert.do">신규 부서 등록</a>
<br><br>
<table>
	<tr>
		<td>부서번호</td>
		<td>부서이름</td>
		<td>매니저</td>
		<td>지역번호</td>
	</tr>
	<c:forEach items="${deptlist}" var="dept"> <!-- var : DTO -->
		<tr>
			<td><a href="../html/dept.do?dept_id=${dept.department_id}">${dept.department_id}</td>
			<td><a href="../html/dept.do?dept_id=${dept.department_id}">${dept.department_name }</td>
			<td>${dept.manager_id }</td>
			<td>${dept.location_id }</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>