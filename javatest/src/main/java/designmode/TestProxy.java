package designmode;

//(个人理解) 装饰者模式是使用的调用者从外部传进来的被装饰对象,调用者只想让你把他给你的对象加强一下,装饰一下. 
//代理模式使用的是代理对象在自己的构造方法里面new的一个被代理类的对象,不是调用者传入的,调用者不知道你找了其他人,他也不关心这些事,只要你把事情做好就行了.
//装饰器模式应当为所装饰的对象提供增强功能，而代理模式对所代理对象的使用施加控制，并不提供对象本身的增强功能。From：《java与模式》阎宏编著

//静态代理
//一个接口
//一个实现类
//一个代理类，也需要实现接口
public class TestProxy {
public static void main(String[] args) {
	
	Manager manager = new Manager();
	manager.sing();
	manager.act();
	
}
}

interface Act{
	
   void act();
   void sing();
   
}
class Actor implements Act{

	@Override
	public void act() {
		// TODO Auto-generated method stub
		System.out.println("i am acting");
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		System.out.println("i am singing");
	}
	
}


class Manager implements Act{
	
	Act mActor ;
	
	public Manager() {
		// TODO Auto-generated constructor stub
		mActor = new Actor();
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		mActor.act();
		
	}

	@Override
	public void sing() {
		// TODO Auto-generated method stub
		mActor.sing();
	}
	
}