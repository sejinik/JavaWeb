<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="membersList" class="java.util.ArrayList" />
<jsp:useBean id="membersMap" class="java.util.HashMap" />

<%
	MemberBean m1 = new MemberBean("son", "1234", "손흥민", "son@test.com");
	MemberBean m2 = new MemberBean("son2", "1234", "손2흥민", "son2@test.com");
	MemberBean m3 = new MemberBean("son3", "1234", "손2흥민", "son2@test.com");

	membersList.add(m1);
	membersList.add(m2);
	membersList.add(m3);
%>

<c:set var="list" value="${membersList }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align=center bgcolor="#99ccff">
	      	<td width="20%"><b>아이디</b></td>
	      	<td width="20%"><b>비밀번호</b></td>
	     	<td width="20%" ><b>이름</b></td>
	      	<td width="20%"><b>이메일</b></td>
		</tr>	
		<c:forEach var="data" items="${list }">
		<tr align="center">
	      	<td>${data.id}</td>
	      	<td>${data.pwd}</td>
	      	<td>${data.name}</td>
	      	<td>${data.email}</td>
	   	</tr>
		</c:forEach>

	</table>
</body>
</html>