<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	String name="이순신";
	String getName(){return name;}
%>

<% String age=request.getParameter("age"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿 연습</title>
</head>
<body>
	<h1>이름 : <%=name %></h1>
	<h1>나이 : <%=age %></h1>
</body>
</html>