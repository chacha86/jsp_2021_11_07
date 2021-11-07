<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>게시물 수정</h1>
<form action="article">
	<div>
		제목 : <input type="text" name="title"  value="${article.title }"/>
	</div>
	<div>
		내용 : <input type="text" name="body" value="${article.body }"/>
	</div>
	<input type="submit" value="수정" />
	<input type="hidden" name="action" value="doUpdate">
	<input type="hidden" name="id" value="${article.id }">
</form>

</body>
</html>