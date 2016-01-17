package com.palette.busi.project.tms.web.support;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private final byte[] bodyParamter;
	
	public MyHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		
		InputStream input = request.getInputStream();
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int n = 0;
		while ((n = input.read(buffer)) != -1) {
			output.write(buffer, 0 ,n);
		}
		
		bodyParamter = output.toByteArray();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream input = new ByteArrayInputStream(bodyParamter);
		ServletInputStream servletInput = new ServletInputStream() {
			
			@Override
			public int read() throws IOException {
				return input.read();
			}
			
			@Override
			public void setReadListener(ReadListener readListener) {
				
			}
			
			@Override
			public boolean isReady() {
				return false;
			}
			
			@Override
			public boolean isFinished() {
				return false;
			}
		};
		
		return servletInput;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(getInputStream()));
		return reader;
	}
	
}
