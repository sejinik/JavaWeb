<%@page import="java.util.List"%>
<%@page import="sec02.ex01.MemberDAO"%>
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
<jsp:useBean id="m" class="sec02.ex01.MemberBean" />
<jsp:setProperty property="*" name="m"/>
<%
	MemberDAO dao = new MemberDAO();
	dao.addMember(m);
	List membersList = dao.listMembers();
	request.setAttribute("membersList", membersList);
%>
</head>
<body>
	<jsp:forward page="membersList.jsp" />
</body>
</html>