package com.umt.work;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * DAO:Data Access Object
 */

public class StudentDAO {
	
	private final String url = "student.txt";
	private Reader reader = null;
	private BufferedReader br = null;
	private Writer writer = null;
	private BufferedWriter bw = null;
	
	/**
	 * ��ѯ�����ļ�����ȫ��
	 * @return
	 */

	public List<Student> findAll(){
		List<Student> students = new ArrayList<Student>();
		
		
		try {
			reader = new FileReader(url);
			br = new BufferedReader(reader);
			
			
			String str = null;
			while((str = br.readLine()) != null){
//System.out.println(str);
				String[] stu = str.split("-");
				Student student = new Student(Integer.parseInt(stu[0]),stu[1],stu[2],Double.parseDouble(stu[3]));
				
				students.add(student);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(br != null){
					br.close();
					br = null;
				}
				
				if(reader != null){
					reader.close();
					reader = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return students;
	}
	
	/**
	 * ��ѯ�ļ���ָ��ѧ�ŵ�ѧԱ����Ϣ
	 * @param stuId��ѧ��
	 */
	public void delete(int stuId){
		
		//��һ�����Ȳ�ѯ����ѧԱ����Ϣ
		List<Student> students = this.findAll();
		
		//�ڶ�������ѯָ��id�Ķ���
		for (Iterator iter = students.iterator(); iter.hasNext();) {
			Student stu = (Student) iter.next();
			
			if(stu.getStuId() == stuId){
				students.remove(stu);		//��Ŀ������������ɾ������������
				break;
			}			
		}
		
		//�������е���������д���ļ���
		this.reWrite(students);
	}
	
	/**
	 * �������еĶ���һ����д���ļ��У�������ԭ���ļ��е���Ϣ
	 * @param stus
	 */
	private void reWrite(List<Student> stus){
		File file = new File(url);
		file.delete();
		
		
		try {
			writer = new FileWriter(file);
			bw = new BufferedWriter(writer);
			
			
			for(int i = 0; i < stus.size(); i++){
				Student stu = stus.get(i);
				
				//bw.write(stu.getStuId() + "-" + stu.getStuName() + "-" + stu.getSex() + "-" + stu.getMark());
				bw.write(stu.toString());
				bw.newLine();
			}
			
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(bw != null){
					bw.close();
					bw = null;
				}
				
				if(writer != null){
					writer.close();
					writer = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]){
		StudentDAO dao = new StudentDAO();
		
		
		dao.delete(1004);
		
		
		
		
		
		
		
		
		List<Student> stus = dao.findAll();
		for (Iterator iter = stus.iterator(); iter.hasNext();) {
			Student stu = (Student) iter.next();
			System.out.println(stu.getStuId() + " " + stu.getStuName());
			
		}
	}
}
