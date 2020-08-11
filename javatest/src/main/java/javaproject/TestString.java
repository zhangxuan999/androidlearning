package javaproject;

/**
 * ��ת�ַ��������ַ�����String��һЩ��ʶ
 */
public class TestString {
public static void main(String[] args) {
//	String aString = "abcfdef��";
//	System.out.println(reverse(aString));
//	
//	
//	String bString = "abcfdef";
//	System.out.println(reverse2(aString));
//	
//	
	String cString = "abcfdef";
	System.out.println(reverse3(cString));
//	test1();
	
}
//��ת�ַ���
//	˼·1.
//	1.��stringͨ��String��toCharArray����ת��Ϊchar����
//	2.ͨ��String��valueOf������һ��char����ת��ΪString
public static String reverse(String original){
	
	if (original == null) {
		return null;
	}
	char[] a = original.toCharArray();
	char[] b = new char[a.length];
	for (int i = 0; i < a.length; i++) {
		b[i] = a[a.length -1 -i];
	}
	
	String bString  = String.valueOf(b);
	return bString;
	
}

//��ת�ַ���
//	˼·2.1��stringͨ��String��toCharArray����ת��Ϊchar����
//	2����������ֵһ��leftΪ0����һ���Ǳ꣬rightΪ���һ���Ǳ꣬�������Ǳ��char����
//	3.ͨ��String��valueof������charתΪΪString
 public static String reverse2(String original){
	
	if (original == null) {
		return null;
	}
	char[] a = original.toCharArray();
	
	int left = 0;
	int right = a.length -1;
	while (left < right) {
		char temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		left ++;
		right --;
	}
	
	String bString  = String.valueOf(a);
	return bString;
	
}


//��ת�ַ���
//	˼·3 1.ͨ��String��charAt����ȡ��ÿ��λ�õ�char
//	2.����
//	3.ÿ�α�������ǰ��char����֮ǰ��String���Ϳ���ʵ�ַ�ת
public static String reverse3(String original){
	
	if (original == null) {
		return null;
	}
	String bString = "";
	for (int i = 0; i < original.length(); i++) {
		bString = original.charAt(i) + bString;
	}
	return bString;
	
}

	/**
	 * string ���
	 */
	public static void test1(){
String a = "abc";
String b = "abc";
String c = new String("abc");
String d = "ab" + "c";
String e = "ab";
String f = "c";
String g = e + "c";
String h = e + f;
System.out.println(a == b);//true a��b���
System.out.println(a == c);//false a��c����
System.out.println(a == d);//true a��d���
System.out.println(a == g);//a ��g����ȣ���Ϊg��������ƴ�Ӷ���
System.out.println(a == h);//a �� h����ȡ���Ϊh��������ƴ�Ӷ���


String aString  = new String("111");
String bString = aString;
String cString = new String("111");

System.out.println(aString == bString);//true ������
System.out.println(aString.equals(cString));//true String��д��equals����
System.out.println(aString.hashCode() == cString.hashCode());//true String��д��hashCode������equals��Ȼhashcode���
}
}
