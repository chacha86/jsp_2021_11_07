package com.sbs.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 출력 처리 -> 어떤 형식으로 어떤 문자셋을 이용해서 출력할 것인가.
		response.setContentType("text/html;charset=utf8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		int dan = Integer.parseInt(request.getParameter("dan"));
		PrintWriter out = response.getWriter();		
		
		for(int i = 1; i < 10; i++) {
			out.println(dan + " X " + i + " = " + dan*i + "<br />");
		}
		
	
		
		
		
	}

}

