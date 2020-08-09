package com.shane.test;

public class TestThread2 {
public static void main(String[] args) {
	final TestThread2 thread2 = new TestThread2();
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			thread2.function();
		}
	}).start();
	
	try {
		Thread.sleep(200);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			thread2.function();
		}
	}).start();
}


public void function(){
	
	System.out.println("function" + Thread.currentThread().getId());
	synchronized (this) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for (int i = 0; i < 100000000; i++) {
//			i++;
//		}
//		for (int i = 0; i < 100000000; i++) {
//			i++;
//		}
	}
	System.out.println("exit function" + Thread.currentThread().getId());
}
}
