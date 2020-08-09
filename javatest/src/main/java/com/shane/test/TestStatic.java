package com.shane.test;

import javaproject.Person;

public class TestStatic {
public static Person person;
public static Person getPerson() {
	return person;
}

public static void setPerson(Person p) {
	TestStatic.person = p;
}

public static void main(String[] args) {
	Person person1 = new Person(1);
	TestStatic.setPerson(person1);
	Person person2 = TestStatic.getPerson();
	System.out.println(person2 == person1);
	Person person3 = new Person(2);
	TestStatic.setPerson(person3);
	
	System.out.println(person3.age);
	System.out.println(person2.age);
	System.out.println(person3 == TestStatic.person);
	
}
}
