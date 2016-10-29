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
		//��ÿͻ��˵�����
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		//��֤�û����������Ƿ�Ϸ�
		UserDAO userDAO = new UserDAO();
		User user = userDAO.isLogin(username, pwd);
		
		if(user != null){
			//��½�ɹ�
			response.sendRedirect("success.html");
		}else{
			//��½ʧ�ܣ���ת����½ҳ��
			response.sendRedirect("login.html");
		}
	
	}

}
