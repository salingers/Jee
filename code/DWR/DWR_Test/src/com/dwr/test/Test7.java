package com.dwr.test;

public class Test7 {

	public boolean hasPermission(String name,int permission){
		boolean flag = false;
		
		if(name.equals("admin") && permission == 1){
			flag = true;
		}
		
		return flag;
	}
}
