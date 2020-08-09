package com.shane.test;

import java.util.ArrayList;


public class TestGeneric<U , G>{
	U firstU;
	G secondG;
	public TestGeneric(U first ,G second){
		firstU = first;
		secondG = second;
	}
	
	
	
	public U getFirst(){
		return firstU;
	}
	
	public G getSecond(){
		return secondG;
	}
	
	public static void main(String[] args) {
		TestGeneric<Integer, String> testGeneric = new TestGeneric<>(1,"ZHANGSAN");
		
		SonTestGeneric<Son,String,String> sonTestGeneric = new SonTestGeneric<>(new Son(1),"HSH","hhhss");
		
		System.out.println(((Son)sonTestGeneric.firstU).xueli);
	}
}

class SonTestGeneric<U extends Father,G ,V> extends TestGeneric<U,G> {
	V third;

	public SonTestGeneric(U first, Object second , V third) {
		super(first, (G) second);
		this.third = third;
	}
	
}


class GrandFather{
	public GrandFather(int huzi) {
		this.huzi = huzi;
	}

	int huzi;
}

class Father extends GrandFather{
	public Father(int age) {
		super(4);
		this.age = age;
	}

	int age ;
}

class Son extends Father{

	int xueli;
	public Son(int xueli) {
		super(3);
		this.xueli = xueli;
	}

}

class Sonson extends Son{
	int cute;
	public Sonson(int cute){
		super(2);
		this.cute = cute;
	}
}

