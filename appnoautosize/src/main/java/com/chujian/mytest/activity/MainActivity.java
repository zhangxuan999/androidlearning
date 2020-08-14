package com.chujian.mytest.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chujian.mytest.R;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Handler subThreadHandler;

    private Handler mainHander = new Handler(){

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_noauto);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        startActivity(new Intent(MainActivity.this,BitmapTestActivity.class));
//                        finish();
            }
        });
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subThreadHandler.getLooper().quit();


            }
        });
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subThreadHandler.sendEmptyMessage(22);
                EventBus.getDefault().post(new EventBusMessage(3,"message three"));

            }
        });
        Log.i("zhangxuan","主线程" + Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("zhangxuan","子线程 111");
                Looper.prepare();
                Log.i("zhangxuan","子线程 222");
                Log.i("zhangxuan","子线程" + Thread.currentThread().getName());
                subThreadHandler = new Handler(Looper.myLooper()
                ){
                    @Override
                    public void handleMessage( Message msg) {
                        Log.i("zhangxuan",">>>>> Dispatching to " + msg.what);
                    }
                };
                Log.i("zhangxuan","子线程 333");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i("zhangxuan","子线程 444");
                Looper.loop();
            }
        }).start();
        print();
    }

    private void print() {
        Log.i("zhangxuan","getResources().getDisplayMetrics().density = " + getResources().getDisplayMetrics().density);
        Log.i("zhangxuan","getResources().getDisplayMetrics().densityDpi = " + getResources().getDisplayMetrics().densityDpi);
        Log.i("zhangxuan","getResources().getDisplayMetrics().xdpi = " + getResources().getDisplayMetrics().xdpi);
        Log.i("zhangxuan","getResources().getDisplayMetrics().ydpi = " + getResources().getDisplayMetrics().ydpi);
        Log.i("zhangxuan","getResources().getDisplayMetrics().heightPixels = " + getResources().getDisplayMetrics().heightPixels);
        Log.i("zhangxuan","getResources().getDisplayMetrics().widthPixels = " + getResources().getDisplayMetrics().widthPixels);
        Log.i("zhangxuan","getResources().getDisplayMetrics().scaledDensity = " + getResources().getDisplayMetrics().scaledDensity);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        print();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        button1.post(new Runnable() {
//
//            @Override
//            public void run() {
//                Log.w("zhangxuan", "button1.getWidth()" + button1.getWidth());
//                Log.w("zhangxuan", "button2.getWidth()" + button2.getWidth());
//                Log.w("zhangxuan", "button3.getWidth()" + button3.getWidth());
//                Log.w("zhangxuan", "button4.getWidth()" + button4.getWidth());
//            }
//        });

    }
}
