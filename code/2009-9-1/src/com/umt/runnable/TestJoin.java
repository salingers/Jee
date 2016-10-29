package com.umt.runnable;

public class TestJoin extends Thread{
	
	

	public void run() {
		for(int i = 0; i < 100; i++){
			System.out.println(this.getName() + "_____" + i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TestJoin tj1 = new TestJoin();
		tj1.setName("tj1");
		tj1.start();
		
		try {
			tj1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		TestJoin tj2 = new TestJoin();
		tj2.setName("tj2");
		tj2.start();
		

	}

}
