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
				let jsonStr  = '{"age": [22, 33, 44] }';          
		        let jsonInfo = JSON.parse(jsonStr);
		        let output ="회원 나이<br>";
		        output += "=======<br>";
		        for(let i in jsonInfo.age) {
		            output += jsonInfo.age[i]+"<br>";
		        }
		        $("#output").html(output);
			});
		})
			
	</script>
</head>
<body>
	<a id="checkJson" style="cursor:pointer">출력</a><br><br>
	<div id="output"></div>
	
</body>
</html>