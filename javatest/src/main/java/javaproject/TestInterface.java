package javaproject;


interface MyAidl {
	public int add(int first, int second);
	
	public abstract static class Stub implements MyAidl{
		public static class Proxy implements MyAidl{

			@Override
			public int add(int first, int second) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		}
	}
}
