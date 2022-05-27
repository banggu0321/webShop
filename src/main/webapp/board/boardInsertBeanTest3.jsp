<%@page import="com.kosta.dto.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board생성</title>
</head>
<body>
<h1>JavaBeans Test</h1>


<jsp:useBean id="board2" class="com.kosta.dto.BoardVO" 
	scope="session"></jsp:useBean>

<hr>
<h2>Action Tag사용해서 읽기</h2>
제목 : <jsp:getProperty property="title" name="board2"/><br>
내용 : <jsp:getProperty property="content" name="board2"/><br>
작성자 : <jsp:getProperty property="writer" name="board2"/>
</body>
</html>