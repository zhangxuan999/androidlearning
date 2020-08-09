package com.shane.test;

public class HelloFactory {

	public static void main(String[] args) {
		IFactory factory = new NikeFactory();
		IProduct nike = factory.createProduct();
		factory = new AdidasFactory();
		IProduct adidas = factory.createProduct();
		System.out.println(nike);
		System.out.println(adidas);

		IProduct nikeShoe = ShoeFactory.createProduct("nike");
		IProduct adidasShoe = ShoeFactory.createProduct("adidas");
		System.out.println(nikeShoe);
		System.out.println(adidasShoe);
		
	}

	private interface IProduct {
		void setProduct();
	}

	private static class NikeShoeProduct implements IProduct {

		String band;

		public NikeShoeProduct() {
			setProduct();
		}

		@Override
		public void setProduct() {
			this.band = "nike";
		}

		@Override
		public String toString() {
			return "this is " + band + " product ";
		}

	}

	private static class AdidasShoeProduct implements IProduct {
		String band;

		public AdidasShoeProduct() {
			setProduct();
		}

		@Override
		public void setProduct() {
			this.band = "adidas";
		}

		@Override
		public String toString() {
			return "this is " + band + " product ";
		}
	}

	private interface IFactory {
		IProduct createProduct();
	}

	private static class NikeFactory implements IFactory {

		@Override
		public IProduct createProduct() {
			return new NikeShoeProduct();
		}

	}

	private static class AdidasFactory implements IFactory {

		@Override
		public IProduct createProduct() {
			return new AdidasShoeProduct();
		}
	}
	
	private static class ShoeFactory {
		public static IProduct createProduct(String band) {
			if (band.equals("ninke")) {
				return new NikeShoeProduct();
			} else if (band.equals("adidas")) {
				return new AdidasShoeProduct();
			}
			
			return new NikeShoeProduct();
		}
	}
}