package javaproject;

import java.util.ArrayList;
import java.util.Iterator;

import org.omg.CORBA.PUBLIC_MEMBER;

public class TestArrayList {
public static void main(String[] args) {
	ArrayList<Integer>  alArrayList = new ArrayList<>();
	alArrayList.add(2);
	alArrayList.add(5);
	alArrayList.add(6);
	alArrayList.add(8);
	alArrayList.add(4);
	alArrayList.add(9);
	alArrayList.add(11);
	alArrayList.add(18);
	//delete(alArrayList);
	
	int a [] = {1,2,3,4,5};
	int i = 0;
	System.out.println(a[i = 3 -2] + "i = " + i);
	
}
//千万不能这样删，要通过arraylist的iterator来删除
public static void delete(ArrayList<Integer> al){
//	for (int i = 0; i < al.size(); i++) {
//		if (al.get(i)%2 == 0) {
//			al.remove(i);
//		}
//	}
	for (Iterator iterator = al.iterator(); iterator.hasNext();) {
		Integer integer = (Integer) iterator.next();
		
		if (integer.intValue()%2 == 0) {
			iterator.remove();
		}
		
	}
	System.out.println(al);
}
}
