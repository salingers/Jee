package com.umt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.umt.base.DatabaseConnection;
import com.umt.vo.User;

/**
 * DAO:data access object
 * @author Administrator
 *
 */
public class UserDAO {
	
	private DatabaseConnection dbc;
	private Connection con;			//���ݿ����Ӷ���
	private PreparedStatement ps;	//Ԥ�����������ִ��sql���
	private ResultSet rs;
	
	/**
	 * �ж��û����������Ƿ�Ϸ�
	 * 
	 * @param username
	 * @param pwd
	 * @return ���Ϊ�Ϸ��û����˷��ش��û��Ķ���������Ϸ�������null
	 */

	public User isLogin(String username,String pwd){
		User user = null;
		//��һ���������ݿ�
		dbc = new DatabaseConnection();
		con = dbc.getCon();
		//�ڶ������������ݿ�
		String sql = "select * from users u where u.name = ? and u.pwd = ?";
		try {
			ps = con.prepareStatement(sql);
			
			//���ò���
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
		
			rs.next();
			
			user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"),rs.getInt("empid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//���������ر����ݿ�
			dbc.close(con);
			dbc = null;
		}
		
		return user;
	}
}
