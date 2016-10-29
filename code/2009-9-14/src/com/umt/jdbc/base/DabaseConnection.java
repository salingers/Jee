package com.umt.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DabaseConnection {

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

}
