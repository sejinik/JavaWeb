<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("name", "김세진");
	request.setAttribute("address", "서울");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫 번째 JSP</title>
</head>
<body>
	<%
		RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
		dispatch.forward(request, response);
	%>
</body>
</html>