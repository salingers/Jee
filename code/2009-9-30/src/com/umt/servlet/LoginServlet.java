package com.umt.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.umt.dao.UserDAO;
import com.umt.vo.User;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String method = request.getParameter("method");

		if (method.equals("login")) {
			this.login(request, response);
		} else if (method.equals("delete")) {
			this.delete(request,response);
		}else if(method.equals("toUpdate")){
			//��ת���޸�ҳ��
			this.toUpdate(request, response);
		}else if(method.equals("update")){
			//�޸����ݣ�����ת��ȫ��ҳ��
			this.update(request, response);
			this.findAll(request, response);
		}
	}

	/**
	 * ��½
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ÿͻ��˵�����
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		// ��֤�û����������Ƿ�Ϸ�
		UserDAO userDAO = new UserDAO();
		User user = userDAO.isLogin(username, pwd);

		if (user != null) {
			// ��½�ɹ�
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			// ��װList
			this.findAll(request, response);
		} else {
			// ��½ʧ�ܣ���ת����½ҳ��
			response.sendRedirect("login.html");
		}
	}

	/**
	 * ɾ��ҳ����ָ���Ķ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//...................
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDAO userDAO = new UserDAO();
		userDAO.delete(id);
		
		//��ת��ȫ��ҳ��
		this.findAll(request, response);
	}
	/**
	 * ��ѯUsers���е�ȫ����¼������ת����ʾҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findAll(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		List<User> users = userDAO.findAll();

		request.setAttribute("users", users);
		request.getRequestDispatcher("success.jsp").forward(request,
				response);
	}

	public void toUpdate(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO = new UserDAO();
		
		User user = userDAO.findById(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("update.jsp").forward(request, response);
	}

	public void update(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		//����pwdΪ��
		String pwd = request.getParameter("pwd");
		if(pwd == null){
			System.out.println("pwd Ϊ�գ�");
		}
		
		
		String strEmpId = request.getParameter("empId");
		if(strEmpId == null){
			strEmpId = "0";
		}
		int empId = Integer.parseInt(strEmpId);
		
		User user = new User(id,name,pwd,empId);
		
		UserDAO userDAO = new UserDAO();
		userDAO.update(user);
		
	}
}
