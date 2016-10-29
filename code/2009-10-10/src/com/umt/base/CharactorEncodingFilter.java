package com.umt.base;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharactorEncodingFilter implements Filter {
	private String encoding = "ISO-8859-1";

	public void destroy() {
		encoding = "ISO-8859-1";
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		chain.doFilter(request, response);

	}

	public void init(FilterConfig config) throws ServletException {
		String encode = config.getInitParameter("encoding");

		if (encode != null && !encode.equals("")) {
			encoding = encode;
		}
	}

}
