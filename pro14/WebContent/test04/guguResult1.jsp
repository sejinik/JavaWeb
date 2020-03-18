<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="dan" value="${param.dan }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="lightgreen">
			<td colspan="2">${dan}단 출력</td>
		</tr>
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr align="center">
				<td width="400">${i } X ${dan }</td>
				<td width="400">${i*dan }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>