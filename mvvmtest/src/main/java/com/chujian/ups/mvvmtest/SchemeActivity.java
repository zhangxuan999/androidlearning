package com.chujian.ups.mvvmtest;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class SchemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme);

        Uri data = getIntent().getData();
        if (data != null){
            List<String> pathSegments = data.getPathSegments();
            String query = data.getQuery();
            Log.i("zhangxuan","query = "+ data);
            Log.i("zhangxuan","pathSegments = "+ pathSegments.toString());
            StringBuilder sb = new StringBuilder();
            sb.append("scheme: ").append(getIntent().getScheme()).append("<p>");
            sb.append("host: ").append(data.getHost()).append("<p>");
            sb.append("port: ").append(data.getPort()).append("<p>");
            sb.append("path: ").append(data.getPath()).append("<p>");
            sb.append("params: ").append(data.getQuery()).append("<p>");
            Log.i("zhangxuan","sb = "+ sb.toString());

        }

    }
}