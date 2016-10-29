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
		
		
		
		//�������ݿ�
		String sql1 = "insert into dept(deptid,deptname) values(7,'aaaaa')";
		
		String sql2 = "insert into dept(deptid,deptname) values(7,'bbbbbb')";
		
		String sql3 = "insert into dept(deptid,deptname) values(8,'cccccc')";
		
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(false);		//�ر�������Զ��ύ����
			
			
			 ps = con.prepareStatement(sql1);
			 
			 ps.executeUpdate();
			 
			 //ִ��sql2
			 ps = con.prepareStatement(sql2);
			 ps.executeUpdate();
			 
			 //ִ��sql3
			 ps = con.prepareStatement(sql3);
			 ps.executeUpdate();
			 
			 //�ֶ��ύ����
			 con.commit();
			 
		} catch (SQLException e) {
			//����ع�
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
