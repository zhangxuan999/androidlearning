package com.chujian.mytest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.chujian.mytest.R;

public class MainActivity extends AppCompatActivity {


    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        print();

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
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
    protected void onResume() {
        super.onResume();
        button1.post(new Runnable() {

            @Override
            public void run() {
                Log.w("zhangxuan", "button1.getWidth()" + button1.getWidth());
                Log.w("zhangxuan", "button2.getWidth()" + button2.getWidth());
                Log.w("zhangxuan", "button3.getWidth()" + button3.getWidth());
                Log.w("zhangxuan", "button4.getWidth()" + button4.getWidth());
            }
        });

    }
}
