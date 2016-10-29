package com.umt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.umt.dao.UserDAO;
import com.umt.vo.User;

public class LoginServlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得客户端的请求
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		//验证用户名和密码是否合法
		UserDAO userDAO = new UserDAO();
		User user = userDAO.isLogin(username, pwd);
		
		if(user != null){
			//登陆成功
			response.sendRedirect("success.html");
		}else{
			//登陆失败，跳转到登陆页面
			response.sendRedirect("login.html");
		}
	
	}

}
