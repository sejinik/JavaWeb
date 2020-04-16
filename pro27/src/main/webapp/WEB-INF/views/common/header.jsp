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
<title>헤더</title>
</head>
<body>
	<table border="0" width="100%">
		<tr>
			<td>
				<a href="${contextPath }/main.do">
					<img src="${contextPath }/resource/image/duke.png" />
				</a>
			</td>
			<td>
				<h1><font size=30>스프링실습 홈페이지!!</font></h1>
			</td>
			<td>
				<a href="#">로그인</a>
			</td>
		</tr>
		
	</table>
</body>
</html>