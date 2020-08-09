package javaproject;

import java.util.HashSet;
import java.util.Vector;

public class TestHashSet {
public static void main(String[] args) {
	HashSet<Vector<Integer>> hashSet = new HashSet<>();
	
	Vector<Integer>  vector1 = new Vector<>();
	vector1.add(1);
	vector1.add(2);
	vector1.add(3);
	
	
	
	Vector<Integer>  vector2 = new Vector<>();
	vector2.add(1);
	vector2.add(2);
	vector2.add(3);
	
	
	Vector<Integer>  vector3 = new Vector<>();
	vector3.add(1);
	vector3.add(3);
	vector3.add(2);
	
	hashSet.add(vector1);
	hashSet.add(vector2);
	hashSet.add(vector3);
	
	System.out.println(hashSet.size());
	
	HashSet<HaHa>  hashSet2 = new HashSet<>();
	hashSet2.add(new HaHa("a"));
	hashSet2.add(new HaHa("b"));
	
	System.out.println(hashSet2.size());
	
	
	
}
}

class HaHa{
	private String a;

	public HaHa(String a){
		this.a = a;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 12345;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a;
	}
	
	
}
