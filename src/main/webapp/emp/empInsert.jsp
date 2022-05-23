<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>직원생성</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
  	label{display:inline-block; width:100px;}
  	.form-control{display:inline-block; width:auto;}
  </style>
</head>
<body>
<h1>직원 생성하기</h1>
<form action="empInsert.do" method="post">
	<div class="form-group">
		<label>직원번호</label>
		<input class="form-control" type="number" name="employee_id">
	</div>
	<div class="form-group">
		<label>first name</label>
		<input class="form-control" type="text" name="first_name">
	</div>
	<div class="form-group">
		<label>last name</label>
		<input class="form-control" type="text" name="last_name">
	</div>
	<div class="form-group">
		<label>이메일</label>
		<input class="form-control" type="text" name="email">
	</div>
	<div class="form-group">
		<label>전화번호</label>
		<input class="form-control" type="text" name="phone_number">
	</div>
	<div class="form-group">
		<label>커미션</label>
		<input class="form-control" type="text" name="commission_pct">
	</div>
	<div class="form-group">
		<label>매니저</label>
		<select class="form-control" name="manager_id" >
			<c:forEach items="${mlist}" var="m">
				<option value="${m.key}">${m.value}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label>부서</label>
		<select class="form-control" name="department_id" >
			<c:forEach items="${dlist}" var="dept">
				<option value="${dept.department_id}">${dept.department_name}부서</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label>직책</label>
		<select class="form-control" name="job_id" >
			<c:forEach items="${jlist}" var="job">
				<option value="${job.job_id}">${job.job_title}</option>
			</c:forEach>
		</select>
	</div>
	<div class="form-group">
		<label>급여</label>
		<input class="form-control" type="text" name="salary">
	</div>
	<div class="form-group">
		<label>입사일</label>
		<input class="form-control" type="date" name="hire_date">
	</div>
	<input class="btn btn-primary" type="submit" value="생성하기">
	<input class="btn btn-secondary" type="reset" value="취소하기">
</form>
</body>
</html>