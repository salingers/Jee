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
 * DAO:data access object���ݲ�������
 * 
 * �����������ݣ�����ɾ���ġ���ȣ�
 */
public class UserDAO {

	private final String filePath = "users.txt";
	
	/**
	 * �ж��û��Ƿ�Ϊ�Ϸ��û�
	 * @param username �û���
	 * @param pwd ����
	 * @return boolean��true���Ϸ��û���false���Ƿ��û���
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
	 * ��ѯUsers�ļ��е�ȫ���û���������
	 * �������װ������User�У��ٽ�User�����װ��List��
	 * @return List����װ��User����
	 */
	public List<User> findAll() {

		List<User> users = new ArrayList<User>();
		Reader reader = null;
		BufferedReader br = null;

		// ����
		try {
			reader = new FileReader(filePath);
			br = new BufferedReader(reader);

			// ������
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
