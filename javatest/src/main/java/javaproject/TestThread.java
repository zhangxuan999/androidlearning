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
//	                    //����t1�̣߳��ȴ�t1�߳�ִ����
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
//	                    //����t2�̣߳��ȴ�t2�߳�ִ����
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
            tmp.join();// ��ͣ�ؼ���߳��Ƿ�ִ����ɣ�ִ����ɲż�������
        }
        return System.currentTimeMillis() - startMillis;
    }
}
