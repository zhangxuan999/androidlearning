package javaproject;

public class TestThread {
	private long millisUnit = 1000;
    private int count = 2;
    static int a = 0;

	public static void main(String[] args)  {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 30000; i++) {
					a++;
				}
				System.out.println("jjj");
				
			}
		});	
		thread1.start();
		Thread  thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 20000; i++) {
					a++;
				}
				System.out.println("hhh");
			}
		});
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(a);
		
		
//		 final Thread t1 = new Thread(new Runnable() {
//			 
//	            @Override
//	            public void run() {
//	            	try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//	                System.out.println("t1");
//	            }
//	        });
//	        final Thread t2 = new Thread(new Runnable() {
//	 
//	            @Override
//	            public void run() {
//	                try {
//	                    //引用t1线程，等待t1线程执行完
//	                    t1.join();
//	                    Thread.sleep(1000);
//	                } catch (InterruptedException e) {
//	                    e.printStackTrace();
//	                }
//	                System.out.println("t2");
//	            }
//	        });
//	        Thread t3 = new Thread(new Runnable() {
//	 
//	            @Override
//	            public void run() {
//	                try {
//	                    //引用t2线程，等待t2线程执行完
//	                    t2.join();
//	                    Thread.sleep(1000);
//	                } catch (InterruptedException e) {
//	                    e.printStackTrace();
//	                }
//	                System.out.println("t3");
//	            }
//	        });
//	        t3.start();
//	        t2.start();
//	        t1.start();

	}
    public  long preserveOrderViaJoin() throws InterruptedException {
        long startMillis = System.currentTimeMillis();
        Thread tmp;
        for (int i = 0; i < count; i++) {
            tmp = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(millisUnit);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "join-" + i);
            tmp.start();
            tmp.join();// 不停地检测线程是否执行完成，执行完成才继续往下
        }
        return System.currentTimeMillis() - startMillis;
    }
}
