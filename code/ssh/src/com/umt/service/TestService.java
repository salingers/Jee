package com.umt.service;

import java.util.List;

import com.umt.vo.Test;

public interface TestService {

	public Test isLogin(String name, String pwd);

	public void save(Test t);

	public void delete(Long id);

	public void update(Test t);

	public List<Test> findAll();

	public Test findById(Long id);
}
