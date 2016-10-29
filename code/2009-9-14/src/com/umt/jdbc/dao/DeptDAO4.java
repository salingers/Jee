package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.base.DabaseConnection;
import com.umt.jdbc.vo.DeptVO;

public class DeptDAO4 {	
	private Connection con; // ���ݿ����Ӷ���
	private PreparedStatement ps; // Ԥ�����������ִ��sql���
	private DabaseConnection dbc;

	
	/**
	 * ���һ����¼
	 * 
	 * @param vo��DeptVO����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void save(DeptVO vo) throws ClassNotFoundException, SQLException {
		// ��һ���������ݿ�
		dbc = new DabaseConnection();
		con = dbc.getCon();

		// �ڶ������������ݿ�
		/*
		 * String sql = "insert into dept(deptid,deptname) " + "values(" +
		 * vo.getDeptId() + ",'" + vo.getDeptName() + "')";
		 */

		String sql = "insert into dept(deptid,deptname) values(?,?)";
		ps = con.prepareStatement(sql); // Ԥ�������

		// ����sql�Ĳ���
		ps.setInt(1, vo.getDeptId());
		ps.setString(2, vo.getDeptName());

		ps.executeUpdate();

		// ���������ر����ݿ�
		
		dbc.close(con);
		dbc = null;
	}

	public void delete(int deptid) throws ClassNotFoundException, SQLException {
		// ��һ���������ݿ�
		dbc = new DabaseConnection();
		con = dbc.getCon();
		// �ڶ������������ݿ�

		String sql = "delete from dept where deptid = ?";
		ps = con.prepareStatement(sql); // Ԥ�������

		// ����sql�Ĳ���
		ps.setInt(1, deptid);

		ps.executeUpdate();

		// ���������ر����ݿ�

		dbc.close(con);
		dbc = null;
	}

	public void update(DeptVO vo) {

	}

	public static void main(String args[]) {
		DeptDAO4 dao = new DeptDAO4();
		DeptVO vo = new DeptVO(8, "bbbbbbb");
		try {
			dao.save(vo);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
