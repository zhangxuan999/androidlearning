package javaproject;

public class TestOther {
	
	
public static void main(String[] args) {
	TestB b = new TestB();
	System.out.println(b == b.mOwnerTest);
}
}

class TestB{
	public TestB mOwnerTest;
	public TestB(){
		this.attachInterface(this);
	}
	
	public void attachInterface(TestB b){
		mOwnerTest = b;
	}
}

