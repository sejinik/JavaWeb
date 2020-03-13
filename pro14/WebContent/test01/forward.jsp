<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	request.setAttribute("address", "서울");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward</title>
</head>
<body>
	<jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>