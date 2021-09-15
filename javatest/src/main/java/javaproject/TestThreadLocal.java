package javaproject;


public class TestThreadLocal {
public static void main(String[] args) {
	//可以看到new 一个threadlocal变量，可以在不同的线程set，互相不会影响。get也是取当前线程的那个变量。
	final ThreadLocal<String> tl1 =  new ThreadLocal<>();
	ThreadLocal<Integer>  tl2 = new ThreadLocal<>();
	tl1.set("aaa");
	tl1.set("bbb");
	//bbb会覆盖aaa
	tl2.set(1);
	new Thread( new Runnable() {
		@Override
		public void run() {
			tl1.set("CCC");
			System.out.println(tl1.get()+ "/" + tl1.hashCode());
		}
	}).start();
	
	System.out.println(tl1.get()+ "/" + tl1.hashCode());
	System.out.println(tl2.get() + "/" + tl2.hashCode());
	
}
}
