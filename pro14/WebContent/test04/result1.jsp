<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
</head>
<body>
	<c:if test="${empty param.id }">
		아이디를 입력하세요.<br>
		<a href="login.jsp"> 로그인하기</a>
	</c:if>
	<c:if test="${not empty param.id }">
		<h1> 환영합니다 ${param.id }님 !!! </h1>
	</c:if>
</body>
</html>