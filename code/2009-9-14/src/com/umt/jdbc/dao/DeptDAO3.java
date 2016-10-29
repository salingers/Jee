package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.vo.DeptVO;

public class DeptDAO3 {
	private final String user = "edu";
	private final String password = "edu";
	private final String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
	private Connection con; // 数据库连接对象
	private PreparedStatement ps; // 预编译对象，用来执行sql语句

	/**
	 * 获得数据库的连接
	 * 
	 * @return
	 */

	public Connection getCon() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * 关闭数据库连接
	 * @param con
	 */
	public void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加一条记录
	 * 
	 * @param vo：DeptVO对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void save(DeptVO vo) throws ClassNotFoundException, SQLException {
		// 第一步：打开数据库
		con = this.getCon();

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
		
		this.close(con);
	}

	public void delete(int deptid) throws ClassNotFoundException, SQLException {
		// 第一步：打开数据库

		con = this.getCon();
		// 第二部：操作数据库

		String sql = "delete from dept where deptid = ?";
		ps = con.prepareStatement(sql); // 预编译对象

		// 设置sql的参数
		ps.setInt(1, deptid);

		ps.executeUpdate();

		// 第三部：关闭数据库

		this.close(con);
	}

	public void update(DeptVO vo) {

	}

	public static void main(String args[]) {
		DeptDAO3 dao = new DeptDAO3();
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
