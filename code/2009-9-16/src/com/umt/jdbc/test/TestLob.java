package com.umt.jdbc.test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.sql.BLOB;
import oracle.sql.CLOB;

import com.umt.jdbc.base.DabaseConnection;

public class TestLob {
	

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args){
		DabaseConnection dbc = new DabaseConnection();
		Connection con = dbc.getCon();
		
		//�������ݿ�
		
		PreparedStatement ps = null;
		try {
			
			con.setAutoCommit(false);
			
			//��һ������oracle���ݿ��в���һ���ն���
			
			String sql = "insert into testlob(id,image,content) values(?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 2);
			ps.setBlob(2, BLOB.getEmptyBLOB());
			ps.setClob(3, CLOB.getEmptyCLOB());
			
			ps.executeUpdate();
			
			//�ڶ�������ѯ�ն���
			String sql2 = "select image,content from testlob where id = ? for update";
			ps = con.prepareStatement(sql2);
			ps.setInt(1, 2);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			BLOB image = (BLOB) rs.getBlob("image");
			CLOB content = (CLOB) rs.getClob("content");
			
			//���������������ж�������
			InputStream ins = new FileInputStream("image.jpeg");
			OutputStream out = image.getBinaryOutputStream();
			
			byte b[] = new byte[1024];
			while((ins.read(b)) != -1){
				out.write(b);
			}
			out.flush();
			out.close();
			ins.close();
			
			
			Writer w = content.getCharacterOutputStream();
			w.write("Hello World!!");
			w.flush();
			w.close();
			
			
			//���Ĳ����������ݿ�
			String sql4 = "update testlob set image = ?,content = ? where id = ?";
			ps = con.prepareStatement(sql4);
			ps.setBlob(1, image);
			ps.setClob(2, content);
			ps.setInt(3, 2);
			
			ps.executeUpdate();
			
			con.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
