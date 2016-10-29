package com.umt.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.umt.dao.TestDAO;
import com.umt.vo.Test;

public class TestDAOImpl extends HibernateDaoSupport implements TestDAO {

	public void delete(Long id) {
		this.getHibernateTemplate().delete(
				getHibernateTemplate().get(Test.class, id)
			);
	}

	public List<Test> findAll() {
//		return this.getSession().createQuery("from Test")
//					.list();
		
		return this.getHibernateTemplate().find("from Test");
	}

	public Test findById(Long id) {
		return (Test) getSession().createQuery("from Test t where t.id = :id")
							.setLong("id", id)
							.uniqueResult();
	}

	public Test isLogin(String name, String pwd) {
		return (Test) getSession().createQuery("from Test t where t.name = :name and t.pwd = :pwd")
							.setString("name", name)
							.setString("pwd", pwd)
							.uniqueResult();
	}

	public void save(Test t) {
		this.getHibernateTemplate().save(t);
	}

	public void update(Test t) {
		this.getHibernateTemplate().update(t);
	}

}
