package com.umt.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.umt.sessionfactory.HibernateSessionFactory;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//�����ݿ��в���һ����¼
		
		Session session = HibernateSessionFactory.getSession();
		
		com.umt.vo.Test test = new com.umt.vo.Test(2L,"aaa","123");
		
		Transaction tst = session.beginTransaction();	//������
		
		session.save(test);
		
		
		tst.commit();		//�ύ����
		
		session.close();
		

		
		
		//�޸����ݿ��е�һ����¼
		/*Session session = HibernateSessionFactory.getSession();
		
		com.umt.vo.Test test = new com.umt.vo.Test(1L,"admin","456");
		
		Transaction tst = session.beginTransaction();	//������
		
		session.update(test);
		
		tst.commit();		//�ύ����
		
		session.close();
		*/
		
		
		
		
		//ɾ�����ݿ��е�һ����¼

		/*Session session = HibernateSessionFactory.getSession();
		
		com.umt.vo.Test test = new com.umt.vo.Test(1L,"yexu","123");
		
		Transaction tst = session.beginTransaction();	//������
		
		session.delete(test);
		
		tst.commit();		//�ύ����
		
		session.close();*/
		
		
		
		
		
		//��ѯ���ݿ��е�һ����¼
		
		/*Session session = HibernateSessionFactory.getSession();
		com.umt.vo.Test test = (com.umt.vo.Test) session.get(com.umt.vo.Test.class, 1L);
		System.out.println(test.getId() + " " +  test.getName() + " " + test.getPwd());
		session.close();*/
		
		
		
		
		
		/* ȫ��
		 * hql:
		 */
		/* String hql = "from com.umt.vo.Test";
		Session session = HibernateSessionFactory.getSession();
		
		Query query = session.createQuery(hql);
		
		List<com.umt.vo.Test> listTest = query.list();
		
		for (Iterator iterator = listTest.iterator(); iterator.hasNext();) {
			com.umt.vo.Test test = (com.umt.vo.Test) iterator.next();
			System.out.println(test.getId() + " " +  test.getName() + " " + test.getPwd());
			
		}
		
		HibernateSessionFactory.closeSession();   */
	}

}
