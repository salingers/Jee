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
	 * 查询，对文件进行全查
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
	 * 查询文件中指定学号的学员的信息
	 * @param stuId：学号
	 */
	public void delete(int stuId){
		
		//第一步：先查询所有学员的信息
		List<Student> students = this.findAll();
		
		//第二步：查询指定id的对象
		for (Iterator iter = students.iterator(); iter.hasNext();) {
			Student stu = (Student) iter.next();
			
			if(stu.getStuId() == stuId){
				students.remove(stu);		//将目标对象从容器中删除，更新容器
				break;
			}			
		}
		
		//将容器中的数据重新写到文件中
		this.reWrite(students);
	}
	
	/**
	 * 将容器中的对象一次性写到文件中，并覆盖原来文件中的信息
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
