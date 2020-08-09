package designmode;

public class TestSingleTon {
	public static void main(String[] args) {

	}

}

// ����ģʽ
class SingleTon {
	private SingleTon() {

	}

	private static final SingleTon instance = new SingleTon();

	public static SingleTon getInstance() {
		return instance;
	}
}

// ����ģʽ
class SingleTon2 {
	private SingleTon2() {

	}

	private static volatile SingleTon2 instance = null;

	public static SingleTon2 getInstance() {
		if (instance == null) {
			synchronized (SingleTon2.class) {
				if (instance == null) {
					instance = new SingleTon2();
				}
			}
		}
		return instance;
	}
}

// ��̬�ڲ���
class SingleTon3 {
	private SingleTon3() {

	}

	public static SingleTon3 getInstance() {
		return Inner.instance;
	}

	private static class Inner {
		private static SingleTon3 instance = new SingleTon3();
	}
}
