package com.umt.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private final String url = "jdbc:oracle:thin:@192.168.3.129:1521:orcl";
	private final String username = "edu";
	private final String pwd = "edu";
	
	/**
	 * ������ݿ����Ӷ���
	 * @return
	 */

	public Connection getCon() {

		// ������������
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			// ������ݿ�����
			return DriverManager.getConnection(url, username, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * �ر����ݿ����Ӷ���
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
