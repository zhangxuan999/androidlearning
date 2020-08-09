package designmode;

import java.util.Random;

public class testChain {
	
	public static void main(String[] args) {
		
		Ceo ceo = new Ceo(null);
		Manage manage =  new Manage(ceo);
		
		Sale sale = new Sale(manage);
		Random random =  new Random();
		for (int i = 0; i < 10; i++) {
			float disount = random.nextFloat();
			System.out.println(disount);
			System.out.println(sale.processDiscount(disount));;
		}
		
		
	}

}

abstract class PriceHandler{
	PriceHandler mPriceHandler;
	
	public PriceHandler(PriceHandler priceHandler){
		mPriceHandler = priceHandler;
	}
	
	abstract boolean processDiscount(float discount);
}

class Sale extends PriceHandler{

	public Sale(PriceHandler priceHandler) {
		super(priceHandler);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean processDiscount(float discount) {
		// TODO Auto-generated method stub
		if (discount >0.95) {
			
			System.out.println("Sale can give you this discount");
			return true;
		}else{
			System.out.println("Sale can not give you this discount ,dispach to manager");
			return mPriceHandler.processDiscount(discount);
		}
	}
	
}

class Manage extends PriceHandler{

	public Manage(PriceHandler priceHandler) {
		super(priceHandler);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean processDiscount(float discount) {
		// TODO Auto-generated method stub
		if (discount >0.7) {
			
			System.out.println("Manager can give you this discount");
			return true;
		}else{
			System.out.println("Manager can not give you this discount ,dispach to ceo");
			return mPriceHandler.processDiscount(discount);
			
		}
	}
	
}


class Ceo extends PriceHandler{

	public Ceo(PriceHandler priceHandler) {
		super(priceHandler);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean processDiscount(float discount) {
		// TODO Auto-generated method stub
		if (discount >0.5) {
			
			System.out.println("Ceo can give you this discount");
			return true;
		}else{
			System.out.println("resufe this discount");
			return false;
		}
	}
	
}


//class Father{
//	public Father(int s){
//		
//	}
//}
//
//class Son extends Father{
//
//	public Son(int i) {
//		super(5);
//		// TODO Auto-generated constructor stub
//	}
//	
//}
//
//
//class Sonsson extends Son{
//
//	public Sonsson() {
//		super(1);
//		// TODO Auto-generated constructor stub
//	}
//	
//}