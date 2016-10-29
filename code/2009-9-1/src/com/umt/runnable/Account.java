package com.umt.runnable;

public class Account implements Runnable {
	
	private static  double subMoney = 100;

	public synchronized void run() {
		for(int i = 0; i < 5; i++){
			this.subMoney -= 10;
			
			System.out.println(Thread.currentThread().getName() + "  取了10元，还剩 " + this.subMoney );
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public static void main(String args[]){
		Account a = new Account();
		Thread h = new Thread(a);
		h.setName("老公");
		h.start();
		
		Thread w = new Thread(a);
		w.setName("老婆");
		w.start();
		
	}

	
}
