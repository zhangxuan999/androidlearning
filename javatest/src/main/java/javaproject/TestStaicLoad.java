package javaproject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestStaicLoad {
	//static 测试
	public static void main(String[] args) {
		// relection();
		// try {
		// Class.forName("javaproject.Dog");
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// try {
		// Class class_Dog = Class.forName("javaproject.Dog");
		// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

//		 Dog dog = new Dog(3);
//		 dog.functionA();
//		 System.out.println(dog.value);;
//		 System.out.println(dog.nonStaticValue);
//		 dog.shout();
//		 
		 Class c = TestStaicLoad.class;
//		 
//		 Dog dog2 = new Dog();
//		 dog2.functionA();
//		 System.out.println(dog2.value);;
//		 System.out.println(dog2.nonStaticValue);
//		 dog2.shout();

		// 以下三种形式都是被动引用
		// 不会触发Ani类的初始化
		Ani[] array = new Ani[3];
//		// 只会触发sFatherValue所在类的初始化
//		System.out.println(Dog.sAniStaticvalue);
//		// 不会触发Dog类的初始化，也不会触发Ani类的初始化
//		System.out.println(Dog.HELLO_WORLD);
		
//		System.out.println(Dog.sDogStaticvalue);
//		System.out.println(Dog.sDogStaticfinalvalue);


	}

	public static void relection() {
		try {
			Class class_dog = Class.forName("javaproject.Human");
			System.out.println("getDeclaredFields");
			Field[] fields = class_dog.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}

			System.out.println("getFields");
			Field[] fields2 = class_dog.getFields();
			for (Field field : fields2) {
				System.out.println(field.getName());
			}

			System.out.println("getDeclaredMethods");
			Method[] methods = class_dog.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method);
			}

			System.out.println("getMethods");
			Method[] methods2 = class_dog.getMethods();
			for (Method method : methods2) {
				System.out.println(method);
			}

			Constructor constructor;
			try {
				constructor = class_dog.getConstructor(String.class, int.class);
				try {
					constructor.newInstance("Tom", 10);
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Ani {
	private String name;
	private int age;

	public Ani() {
		System.out.println("ani create");
	}
	
	public Ani(int age){
		System.out.println("ani create 222");
	}

	static {
		System.out.println("ani static yujukuai");
	}

	static {
		System.out.println("ani static yujukuai222");
	}

	{
		System.out.println("ani nonstatic yujukuai");
	}
	{
		System.out.println("ani nonstatic yujukuai 222");
	}
	protected static void functionA() {
		System.out.println("ani static method functionA");
	}

	public static int value = 1;
	public static int sAniStaticvalue = 3;
	public int nonStaticValue = 1;

	public void shout() {
		System.out.println("ani");
	}

	public void anipublicMethod() {
		System.out.println("anipublicMethod");
	}

	protected void aniprotectedMethod() {
		System.out.println("aniprotectedMethod");
	}

	private void aniprivateMethod() {
		System.out.println("aniprivateMethod");
	}

}

class Dog extends Ani {

	public Dog() {
		System.out.println("Dog create");
	}
	
	
	public Dog(int age){
		
		//super(age);
		System.out.println("Dog create 222");
	}

	// 语句块
	{
		System.out.println("Dog nonstatic yujukuai");
	}

	// 静态语句块
	static {
		System.out.println("Dog static yujukuai 111");
	}
	
	static {
		System.out.println("Dog static yujukuai 222");
	}

	// 静态方法
	public static void functionA() {
		System.out.println("DOG static method functionA");
	}

	// 静态变量
	public static int value = 2;

	public static   int sDogStaticvalue = 4;
	public static final  int sDogStaticfinalvalue = 5;
	// 成员变量
	public int nonStaticValue = 2;
	
	public static final String HELLO_WORLD = "hello world";

	// 成员方法
	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("wangwang");
	}

	public void dogpublicMethod() {
		System.out.println("dogpublicMethod");
	}

	protected void dogprotectedMethod() {

		System.out.println("dogprotectedMethod");
	}

	private void dogprivateMethod() {
		System.out.println("dogprivateMethod");
	}
	
	static {
		System.out.println("Dog static yujukuai 333");
	}

}

class Cat extends Ani {

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("miaomiao");
	}
}
