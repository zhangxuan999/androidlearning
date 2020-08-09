package javaproject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RacerWithCountDownLatch {
 static class Racer extends Thread{
	 private CountDownLatch cdl;
	 public Racer(CountDownLatch cdl){
		 this.cdl = cdl;
		 
	 }
	 @Override
	 public void run() {
		 try {
			//cdl.await(1000,TimeUnit.MILLISECONDS);
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("Start run " + Thread.currentThread().getId()+ "time = " + System.currentTimeMillis());
	}
 }
 
 public static void main(String[] args) {
	CountDownLatch cdl = new CountDownLatch(1);
	System.out.println(  Thread.currentThread() + "time = " + System.currentTimeMillis());
	for (int i = 0; i < 10; i++) {
		Racer racer = new Racer(cdl);
		racer.start();
	}
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	cdl.countDown();
}
}
