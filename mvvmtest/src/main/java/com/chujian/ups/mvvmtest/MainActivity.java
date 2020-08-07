package com.chujian.ups.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2;
    private TextView tv;
    private MyViewModel myViewModel;
    static MainActivity mainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("zhangxuan","MainActivity oncreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        tv = findViewById(R.id.text);

        myViewModel = new ViewModelProvider(MainActivity.this).get(MyViewModel.class);
        myViewModel.getNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                // 当数据发生改变时会回调该方法
                tv.setText(myViewModel.getNum().getValue()+"");
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setNum(1);
                startActivity(new Intent(MainActivity.this,MainActivity2.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setNum(-1);
            }
        });

        getLifecycle().addObserver(new LifecycleObserver() {
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            void onResumessssss(){
                Log.d("zhangxuan", "Lifecycle call onResume");
            }


            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            void onResumesssdd(){
                Log.d("zhangxuan", "Lifecycle call onResume2222");
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            void onPause(){
                Log.d("zhangxuan", "Lifecycle call onPause");
            }
        });

        mainActivity = this;
    }
}