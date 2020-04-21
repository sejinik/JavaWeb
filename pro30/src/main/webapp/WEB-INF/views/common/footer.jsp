<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	p {
		font-size: 20px;
		text-align: center;
	}
</style>
<title>하단 부분</title>
</head>
<body>
	<p> e-mail:sejinik@gmail.com</p>
	<p> 회사주소 : 서울시 강남구</p>
	<p> 찾아오는 길 : <a href="#">약도</a></p>
</body>
</html>