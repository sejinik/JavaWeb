<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<%
	String userId = request.getParameter("userId");
	if(userId.length()==0) {
%>
	<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
%>
	<h1>환영합니다 <%=userId %>님!!</h1>
</body>
</html>