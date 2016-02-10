package com.sky.hoverplayer;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.WindowManager;

public class HoverVideoViewGestures implements View.OnTouchListener, ScaleGestureDetector.OnScaleGestureListener {

    private View view;
    private ScaleGestureDetector gestureScale;
    private float scaleFactor = 1;
    private float lastScale = 1;
    private boolean inScale;
    private WindowManager windowManager;
    private int _xDelta;
    private int _yDelta;


    public HoverVideoViewGestures(Context c, WindowManager windowManager){
        gestureScale = new ScaleGestureDetector(c, this);
        this.windowManager = windowManager;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        this.view = view;
        final int X = (int) event.getRawX();
        final int Y = (int) event.getRawY();
        switch (event.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                WindowManager.LayoutParams lParams = (WindowManager.LayoutParams) view.getLayoutParams();
                _xDelta = X - lParams.x;
                _yDelta = Y - lParams.y;
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
                layoutParams.x = X - _xDelta;
                layoutParams.y = Y - _yDelta;
                windowManager.updateViewLayout(view, layoutParams);
                break;
        }
        gestureScale.onTouchEvent(event);
        return true;
    }

    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getRealMetrics(metrics);

        if(view.getWidth() < metrics.widthPixels){
            scaleFactor *= detector.getScaleFactor();
            if(scaleFactor < 1){
                scaleFactor = 1;
            } else if(scaleFactor > 2){
                scaleFactor = 2;
            }
            Log.v("lnln", "being scale - " + String.valueOf(detector.getScaleFactor()));

            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);
            lastScale = scaleFactor;

            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();
            layoutParams.width = (int) (layoutParams.width * scaleFactor);
            layoutParams.height = (int) (layoutParams.height * scaleFactor);

            windowManager.updateViewLayout(view, layoutParams);
        }

        return true;
    }

    @Override
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        inScale = true;
        Log.v("lnln", "being scale - " + String.valueOf(detector.getScaleFactor()));

        return true;
    }

    @Override
    public void onScaleEnd(ScaleGestureDetector detector) {
        Log.v("lnln", "last scale - " + String.valueOf(detector.getScaleFactor()));
        inScale = false;
    }

}
