package com.sky.hoverplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;


import com.sky.hoverplayer.adapter.MovieAdapter;
import com.sky.hoverplayer.data.Movie;

import java.util.ArrayList;

public class HoverPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Movie> data = new ArrayList<>();
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hover_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent videoViewService = new Intent(HoverPlayerActivity.this, HoverPlayerService.class);
                videoViewService.putExtra("videoUrl", "http://video.news.sky.com/video/h264/vod/700/2016/01/DIGI120732FRSWIPETECHSHOW160129163058011454085472545700.mp4");
                startService(videoViewService);
            }
        });

        rv = (RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        initaliseData();
        MovieAdapter adapter = new MovieAdapter(data, this);
        rv.setAdapter(adapter);

    }


    void initaliseData() {

        /*

        http://news.sky.com/video/1632859/nhs-to-provide-proton-beam-therapy
http://video.news.sky.com/video/h264/vod/700/2016/01/DIGI1704411SAPROTONTHERAPYWILLIAMS1160130171307711454174095643700.mp4

http://news.sky.com/video/1637200/the-sixth-man-on-the-moon
http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI093835SANASAMITCHELLLS1454753482919700.mp4

http://news.sky.com/video/1636667/high-tech-helmets-for-pilots
http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI114024FRSWIPETECHSHOWDIGITALEDIT2050216V21454673644562700.mp4

         */

        Movie m1 = new Movie("NHS Proton Beam Therapy",
                "New evidence suggests proton beam therapy has fewer side effects for cancer patients than traditional radiotherapy.",
                "http://media.skynews.com/media/images/generated/2016/1/17/441710/default/v1/cegrab-20160117-231858-635-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/01/DIGI1704411SAPROTONTHERAPYWILLIAMS1160130171307711454174095643700.mp4"
        );
        Movie m2 = new Movie("Apollo Astronaut Edgar Mitchell Dies",
                "Apollo 14 astronaut Edgar Mitchell, who was the sixth man to walk on the moon, has died in Florida, aged 85.",
                "http://media.skynews.com/media/images/generated/2016/2/6/445494/default/v1/edgar-mitchell-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI093835SANASAMITCHELLLS1454753482919700.mp4"
        );

        Movie m3 = new Movie("Swipe Goes Behind The Scenes At BAE",
                "The Eurofighter Typhoon is one of the most advanced combat aircraft in the world and BAE Systems has created a helmet",
                "http://media.skynews.com/media/images/generated/2016/2/4/445199/default/v1/cegrab-20160204-153608-455-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI114024FRSWIPETECHSHOWDIGITALEDIT2050216V21454673644562700.mp4"
        );
        data.add(m1);
        data.add(m2);
        data.add(m3);

    }

    @Override
    public void onClick(View v) {
        int itemPosition = rv.getChildPosition(v);
        String videoUrl = data.get(itemPosition).getVideoUrl();
        Intent videoViewService = new Intent(HoverPlayerActivity.this, HoverPlayerService.class);
        videoViewService.putExtra("videoUrl", videoUrl);
        startService(videoViewService);
    }
}
