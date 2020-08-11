package javaproject;

/**
 * 翻转字符串的三种方法和String的一些常识
 */
public class TestString {
public static void main(String[] args) {
//	String aString = "abcfdef我";
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
//翻转字符串
//	思路1.
//	1.将string通过String的toCharArray方法转换为char数组
//	2.通过String的valueOf方法将一个char数组转换为String
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

//翻转字符串
//	思路2.1将string通过String的toCharArray方法转换为char数组
//	2。定义两个值一个left为0，第一个角标，right为最后一个角标，这两个角标的char互换
//	3.通过String的valueof方法将char转为为String
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


//翻转字符串
//	思路3 1.通过String的charAt方法取到每个位置的char
//	2.遍历
//	3.每次遍历将当前的char加上之前的String，就可以实现翻转
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
	 * string 相关
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
System.out.println(a == b);//true a与b相等
System.out.println(a == c);//false a与c不等
System.out.println(a == d);//true a与d相等
System.out.println(a == g);//a 与g不相等，因为g包含变量拼接而成
System.out.println(a == h);//a 与 h不相等。因为h包含变量拼接而成


String aString  = new String("111");
String bString = aString;
String cString = new String("111");

System.out.println(aString == bString);//true 无疑问
System.out.println(aString.equals(cString));//true String重写了equals方法
System.out.println(aString.hashCode() == cString.hashCode());//true String重写了hashCode方法，equals必然hashcode相等
}
}
