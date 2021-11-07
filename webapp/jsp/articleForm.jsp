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


<h1>게시물 등록 페이지</h1>
<form action="/article?action=doAdd">
	<div>
		제목 : <input type="text" name="title" />
	</div>
	<div>
		내용 : <input type="text" name="body" />
	</div>
	<input type="hidden" name="action" value="doAdd">
	<input type="submit" value="등록" />
</form>

</body>
</html>