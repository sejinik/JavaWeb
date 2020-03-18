<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="score" value="${param.score }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 출력</title>
</head>
<body>
	<h1>시험점수 : ${score }</h1><br>
	
	<c:choose>
		<c:when test="${score >=90 }"><h1>A</h1></c:when>
		<c:when test="${score >=80 }"><h1>B</h1></c:when>
		<c:when test="${score >=70 }"><h1>C</h1></c:when>
		<c:when test="${score >=60 }"><h1>D</h1></c:when>
	</c:choose>
</body>
</html>