<%@ page language="java" contentType="text/html; charset=UTF-8"
    isErrorPage="true"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	===== toString() 내용 =====<br>
	<h1><%= exception.toString() %></h1>
	===== getMessage() 내용 =====<br>
	<h1><%= exception.getMessage() %></h1>
	===== printStackTrace()	내용 ===== <br>
	<h1><% exception.printStackTrace(); %></h1>
	
	<h3>
		숫자만 입력 가능합 니다
		<a href='add.html'>다시 하기</a>
	</h3>
</body>
</html>