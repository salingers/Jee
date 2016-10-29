package com.umt.jdbc.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DabaseConnection {

	private final String user = "edu";
	private final String password = "edu";
	private final String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
	private Connection con; // ���ݿ����Ӷ���
	private PreparedStatement ps; // Ԥ�����������ִ��sql���
	
	/**
	 * ������ݿ������
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
	 * �ر����ݿ�����
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
