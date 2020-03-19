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
		$("#checkJson").on("click",()=> {
			$.ajax({
				type:"post",
				async:false,
				url:"${contextPath}/json2",
				success:(data,textStatus) => {
					let jsonInfo = JSON.parse(data);
					let memberInfo = "회원 정보<br>";
					memberInfo +="=======<br>";
					
					for(let i in jsonInfo.members){
						 memberInfo += "이름: " + jsonInfo.members[i].name+"<br>";
						 memberInfo += "나이: " + jsonInfo.members[i].age+"<br>";
						 memberInfo += "성별: " + jsonInfo.members[i].gender+"<br>";
						 memberInfo += "별명: " + jsonInfo.members[i].nickname+"<br><br><br>";						
					}
					$("#output").html(memberInfo);
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
	<a id="checkJson" style="cursor:pointer">회원정보 수신하기</a><br><br>
	<div id="output"></div>
</body>
</html>