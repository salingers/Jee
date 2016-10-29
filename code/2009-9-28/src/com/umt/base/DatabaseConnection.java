package com.umt.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private final String url = "jdbc:oracle:thin:@192.168.3.129:1521:orcl";
	private final String username = "edu";
	private final String pwd = "edu";
	
	/**
	 * 获得数据库连接对象
	 * @return
	 */

	public Connection getCon() {

		// 加载驱动程序
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			// 获得数据库连接
			return DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 关闭数据库连接对象
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
