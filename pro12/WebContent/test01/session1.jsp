<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String) session.getAttribute("name");
	session.setAttribute("address", "seoul");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫번째 페이지</title>
</head>
<body>
	바인딩 된 이름 : <%=name %>
	<a href='session2.jsp'>두 번째 페이지</a>
</body>
</html>
