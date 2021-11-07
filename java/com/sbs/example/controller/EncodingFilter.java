package com.sbs.example.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = {"/article", "/filter", "/nofilter"})
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
    	// 필터 내용 작성
    	ServletContext application = request.getServletContext();
		
		application.setAttribute("charset", "utf-8");
		String charset = (String)application.getAttribute("charset");
		
		response.setContentType("text/html;charset=" + charset);
		response.setCharacterEncoding(charset);
		request.setCharacterEncoding(charset);
    	
		chain.doFilter(request, response);
		
	}

}
