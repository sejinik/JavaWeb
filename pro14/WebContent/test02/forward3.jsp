<%@page import="java.util.*"%>
<%@page import="sec01.ex02.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	List memberList = new ArrayList();
	MemberBean m1 = new MemberBean("lee","1234","이순신","lee@test.com");
	MemberBean m2 = new MemberBean("lee","123455","이순신","lee@test.com");
	memberList.add(m1);
	memberList.add(m2);
	
	request.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward2</title>
</head>
<body>
	<jsp:forward page="member3.jsp" />
</body>
</html>