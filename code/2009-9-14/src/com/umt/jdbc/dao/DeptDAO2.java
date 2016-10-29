package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.vo.DeptVO;

public class DeptDAO2 {
	private final String user = "edu";
	private final String password = "edu";
	private final String url = "jdbc:oracle:thin:@192.168.1.252:1521:orcl";
	private Connection con;		//���ݿ����Ӷ���
	private PreparedStatement ps;		//Ԥ�����������ִ��sql���
	/**
	 * ���һ����¼
	 * @param vo��DeptVO����
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public void save(DeptVO vo) throws ClassNotFoundException, SQLException{
		//��һ���������ݿ�
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
		//�ڶ������������ݿ�
		/*
		 * String sql = "insert into dept(deptid,deptname) " +
				"values(" + vo.getDeptId() + ",'" + vo.getDeptName() + "')";
		 */
		
		String sql = "insert into dept(deptid,deptname) values(?,?)";
		ps = con.prepareStatement(sql);		//Ԥ�������
		
		//����sql�Ĳ���
		ps.setInt(1, vo.getDeptId());
		ps.setString(2, vo.getDeptName());
		
		ps.executeUpdate();
		
		//���������ر����ݿ�
		ps.close();
		ps = null;
		con.close();
		con = null;
	}
	
	public void delete(int deptid) throws ClassNotFoundException, SQLException{
		//��һ���������ݿ�
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
		//�ڶ������������ݿ�
		
		
		String sql = "delete from dept where deptid = ?";
		ps = con.prepareStatement(sql);		//Ԥ�������
		
		//����sql�Ĳ���
		ps.setInt(1, deptid);
		
		ps.executeUpdate();
		
		//���������ر����ݿ�
		
		ps.close();
		ps = null;
		con.close();
		con = null;
	}
	
	public void update(DeptVO vo){
		
	}
	
	public static void main(String args[]){
		DeptDAO2 dao = new DeptDAO2();
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
