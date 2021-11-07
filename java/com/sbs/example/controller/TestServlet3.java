package com.sbs.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/storage")
public class TestServlet3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		
		if(action.equals("req")) {
			String data = (String)request.getAttribute("data1");
			System.out.println(data);
			
		} else if(action.equals("reqAdd")) {
			String name = request.getParameter("name");
			request.setAttribute("data1", name);
			
		} else if(action.equals("sessAdd")) {
			String name = request.getParameter("name");
			session.setAttribute("data1", name);
			
		} else if(action.equals("sess")) {
			String data = (String)session.getAttribute("data1");
			System.out.println(data);
			
		} else if(action.equals("appAdd")) {
			String name = request.getParameter("name");
			application.setAttribute("data1", name);
			
		} else if(action.equals("app")) {
			String data = (String)application.getAttribute("data1");
			System.out.println(data);
		} else if(action.equals("dataAdd")) {
			
			application.setAttribute("data1", "appData");
			session.setAttribute("data2", "sessData");
			request.setAttribute("data3", "reqData");
			
			RequestDispatcher rd = request.getRequestDispatcher("test/storage.jsp");
			rd.forward(request, response);
		
			
		}
		
		
		
		
	}
}
