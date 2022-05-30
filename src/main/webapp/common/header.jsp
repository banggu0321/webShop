<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.right{float:right; padding:0 20px 0 0 }
</style>
<div>
	<c:set var="path" value="${pageContext.request.contextPath }"/>
	<span class="right">
		<c:if test="${user != null }">${user.user_name}님</c:if>
		<c:if test="${user == null }">Guest님</c:if>
	</span> 
	<span>
		<c:if test="${user==null}">
			<a class="right" href="${path}/html/login.do">로그인</a>
		</c:if>
		<c:if test="${user!=null}">
			<a class="right" href="${path}/logOut">로그아웃</a>
		</c:if>
		<!-- choose when으로 수정해보자 -->
		<c:choose>
			<c:when test="${user==null }">
				<a class="right" href="${path}/html/login.do">로그인</a>
			</c:when>
			<c:otherwise>
				<a class="right" href="${path}/logOut">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</span>
</div>
