package javaproject;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
//生产者消费者模式
public class TestCustomer<T> {
	public static void main(String[] args) {
		final TestCustomer<String> testCustomer = new TestCustomer<>(10);
		//倒计时门栓
		final CountDownLatch countDownLatch = new CountDownLatch(50);
		for (int i = 0; i < 50; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					
					int j = new Random().nextInt(2);
					System.out.println(Thread.currentThread().getId() + "/j=" + j);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (j == 0) {
						testCustomer.produce("thing");
					} else if (j == 1) {
						testCustomer.buy();
					}

					countDownLatch.countDown();

				}
			}).start();
		}

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("mainthread exit");

	}

	int limit = 0;
	Queue<T> queue = null;

	public TestCustomer(int limit) {
		this.limit = limit;
		 queue = new ArrayDeque<>(limit);
	}

	public synchronized void produce(T t) {
		try {
			while (queue.size() == limit) {
				System.out.println(Thread.currentThread().getId() + " produce enter wait");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId() + " start produce ");
		queue.add(t);
		notifyAll();
	}

	public synchronized T buy() {

		try {
			while (queue.isEmpty()) {
				System.out.println(Thread.currentThread().getId() + " buy enter wait");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getId() + " start buy ");
		T t = queue.poll();
		notifyAll();
		return t;
	}
}
