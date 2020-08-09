package designmode;

public class TestFactory {
public static void main(String[] args) {
	
}
}

interface Cup{
	Cup getCup();
}

class ACup implements Cup{

	@Override
	public Cup getCup() {
		// TODO Auto-generated method stub
		return new ACup();
	}

}

class Bcup implements Cup{

	@Override
	public Cup getCup() {
		// TODO Auto-generated method stub
		return new Bcup();
	}

}

//简单工厂，根据传入参数的类型，决定new哪一个产品
class SimpleFactory{
	static Cup newCup(int i){
		if (i == 0) {
			return new ACup();
		}else{
			return new Bcup();
		}
	}
}


//工厂方法
interface FactoryMethod {
	Cup newCup();
}

//每个产品有自己的工厂类，这个工厂类的方法只返回对应的产品，比如A工厂类只生产A产品
class Afactory implements FactoryMethod{

	@Override
	public Cup newCup() {
		// TODO Auto-generated method stub
		return new ACup();
	}
	
}

class Bfactory implements FactoryMethod{

	@Override
	public Cup newCup() {
		// TODO Auto-generated method stub
		return new Bcup();
	}
	
}

//抽象工厂是在简单工厂的基础上 加上生产其它产品的接口
//也就是说这个工厂不仅生产ACUP，还成产例如Abowl其他产品
