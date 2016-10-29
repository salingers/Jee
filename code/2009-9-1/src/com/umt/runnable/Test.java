package com.umt.runnable;

/**
 *此线程用来输出1——20
 * @author Administrator
 *
 */

class TestRunnable implements Runnable {

	public void run() {
		for(int i = 1; i <= 2000; i++){
			System.out.println(i);
		}
	}

}

public class Test{
	public static void main(String args[]){
		TestRunnable tr = new TestRunnable();
		//tr.run();		
		
		Thread t = new Thread(tr);
		t.start();
		
		for(int i = 10; i < 20000; i+= 10 ){
			System.out.println("main" + i);
		}
	}
}
