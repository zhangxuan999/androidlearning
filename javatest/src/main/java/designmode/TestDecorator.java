package designmode;
//װ����ģʽ
public class TestDecorator {
public static void main(String[] args) {
	
	CafeReal cafeReal =  new CafeReal();
	MilkCafeDecorator milkCafeDecorator = new MilkCafeDecorator(new SugarCafeDecorator(cafeReal));
	ICafe newCafeReal = milkCafeDecorator.getCafe();//һ�����Ǽ��̵Ŀ���
	
//	MilkCafeDecorator milkCafeDecorator = new MilkCafeDecorator(cafeReal);
//	ICafe newCafeReal = milkCafeDecorator.getCafe();
	
	System.out.println(newCafeReal == cafeReal);
	
}
}

interface ICafe{
	ICafe getCafe();
}

class CafeReal implements ICafe{

	@Override
	public ICafe getCafe() {
		// TODO Auto-generated method stub
		return this;
	}
}


class CafeDecorator implements ICafe{
	ICafe iCafe;
	
	public CafeDecorator(ICafe iCafe){
		this.iCafe = iCafe;
	}

	@Override
	public ICafe getCafe() {
		// TODO Auto-generated method stub
		return iCafe.getCafe();
	}
}

class MilkCafeDecorator extends CafeDecorator{

	public MilkCafeDecorator(ICafe iCafe) {
		super(iCafe);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ICafe getCafe() {
		// TODO Auto-generated method stub
		
		addMilk(iCafe);
		return super.getCafe();
		
	}
	
	public void addMilk(ICafe cafe){
		System.out.println("jia nai ");
	}
	
}


class SugarCafeDecorator extends CafeDecorator{

	public SugarCafeDecorator(ICafe iCafe) {
		super(iCafe);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ICafe getCafe() {
		addSugar(iCafe);
		return super.getCafe();
		
	}
	
	public void addSugar(ICafe cafe){
		System.out.println("jia tang ");
	}
	
}
