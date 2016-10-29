package com.umt.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			request.setAttribute("username", username);
			//用于发送到success页面显示登录用户
			User u = new User(1,"yexu","123",2);
			User u2 = new User(2,"yexu2","123",2);
			request.setAttribute("user", u);
			
			
			//封装List
			List users = new ArrayList();
			users.add(u);
			users.add(u2);
			
			request.setAttribute("users", users);
			//用于发送到success页面的显示当前登录人的数据
			request.getRequestDispatcher("success.jsp");
		}else{
			//登陆失败，跳转到登陆页面
			response.sendRedirect("login.html");
		}
	
	}

}
