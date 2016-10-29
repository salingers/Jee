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
		 * 测试第一个简单的全查Hql语句
		 * from com.umt.vo.Dept
		 * 
		 * 
		 * Session session = HibernateSessionFactory.getSession();
		 * 
		 * List<Dept> depts = session.createQuery("from Dept") .list();
		 * 
		 * for (Dept dept : depts) { System.out.println(dept.getId() + " " +
		 * dept.getDeptname()); }
		 * 
		 * HibernateSessionFactory.closeSession();
		 * 
		 */

		/*
		 * 根据Dept对象中的id属性进行查询
		 * from Dept where id = ? 
		 * from Dept d where d.id = ?
		 
		Session session = HibernateSessionFactory.getSession();

		List<Dept> depts = session.createQuery("from Dept d where d.id = ?")
								.setLong(0, 1L)
								.list();

		for (Dept dept : depts) {
			System.out.println(dept.getId() + " " + dept.getDeptname());
		}

		HibernateSessionFactory.closeSession();
		
		*/
		
		/*
		 * 测试hql语句中动态绑定参数
		 * 注意：“：”和后面的变量名之间不能有空格
		 * from Dept where id = :id
		 * 		
		 
		
		Session session = HibernateSessionFactory.getSession();

		List<Dept> depts = session.createQuery("from Dept d where d.id = :myid")
								.setLong("myid", 1L)
								.list();

		for (Dept dept : depts) {
			System.out.println(dept.getId() + " " + dept.getDeptname());
		}

		HibernateSessionFactory.closeSession();
		
		*/
		
		/*
		 *hql语句中的模糊查询
		 * from Dept d where d.deptname like :deptname
		 
		Session session = HibernateSessionFactory.getSession();

		List<Dept> depts = session.createQuery("from Dept d where d.deptname like :deptname")
								.setString("deptname", "%财%")
								.list();

		for (Dept dept : depts) {
			System.out.println(dept.getId() + " " + dept.getDeptname());
		}

		HibernateSessionFactory.closeSession();
		*/
		
		/*
		 * hql语句中，有多个查询条件的解决办法
		 * from Dept d where d.deptname like :deptname and d.other like :other
		 
		
		Session session = HibernateSessionFactory.getSession();

		List<Dept> depts = session.createQuery("from Dept d where d.deptname like :deptname and d.other like :other order by d.id")
								.setString("deptname", "%财%")
								.setString("other", "%钱%")
								.list();

		for (Dept dept : depts) {
			System.out.println(dept.getId() + " " + dept.getDeptname());
		}

		HibernateSessionFactory.closeSession();
		
		*/
		
		/*
		 * 在hql语句中，只查询deptname的值
		 * select d.deptname
		 * from Dept d
		
		Session session = HibernateSessionFactory.getSession();
		List<String> deptnames = session.createQuery("select  new java.lang.String(d.deptname) from Dept d")
							.list();
		for (String object : deptnames) {
			System.out.println(object);
		}
		HibernateSessionFactory.closeSession();
		 */
		
		
		/*
		 * 多列查询
		 * select d.id,d.deptname
		 * from Dept d
		
		
		Session session = HibernateSessionFactory.getSession();
		List<Object[]> depts = session.createQuery("select  d.id,d.deptname from Dept d")
							.list();
		for (Iterator iterator = depts.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			
			System.out.println("id = " + object[0]);
			System.out.println("deptname = " + object[1]);
			
		}
		
		HibernateSessionFactory.closeSession();
		 */
		
		/*
		 * 在hql语句中，将查询的多个属性值封装到一个对象中
		 * 
		
		Session session = HibernateSessionFactory.getSession();
		List<Dept> depts = session.createQuery("select  new com.umt.vo.Dept(d.id,d.deptname) from Dept d")
							.list();
		for (Iterator iterator = depts.iterator(); iterator.hasNext();) {
			Dept object = (Dept) iterator.next();
			System.out.println(object.getId() + " " + object.getDeptname());
		}
		
		HibernateSessionFactory.closeSession();
		 */
		
		
		/*
		 * 在hql语句中使用组函数
		 * select count(*) from Dept d where d.deptname = '开发部'
		 
		Session session = HibernateSessionFactory.getSession();
		
		List<Integer> nums = session.createQuery("select count(*) from Dept d where d.deptname = '开发部'")
							.list();
		
		for (Iterator iterator = nums.iterator(); iterator.hasNext();) {
			Integer object2 = (Integer) iterator.next();
			System.out.println("Num :" + object2);
			
		}
		HibernateSessionFactory.closeSession();
		*/
		
		/*
		 * uniqueResult():
		 * 返回查询结果的一个对象
		 * from Dept d where d.id = :id
		 */
		Session session = HibernateSessionFactory.getSession();
		Dept dept = (Dept) session.createQuery("from Dept d where d.id = :id")
							.setLong("id", 1L)
							.uniqueResult();
		System.out.println(dept.getDeptname());
		
		HibernateSessionFactory.closeSession();
	}

}
