package com.umt.dao;

import java.util.List;

import com.umt.vo.Test;

public interface TestDAO {

	public Test isLogin(String name,String pwd);
	
	public void save(Test t);
	
	public void delete(Long id);
	
	public void update(Test t);
	
	public List<Test> findAll();
	
	public Test findById(Long id);
	
}
