<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	request.setCharacterEncoding("utf-8");
%>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>redirect 태그 실습</title>
</head>
<body>
	<c:redirect url="/test01/member1.jsp">
		<c:param name="id" value="hong" />
		<c:param name="pwd" value="1234" />
		<c:param name="name" value="홍길동" />
		<c:param name="email" value="hong@a.com" />
	</c:redirect>
</body>
</html>