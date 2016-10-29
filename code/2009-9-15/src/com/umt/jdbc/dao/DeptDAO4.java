package com.umt.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.umt.jdbc.base.DabaseConnection;
import com.umt.jdbc.vo.DeptVO;

/*
 * DAO :data access object
 */

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

	/**
	 * ��ѯָ������ID����Ϣ
	 * 
	 * @param deptId
	 *            ������ID
	 * @return DeptVO
	 */

	public DeptVO findbyId(int deptId) {
		DeptVO dept = null;

		// �����ݿ�
		dbc = new DabaseConnection();
		con = dbc.getCon();

		// �������ݿ�
		String sql = "select * from dept d where d.deptid = ?";

		try {
			ps = con.prepareStatement(sql);

			// ���ò���
			ps.setInt(1, deptId);

			// ִ��sql���
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				int id = rs.getInt("deptid");
				String deptName = rs.getString("deptName");
				dept = new DeptVO(id, deptName);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
		}

		return dept;
	}

	
	public List<DeptVO> findAll(){
		List<DeptVO> depts =  new ArrayList<DeptVO>();
		// �����ݿ�
		dbc = new DabaseConnection();
		con = dbc.getCon();

		// �������ݿ�
		String sql = "select * from dept d";

		try {
			ps = con.prepareStatement(sql);

			// ִ��sql���
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("deptid");
				String deptName = rs.getString("deptName");
				DeptVO dept = new DeptVO(id, deptName);
				
				depts.add(dept);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			dbc.close(con);
			dbc = null;
		}

		
		return depts;
	}
	public static void main(String args[]) {
		DeptDAO4 dao = new DeptDAO4();
		DeptVO vo = null;

		vo = dao.findbyId(6);
		System.out.println(vo.getDeptId() + " " + vo.getDeptName());
		
		List<DeptVO> depts = dao.findAll();
		for (Iterator iterator = depts.iterator(); iterator.hasNext();) {
			DeptVO deptVO = (DeptVO) iterator.next();
			System.out.println(deptVO.getDeptId() + " " + deptVO.getDeptName());
			
		}
	}

}
