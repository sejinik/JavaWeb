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
<script type="text/javascript">
 $(function(){
	 $("#btn").click(function(){
		 let article = {
				 articleNO : "114",
				 writer : "qwe",
				 title : "qwr",
				 content : "adw"
		 };
		 
		 $.ajax({
			 type : "POST",
			 url : "${contextPath}/boards",
			 contentType : "application/json",
			 data : JSON.stringify(article),
			 success: function(data,textStatus){
				 alert(data);
			 },
			 error : function(data,textStatus){
				 alert("에러가 발생했습니다");
			 },
			 complete : function(data,textStatus){
				 
			 }
		 });
	 });
	 
	 $("#btn2").click(function(){
		 let article = {
				 articleNO : "114",
				 writer : "qwe",
				 title : "qwr",
				 content : "adw"
		 };
		 
		 $.ajax({
			 type:"PUT",
			 url:"${contextPath}/boards/123",
			 contentType : "application/json",
			 data : JSON.stringify(article),
			 success: function(data,textStatus){
				 alert(data);
			 },
			 error : function(data,textStatus){
				 alert("에러가 발생했습니다");
			 },
			 complete : function(data,textStatus){
				 
			 }
		 });
	 });
	 
	 $("#btn3").click(function(){
		 $.ajax({
			 type:"DELETE",
			 url:"${contextPath}/boards/123",
			 contentType : "application/json",
			 success: function(data,textStatus){
				 alert(data);
			 },
			 error : function(data,textStatus){
				 alert("에러가 발생했습니다");
			 },
			 complete : function(data,textStatus){
				 
			 }
		 });
	 });
 });
</script>
<title>결과창</title>
</head>
<body>
	<input type="button" id="btn" value="새글쓰기"><br><br>
	<input type="button" id="btn2" value="수정하기"><br><br>
	<input type="button" id="btn3" value="삭제하기"><br><br>
</body>
</html>