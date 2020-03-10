<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 변환 결과 출력</title>
</head>
<body>
<%
	if(score <0 || 100<score) {
%>
	점수를 제대로 입력해주세요.
<%
	} else {
%>
	<h1>너의 학점은</h1>
<%
	if(score>=90){
%>
	<h1> A </h1>
<%
	} else if(score>=80) {
%>
	<h1> B </h1>
<%
	} else if(score>=70) {
%>
	<h1> C </h1>
<%
	} else if(score>=60) {
%>
	<h1> D </h1>
<%
	} else {
%>
	<h1> F </h1>
<%
		}
	}
%>
	<a href='scoreTest.html'>점수입력</a>
</body>
</html>