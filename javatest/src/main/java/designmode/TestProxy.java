package designmode;

//(�������) װ����ģʽ��ʹ�õĵ����ߴ��ⲿ�������ı�װ�ζ���,������ֻ�������������Ķ����ǿһ��,װ��һ��. 
//����ģʽʹ�õ��Ǵ���������Լ��Ĺ��췽������new��һ����������Ķ���,���ǵ����ߴ����,�����߲�֪��������������,��Ҳ��������Щ��,ֻҪ����������þ�����.
//װ����ģʽӦ��Ϊ��װ�εĶ����ṩ��ǿ���ܣ�������ģʽ������������ʹ��ʩ�ӿ��ƣ������ṩ���������ǿ���ܡ�From����java��ģʽ���ֺ����

//��̬����
//һ���ӿ�
//һ��ʵ����
//һ�������࣬Ҳ��Ҫʵ�ֽӿ�
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