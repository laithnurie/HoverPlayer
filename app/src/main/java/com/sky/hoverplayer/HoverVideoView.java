package com.sky.hoverplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.VideoView;

    public class HoverVideoView extends VideoView {
    public HoverVideoView(Context context) {
        super(context);
        init();
    }

    public HoverVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public HoverVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HoverVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    private void init() {
        setVideoURI(Uri.parse("http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_1mb.mp4"));
        requestFocus();
        start();
    }

}
