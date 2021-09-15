package javaproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

	System.out.println("遍历1");
	//方法1
	Iterator it1 = alArrayList.iterator();
	while(it1.hasNext()){
		System.out.println(it1.next());
	}
	System.out.println("遍历2");
	//方法2
	for(Iterator it2 = alArrayList.iterator();it2.hasNext();){
		System.out.println(it2.next());
	}
	System.out.println("遍历3");
	//方法3
	for(Integer tmp:alArrayList){
		System.out.println(tmp);
	}
	System.out.println("遍历4");
	//方法4
	for(int i = 0;i < alArrayList.size(); i ++){
		System.out.println(alArrayList.get(i));
	}
	delete(alArrayList);
	
//	int a [] = {1,2,3,4,5};
//	int i = 0;
//	System.out.println(a[i = 3 -2] + "i = " + i);
	
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
