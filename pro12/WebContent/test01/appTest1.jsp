<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	session.setAttribute("name", "김세진");
	application.setAttribute("address", "seoul");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 스코프 테스트</title>
</head>
<body>
	<a href='appTest2.jsp'>두번째 페이지로 이동</a>
	
</body>
</html>