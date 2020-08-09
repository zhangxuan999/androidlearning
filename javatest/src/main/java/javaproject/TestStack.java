	package javaproject;

import java.util.ArrayList;

//用数组实现栈
public class TestStack<T> {
	
private T[] array ;
private int size = 0;

private static final int DEAFAUT_SIZE = 2;
public static void main(String[] args) {
	TestStack<String> stack= new TestStack<>();
	stack.push("1");
	stack.push("2");
	stack.push("3");
	stack.push("4");
	stack.push("5");
	System.out.println(stack.size);
	System.out.println(stack.peek());
	System.out.println(stack.pop());
	System.out.println(stack.size);
}

public TestStack(){
	array = (T[])new Object[DEAFAUT_SIZE];
}

public boolean isEmpty() {
    return size==0?false:true;
}
private void push(T o){
	if (size < array.length) {
		array[size] = o;
		size ++;
	}else{
		doubleCapapity();
		array[size] = o;
		size ++;
	}
	
}

private void doubleCapapity() {
	// TODO Auto-generated method stub
	T[] newArray = (T[])new Object[array.length*2];
	for (int i = 0; i < array.length; i++) {
		newArray[i] = array[i];
	}
	 
	array = newArray;
	
}

private T pop(){
	if (size>0) {
		T object = array[size-1];
		array[size-1] = null;
		size --;
		return object;
	}
	else {
		System.out.print("emptystack");
		return null;
	}
}




private T peek(){
	if (size>0) {
		T object = array[size-1];
		return object;
	}
	else {
		System.out.print("emptystack");
		return null;
	}
}
}
