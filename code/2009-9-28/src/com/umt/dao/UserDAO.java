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
	private Connection con;			//数据库连接对象
	private PreparedStatement ps;	//预编译对象，用来执行sql语句
	private ResultSet rs;
	
	/**
	 * 判断用户名和密码是否合法
	 * 
	 * @param username
	 * @param pwd
	 * @return 如果为合法用户，此返回此用户的对象；如果不合法，返回null
	 */

	public User isLogin(String username,String pwd){
		User user = null;
		//第一步：打开数据库
		dbc = new DatabaseConnection();
		con = dbc.getCon();
		//第二步：操作数据库
		String sql = "select * from users u where u.name = ? and u.pwd = ?";
		try {
			ps = con.prepareStatement(sql);
			
			//设置参数
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
		
			rs.next();
			
			user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"),rs.getInt("empid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//第三步：关闭数据库
			dbc.close(con);
			dbc = null;
		}
		
		return user;
	}
}
