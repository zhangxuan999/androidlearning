package javaproject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class TestBianma {
public static void main(String[] args) {
	String a = "��";
	
			try {
			System.out.println("���������ַ���ռ�ֽ���:"
					+ a.getBytes("unicode").length);
/*			System.out.println("���������ַ���ռ�ֽ���:"
					+ Ch);*/
/*			System.out.println("���������ַ���ռ�ֽ���:"
					+ b.length());*/
			System.out.println();
		} catch (Exception e) {
			System.out.println("�Ƿ������ʽ��");
		}
			
			
			
			//��ȡϵͳĬ�ϱ���
			System.out.println("ϵͳĬ�ϱ��룺    "+System.getProperty("file.encoding"));//��ѯ���GBK
			//ϵͳĬ���ַ�����
			System.out.println("ϵͳĬ���ַ�����:"+Charset.defaultCharset());
			
			
			//����ϵͳ�û�ʹ�õ�����
			System.out.println("ϵͳĬ������:"+ System.getProperty("user.language")); //��ѯ���zh
			//�����ַ����������ֺ�����
	       String t = "��";
	       //ͨ��getBytes������ȡĬ�ϵı���
	       System.out.println("Ĭ�ϱ����ʽ:");
	       byte[] b = t.getBytes();//ASCII,GBK,UTF-8�����ֺ�Ӣ����ĸ�ı�����ͬ,�Ժ��ֵı��벻ͬ,unicode�ı����ǰ�������ͬ
	       System.out.println(b.length);
	       //��ӡĬ�ϱ���
	       for (byte c : b) {
	    	   System.out.print(c+",\t");
	       }
	       System.out.println();
	       //��ӡGBK����
	       System.out.println("GBK�����ʽ:");
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
	     //��ӡGBK����
	       System.out.println("UTF-8�����ʽ:");
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
	     //��ӡGBK����
	       System.out.println("ASCII�����ʽ:");
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
	     //��ӡGBK����
	       System.out.println("UNICODE�����ʽ:");
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
