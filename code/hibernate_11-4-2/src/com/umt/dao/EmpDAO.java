package com.umt.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.umt.sessionfactory.HibernateSessionFactory;
import com.umt.vo.Dept;
import com.umt.vo.Emp;

public class EmpDAO {
	
	public void save(Emp emp){
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tst = session.beginTransaction();
		
		session.save(emp);
		
		tst.commit();
		HibernateSessionFactory.closeSession();
	}
	
	public void findAll(){
		
		Session session = HibernateSessionFactory.getSession();
		
		/*
		 * select *
		 * from emp e,dept d,salary s
		 * where e.deptid = d.id and e.sid = s.id
		 * 
		 * select *
		 * from emp e
		 * left join dept d on e.deptid = d.id 
		 */
		
		/*
		 * join fetch:即时抓取，不受延迟加载机制的影响
		 */
		
		List<Emp> emps = session.createQuery("from Emp e left join fetch e.dept")
							.list();
		
		
		HibernateSessionFactory.closeSession();
		

		for (Iterator iterator = emps.iterator(); iterator.hasNext();) {
			Emp emp = (Emp) iterator.next();
			System.err.println("输出部门信息之前");
			System.out.println(emp.getDept().getDeptname());
			System.out.println("输出部门信息之后");
			
		}
	}

	
	public static void main(String args[]){
		/*Session session = HibernateSessionFactory.getSession();
		
		Emp emp = (Emp) session.get(Emp.class, 1L);
		
		System.out.println("调用Dept对象之前.....");
		
		
		System.out.println(emp.getDept().getDeptname());
		
		System.out.println("调用Dept对象之后.....");
		
		Dept dept = new Dept();
		dept.setId(6L);
		
		Emp emp2 = new Emp(dept,"小小");
		session.save(emp2);
		
		session.close();
		
		*/
		
		EmpDAO dao = new EmpDAO();
		dao.findAll();
	}
}
