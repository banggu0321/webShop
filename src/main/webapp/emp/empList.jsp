<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원목록</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="../css/common.css">  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style>
	table, td {
		border:1px solid black;
		border-collapse: collapse;
		padding : 10px;}
	tr:first-child{
		background-color: lightgray;
	}
	.table{ width:auto; margin:0 0 0 20px; }
	h1{text-align:center; padding : 20px; margin:10px;}
	.color1{background-color: pink;}
	.color2{background-color: beige;}
</style>
<script>
 $(function(){
	$(".empDetailView").click(function(){
		var empid = $(this).attr("data-empid");
		//alert(empid);
		$("#emp_id").val(empid);
		$.ajax({
			url:"empDetail2.do",	//어디로
			data:{"empid":empid},	//가져갈 data{key,value}
			type:"get",
			success:function(responseData){
				//alert("서버에 다녀옴 : "+responseData);
				//JSON받기 '{"emp_fname":"aa","emp_lname":"bb"}'
				var obj = JSON.parse(responseData);
				$("#emp_fname").val(obj["emp_fname"]);
				$("#emp_lname").val(obj["emp_lname"]);
			}
		});
	}); 
 });
</script>
</head>
<body>
<h1>직원목록</h1>
<hr>
	<%-- <h2>EL문법(Expression Language)문법</h2>
	<p>application영역의 접근 : ${appVar}</p>
	<p>session영역의 접근 : ${sessionVar}</p>
	<p>request영역의 접근 : ${requestVar}</p> --%>
<div><span><a class="left" href="empInsert.do">신규등록</a> </span></div>
	<c:set  var="now" value="<%=new Date() %>" />
    <fmt:formatDate  value="${now }" type="both" dateStyle="full" timeStyle="full"/><br>

<%-- ${pageContext.request.contextPath} --%>
<br><br>
<table class="table">
	<tr>
		<td>순서</td>
		<td>상세보기</td>
		<td>직원번호</td>
		<td>성</td>
		<td>이름</td>
		<td>입사일</td>
		<td>급여</td>
		<td>전화번호</td>
		<td>부서</td>
		<td>커미션</td>
		<td>매니저</td>
		<td>직책</td>
		<td>이메일</td>
		<td></td>
	</tr>
	<c:forEach items="${emplist}" var="emp" varStatus="status">
		<c:if test="${status.first }">
			<tr class="color1">
		</c:if>
		<c:if test="${status.last }">
			<tr class="color2">
		</c:if>
		<c:if test="${status.first==false && status.last==false }">
			<tr>
		</c:if>
			<td>${status.count }</td>
			<td><input type="button" value="Detail" class="empDetailView btn btn-info" 
				data-toggle="modal" data-target="#myModal" data-empid="${emp.employee_id}"></td>
			<td><a href="empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
			<td>${emp.last_name}</td>
			<td>${emp.first_name}..${fn:contains(emp.first_name,"Al")}</td>
			<td>${emp.hire_date}</td>
			<td>
   				<fmt:formatNumber value="${emp.salary}" type="currency" currencySymbol="$" />
   			</td>
			<td>${fn:substring(emp.phone_number,0,3)}</td>
			<td>${emp.department_id}</td>
			<td>${emp.commission_pct}</td>
			<td>${emp.manager_id}</td>
			<td>${emp.job_id}</td>
			<td>${emp.email}</td>
			<td>
				<form action="empDelete.do" method="post">
					<input type="hidden" name="emp_id" value="${emp.employee_id}">
					<input type="submit" class="btn btn-dark" value="삭제">
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<!-- The Modal -->
  <div class="modal" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">직원정보 상세보기</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body form-group">
          <label>직원정보</label><input class="form-control" type="text" id="emp_id" readonly="readonly"><br>
          <label>이름</label><input class="form-control" type="text" id="emp_fname"><br>
          <label>성</label><input class="form-control" type="text" id="emp_lname"><br>
          
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>
  
</body>
</html>