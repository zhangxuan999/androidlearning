package javaproject;

/**
 * 符号优先级以及一些基本知识
 */
public class Testfuhao {
    public static void main(String[] args) {
        int i = 3;
        int j = 5&i-1;
        //这里先算i-1，再与5做位于运算，也就是加减运算符优先级高于位与


        System.out.println(j);

        int k = 0xf;
        //0x开头代表十六进制
        k = 0b11;
        //0b代表二进制
        k = -017;
        //0开头代表八进制
        System.out.println(k);
//        八进制数值只能用一种前缀0
        System.out.println(077);

//        二进制binary
//        八进制octal
//        十进制decimal
//        十六进制 hex


    }
}
