package com.chujian.mytest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhy on 15/5/16.
 */
public class LargeImageView extends View
{
    private BitmapRegionDecoder mDecoder;
    /**
     * 图片的宽度和高度
     */
    private int mImageWidth, mImageHeight;
    /**
     * 绘制的区域
     */
    private volatile Rect mRect = new Rect();

    private MoveGestureDetector mDetector;


    private static final BitmapFactory.Options options = new BitmapFactory.Options();

    static
    {
        options.inPreferredConfig = Bitmap.Config.RGB_565;
    }

    public void setInputStream(InputStream is)
    {
        try
        {

            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            Bitmap bitmap1 = BitmapFactory.decodeStream(is,null,opts);
            mImageWidth = opts.outWidth;
            mImageHeight = opts.outHeight;
            Log.i("zhangxuan","mImageWidth = " + mImageWidth);
            Log.i("zhangxuan","mImageHeight = " + mImageHeight);
            mDecoder = BitmapRegionDecoder.newInstance(is, false);
            requestLayout();
            invalidate();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {

            try
            {
                if (is != null) is.close();
            } catch (Exception e)
            {
            }
        }
    }


    public void init()
    {
        mDetector = new MoveGestureDetector(getContext(), new MoveGestureDetector.SimpleMoveGestureDetector()
        {
            @Override
            public boolean onMove(MoveGestureDetector detector)
            {
                int moveX = (int) detector.getMoveX();
                int moveY = (int) detector.getMoveY();

                if (mImageWidth > getWidth())
                {
                    mRect.offset(-moveX, 0);
                    checkWidth();
                    invalidate();
                }
                if (mImageHeight > getHeight())
                {
                    mRect.offset(0, -moveY);
                    checkHeight();
                    invalidate();
                }

                return true;
            }
        });
    }


    private void checkWidth()
    {


        Rect rect = mRect;
        int imageWidth = mImageWidth;
        int imageHeight = mImageHeight;

        if (rect.right > imageWidth)
        {
            rect.right = imageWidth;
            rect.left = imageWidth - getWidth();
        }

        if (rect.left < 0)
        {
            rect.left = 0;
            rect.right = getWidth();
        }
    }


    private void checkHeight()
    {

        Rect rect = mRect;
        int imageWidth = mImageWidth;
        int imageHeight = mImageHeight;

        if (rect.bottom > imageHeight)
        {
            rect.bottom = imageHeight;
            rect.top = imageHeight - getHeight();
        }

        if (rect.top < 0)
        {
            rect.top = 0;
            rect.bottom = getHeight();
        }
    }


    public LargeImageView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        mDetector.onToucEvent(event);
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        Bitmap bm = mDecoder.decodeRegion(mRect, options);
        Log.i("zhangxuan","mRect222 = " + mRect.toString());
        Log.i("zhangxuan","bm.getRowBytes" + bm.getRowBytes()) ;
        canvas.drawBitmap(bm, 0, 0, null);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        int imageWidth = mImageWidth;
        int imageHeight = mImageHeight;
        Log.i("zhangxuan","width = " + width);
        Log.i("zhangxuan","imageWidth = " + imageWidth);
        //默认直接显示图片的中心区域，可以自己去调节
        mRect.left = imageWidth / 2 - width / 2;
        mRect.top = imageHeight / 2 - height / 2;
        mRect.right = mRect.left + width;
        mRect.bottom = mRect.top + height;

        Log.i("zhangxuan","mRect = " + mRect.toString());
    }


}

