package com.chujian.ups.mvvmtest;

import android.app.Application;
import android.util.Log;

public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("zhangxuan","APP oncreate");
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(A.getInstance()).start();
        A.getInstance().aa();
    }


    static class A implements Runnable{
        private static A sInstance;
        public static A getInstance(){
            if (sInstance == null){
                sInstance = new A();
            }
            return sInstance;
        }

        @Override
        public void run() {
            Log.i("zhangxuan","threadid = " + Thread.currentThread().getId());
        }

        public void aa() {
            Log.i("zhangxuan","aa threadid = " + Thread.currentThread().getId());

        }
    }
}
