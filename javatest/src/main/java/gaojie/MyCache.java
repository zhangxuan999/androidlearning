package gaojie;


import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {

    private ReentrantReadWriteLock reentrantReadWriteLock  = new ReentrantReadWriteLock();
    private Lock readLock = reentrantReadWriteLock.readLock();
    private Lock writeLock = reentrantReadWriteLock.writeLock();



    //看上去是两个锁，一个整数变量表示锁的状态，16位给读锁用，16位给写锁用
    //读读可并行，读写，写写不可并行

    private HashMap<String,Object> hashMap = new HashMap<>();

    /**
     * read

     */

    private Object read(String key){
        readLock.lock();
        try{
            return hashMap.get(key);
        }finally {
            readLock.unlock();

        }
    }

    private Object write(String key,Object value){
        writeLock.lock();
        try{
            return hashMap.put(key,value);
        }finally {
            writeLock.unlock();
        }

    }
}
