package javaproject;

public class Person implements Cloneable {

	public int age;

	public Person(int a) {
		age = a;
	}
	
	@Override
	protected Person clone() throws CloneNotSupportedException {
		return (Person) super.clone();
	}

}
