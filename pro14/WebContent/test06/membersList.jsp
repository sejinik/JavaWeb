<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%" ><b>아이디</b></td>
	      	<td width="7%" ><b>비밀번호</b></td>
	      	<td width="7%" ><b>이름</b></td>
	      	<td width="7%"><b>이메일</b></td>
	   		<td width="7%" ><b>가입일</b></td>
		</tr>
		<c:choose>
			<c:when test="${empty membersList }">
				<tr>
					<td colspan="5">
						<b>등록된 회원이 없습니다</b>
					</td>
				</tr>
			</c:when>
			<c:when test="${not empty membersList }">1
				<c:forEach	var="member" items="${membersList }">
					<tr align="center">
						<td>${member.id }</td>
						<td>${member.pwd }</td>
						<td>${member.name }</td>
						<td>${member.email }</td>
						<td>${member.joinDate }</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>
</html>