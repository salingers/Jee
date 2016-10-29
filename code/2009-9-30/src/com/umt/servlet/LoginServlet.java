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
			//跳转到修改页面
			this.toUpdate(request, response);
		}else if(method.equals("update")){
			//修改数据，并跳转到全查页面
			this.update(request, response);
			this.findAll(request, response);
		}
	}

	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获得客户端的请求
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		// 验证用户名和密码是否合法
		UserDAO userDAO = new UserDAO();
		User user = userDAO.isLogin(username, pwd);

		if (user != null) {
			// 登陆成功
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			// 封装List
			this.findAll(request, response);
		} else {
			// 登陆失败，跳转到登陆页面
			response.sendRedirect("login.html");
		}
	}

	/**
	 * 删除页面上指定的对象
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
		
		//跳转到全查页面
		this.findAll(request, response);
	}
	/**
	 * 查询Users表中的全部记录，并跳转到显示页面
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
		
		//允许pwd为空
		String pwd = request.getParameter("pwd");
		if(pwd == null){
			System.out.println("pwd 为空！");
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
