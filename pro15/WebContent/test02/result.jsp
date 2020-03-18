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
<c:set var="file1" value="${param.param1 }" />
<c:set var="file2" value="${param.param2 }" />

<title>이미지 출력하기</title>
</head>
<body>
	파라미터 1 : ${file1 }<br>
	파라미터 2 : ${file2 }<br>
	
	<c:if test="${not empty file1 }">
		<img src="${contextPath }/download.do?fileName=${file1}" width="300" height="300"><br>
	</c:if>
	
	<c:if test="${not empty file2 }">
		<img src="${contextPath }/download.do?fileName=${file2}" width="300" height="300"><br>
	</c:if>
	
	파일 내려받기 : <br>
	<a href="${contextPath }/download.do?fileName=${file2}">파일 내려받기</a><br>
</body>
</html>