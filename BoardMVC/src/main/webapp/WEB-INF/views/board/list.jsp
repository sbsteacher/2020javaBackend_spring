<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<a href="/board/write">글등록</a>
	<c:forEach items="${data}" var="item">
		<div>${item.title }</div>
	</c:forEach>
</body>
</html>






