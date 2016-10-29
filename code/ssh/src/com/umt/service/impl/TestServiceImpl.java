package com.umt.service.impl;

import java.util.List;

import com.umt.dao.TestDAO;
import com.umt.service.TestService;
import com.umt.vo.Test;

public class TestServiceImpl implements TestService {
	
	private TestDAO tDAO;
	
	

	public void setTDAO(TestDAO tdao) {
		tDAO = tdao;
	}

	public void delete(Long id) {
		tDAO.delete(id);
	}

	public List<Test> findAll() {
		return tDAO.findAll();
	}

	public Test findById(Long id) {
		return tDAO.findById(id);
	}

	public Test isLogin(String name, String pwd) {
		return tDAO.isLogin(name, pwd);
	}

	public void save(Test t) {
		tDAO.save(t);
	}

	public void update(Test t) {
		tDAO.update(t);
	}

}
