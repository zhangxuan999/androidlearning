package designmode;

public class TestSingleTon {
	public static void main(String[] args) {

	}

}

/**
 * 单例模式的构造方法是私有的，因为不希望暴露
 * 单例模式的getinstance和单例对象都是static的
 * 单例对象最好的private的,只能通过getinstance访问
 *
 */
// 饿汉模式
class SingleTon {
	private SingleTon() {

	}

	private static final SingleTon instance = new SingleTon();

	public static SingleTon getInstance() {
		return instance;
	}
}

// 懒汉模式
class SingleTon2 {
	private SingleTon2() {

	}

	private static volatile SingleTon2 instance = null;

	//双层判空，为什么？A，B都进来，判断instance为空，假如A先拿到锁，那么B等锁，再判空，new instance。B拿到锁，进入不用重新new了
	//为什么加volatile，假设A持有锁，在执行时有指令重排序，有可能是对象还没new 出来，但是instance已经不为空了，此时C进来，判断instance不为空
	//	，返回instance，但是此时instance还没有真正被new 出来
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

// 内部类模式
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
