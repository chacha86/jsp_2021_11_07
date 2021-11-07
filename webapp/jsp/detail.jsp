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
</body>
</html>