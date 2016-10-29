package com.umt.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.base.DabaseConnection;

public class TestDept {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		DabaseConnection dbc = new DabaseConnection();
		Connection con = dbc.getCon();
		
		
		
		//操作数据库
		String sql1 = "insert into dept(deptid,deptname) values(7,'aaaaa')";
		
		String sql2 = "insert into dept(deptid,deptname) values(7,'bbbbbb')";
		
		String sql3 = "insert into dept(deptid,deptname) values(8,'cccccc')";
		
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);		//关闭事物的自动提交功能
			
			
			 ps = con.prepareStatement(sql1);
			 
			 ps.executeUpdate();
			 
			 //执行sql2
			 ps = con.prepareStatement(sql2);
			 ps.executeUpdate();
			 
			 //执行sql3
			 ps = con.prepareStatement(sql3);
			 ps.executeUpdate();
			 
			 //手动提交事物
			 con.commit();
			 
		} catch (SQLException e) {
			//事物回滚
			try {
				con.rollback();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
		}
		

	}

}
