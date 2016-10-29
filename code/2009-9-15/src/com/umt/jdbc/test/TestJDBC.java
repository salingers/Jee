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
		//第一步：打开数据库
		String username = "edu";
		String pwd = "edu";
		String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
		
		//第i步：加载驱动程序
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//第ii步：获得数据库的连接
		Connection con = DriverManager.getConnection(url, username, pwd);
		
		System.out.println("数据库连接成功！");
		
		//操作数据库
		//String sql = "insert into dept(deptid,deptname) values(8,'bbbbb')";
		
		//String sql = "delete from dept d where d.deptid = 8";
		
		String sql = "update dept set deptname = '财务部' where deptid = 7";
		PreparedStatement ps  = con.prepareStatement(sql);
		
		ps.executeUpdate();
		
		//关闭数据
		con.close();
		
		
		
	}

}
