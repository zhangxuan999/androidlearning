package com.chujian.mytest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chujian.mytest.LargeImageView;
import com.chujian.mytest.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.InputStream;

public class BitmapTestActivity extends AppCompatActivity implements View.OnClickListener {

    private LargeImageView imageView;
    private Button button1;
    private Button button2;

//    private int[][][] cache = new int[1024][1024][10];//这个占40M内存

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_test);
        imageView = findViewById(R.id.image);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


        AssetManager assetManager = getResources().getAssets();
        try {
            InputStream is=assetManager.open("timg.jpg");
//            不加载图片，计算图片的宽高
//            BitmapFactory.Options opts = new BitmapFactory.Options();
//            opts.inJustDecodeBounds = true;
//            Bitmap bitmap1 = BitmapFactory.decodeStream(is,null,opts);
//            int width = opts.outWidth;
//            int height = opts.outHeight;
//            Log.i("zhangxuan","test width = " + width);
//            Log.i("zhangxuan","test height = " + height);
            //设置显示图片的中心区域
//            BitmapRegionDecoder bitmapRegionDecoder = BitmapRegionDecoder.newInstance(is, false);
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inPreferredConfig = Bitmap.Config.RGB_565;
//            Bitmap bitmap = bitmapRegionDecoder.decodeRegion(new Rect(width / 2 - 100, height / 2 - 100, width / 2 + 100, height / 2 + 100), options);
//            imageView.setImageBitmap(bitmap);
            imageView.setInputStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusMessage message) {
        Log.i("zhangxuan","onMessageEvent message = " + message.getMessage());
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        final int width = options.outWidth;
        final int height = options.outHeight;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {
            //使用需要的宽高的最大值来计算比率
            final int suitedValue = reqHeight > reqWidth ? reqHeight : reqWidth;
            final int heightRatio = Math.round((float) height / (float) suitedValue);
            final int widthRatio = Math.round((float) width / (float) suitedValue);

            inSampleSize = heightRatio > widthRatio ? heightRatio : widthRatio;//用最大
        }

        return inSampleSize;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                EventBus.getDefault().post(new EventBusMessage(1,"message one"));
                break;
            case R.id.button2:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EventBus.getDefault().post(new EventBusMessage(2,"message two"));
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}