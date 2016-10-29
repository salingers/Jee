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
		//��ÿͻ��˵�����
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		
		//��֤�û����������Ƿ�Ϸ�
		UserDAO userDAO = new UserDAO();
		User user = userDAO.isLogin(username, pwd);
		
		if(user != null){
			//��½�ɹ�
			request.setAttribute("username", username);
			//���ڷ��͵�successҳ����ʾ��¼�û�
			User u = new User(1,"yexu","123",2);
			User u2 = new User(2,"yexu2","123",2);
			request.setAttribute("user", u);
			
			
			//��װList
			List users = new ArrayList();
			users.add(u);
			users.add(u2);
			
			request.setAttribute("users", users);
			//���ڷ��͵�successҳ�����ʾ��ǰ��¼�˵�����
			request.getRequestDispatcher("success.jsp");
		}else{
			//��½ʧ�ܣ���ת����½ҳ��
			response.sendRedirect("login.html");
		}
	
	}

}
