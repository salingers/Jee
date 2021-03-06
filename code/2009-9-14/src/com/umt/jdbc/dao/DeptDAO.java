package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.vo.DeptVO;

public class DeptDAO {
	/**
	 * 添加一条记录
	 * @param vo：DeptVO对象
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public void save(DeptVO vo) throws ClassNotFoundException, SQLException{
		//第一步：打开数据库
		String user = "edu";
		String password = "edu";
		String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		//第二部：操作数据库
		/*
		 * String sql = "insert into dept(deptid,deptname) " +
				"values(" + vo.getDeptId() + ",'" + vo.getDeptName() + "')";
		 */
		
		String sql = "insert into dept(deptid,deptname) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);		//预编译对象
		
		//设置sql的参数
		ps.setInt(1, vo.getDeptId());
		ps.setString(2, vo.getDeptName());
		
		ps.executeUpdate();
		
		//第三部：关闭数据库
		
		con.close();
	}
	
	public void delete(int deptid) throws ClassNotFoundException, SQLException{
		//第一步：打开数据库
		String user = "edu";
		String password = "edu";
		String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		//第二部：操作数据库
		
		
		String sql = "delete from dept where deptid = ?";
		PreparedStatement ps = con.prepareStatement(sql);		//预编译对象
		
		//设置sql的参数
		ps.setInt(1, deptid);
		
		ps.executeUpdate();
		
		//第三部：关闭数据库
		
		con.close();
	}
	
	public void update(DeptVO vo){
		
	}
	
	public static void main(String args[]){
		DeptDAO dao = new DeptDAO();
		DeptVO vo = new DeptVO(8,"bbbbbbb");
		try {
			dao.save(vo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
