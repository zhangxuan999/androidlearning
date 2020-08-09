package javaproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class TestCommon implements Cloneable {
	
	private int age;
	private String name;
	private  Person person;
	
	public TestCommon(int age, String name) {
		this.age = age;
		this.name = name;
		this.person = new Person(3);
	}
	
	@Override
	protected TestCommon clone() throws CloneNotSupportedException {
		//
		 TestCommon common = (TestCommon) super.clone();
		 common.person = (Person)this.person.clone();
		 return common;
		//浅拷贝
		//return (TestCommon)super.clone();
	}

	public static void main(String[] args) {
		
		TestCommon common = new TestCommon(1, "zhangsan");
		try {
			TestCommon copy = (TestCommon) common.clone();
			common.person.age = 33;
			System.out.println(copy.name + ", " + copy.age + " ," + copy.person.age);
			System.out.println(copy == common);
			System.out.println(copy.person == common.person);
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		
		System.out.println("isHuiwen");
		String aString = "abcdeffedcba";
		System.out.println(isHuiwen(aString));
		System.out.println("ishappynumber");
		System.out.println(isHappyNumber(4));
		System.out.println("IntToString");
		System.out.println(IntToString(0));
	}

	// 判断某个字符串是否是回文字符串，n/次
	private static boolean isHuiwen(String string) {
		char[] a = string.toCharArray();
		for (int i = 0; i < a.length / 2; i++) {
			if (a[i] != a[a.length - 1 - i]) {
				return false;
			}

		}
		return true;
	}

	// 判断是否是快乐数字
	// 2 8 → 2?+8?=68 → 6?+8?=100 → 1?+0?+0?=1
	public static boolean isHappyNumber(int num) {
		if (num < 0) {
			return false;
		}

		ArrayList<Integer> aList = new ArrayList<>();
		while (num >= 10) {
			int temp = num % 10;
			num = num / 10;
			aList.add(temp);
		}
		aList.add(num);

		int sum = 0;
		Iterator<Integer> iterator = aList.iterator();
		while (iterator.hasNext()) {
			int value = iterator.next();
			sum = value * value + sum;
		}
		System.out.println("sum = " + sum);
		if (sum == 1) {
			return true;
		} else if (sum == 4) {// 等于4是不是快乐数字的判断条件
			return false;
		} else {
			return isHappyNumber(sum);
		}
	}

	// int to string
	private static String IntToString(int i) {
		StringBuilder sbBuilder = new StringBuilder();
		Stack<String> stack = new Stack<>();
		if (i < 0) {
			i = -i;
			sbBuilder.append("-");
		}

		while (i >= 10) {
			int yushu = i % 10;
			stack.push(String.valueOf(yushu));
			i = i / 10;
		}
		stack.push(String.valueOf(i));

		while (!stack.isEmpty()) {
			sbBuilder.append(stack.pop());
		}
		return sbBuilder.toString();
	}
}
