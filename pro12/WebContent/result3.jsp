<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과출력</title>
</head>
<body>
<h1>결과 출력</h1>

<%
	if(id==null || id.length()==0) {
%>
	아이디를 입력하세요. <br>
	<a href='login.html'>로그인하기</a>
<%
	} else if(id.equals("admin")) {
%>
	<h1>관리자로 로그인 하였습니다.</h1>
	<input type="button" value="회원정보 삭제하기">
	<input type="button" value="회원정보 수정하기">
<%
	} else {
%>
	아이디 : <%=id %>
	비밀번호 : <%=pw %>
<%
	}
%>
</body>
</html>