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
<title>결과창</title>
</head>
<body>
	<h1>업로드가 완료되었습니다.</h1>
	<label>아이디 :</label>
	<input type="text" value="${map.id }" readonly="readonly">
	<label>이름 : </label>
	<input type="text" value="${map.name }" readonly="readonly">
	<div class="result-images">
		<c:forEach var="imageFileName" items="${map.fileList }">
			<img src="${contextPath }/download?imageFileName=${imageFileName}">
			<br><br><br>
		</c:forEach>
	</div>
	<p><a href="${contextPath }/form">다시 업로드 하기</a></p>
</body>
</html>