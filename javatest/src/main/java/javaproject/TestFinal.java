package javaproject;

public class TestFinal {
public static void main(String[] args) {
	final Person p = new Person(10,1);
	p.setSex(0);
	System.out.println(p.getSex());
	
}

public static class Person{
	int age ;
	public Person(int i, int j) {
		// TODO Auto-generated constructor stub
		age = i;
		sex = j;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	int sex;
}
}
