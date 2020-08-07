package com.chujian.ups.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private Button btn1,btn2;
    private TextView tv;
    private MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.i("zhangxuan","MainActivity2 onCreate");
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        tv = findViewById(R.id.text);
        //这里用的是MainActivity.mainActivity，那么和MainActivity是同一个viewmodel
//        myViewModel = new ViewModelProvider(MainActivity.mainActivity).get(MyViewModel.class);
        myViewModel = new ViewModelProvider(MainActivity2.this).get(MyViewModel.class);
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
//                tv.setText("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setNum(-1);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("uumobile://yongche/123123123?card_id=123456&num=5555")));
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("weixin://")));  //  打开微信
            }
        });
    }
}