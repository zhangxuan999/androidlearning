package javaproject;

public class TestFloat {
	public static void main(String[] args) {
		float f = (float) -0.5;
		System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
		
		
//�����������Ʊ�ʾ
//		0 01111101  00000000000000000000000   0.25
//		0 01111110  00000000000000000000000   0.5
//		0 01111110  10000000000000000000000   0.75
//		0 01111110  11000000000000000000000   0.875
//		1 01111110  11000000000000000000000   -0.875
//		1 01111110  10000000000000000000000  -0.75
//		1 01111110  00000000000000000000000  -0.5
	}
	
	
	
}
