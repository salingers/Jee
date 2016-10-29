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
		 * ���Ե�һ���򵥵�ȫ��Hql���
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
		 * ����Dept�����е�id���Խ��в�ѯ
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
		 * ����hql����ж�̬�󶨲���
		 * ע�⣺�������ͺ���ı�����֮�䲻���пո�
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
		 *hql����е�ģ����ѯ
		 * from Dept d where d.deptname like :deptname
		 
		Session session = HibernateSessionFactory.getSession();

		List<Dept> depts = session.createQuery("from Dept d where d.deptname like :deptname")
								.setString("deptname", "%��%")
								.list();

		for (Dept dept : depts) {
			System.out.println(dept.getId() + " " + dept.getDeptname());
		}

		HibernateSessionFactory.closeSession();
		*/
		
		/*
		 * hql����У��ж����ѯ�����Ľ���취
		 * from Dept d where d.deptname like :deptname and d.other like :other
		 
		
		Session session = HibernateSessionFactory.getSession();

		List<Dept> depts = session.createQuery("from Dept d where d.deptname like :deptname and d.other like :other order by d.id")
								.setString("deptname", "%��%")
								.setString("other", "%Ǯ%")
								.list();

		for (Dept dept : depts) {
			System.out.println(dept.getId() + " " + dept.getDeptname());
		}

		HibernateSessionFactory.closeSession();
		
		*/
		
		/*
		 * ��hql����У�ֻ��ѯdeptname��ֵ
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
		 * ���в�ѯ
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
		 * ��hql����У�����ѯ�Ķ������ֵ��װ��һ��������
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
		 * ��hql�����ʹ���麯��
		 * select count(*) from Dept d where d.deptname = '������'
		 
		Session session = HibernateSessionFactory.getSession();
		
		List<Integer> nums = session.createQuery("select count(*) from Dept d where d.deptname = '������'")
							.list();
		
		for (Iterator iterator = nums.iterator(); iterator.hasNext();) {
			Integer object2 = (Integer) iterator.next();
			System.out.println("Num :" + object2);
			
		}
		HibernateSessionFactory.closeSession();
		*/
		
		/*
		 * uniqueResult():
		 * ���ز�ѯ�����һ������
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
