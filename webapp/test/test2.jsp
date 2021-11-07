<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
여기는 test2.jsp 입니다~~
<hr>
<%
	
int age = 0;

ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");

for(int i = 0; i < list.size(); i++) {%>
	
	<%= list.get(i) %>
	<hr>
<%
}
%>
</body>
</html>