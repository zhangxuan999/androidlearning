package javaproject;

//数组实现队列
public class TestQueue<T> {
	
private T[] array;
public static final int DEAFAULT_SIZE = 2;
public int size = 0;
public int first = -1;
public int last = -1;
public static void main(String[] args) {
	TestQueue<String> queue = new TestQueue<>();
/*	queue.add("aaa");
	queue.add("bbb");
	queue.add("ccc");
	queue.add("ddd");
	System.out.println(queue.poll());
	System.out.println(queue.poll());
	queue.add("eee");
	queue.add("fff");
	System.out.println(queue.poll());
	System.out.println(queue.poll());

	System.out.println(queue.size);*/
	
	
	queue.add("aaa");
	queue.add("bbb");
	queue.add("ccc");
	queue.add("ddd");
	System.out.println(queue.poll());
	System.out.println(queue.poll());
	queue.add("eee");
	queue.add("fff");
	queue.add("ggg");
	System.out.println(queue.first + "/" + queue.last +  "/"+ queue.size );
	
	
}
public TestQueue(){
	array = (T[])new Object[DEAFAULT_SIZE];
}

private void add(T o){
	if (size < array.length) {
		array[(last+1)%array.length] = o;
		last = (last+1)%array.length;
		size ++;
		if(size==1){
			first = 0;
		}
	}else{
		doubleCapality();
		array[(last+1)%array.length] = o;
		last = (last+1)%array.length;
		size ++;
	}
	
}

private void doubleCapality() {
	// TODO Auto-generated method stub
	T[] newArrayTs = (T[])new Object[array.length *2];
	for (int i = 0; i < array.length; i++) {
		newArrayTs[i] = array[(first+i)%array.length];
	}
	first = 0;
	last = array.length -1;
	array = newArrayTs;
}

private T peek(){
	if (size>0) {
		T object = array[first];
		return object;
	}
	else {
		System.out.print("emptyqueue");
		return null;
	}
}

private T poll(){
	if (size>0) {
		T object = array[first];
		array[first] = null;
		first = (first+1)%array.length;
		size --;
		if(size == 0 ){
			first = -1;
			last = -1;
		}
		return object;
	}
	else {
		System.out.print("emptyqueue");
		return null;
	}
}
}
