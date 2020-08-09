package javaproject;

import java.util.Stack;
//����ջʵ��һ������ �Ƚ��ȳ�
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
	
	//˼· 1.�ж�stack2�Ƿ�Ϊ��
	//2.���Ϊ�գ���ô��ջ1ȫ���ĳ�ջ��ÿ��һ����ջ2��ѹ��һ��
	//3.���ʱ��stack2��popһ��Ԫ�س���
	
	public T poll(){
		if (stack2.isEmpty()) {
//			while (stack1.peek()!=null) {//��ΪջΪ�յĻ�������stack1.peek()���׳��쳣����˴˴�������stack1.peek()
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
