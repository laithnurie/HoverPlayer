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
        initialiseData();
        MovieAdapter adapter = new MovieAdapter(data, this);
        rv.setAdapter(adapter);

    }

    private void initialiseData() {

        data.add(new Movie("NHS Proton Beam Therapy",
                "New evidence suggests proton beam therapy has fewer side effects for cancer patients than traditional radiotherapy.",
                "http://media.skynews.com/media/images/generated/2016/1/17/441710/default/v1/cegrab-20160117-231858-635-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/01/DIGI1704411SAPROTONTHERAPYWILLIAMS1160130171307711454174095643700.mp4"
        ));

        data.add(new Movie("Apollo Astronaut Edgar Mitchell Dies",
                "Apollo 14 astronaut Edgar Mitchell, who was the sixth man to walk on the moon, has died in Florida, aged 85.",
                "http://media.skynews.com/media/images/generated/2016/2/6/445494/default/v1/edgar-mitchell-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI093835SANASAMITCHELLLS1454753482919700.mp4"
        ));

        data.add(new Movie("Swipe Goes Behind The Scenes At BAE",
                "The Eurofighter Typhoon is one of the most advanced combat aircraft in the world and BAE Systems has created a helmet",
                "http://media.skynews.com/media/images/generated/2016/2/4/445199/default/v1/cegrab-20160204-153608-455-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI114024FRSWIPETECHSHOWDIGITALEDIT2050216V21454673644562700.mp4"
        ));

        data.add(new Movie(
                "Minister: No Plans To Cut Drink-Drive Limit",
                "The Government has dismissed reports it is planning to reduce the drink-drive limit in England and Wales",
                "http://media.skynews.com/media/images/generated/2016/2/10/446239/default/v1/cegrab-20160210-061556-139-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/374/2016/02/DIGI061355WE100216DRINKDRIVEGRAPHIC160210061548321455084985367374.mp4"
        ));

        data.add(new Movie(
                "Doctors' Strike: 'More Than 2,800' Ops Halted",
                "Doctors in England walk out again in a dispute over new contracts and weekend pay",
                "http://media.skynews.com/media/images/generated/2016/2/10/446265/default/v1/cegrab-20160210-081621-828-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI080311WEJUNIORDOCTORSSTRIKEEMMA160210081637261455092272859700.mp4"
        ));

        data.add(new Movie(
                "Union Boss Warns Stop 'Sniping' At Corbyn",
                "McCluskey: 'Corbyn was giving voice to the views of most Labour supporters'",
                "http://media.skynews.com/media/images/generated/2016/2/9/446205/default/v1/mccluskey-corbyn-comp-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/01/DIGI153300SA230116CorbynFranceRefug160123160702061453565267706700.mp4"
        ));

        data.add(new Movie(
                "Leukaemia Sufferer Finds Donor After Global Bid",
                "Joy for Lara Casalotti after being told her mixed Thai and Italian heritage meant the odds of finding a donor were against her.\n",
                "http://media.skynews.com/media/images/generated/2016/2/9/445960/default/v1/11118226-1-1-992x558.jpg",
                "http://video.news.sky.com/video/h264/vod/700/2016/02/DIGI010541TUBONEMARROWLARAED4RH1454993775601700.mp4"
        ));
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
