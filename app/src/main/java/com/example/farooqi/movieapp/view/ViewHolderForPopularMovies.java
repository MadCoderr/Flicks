package com.example.farooqi.movieapp.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farooqi.movieapp.R;

/**
 * Created by SAMSUNG on 2/10/2018.
 */

public class ViewHolderForPopularMovies extends RecyclerView.ViewHolder {
    ImageView moviePic;
    ImageView playIcon;
    TextView movieTitlePop;
    TextView movieDesPop;

    public ViewHolderForPopularMovies(View itemView) {
        super(itemView);

        moviePic = itemView.findViewById(R.id.img_pop_movie);
        playIcon = itemView.findViewById(R.id.img_play_icon_pop_movie);
        movieTitlePop = itemView.findViewById(R.id.lbl_tle_movie_pop);
        movieDesPop = itemView.findViewById(R.id.lbl_des_movie_pop);
    }

    public ImageView getMoviePic() {
        return moviePic;
    }

    public void setMoviePic(ImageView moviePic) {
        this.moviePic = moviePic;
    }

    public ImageView getPlayIcon() {
        return playIcon;
    }

    public void setPlayIcon(ImageView playIcon) {
        this.playIcon = playIcon;
    }

    public TextView getMovieTitlePop() {
        return movieTitlePop;
    }

    public void setMovieTitlePop(TextView movieTitlePop) {
        this.movieTitlePop = movieTitlePop;
    }

    public TextView getMovieDesPop() {
        return movieDesPop;
    }

    public void setMovieDesPop(TextView movieDesPop) {
        this.movieDesPop = movieDesPop;
    }
}
