package javaproject;

public class Human {
	public String name;
	private int age;
	protected int haha;
	static {
		System.out.println("Human is load");
	}

	public static int static_value = 1;

	public static void staticMethod() {
		System.out.println("staticMethod is load");
	}

	public Human() {
		System.out.println("constructor 1 ");
	}
	
	public Human(String name, int age) {
		System.out.println("constructor 2");
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int FunctionA() {
		return age;
	}

	private int FunctionB() {
		return age;
	}

	protected int FunctionC() {
		return age;
	}

}
