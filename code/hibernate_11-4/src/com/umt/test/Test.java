package com.umt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.umt.sessionfactory.HibernateSessionFactory;
import com.umt.vo.Dept;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		/*
		 * get()方法  & load()方法
		 
		 
		Session session = HibernateSessionFactory.getSession();
		//Dept dept = (Dept) session.get(Dept.class, 4L);
		Dept dept = (Dept) session.load(Dept.class, 1L);
		//System.out.println(dept.getDeptname());
		
//		System.out.println(dept.getId());		//此时不执行sql语句
		System.out.println(dept.getDeptname());	//此时执行sql语句
		
		session.close();
		
		*/
		
		
		/*
		 * 持久化对象
		 * 
		 * 1.在数据库中存在
		 * 2.在同一Session范围内
		 * 
		 * 特点：
		 * 	持久化对象会和数据库中的记录保持同步。
		 * 等更新持久化对象时，可以调用update(),也可以调用save()方法，也可以不调用任何方法。
		 */
		Session session = HibernateSessionFactory.getSession();
		
		Dept dept = (Dept) session.get(Dept.class, 1L);
		
		
		dept.setOther("rrrrrrrrrr！");
		
		//session.update(dept);
		session.save(dept);
		
		session.beginTransaction().commit();
		session.close();
		
		/*
		 * 游离对象
		 * 
		 * 1.在数据库中存在
		 * 2.在不同的session中
		 * 
		 * 特点：
		 * 	游离对象在更新时，只能调用update()方法
		
		Session session1  = HibernateSessionFactory.getSession();
		
			System.out.println(dept.getDeptname());
			
			dept.setOther("dfdfdfd");
			
			session1.update(dept);
			//session1.save(dept);
			
			session1.beginTransaction().commit();
		session1.close();
		 */
		
		
		
		/*
		 * 临时对象
		 *	在数据库中不存在，一般是通过new关键字创建的对象
		 *
		 *	只能调用save()方法
		 
		
		Session session2 = HibernateSessionFactory.getSession();
		Dept dept2 = new Dept("测试部","测试着玩");
		
		session2.save(dept2);	//码，主键
		
		session2.beginTransaction().commit();
		session2.close();
		*/
		
		/*
		 * saveOrUpdate()
		 */
		/*
		 * 测试游离对象
		
		Session session3 = HibernateSessionFactory.getSession();
		
		dept.setDeptname("营销部");
		
		session3.saveOrUpdate(dept);
		
		session3.beginTransaction().commit();
		session3.close();
		
		 */
		
		
		/*
		 * 测试临时对象
		 
		Session session4 = HibernateSessionFactory.getSession();
		
		Dept dept3 = new Dept("后勤部","烧水做饭");
		
		session4.saveOrUpdate(dept3);
		
		session4.beginTransaction().commit();
		session4.close();
		
		*/
		
		Session session4 = HibernateSessionFactory.getSession();
		
		Dept dept3 = new Dept("公关部","赔笑");
		dept3.setId(6L);
		session4.saveOrUpdate(dept3);
		
		session4.beginTransaction().commit();
		session4.close();
	}

}
