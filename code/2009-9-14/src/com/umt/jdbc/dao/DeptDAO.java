package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.vo.DeptVO;

public class DeptDAO {
	/**
	 * ���һ����¼
	 * @param vo��DeptVO����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public void save(DeptVO vo) throws ClassNotFoundException, SQLException{
		//��һ���������ݿ�
		String user = "edu";
		String password = "edu";
		String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		//�ڶ������������ݿ�
		/*
		 * String sql = "insert into dept(deptid,deptname) " +
				"values(" + vo.getDeptId() + ",'" + vo.getDeptName() + "')";
		 */
		
		String sql = "insert into dept(deptid,deptname) values(?,?)";
		PreparedStatement ps = con.prepareStatement(sql);		//Ԥ�������
		
		//����sql�Ĳ���
		ps.setInt(1, vo.getDeptId());
		ps.setString(2, vo.getDeptName());
		
		ps.executeUpdate();
		
		//���������ر����ݿ�
		
		con.close();
	}
	
	public void delete(int deptid) throws ClassNotFoundException, SQLException{
		//��һ���������ݿ�
		String user = "edu";
		String password = "edu";
		String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, user, password);
		//�ڶ������������ݿ�
		
		
		String sql = "delete from dept where deptid = ?";
		PreparedStatement ps = con.prepareStatement(sql);		//Ԥ�������
		
		//����sql�Ĳ���
		ps.setInt(1, deptid);
		
		ps.executeUpdate();
		
		//���������ر����ݿ�
		
		con.close();
	}
	
	public void update(DeptVO vo){
		
	}
	
	public static void main(String args[]){
		DeptDAO dao = new DeptDAO();
		DeptVO vo = new DeptVO(8,"bbbbbbb");
		try {
			dao.save(vo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
