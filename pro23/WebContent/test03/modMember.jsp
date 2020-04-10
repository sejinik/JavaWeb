<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form method="post" action="${contextPath }/mem4.do?action=updateMember" >
		<h1 class="text_center">회원 수정 창</h1>
		<table align="center">
			<tr>
				<td width="200">아이디</td>
				<td width="400"><input type="text" name="id"></td>
			</tr>
			<tr>
				<td width="200">비밀번호</td>
				<td width="400"><input type="text" name="pwd"></td>
			</tr>
			<tr>
				<td width="200">이름</td>
				<td width="400"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td width="200">이메일</td>
				<td width="400"><input type="text" name="email"></td>
			</tr>
			<tr>
				<td width="200">&nbsp;</td>
				<td width="400"><input type="submit" value="수정"><input type="reset" value="다시입력"></td>
			</tr>
		</table>
	</form>
	<a href="${contextPath }/mem4.do?action=listMembers">뒤로 가기</a>
</body>
</html>