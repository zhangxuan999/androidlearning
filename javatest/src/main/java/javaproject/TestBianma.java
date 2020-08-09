package javaproject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TestBianma {
public static void main(String[] args) {
	String a = "严";
	
			try {
			System.out.println("编码中文字符所占字节数:"
					+ a.getBytes("unicode").length);
/*			System.out.println("编码中文字符所占字节数:"
					+ Ch);*/
/*			System.out.println("编码中文字符所占字节数:"
					+ b.length());*/
			System.out.println();
		} catch (Exception e) {
			System.out.println("非法编码格式！");
		}
			
			
			
			//获取系统默认编码
			System.out.println("系统默认编码：    "+System.getProperty("file.encoding"));//查询结果GBK
			//系统默认字符编码
			System.out.println("系统默认字符编码:"+Charset.defaultCharset());
			
			
			//操作系统用户使用的语言
			System.out.println("系统默认语言:"+ System.getProperty("user.language")); //查询结果zh
			//定义字符串包含数字和中文
	       String t = "燕";
	       //通过getBytes方法获取默认的编码
	       System.out.println("默认编码格式:");
	       byte[] b = t.getBytes();//ASCII,GBK,UTF-8对数字和英文字母的编码相同,对汉字的编码不同,unicode的编码跟前面三项都不同
	       System.out.println(b.length);
	       //打印默认编码
	       for (byte c : b) {
	    	   System.out.print(c+",\t");
	       }
	       System.out.println();
	       //打印GBK编码
	       System.out.println("GBK编码格式:");
	       try {
			b = t.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       System.out.println(b.length);
	       for (byte c : b) {
	   			System.out.print(c+",\t");
	       }
	       System.out.println();
	     //打印GBK编码
	       System.out.println("UTF-8编码格式:");
	       try {
			b = t.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       System.out.println(b.length);
	       for (byte c : b) {
	    	   System.out.print(c+",\t");
	       }
	       System.out.println();
	     //打印GBK编码
	       System.out.println("ASCII编码格式:");
	       try {
			b = t.getBytes("ASCII");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       System.out.println(b.length);
	       for (byte c : b) {
	    	   System.out.print(c+",\t");
	       }
	       System.out.println();
	     //打印GBK编码
	       System.out.println("UNICODE编码格式:");
	       try {
			b = t.getBytes("UNICODE");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       System.out.println(b.length);
	       for (byte c : b) {
	    	   System.out.print(c+",\t");
	       }

}
}
