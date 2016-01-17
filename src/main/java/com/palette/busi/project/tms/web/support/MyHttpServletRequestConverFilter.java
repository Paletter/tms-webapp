package com.palette.busi.project.tms.web.support;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class MyHttpServletRequestConverFilter extends HttpServlet implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		if(request instanceof HttpServletRequest) {
			HttpServletRequest requestWrapper = new MyHttpServletRequestWrapper((HttpServletRequest) request);
			chain.doFilter(requestWrapper, response);
		} else {
			chain.doFilter(request, response);
		}
	}

}
