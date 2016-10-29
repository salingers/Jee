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
	private Connection con; // 数据库连接对象
	private PreparedStatement ps; // 预编译对象，用来执行sql语句
	private DabaseConnection dbc;

	/**
	 * 添加一条记录
	 * 
	 * @param vo：DeptVO对象
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */

	public void save(DeptVO vo) throws ClassNotFoundException, SQLException {
		// 第一步：打开数据库
		dbc = new DabaseConnection();
		con = dbc.getCon();

		// 第二部：操作数据库
		/*
		 * String sql = "insert into dept(deptid,deptname) " + "values(" +
		 * vo.getDeptId() + ",'" + vo.getDeptName() + "')";
		 */

		String sql = "insert into dept(deptid,deptname) values(?,?)";
		ps = con.prepareStatement(sql); // 预编译对象

		// 设置sql的参数
		ps.setInt(1, vo.getDeptId());
		ps.setString(2, vo.getDeptName());

		ps.executeUpdate();

		// 第三部：关闭数据库

		dbc.close(con);
		dbc = null;
	}

	public void delete(int deptid) throws ClassNotFoundException, SQLException {
		// 第一步：打开数据库
		dbc = new DabaseConnection();
		con = dbc.getCon();
		// 第二部：操作数据库

		String sql = "delete from dept where deptid = ?";
		ps = con.prepareStatement(sql); // 预编译对象

		// 设置sql的参数
		ps.setInt(1, deptid);

		ps.executeUpdate();

		// 第三部：关闭数据库

		dbc.close(con);
		dbc = null;
	}

	public void update(DeptVO vo) {

	}

	/**
	 * 查询指定部门ID的信息
	 * 
	 * @param deptId
	 *            ：部门ID
	 * @return DeptVO
	 */

	public DeptVO findbyId(int deptId) {
		DeptVO dept = null;

		// 打开数据库
		dbc = new DabaseConnection();
		con = dbc.getCon();

		// 操作数据库
		String sql = "select * from dept d where d.deptid = ?";

		try {
			ps = con.prepareStatement(sql);

			// 设置参数
			ps.setInt(1, deptId);

			// 执行sql语句
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
		// 打开数据库
		dbc = new DabaseConnection();
		con = dbc.getCon();

		// 操作数据库
		String sql = "select * from dept d";

		try {
			ps = con.prepareStatement(sql);

			// 执行sql语句
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
