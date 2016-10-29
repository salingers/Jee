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


	/**
	 * ��ѯUsers���е�ȫ����¼
	 * @return List<User>����װ��User�����List����
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
	 * �����ݿ��в���һ����¼
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
			
			//���ò���
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
	 * ɾ��Users���У�ָ������ֵ�Ķ���
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
			
			//���ò���
			
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
			
			//���ò���
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
