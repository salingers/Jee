package org.jsw.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jsw.base.HibernateSessionFactory;
import org.jsw.vo.Temp;

public class TempDao {

	/**
	 * @param args
	 */
	public void doInsert(Long inputid, String inputuname, String inputupwd) {
		
		Long id = inputid;
		String uname = inputuname;
		String upwd = inputupwd;

		Session ss = HibernateSessionFactory.getSession();
		
		Temp t1 = new Temp(id,uname,upwd);
		
		Transaction tst = ss.beginTransaction();
		
		ss.save(t1);
		
		tst.commit();
		
		ss.close();
		
	}
	
	
	public void doDelete(Long inputid) {
		
		Long id = inputid;

		Session ss = HibernateSessionFactory.getSession();
		
		Temp t1 = new Temp(id);
		
		Transaction tst = ss.beginTransaction();
		
		ss.delete(t1);
		
		tst.commit();
		
		ss.close();
		
	}

	
public void doFindAll() {

		String hql = "from Temp";
		Session ss = HibernateSessionFactory.getSession();
		
		Query query = ss.createQuery(hql);
		
		List<Temp> list = query.list();
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Temp temp = (Temp) iterator.next();
			System.out.println("ID: "+ temp.getId() + "uname:" + temp.getUname() + "upwd" + temp.getUpwd());
		}
	}
}
