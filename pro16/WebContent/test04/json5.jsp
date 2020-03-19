<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON ajax 연습</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
<script type="text/javascript">
	$(()=>{
		$("#checkJson").on("click",()=>{
			let _jsonInfo = '{"name":"박지성","age":"25","gender":"남자","nickname":"날센돌이"}';
			$.ajax({
				type:"post",
				async:false,
				url:"${contextPath}/json",
				data:{jsonInfo : _jsonInfo},
				success:(data,textStatus) =>{
					
				},
				error:(data,textStatus) => {
					alert("에러가 발생했습니다");
				},
				complete:(data,textStatus) => {
					
				}
			});
		});
	})
</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">전송</a><br><br>
	<div id="output"></div>
</body>
</html>