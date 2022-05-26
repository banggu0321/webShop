<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>scopeTest2</title>
</head>
<body>
<%
//자바땅
//내장객체가 제공된다. : application, session, request
%>
	<h1>scopeTest2.jsp페이지....Servlet Scope를 Test한다.(서블릿과 연결 안함)</h1>
	
	<h2>ScriptLet문법</h2>
	<p>application영역의 접근 : <%=application.getAttribute("appVar") %></p>
	<p>session영역의 접근 : <%=session.getAttribute("sessionVar") %></p>
	<p>request영역의 접근 : <%=request.getAttribute("requestVar") %></p>
	<hr>
	
	<h2>EL문법(Expression Language)문법</h2>
	<p>application영역의 접근 : ${appVar}</p>
	<p>session영역의 접근 : ${sessionVar}</p>
	<p>request영역의 접근 : ${requestVar}</p>
</body>
</html>