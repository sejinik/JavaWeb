<%@ page language="java" contentType="text/html; charset=UTF-8"
	isErrorPage="false"
	isELIgnored="false"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"  />

<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정찰</title>
<style>
	.cls1 {
     font-size:40px;
     text-align:center;
   }
</style>
</head>
<body>
	<h1 class="cls1">회원 정보 수정창</h1>
	<form method="post" action="${contextPath }/member/modMember.do?id=${memInfo.id}">
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</td>
				<td width="400"><input type="text" name="id" value="${memInfo.id }" disabled></td>
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</td>
				<td width="400"><input type="text" name="pwd" value="${memInfo.pwd}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</td>
				<td width="400"><input type="text" name="name" value="${memInfo.name }"/></td>
			</tr>
			
			<tr>
				<td width="200"><p align="right">이메일</td>
				<td width="400"><input type="text" name="email" value="${memInfo.email }"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">가입일</td>
				<td width="400"><input type="text" name="email" value="${memInfo.joinDate }" disabled></td>
			</tr>
			<tr align="center">
				<td width="200"><p>&nbsp;</p></td>
				<td width="400">
					<input type="submit" value="수정하기">
					<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>