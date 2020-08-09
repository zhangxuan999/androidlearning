package javaproject;

import javax.xml.stream.events.StartDocument;

public class TestThreadLocal {
public static void main(String[] args) {
	final ThreadLocal<String> tl1 =  new ThreadLocal<>();
	ThreadLocal<Integer>  tl2 = new ThreadLocal<>();
	tl1.set("aaa");
	tl1.set("bbb");
	tl2.set(1);
	new Thread( new Runnable() {
		public void run() {
			tl1.set("CCC");
			System.out.println(tl1.get()+ "/" + tl1.hashCode());
		}
	}).start();
	
	System.out.println(tl1.get()+ "/" + tl1.hashCode());
	System.out.println(tl2.get() + "/" + tl2.hashCode());
	
}
}
