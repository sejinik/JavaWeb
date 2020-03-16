
<%@page import="sec01.ex01.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="memberList" class="java.util.ArrayList" />
<jsp:useBean id="memberMap" class="java.util.HashMap"/>
<%

	memberMap.put("id","park2");
	memberMap.put("pwd","4321");
	memberMap.put("name","박지성");
	memberMap.put("email","park2@test.com");
	
	MemberBean m2 = new MemberBean("son","1234","손흥민","son@test.com");
	memberList.add(m1);
	memberList.add(m2);
	
	memberMap.put("memberList",memberList);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 출력 창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align="center"  bgcolor="#99ccff">
	       <td width="20%"><b>아이디</b></td>
	       <td width="20%"><b>비밀번호</b></td>
	       <td width="20%" ><b>이름</b></td>
	       <td width="20%"><b>이메일</b></td>
		</tr>
		<tr align="center">
			<td>${memberMap.id}</td>
			<td>${memberMap.pwd }</td>
			<td>${memberMap.name }</td>
			<td>${memberMap.email }</td>
		</tr>
		<tr align="center">
			<td>${memberMap.memberList[0].id}</td>
			<td>${memberMap.memberList[0].pwd }</td>
			<td>${memberMap.memberList[0].name }</td>
			<td>${memberMap.memberList[0].email }</td>
		</tr>
		<tr align="center">
			<td>${memberMap.memberList[1].id}</td>
			<td>${memberMap.memberList[1].pwd }</td>
			<td>${memberMap.memberList[1].name }</td>
			<td>${memberMap.memberList[1].email }</td>
		</tr>
	</table>
</body>
</html>