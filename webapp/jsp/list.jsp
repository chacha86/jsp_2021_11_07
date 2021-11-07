<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.col {
	display: inline-block;
	width: 50px;
	font-size: 10px;
}

.title, .regDate {
	width: 150px;
}

</style>
<body>
	<h1>게시물 목록 페이지</h1>
	<%@ include file="head.jspf" %>
	<div>
		<div class="col">번호</div>
		<div class="col title">제목</div>
		<div class="col">작성자</div>
		<div class="col regDate">작성일</div>
		<div class="col">조회수</div>
		<div class="col">좋아요</div>
		<hr>
		<c:forEach items="${articles}" var="article">
		<div> 
			<div class="col">${article.id}</div>
			<div class="col title"><a href="article?action=detail&id=${article.id}">${article.title}</a>[${article.rcnt}]</div>
			<div class="col">${ article.nickname }</div>
			<div class="col regDate">${ article.regDate }</div>
			<div class="col">0</div>
			<div class="col">0</div>
		</div>
		</c:forEach>
		<hr>
	</div>
	<a href="article?action=articleForm">글쓰기</a>
</body>
</html>