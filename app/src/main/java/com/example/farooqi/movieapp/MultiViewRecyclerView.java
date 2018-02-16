package com.example.farooqi.movieapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farooqi.movieapp.data.MovieList;
import com.example.farooqi.movieapp.view.ViewHolderForLessPopularMovies;
import com.example.farooqi.movieapp.view.ViewHolderForPopularMovies;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by SAMSUNG on 2/10/2018.
 */

public class MultiViewRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<MovieList> movieList;

    private static final int LESS_POPULAR_MOVIES = 0;
    private static final int POPULAR_MOVIES = 1;


    public MultiViewRecyclerView(Context context, List<MovieList> list) {
        movieList = new ArrayList<>();
        this.context = context;
        this.movieList.addAll(list);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(context);

        switch (viewType) {
            case POPULAR_MOVIES:
                View v1 = inflater.inflate(R.layout.layout_popular_movies, parent, false);
                viewHolder = new ViewHolderForPopularMovies(v1);
                break;

            case LESS_POPULAR_MOVIES:
                View v2 = inflater.inflate(R.layout.layout_less_popular_movies, parent, false);
                viewHolder = new ViewHolderForLessPopularMovies(v2);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case POPULAR_MOVIES:
                ViewHolderForPopularMovies v1 = (ViewHolderForPopularMovies) holder;
                MovieList list = movieList.get(position);
                if (list != null) {
                    v1.getMovieTitlePop().setText(list.getTitle());
                    v1.getMovieDesPop().setText(list.getOverview());
                    Picasso.with(context)
                            .load(list.getPosterImage())
                            .placeholder(R.drawable.movie_placeholder)
                            .error(R.drawable.movie_placeholder_error)
                            .transform(new RoundedCornersTransformation(10, 10))
                            .into(v1.getMoviePic());
                }
                v1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MovieList list = movieList.get(position);
                        Intent intent = new Intent(context, LaunchVideoActivity.class);
                        intent.putExtra("movie_id", list.getId());
                        context.startActivity(intent);
                    }
                });
                break;

            case LESS_POPULAR_MOVIES:
                ViewHolderForLessPopularMovies v2 = (ViewHolderForLessPopularMovies) holder;
                MovieList list2 = movieList.get(position);
                if (list2 != null) {
                    v2.getMovieTitle().setText(list2.getTitle());
                    v2.getMovieOverView().setText(list2.getOverview());
                    Picasso.with(context)
                            .load(list2.getPosterImage())
                            .placeholder(R.drawable.movie_placeholder)
                            .error(R.drawable.movie_placeholder_error)
                            .transform(new RoundedCornersTransformation(10, 10))
                            .into(v2.getMoviePoster());
                }
                v2.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        MovieList currentList = movieList.get(position);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("movie_id", currentList.getId());
                        intent.putExtra("movie_overview", currentList.getOverview());
                        intent.putExtra("movie_title", currentList.getTitle());
                        intent.putExtra("movie_rel", currentList.getRelDate());
                        intent.putExtra("poster_path", currentList.getPosterImage());
                        intent.putExtra("movie_vote", currentList.getVote());
                        context.startActivity(intent);
                    }
                });
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        MovieList current = movieList.get(position);
        if (((int) current.getVote()) > 5) {
            return POPULAR_MOVIES;
        } else if (((int) current.getVote()) <= 5) {
            return LESS_POPULAR_MOVIES;
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}
