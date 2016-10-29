package com.dwr.test;

import java.util.ArrayList;
import java.util.List;

public class Test10 {
	
	public String method1(){
		return "method1";		
	}
	
	public List method2(){
		List list = new ArrayList();
		list.add(new Student(1,"aaa",22));
		list.add(new Student(2,"bbb",23));
		
		//Student stu = new Student(1,"aaa",22);
		//list.add(stu.getName());
		//list.add("world");
		
		
		return list;
	}
}
