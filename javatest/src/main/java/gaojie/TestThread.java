package gaojie;

import java.util.concurrent.atomic.AtomicInteger;

// 锁 ，cas（compare and set），原子类，REENTRANCELOCK,读写锁，信号量，倒计时门栓
//原子类原理，乐观的，非阻塞的，假定冲突很少，可重入锁，读写锁等都是基于cas实现的，虽然可重入锁是悲观锁
public class TestThread {
    static int value = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread[]  threads = new Thread[1000];
        for (int i = 0;i<100;i++){
            threads[i] = new Visitor();
            threads[i].start();
        }
        for (int i = 0;i<100;i++){
            threads[i].join();
        }

        System.out.println(Visitor.Count);
        System.out.println(Visitor.counter.count);
    }
}

class  Visitor extends Thread{
    static int Count = 0;
   static Counter counter = new Counter();
    @Override
    public void run() {
        for (int i = 0;i<1000;i++){
            Count ++;
//            counter.add();
        }
    }
}


class Counter{
    int count = 0;
     void add(){
         count ++;
    }

    void decree(){
         count --;
    }
}