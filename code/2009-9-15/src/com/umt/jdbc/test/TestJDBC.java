package com.umt.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//��һ���������ݿ�
		String username = "edu";
		String pwd = "edu";
		String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
		
		//��i����������������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//��ii����������ݿ������
		Connection con = DriverManager.getConnection(url, username, pwd);
		
		System.out.println("���ݿ����ӳɹ���");
		
		//�������ݿ�
		//String sql = "insert into dept(deptid,deptname) values(8,'bbbbb')";
		
		//String sql = "delete from dept d where d.deptid = 8";
		
		String sql = "update dept set deptname = '����' where deptid = 7";
		PreparedStatement ps  = con.prepareStatement(sql);
		
		ps.executeUpdate();
		
		//�ر�����
		con.close();
		
		
		
	}

}
