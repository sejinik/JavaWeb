<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
	String id = request.getParameter("userId");
	if(id==null || id.length()==0) {
%>
	<jsp:forward page="login2.jsp">
		<jsp:param value="아이디를 입력하지 않았습니다. 아이디를 입력해 주세요" name="msg"/>
	</jsp:forward>
<%
	}
%>
	<h1>반갑습니다 <%=id %>님 !!!</h1>
</body>
</html>