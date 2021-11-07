<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
    prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>JSTL Test</h1>
<hr>
<!--  el 표현  -->
${ age }살 ${ name }님! 안녕하세요

${ hong.age } 
${ hong.name }
<hr>
<%
	int a = 9;

	if(a % 2 == 0 ) {
%>
	짝수
<% } else { %> 
	홀수
<%
}
%>
<!-- 변수 -->
<c:set var="a" value="3"/>

<!-- 단순 조건문 -->
<c:if test="${a % 2 == 0}">
	짝수
</c:if>
<c:if test="${a % 2 != 0}">
	홀수
</c:if>

<!-- else if => when -->
<c:choose>
	<c:when test="${ a % 2 == 0 }">
		짝수
	</c:when>
	<c:otherwise>
		홀수
	</c:otherwise>
</c:choose> 
</body>
</html>