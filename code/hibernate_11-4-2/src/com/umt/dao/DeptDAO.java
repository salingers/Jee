package com.umt.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.umt.sessionfactory.HibernateSessionFactory;
import com.umt.vo.Dept;

public class DeptDAO {

	public static void main(String args[]){
		Session session = HibernateSessionFactory.getSession();
		
		Transaction tst = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setId(6L);
		
		session.delete(dept);
		
		
		
		tst.commit();
		
		session.close();
		
		/*
		 * from Dept d left join fetch d.emps where d.id = :id
		 */
		
		/*
		 * emp dept
		 */
		/*
		 * select * from Emp e left join  Dept d on e.dept.id = d.id
		 * 
		 * select * from Emp e,Dept d where e.dept.id = d.id
		 */
		
		
		
	}
}
