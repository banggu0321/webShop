<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인하기</h1>
	<%@ include file="../common/header.jsp" %>
	<form action="login.do" method="post">
	사용자번호: <input type="text" name="userid" value=""><br>
	비밀번호: <input type="text" name="userpass" value="1234"><br>
	
	<input type="hidden" name="user_email" value="zz@naver.com"><br>
	<input type="hidden" name="user_address" value="seoul"><br>
	
	<input type="submit" value="로그인">
	</form>
</body>
</html>