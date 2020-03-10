<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과출력창</title>
</head>
<body>
	<h1>결과 출력</h1>
	<%
		if(id==null || id.length()==0) {
	%>
	아이디를 입력하세요.<br>
	<a href='login.html'>로그인하기</a>
	<%
		} else {
	%>
	아이디 : <%=id %>
	비밀번호 : <%=pw %>
	<%
		}
	%>
</body>
</html>