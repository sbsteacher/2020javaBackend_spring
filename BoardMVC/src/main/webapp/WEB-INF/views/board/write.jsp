<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/board/write" method="post">
		<div>제목: <input type="text" name="title"></div>
		<div>내용: <textarea name="ctnt"></textarea></div>
		<div><input type="submit" value="등록"></div>
	</form>
</body>
</html>