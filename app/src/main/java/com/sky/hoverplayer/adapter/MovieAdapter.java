package com.sky.hoverplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sky.hoverplayer.R;
import com.sky.hoverplayer.data.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by davidshalom on 10/02/16.
 */

//  public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder>{

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    Context context;
    public MovieAdapter(List<Movie> data) {
        this.data = data;
    }

    private List<Movie> data;


    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        this.context = viewGroup.getContext();
        View v = LayoutInflater.from(context).inflate(R.layout.movie_item, viewGroup, false);
        MovieViewHolder mvh = new MovieViewHolder(v);
        return mvh;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder movieViewHolder, int position) {



        movieViewHolder.title.setText(data.get(position).getTitle());
        movieViewHolder.description.setText(data.get(position).getDescription());

        Picasso.with(context).load(data.get(position).getImageUrl()).into(movieViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        ImageView imageView;
        public MovieViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.movie_photo);
            description = (TextView) itemView.findViewById(R.id.description);
        }
    }
}
