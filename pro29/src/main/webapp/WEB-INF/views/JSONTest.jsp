<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>  
<title>JSONTest</title>
</head>
<body>
	<button id="checkJson" onclick="sendInfo()">정보 보내기</button><br><br>
	<div id="output"></div>
</body>
<script type="text/javascript">
		function sendInfo(){
			let member = {
					id:"park",
					pwd:"1234",
					name:"a",
					email:"sejkin"
			};
			
			$.ajax({
				type:"post",
				url:"${contextPath}/test/info",
				contentType :"application/json",
				data : JSON.stringify(member),
				success : function(data,textStatus){
					
				},
				error : function(data,textStatus){
					alert("에러가 발생했습니다")
				},
				complete : function(data,textStatus){
					
				}
			});
		}
</script>
</html>