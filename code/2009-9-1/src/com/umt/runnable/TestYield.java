package com.umt.runnable;

public class TestYield extends Thread{
	
	

	public void run() {
		for(int i = 0; i < 100; i++){
			if(i % 10 == 0){
				this.yield();
			}
			System.out.println(this.getName() + " " + i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestYield ty = new TestYield();
		ty.setName("ty1");
		ty.start();
		
		
		TestYield ty2 = new TestYield();
		ty2.setName("ty2");
		ty2.start();
		
//		for(int i = 0; i < 1000; i++){
//			System.out.println("Main" + i);
//		}
		
	}

}
