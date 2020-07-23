<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정</title>
</head>
<body>
	<form action="/board/upd" method="post">
		<input type="hidden" name="i_board" value="${data.i_board }">
		<div>제목: <input type="text" name="title" value="${data.title}"></div>
		<div>내용: <textarea name="ctnt">${data.ctnt}</textarea></div>
		<div><input type="submit" value="수정"></div>
	</form>
</body>
</html>