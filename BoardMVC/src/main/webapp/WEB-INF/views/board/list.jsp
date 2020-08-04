<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
	<div>
		${loginUser.nm }님 환영합니다. 
		<a href="/user/logout"><button>로그아웃</button></a>
	</div>
	<a href="/board/write">글등록</a>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일시</th>
		</tr>
		<div id="boardContent">
		</div>	
	</table>
	<script>
		function moveToDetail(i_board) {
			location.href = '/board/detail?i_board=' + i_board
		}
				
		function getBoardData(page) {
			axios.get('/board/getListData', {
				params: {
					page: page
				}
			}).then(function (data) {
				console.log(data)
			})
		}
		
		var page = 1
		getBoardData(page)
	</script>
</body>
</html>






