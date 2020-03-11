<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
 	String name = (String)session.getAttribute("name");
 	String address = (String)application.getAttribute("address");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 스코프 테스트</title>
</head>
<body>
	<h1>바인딩 된 이름 : <%=name %></h1>
	<h1>바인딩 된 주소 : <%=address %></h1>
</body>
</html>