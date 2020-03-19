<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트</title>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript">
		$(()=>{
			$("#checkJson").on("click",()=>{
				let jsonStr  = '{"name":"박지성","age":22,"genter":"남자","nickname":"날센돌이"}';          
		        let jsonObj = JSON.parse(jsonStr);
		        let output ="회원 나이<br>";
		        output += "=======<br>";
		        output += "이름: " + jsonObj.name+"<br>";
		       	output += "나이: " + jsonObj.age+"<br>";
		      	output += "성별: " + jsonObj.gender+"<br>";
		      	output += "별명: " + jsonObj.nickname+"<br>"; 
		        $("#output").html(output);
			});
		});
	</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
	
</body>
</html>