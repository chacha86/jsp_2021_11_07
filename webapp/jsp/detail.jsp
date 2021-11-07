<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>게시물 상세 페이지</h1>
	<%@ include file="head.jspf" %>
	<div>
		번호 : ${ article.id } 
	</div>
	<div>
		제목 : ${ article.title }
	</div>
	<div>
		내용 : ${article.body }
	</div>
	<div>
		작성자 : ${ article.nickname }
	</div>
	<div>
		작성일 : ${article.regDate }
	</div>
	<hr>
	<a href="article?action=showUpdateForm&id=${article.id}">수정</a>
	<a href="article?action=doDelete&id=${article.id}">삭제</a>
	<hr>
	<c:choose>
		<c:when test="${ false }">
			<a href="article?action=doLike">좋아요 ♡ 0</a>		
		</c:when>
		<c:otherwise>
			<a href="article?action=doLike">좋아요 ♥ 1</a>		
		</c:otherwise>
	</c:choose>
	<hr>
	<div>
		<h4>댓글</h4>
		<div>
			<div>홍길동</div>
			<div>댓글 내용~~~1</div>
			<div>2021.11.07</div>
		</div>
		<hr>
		<div>
			<div>홍길순</div>
			<div>댓글 내용~~~2</div>
			<div>2021.11.07</div>
		</div>
		<hr>
		<div>
			<div>이순신</div>
			<div>댓글 내용~~~3</div>
			<div>2021.11.07</div>
		</div>
		<hr>
		<form action="/article">
			<div>${sessionScope.loginedMember.nickname}</div>
			<input type="text" name="rbody"/>
			<input type="hidden" name="action" value="doAddReply"/>
			<input type="submit" value="등록" />
		</form>
	</div>
</body>
</html>