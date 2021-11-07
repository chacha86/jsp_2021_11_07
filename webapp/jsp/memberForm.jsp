<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>회원가입 페이지</h1>
<form action="/article">
	<div>
		아이디 : <input type="text" name="loginId" />
	</div>
	<div>
		비밀번호 : <input type="password" name="loginPw" />
	</div>
	<div>
		닉네임 : <input type="text" name="nickname" />
	</div>
	<input type="hidden" name="action" value="doJoin">
	<input type="submit" value="가입하기" />
</form>

</body>
</html>