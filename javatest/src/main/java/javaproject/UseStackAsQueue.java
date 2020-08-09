package javaproject;

import java.util.Stack;
//两个栈实现一个队列 先进先出
public class UseStackAsQueue <T>{
	
	public static void main(String[] args) {
		UseStackAsQueue<Integer> useStackAsQueue = new UseStackAsQueue<>();
		useStackAsQueue.add(1);;
		useStackAsQueue.add(2);;
		useStackAsQueue.add(3);;
		useStackAsQueue.poll();
		 useStackAsQueue.poll();
		 useStackAsQueue.add(4);;
		 useStackAsQueue.poll();
		Integer i = useStackAsQueue.poll();
		System.out.println(i);
		
		
	}
	
	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2= new Stack<>();
	
	
	public void add(T t){
		
		stack1.push(t);
		
	}
	
	public T peek(){
		
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				T t = stack1.pop();
				stack2.push(t);
			}
		}
		
		if (stack2.isEmpty()) {
			return null;
		}else{
			return stack2.peek();
		}
		
	}
	
	//思路 1.判断stack2是否为空
	//2.如果为空，那么将栈1全部的出栈，每出一个，栈2就压入一个
	//3.这个时候stack2再pop一个元素出来
	
	public T poll(){
		if (stack2.isEmpty()) {
//			while (stack1.peek()!=null) {//因为栈为空的话，调用stack1.peek()会抛出异常，因此此处不能用stack1.peek()
			while (!stack1.isEmpty()) {
				T t = stack1.pop();
				stack2.push(t);
			}
		}
		
		if (stack2.isEmpty()) {
			return null;
		}else{
			return stack2.pop();
		}
		
		
	}

}
