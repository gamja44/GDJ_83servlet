<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학생 한명 정보</h1>
	<!-- getter의이름:get을 빼고 첫글자를 소문자로 바꾼것 -->
	<h3>${requestScope.s.name}</h3>
	<h3>${requestScope.s.num}</h3>
	<h3>${requestScope.s.avg}</h3>
	
</body>
</html>