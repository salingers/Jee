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
		 * get()����  & load()����
		 
		 
		Session session = HibernateSessionFactory.getSession();
		//Dept dept = (Dept) session.get(Dept.class, 4L);
		Dept dept = (Dept) session.load(Dept.class, 1L);
		//System.out.println(dept.getDeptname());
		
//		System.out.println(dept.getId());		//��ʱ��ִ��sql���
		System.out.println(dept.getDeptname());	//��ʱִ��sql���
		
		session.close();
		
		*/
		
		
		/*
		 * �־û�����
		 * 
		 * 1.�����ݿ��д���
		 * 2.��ͬһSession��Χ��
		 * 
		 * �ص㣺
		 * 	�־û����������ݿ��еļ�¼����ͬ����
		 * �ȸ��³־û�����ʱ�����Ե���update(),Ҳ���Ե���save()������Ҳ���Բ������κη�����
		 */
		Session session = HibernateSessionFactory.getSession();
		
		Dept dept = (Dept) session.get(Dept.class, 1L);
		
		
		dept.setOther("rrrrrrrrrr��");
		
		//session.update(dept);
		session.save(dept);
		
		session.beginTransaction().commit();
		session.close();
		
		/*
		 * �������
		 * 
		 * 1.�����ݿ��д���
		 * 2.�ڲ�ͬ��session��
		 * 
		 * �ص㣺
		 * 	��������ڸ���ʱ��ֻ�ܵ���update()����
		
		Session session1  = HibernateSessionFactory.getSession();
		
			System.out.println(dept.getDeptname());
			
			dept.setOther("dfdfdfd");
			
			session1.update(dept);
			//session1.save(dept);
			
			session1.beginTransaction().commit();
		session1.close();
		 */
		
		
		
		/*
		 * ��ʱ����
		 *	�����ݿ��в����ڣ�һ����ͨ��new�ؼ��ִ����Ķ���
		 *
		 *	ֻ�ܵ���save()����
		 
		
		Session session2 = HibernateSessionFactory.getSession();
		Dept dept2 = new Dept("���Բ�","��������");
		
		session2.save(dept2);	//�룬����
		
		session2.beginTransaction().commit();
		session2.close();
		*/
		
		/*
		 * saveOrUpdate()
		 */
		/*
		 * �����������
		
		Session session3 = HibernateSessionFactory.getSession();
		
		dept.setDeptname("Ӫ����");
		
		session3.saveOrUpdate(dept);
		
		session3.beginTransaction().commit();
		session3.close();
		
		 */
		
		
		/*
		 * ������ʱ����
		 
		Session session4 = HibernateSessionFactory.getSession();
		
		Dept dept3 = new Dept("���ڲ�","��ˮ����");
		
		session4.saveOrUpdate(dept3);
		
		session4.beginTransaction().commit();
		session4.close();
		
		*/
		
		Session session4 = HibernateSessionFactory.getSession();
		
		Dept dept3 = new Dept("���ز�","��Ц");
		dept3.setId(6L);
		session4.saveOrUpdate(dept3);
		
		session4.beginTransaction().commit();
		session4.close();
	}

}
