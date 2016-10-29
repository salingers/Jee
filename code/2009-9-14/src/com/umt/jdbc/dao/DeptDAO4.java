package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.base.DabaseConnection;
import com.umt.jdbc.vo.DeptVO;

public class DeptDAO4 {	
	private Connection con; // 数据库连接对象
	private PreparedStatement ps; // 预编译对象，用来执行sql语句
	private DabaseConnection dbc;

	
	/**
	 * 添加一条记录
	 * 
	 * @param vo：DeptVO对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void save(DeptVO vo) throws ClassNotFoundException, SQLException {
		// 第一步：打开数据库
		dbc = new DabaseConnection();
		con = dbc.getCon();

		// 第二部：操作数据库
		/*
		 * String sql = "insert into dept(deptid,deptname) " + "values(" +
		 * vo.getDeptId() + ",'" + vo.getDeptName() + "')";
		 */

		String sql = "insert into dept(deptid,deptname) values(?,?)";
		ps = con.prepareStatement(sql); // 预编译对象

		// 设置sql的参数
		ps.setInt(1, vo.getDeptId());
		ps.setString(2, vo.getDeptName());

		ps.executeUpdate();

		// 第三部：关闭数据库
		
		dbc.close(con);
		dbc = null;
	}

	public void delete(int deptid) throws ClassNotFoundException, SQLException {
		// 第一步：打开数据库
		dbc = new DabaseConnection();
		con = dbc.getCon();
		// 第二部：操作数据库

		String sql = "delete from dept where deptid = ?";
		ps = con.prepareStatement(sql); // 预编译对象

		// 设置sql的参数
		ps.setInt(1, deptid);

		ps.executeUpdate();

		// 第三部：关闭数据库

		dbc.close(con);
		dbc = null;
	}

	public void update(DeptVO vo) {

	}

	public static void main(String args[]) {
		DeptDAO4 dao = new DeptDAO4();
		DeptVO vo = new DeptVO(8, "bbbbbbb");
		try {
			dao.save(vo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
