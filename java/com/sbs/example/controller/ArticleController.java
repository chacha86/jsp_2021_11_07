package com.sbs.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sbs.example.model.Article;
import com.sbs.example.model.ArticleDao;
import com.sbs.example.model.Member;

@WebServlet("/article")
public class ArticleController extends HttpServlet {

	ArticleDao dao = new ArticleDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println(action);

		if (action.equals("list")) {

			// 로그인 처리

			List<Article> articles = dao.getArticles();
			request.setAttribute("articles", articles);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
			rd.forward(request, response);

		} else if (action.equals("articleForm")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/articleForm.jsp");
			rd.forward(request, response);

		} else if (action.equals("detail")) {

			int nid = 0;
			String id = request.getParameter("id");

			if (id != null) {
				nid = Integer.parseInt(id);
			}

			Article article = dao.getArticleById(nid);
			request.setAttribute("article", article);

			RequestDispatcher rd = request.getRequestDispatcher("jsp/detail.jsp");
			rd.forward(request, response);

		} else if (action.equals("doAdd")) {

			String title = request.getParameter("title");
			String body = request.getParameter("body");

			Article a = new Article(title, body, "2021.10,23", 1);
			dao.insertArticle(a);

			// list
			response.sendRedirect("article?action=list");

		} else if (action.equals("doDelete")) {
			int id = Integer.parseInt(request.getParameter("id"));

			dao.deleteArticle(id);
			
			response.sendRedirect("article?action=list");

		} else if (action.equals("showUpdateForm")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Article article = dao.getArticleById(id);

			request.setAttribute("article", article);
			forward(request, response, "updateForm");

		} else if (action.equals("doUpdate")) {
			int id = Integer.parseInt(request.getParameter("id"));

			String title = request.getParameter("title");
			String body = request.getParameter("body");

			Article article = new Article(id, title, body);
			dao.updateArticle(article);

			response.sendRedirect("article?action=detail&id=" + id);

		} else if (action.equals("memberForm")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/memberForm.jsp");
			rd.forward(request, response);
		} else if (action.equals("doJoin")) {

			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");
			String nickname = request.getParameter("nickname");

			dao.insertMember(new Member(loginId, loginPw, nickname));
			response.sendRedirect("article?action=list");

		} else if (action.equals("loginForm")) {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/loginForm.jsp");
			rd.forward(request, response);

		} else if (action.equals("doLogin")) {

			String loginId = request.getParameter("loginId");
			String loginPw = request.getParameter("loginPw");

			Member loginedMember = dao.getMemberByLoginIdAndLoginPw(new Member(loginId, loginPw));

			if (loginedMember != null) {

				// 포워딩
				List<Article> articles = dao.getArticles();
				request.setAttribute("articles", articles);

				// request.setAttribute("loginedMember", loginedMember);

				// session 저장소

				HttpSession session = request.getSession();
				session.setAttribute("loginedMember", loginedMember);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/list.jsp");
				rd.forward(request, response);

			} else {
				String errorMsg = "로그인 실패!! 로그인 정보가 올바르지않습니다.";
				request.setAttribute("errorMsg", errorMsg);

				RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
				rd.forward(request, response);
			}

		}

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String fname)
			throws ServletException, IOException {
		String path = "/jsp/" + fname + ".jsp";

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
}
