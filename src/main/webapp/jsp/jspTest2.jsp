<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 이것은 JSP주석입니다. JSP에서만 보인다 .java .html없다

Directive
%@ page
%@ include
%@ taglib

--%>
<%
/* 자바주석*/
// 자바주석
//자바코드가 .java의 service메서드에 들어간다.
String coffee = "아메리카노";
out.println("<h2>"+coffee+"</h2>");
%>
<%!
//멤버변수와 멤버메서드
int price = 2000;
public int getPrice(){
	return price;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html주석이다 -->
	<h1><%=coffee %></h1> <%--Expression, 문장 아니므로 ;사용X --%>
	
	<% for(int i=1; i<=5; i++){ %>
	<h3><%=i %></h3>	
	<% } %>
</body>
</html>