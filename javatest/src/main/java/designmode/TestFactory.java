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

//�򵥹���
class SimpleFactory{
	static Cup newCup(int i){
		if (i == 0) {
			return new ACup();
		}else{
			return new Bcup();
		}
	}
}


//��������
interface FactoryMethod {
	Cup newCup();
}
//���󹤳����ڼ򵥹����Ļ����� ��������������Ʒ�Ľӿ�

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
