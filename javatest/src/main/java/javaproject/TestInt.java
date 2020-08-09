package javaproject;

import java.util.ArrayList;

public class TestInt {
	public static void main(String[] args){
		
		
		
		int i = 152525;
		System.out.println(String.valueOf(i));
		System.out.println(Integer.toString(i));
		
		
		String string = "+6363666";
		int j = Integer.valueOf(string);
		
		System.out.println("j=" + j);
		
		int k = Integer.parseInt(string);
		System.out.println("k=" + k);
		
		
		String s= "abc";
		
		byte[] b = s.getBytes();
		
		for (int e = 0;e <b.length;e++){
			System.out.println(b[e]);
		}
		
		double aa = 5.0;
		double bb = 1/4 + aa + 2/4.0;
		System.out.println(bb);
		
		
		test();
		
	}
	
	public static void test() {
		Integer integera = 321;
		Integer integerb = 321;
		Integer integerc = new Integer(321);
		System.out.println(integera == integerb);
		System.out.println(integera == integerc);
		System.out.println(integera.equals(integerc));
		
		
		System.out.println(integera == 321);
		
		
		
	}
	
	
//	public void getArrayList(ArrayList<String> al){
//		
//	}
//	
//	public int getArrayList(ArrayList<Integer> al){
//		return 1;
//	}
}
