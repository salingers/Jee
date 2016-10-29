package com.umt.runnable;

public class TestThread extends Thread{
	
	public void run() {
		for(int i = 0; i < 10; i++){
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestThread tt = new TestThread();
		tt.start();
		
		for(int i = 10; i < 100; i += 10){
			System.out.println("main" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
