package basic;

public class TestBit {


    private static final int COUNT_BITS = Integer.SIZE - 3;
    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
    public static void main(String[] args) {
        System.out.println(5<<2);//101->10100=20
        System.out.println(5>>2);//101->1=1
        System.out.println(5>>1);//101->10=2
        System.out.println(5&1);//101 & 001 (同时为1才为1，类似逻辑与，必须两个都是true)=001=1
        System.out.println(5|2);//101 | 010 （一个为1就是1，，类似逻辑或，一个是true就是true）=111=7
        System.out.println(5^1);//101^ 001(相反的为1，相同的为0，也就是不同为1，相同为0)=100=4
        System.out.println(~1);//-2?why?
        System.out.println(~2);//-3?why?


        System.out.println("------");//-3?why?
        System.out.println(Integer.toBinaryString(COUNT_BITS));
        System.out.println(RUNNING);
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(SHUTDOWN);
        System.out.println(Integer.toBinaryString(SHUTDOWN));
        System.out.println(STOP);
        System.out.println(Integer.toBinaryString(STOP));
        System.out.println(TIDYING);
        System.out.println(Integer.toBinaryString(TIDYING));
        System.out.println(TERMINATED);
        System.out.println(Integer.toBinaryString(TERMINATED));
        System.out.println(CAPACITY);
        System.out.println(Integer.toBinaryString(CAPACITY));





        float a = 0.5f;
        System.out.print(Float.toHexString(a));



    }
}
