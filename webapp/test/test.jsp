<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.sbs.example.model.ArticleDao"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sbs.example.model.Article"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	System.out.println("공통기능");

	ArticleDao dao = new ArticleDao();
	List<Article> articles = dao.getArticles();
	
	for(int i = 0; i < articles.size(); i++) {
%>
	번호 : <%= articles.get(i).getId() %> <br />
	제목 : <%= articles.get(i).getTitle() %> <br />
	내용 : <%= articles.get(i).getBody() %> <br />
	
	<hr>
<%
	}

%>
	<a href="http://localhost:9000/jsp_example/articleForm.jsp">글쓰기</a>
</body>
</html>