<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>알림</h1>
	<p> <%=exception %></p>
	<p> <%=exception.getMessage() %></p>
	<hr>
	<%
	//eclipse console창에 display된다.
	exception.printStackTrace();
	%>
	<p> 전산실에 연락</p>
</body>
</html>