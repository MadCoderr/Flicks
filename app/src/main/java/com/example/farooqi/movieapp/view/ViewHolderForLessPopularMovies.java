package com.example.farooqi.movieapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farooqi.movieapp.R;

/**
 * Created by SAMSUNG on 2/10/2018.
 */

public class ViewHolderForLessPopularMovies extends RecyclerView.ViewHolder {

    ImageView moviePoster;
    TextView movieTitle;
    TextView movieOverView;

    public ViewHolderForLessPopularMovies(View itemView) {
        super(itemView);

        moviePoster = itemView.findViewById(R.id.img_movie);
        movieTitle = itemView.findViewById(R.id.lbl_tle_movie);
        movieOverView = itemView.findViewById(R.id.lbl_des_movie);
    }

    public ImageView getMoviePoster() {
        return moviePoster;
    }

    public void setMoviePoster(ImageView moviePoster) {
        this.moviePoster = moviePoster;
    }

    public TextView getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(TextView movieTitle) {
        this.movieTitle = movieTitle;
    }

    public TextView getMovieOverView() {
        return movieOverView;
    }

    public void setMovieOverView(TextView movieOverView) {
        this.movieOverView = movieOverView;
    }
}
