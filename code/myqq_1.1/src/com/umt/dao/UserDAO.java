package com.umt.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.umt.vo.User;

/*
 * DAO:data access object数据操作对象
 * 
 * 用来操作数据（增、删、改、查等）
 */
public class UserDAO {

	private final String filePath = "users.txt";
	
	/**
	 * 判断用户是否为合法用户
	 * @param username 用户名
	 * @param pwd 密码
	 * @return boolean（true：合法用户；false：非法用户）
	 */

	public boolean isLogin(String username, String pwd) {
		boolean flag = false;

		//
		List<User> users = this.findAll();
		
		for (Iterator iterator = users.iterator(); iterator.hasNext();) {
			User user = (User) iterator.next();
			
			if(username.equals(user.getUsername()) && pwd.equals(user.getPassword())){
				flag = true;
				break;
			}
			
		}
		return flag;
	}

	
	/**
	 * 查询Users文件中的全部用户名和密码
	 * 并将其封装到对象User中，再将User对象封装到List中
	 * @return List：封装了User对象
	 */
	public List<User> findAll() {

		List<User> users = new ArrayList<User>();
		Reader reader = null;
		BufferedReader br = null;

		// 打开流
		try {
			reader = new FileReader(filePath);
			br = new BufferedReader(reader);

			// 操作流
			String strUser = "";
			while ((strUser = br.readLine()) != null) {
				String[] u = strUser.split("-");
				User user = new User(u[0], u[1]);

				users.add(user);
			}

			//

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
					br = null;
				}
				
				if(reader != null){
					reader.close();
					reader = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return users;

	}
	
	public static void main(String args[]){
		UserDAO userDAO = new UserDAO();
		System.out.println(userDAO.findAll().size());
	}

}
