<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = (String)session.getAttribute("name");
	String address = (String)session.getAttribute("address");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>두 번째 페이지</title>
</head>
<body>
	바인딩 된 이름 : <%=name %>
	바인딩 된 주소 : <%=address %>
</body>
</html>