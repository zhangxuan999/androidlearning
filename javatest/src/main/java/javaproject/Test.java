package javaproject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
	public static void main(String[] args) {
		System.out.println("hello");

		
		
		Ani cat = new Cat();
		cat.shout();
		String str = "严";
		try {
			byte[] jiema = str.getBytes("GB2312");
			String bianma = new String(jiema,"GB2312");
			System.out.println(jiema.length);
			System.out.println(bianma);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*
		String[] charsetNames = { "UTF-8", "UTF-16", "UTF-16BE", "UTF-16LE",
				"UTF-32", "UTF-32BE", "UTF-32LE", "UNICODE", "GBK", "GB2312",
				"GB18030", "ISO8859-1", "BIG5", "ASCII" };
		*/
		String[] charsetNames = { "UTF-8","UNICODE", "GBK", "GB2312",
				"GB18030", "ISO8859-1",  "ASCII" };

		for (int i = 0; i < charsetNames.length; i++) {
			printByteLength(charsetNames[i]);
		}
		
		//Human a =  new Human();
		//Human b =  new Human("allen" , 18);
/*  Class clase = Human.class;
  clase.getFields();
  System.out.println(clase.getName());*/
  

		System.out.println("byte所占的字节数为：" + Byte.SIZE/8);		
		System.out.println("char所占的字节数为：" + Character.SIZE/8);
		
		
	}
	
	
	
	

	public static void printByteLength(String charsetName) {
		String en = "a"; // 一个英文字符
		String zh = "啊"; // 一个中文字符
		try {
			System.out.println(charsetName + "编码英文字符所占字节数:"
					+ en.getBytes(charsetName).length);
			System.out.println(charsetName + "编码中文字符所占字节数:"
					+ zh.getBytes(charsetName).length);
			System.out.println();
		} catch (UnsupportedEncodingException e) {
			System.out.println("非法编码格式！");
		}
	}

}




