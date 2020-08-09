package javaproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TestHashMap {
	public static void main(String[] args) {
//		HashMap<String, Person> hashMap = new HashMap<>();
//		hashMap.put("aaa", new Person(11));
//		hashMap.put("bbb", new Person(12));
//		hashMap.put(null, new Person(13));
//		hashMap.put(null, new Person(14));
//		hashMap.put(new String("aaa"), new Person(15));
//		System.out.println(hashMap.size());
//		System.out.println(hashMap.get(null).age);
//		System.out.println(hashMap.get("aaa").age);
//
//		System.out.println("testhashset");
//		HashSet<String> hsHashSet = new HashSet<>();
//		hsHashSet.add("aaa");
//		hsHashSet.add("bbb");
//		hsHashSet.add("aaa");
//		hsHashSet.add(null);
//		hsHashSet.add(null);
//		hsHashSet.remove("aaa");
//		System.out.println(hsHashSet.size());
//
//		System.out.println("testarraylist");
//		ArrayList<String> al = new ArrayList<>();
//		al.add("AAA");
//		al.add("AAA");
//		al.add("BBB");
//		al.add("CCC");
//		al.add("DDD");
//		al.add(null);
//		al.add(null);
//		al.add(null);
//		al.remove("BB");
//		System.out.println(al.size());
//
//
//		System.out.println("testhashmap");
//		HashMap<HaHa, Person> hashMap2= new HashMap<>();
//		HaHa oneHa = new HaHa("a");
//		HaHa twoHa = new HaHa("b");
//		HaHa threeHa = new HaHa("a");
//		System.out.println(threeHa.equals(oneHa));
//		hashMap2.put(oneHa, new Person(111));
//		hashMap2.put(twoHa, new Person(222));
//		System.out.println(hashMap2.size());
//		System.out.println(hashMap2.get(twoHa).age);
		TestHashMap1();
	
	}


	static void TestHashMap1(){
		HashMap<ZZZ,String> hashMap = new HashMap<>();
		hashMap.put(new ZZZ(1),"1111");
		hashMap.put(new ZZZ(1),"1111");

		System.out.println(hashMap.size());
	}


}

class ZZZ{
	int age;

	ZZZ(int i){
		age = i;
	}

	@Override
	public int hashCode() {
//		return 111;
		return super.hashCode();
//		如果不复写hashcode的话，就算equals了，但是hashcode不等，也就是物理地址不相等，仍然会put
	}

	@Override
	public boolean equals(Object to) {
		return ((ZZZ)to).age == this.age?true:false;
//		return  super.equals(to);
	}
}
