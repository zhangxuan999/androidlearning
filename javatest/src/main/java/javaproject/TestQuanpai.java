package javaproject;

import java.util.Collections;
import java.util.LinkedList;

public class TestQuanpai {
public static void main(String[] args) {
	allPermutation("abcd");
}

private static void swap(char[] c, int i, int j){
    char tmp;
    tmp = c[i];
    c[i] = c[j];
    c[j] = tmp;
}

private static void print(LinkedList<String> listStr)
{
    //Collections.sort(listStr);//ʹ�ַ�������'�ֵ�˳��'���
    for (String str : listStr) {
        System.out.println(str);
    }
    System.out.println("size:" + listStr.size());
}

public static void allPermutation(String str){
    if(str == null || str.length() == 0)
        return;
    //�������е�ȫ����
    LinkedList<String> listStr = new LinkedList<String>();
    
    allPermutation(str.toCharArray(), listStr, 0);
    
    print(listStr);//��ӡȫ����
}


private static void allPermutation(char[] c, LinkedList<String> listStr, int start){
	System.out.println("allPermutation: start = " + start);
    
    if(start == c.length-1){
    	listStr.add(String.valueOf(c));
    	System.out.println("allPermutation: result " +  String.valueOf(c));
    }
        
    else{
        for(int i = start; i <= c.length-1; i++)
        {  System.out.println("allPermutation:" + "i = " + i + " start = " + start);
            swap(c, i, start);//�൱��: �̶��� i ���ַ�
            allPermutation(c, listStr, start+1);//������������µ���������
            swap(c, start, i);//��λ
        }
    }
}
}
