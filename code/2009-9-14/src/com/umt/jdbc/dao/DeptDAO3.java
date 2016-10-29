package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.umt.jdbc.vo.DeptVO;

public class DeptDAO3 {
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

	/**
	 * ���һ����¼
	 * 
	 * @param vo��DeptVO����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void save(DeptVO vo) throws ClassNotFoundException, SQLException {
		// ��һ���������ݿ�
		con = this.getCon();

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
		
		this.close(con);
	}

	public void delete(int deptid) throws ClassNotFoundException, SQLException {
		// ��һ���������ݿ�

		con = this.getCon();
		// �ڶ������������ݿ�

		String sql = "delete from dept where deptid = ?";
		ps = con.prepareStatement(sql); // Ԥ�������

		// ����sql�Ĳ���
		ps.setInt(1, deptid);

		ps.executeUpdate();

		// ���������ر����ݿ�

		this.close(con);
	}

	public void update(DeptVO vo) {

	}

	public static void main(String args[]) {
		DeptDAO3 dao = new DeptDAO3();
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
