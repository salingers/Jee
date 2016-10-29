package com.umt.runnable;

public class Account implements Runnable {
	
	private static  double subMoney = 100;

	public synchronized void run() {
		for(int i = 0; i < 5; i++){
			this.subMoney -= 10;
			
			System.out.println(Thread.currentThread().getName() + "  ȡ��10Ԫ����ʣ " + this.subMoney );
			
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
		h.setName("�Ϲ�");
		h.start();
		
		Thread w = new Thread(a);
		w.setName("����");
		w.start();
		
	}

	
}
