package basic;

public class Test {
    /**
     * 三个点的方法
     * @param a
     */
    void t1(String... a) {
        System.out.println("t1");
        //这里a是一个数组，但是传的时候也可以一个一个的传参，自动转换为数组？
        for (String s : a)
            System.out.printf(" " + s);
        System.out.println();
    }

    void t2(String[] a) {
        System.out.println("t2");
        for (String s : a)
            System.out.printf(" " + s);
        System.out.println();
    }

    public static void main(String[] args) {
        String a[] = { "a", "b", "d", "e", "f", "g" };
        Test t = new Test();
        t.t1(a);
        t.t2(a);
        // 区别
        t.t1();// 可不传
        // t.t2();//必须传参数,否则报错
        t.t1("1", "2", "3", "4");// 也可以一个一个的传,t2则不可以
    }
}