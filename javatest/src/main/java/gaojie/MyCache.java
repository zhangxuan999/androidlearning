package gaojie;


import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {

    private ReentrantReadWriteLock reentrantReadWriteLock  = new ReentrantReadWriteLock();
    private Lock readLock = reentrantReadWriteLock.readLock();
    private Lock writeLock = reentrantReadWriteLock.writeLock();



    //����ȥ����������һ������������ʾ����״̬��16λ�������ã�16λ��д����
    //�����ɲ��У���д��дд���ɲ���

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
