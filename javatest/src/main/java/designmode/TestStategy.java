package designmode;

//һ���ӿ�
//���ʵ�ֽӿڵ�ʵ����
//һ�������࣬����Ҫʵ�ֽӿڡ�
public class TestStategy {
public static void main(String[] args) {
	Stategy stategy = new Stategy(new Cat());
	stategy.stategyEat();
}
}


interface Ani{
	void shout();
	void eat();
	void play();
}

class Cat implements Ani{

	@Override
	public void shout() {
		// TODO Auto-generated method stub
		System.out.println("my voice is miaomiao");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("i am eating fish");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("i am playing mouse ");
	}
	
}


class Stategy {
	private Ani ani;
	public Stategy(Ani ani){
		this.ani = ani;
	}
	public void stategyShout(){
		ani.shout();
	}
	
	public void stategyPlay(){
		ani.play();
	}
	
	public void stategyEat(){
		ani.eat();
	}
}
