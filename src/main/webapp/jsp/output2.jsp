<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kosta.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
	<h1>장바구니현황</h1>
	<%
	request.setCharacterEncoding("utf-8");
	String prodName = request.getParameter("prod");
	String s_count = request.getParameter("count");
	int i_count = 0;
	if(s_count != null){
		i_count = Integer.parseInt(s_count);
	}
	Product pro = new Product(prodName, i_count);
	//장바구니가 session에 있으면 얻기, 없으면 만든다.
	
	//List<Product> plist = new ArrayList<>();
	Map<String, Product> plist = (HashMap)session.getAttribute("cart");
	if(plist == null) plist = new HashMap<>(); //장바구니
	
	if(plist.containsKey(prodName)){
		Product p2 = plist.get(prodName);
		p2.setCount(p2.getCount() + i_count);
	}else{
		if(prodName != null) plist.put(prodName,pro);
	}
	
	session.setAttribute("cart", plist);
	
	//출력
	for(String key:plist.keySet()){
		Product p = plist.get(key);
		out.write("<p>"+ p.getName() + " : " + p.getCount() + "개</p>");
	}
	//JSP내장객체 : application session request pageContext out
	
	/* 
	//List<Product> plist = new ArrayList<>();
	List<Product> plist = (ArrayList)session.getAttribute("cart");
	if(plist == null) plist = new ArrayList<>(); //장바구니
	
	//같은 상품이 있으면 갯수를 수정한다.
	boolean flag = false;
	for(Product p:plist){
		if(p.getName().equals(prodName)){
			p.setCount(p.getCount() + i_count);
			flag = true;
		}
	}
	if(!flag) plist.add(pro); //추가
	session.setAttribute("cart", plist);
	
	
	//출력
	for(Product p:plist){
		out.write("<p>" + p.getName() + " : " + p.getCount() + "개</p>");
	}
	 */
	%>
	<a href="input.jsp">계속 구매하기</a>
	<button id="btnClear" onclick="location.href='cartRemove'">비우기</button>
</body>
</html>