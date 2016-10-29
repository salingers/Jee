package com.umt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	

		
		 response.setContentType("text/xml");
		 response.setCharacterEncoding("GBK");
		 StringBuffer sb = new StringBuffer();
		 sb.append("<?xml version=\"1.0\" encoding=\"gbk\" ?> ");
		 sb.append("<students>");
		 sb.append("<student id=\"001\">");
		 sb.append("<name>ÕÅÈý</name>");
		 sb.append("<tel>123445</tel> ");
		 sb.append("</student>");
		 
		 sb.append("<student id=\"002\">");
		 sb.append("<name>lisa</name>");
		 sb.append("<tel>456</tel> ");
		 sb.append("</student>");
		 sb.append("</students>");
		PrintWriter out = response.getWriter();
		out.print(sb);
		out.flush();
		// out.close();
		// request.getRequestDispatcher("").forward(request, response);
	}

}
