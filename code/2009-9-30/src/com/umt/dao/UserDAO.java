package com.umt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


	/**
	 * 查询Users表中的全部记录
	 * @return List<User>：封装了User对象的List容器
	 */
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		User user = null;
		
		//
		dbc = new DatabaseConnection();
		con = dbc.getCon();
		
		//
		String sql = "select * from users u";
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"),rs.getInt("empid"));
				
				users.add(user);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
			rs = null;
			ps = null;
		}
		
		//
		
		return users;
	}

	/**
	 * 向数据库中插入一条记录
	 * @param user
	 */
	public void save(User user){
		//
		dbc = new DatabaseConnection();
		con = dbc.getCon();
		//
		String sql = "insert into users(id,name,pwd,empid) values(seq_users.nextval,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			
			//设置参数
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setInt(3, user.getEmpId());
			
			//
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
			ps = null;
		}
		
		
	}

	/**
	 * 删除Users表中，指定主键值的对象
	 * @param id
	 */
	public void delete(int id){
		//
		dbc = new DatabaseConnection();
		con = dbc.getCon();
		//
		String sql = "delete from users u where u.id = ?";
		try {
			ps = con.prepareStatement(sql);
			
			//设置参数
			
			ps.setInt(1, id);
			
			//
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
			ps = null;
		}
	}

	public void update(User user){
		//
		dbc = new DatabaseConnection();
		con = dbc.getCon();
		//
		String sql = "update users u set u.name = ?,u.pwd = ?,u.empid = ? where u.id = ?";
		try {
			ps = con.prepareStatement(sql);
			
			//设置参数
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setInt(3, user.getEmpId());
			ps.setInt(4, user.getId());
			
			//
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
			ps = null;
		}
	}


	public User findById(int id) {
		User user = null;
		
		//
		dbc = new DatabaseConnection();
		con = dbc.getCon();
		
		//
		String sql = "select * from users u where u.id = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			rs.next();
				user = new User(rs.getInt("id"),rs.getString("name"),rs.getString("pwd"),rs.getInt("empid"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
			rs = null;
			ps = null;
		}
		
		return user;
	}
}
