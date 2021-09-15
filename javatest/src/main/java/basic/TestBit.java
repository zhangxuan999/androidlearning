package basic;

public class TestBit {
    public static void main(String[] args) {
        System.out.println(5<<2);//101->10100=20
        System.out.println(5>>2);//101->1=1
        System.out.println(5>>1);//101->10=2
        System.out.println(5&1);//101 & 001 (同时为1才为1，类似逻辑与，必须两个都是true)=001=1
        System.out.println(5|2);//101 | 010 （一个为1就是1，，类似逻辑或，一个是true就是true）=111=7
        System.out.println(5^1);//101^ 001(相反的为1，相同的为0，也就是不同为1，相同为0)=100=4
        System.out.println(~1);//-2?why?
        System.out.println(~2);//-3?why?

        float a = 0.5f;
        System.out.print(Float.toHexString(a));



    }
}
