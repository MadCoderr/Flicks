package com.example.farooqi.movieapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailActivity extends YouTubeBaseActivity {

    TextView releaseDate;
    TextView overviewMovie;
    TextView title;

    ImageView posterImage;
    ImageView playIcon;

    YouTubePlayerView player;
    RelativeLayout layout;

    RatingBar ratingBar;

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = findViewById(R.id.lbl_tle_movie_detail);
        overviewMovie = findViewById(R.id.lbl_des_detail);
        releaseDate = findViewById(R.id.lbl_rel_date);
        posterImage = findViewById(R.id.img_detail);
        player = findViewById(R.id.you_tube_movie);
        playIcon = findViewById(R.id.img_play_icon);
        ratingBar = findViewById(R.id.rat_bar);
        layout = findViewById(R.id.rel_layout);

        int movieId = getIntent().getIntExtra("movie_id", 0);
        String overview = getIntent().getStringExtra("movie_overview");
        String relDate = getIntent().getStringExtra("movie_rel");
        String tle = getIntent().getStringExtra("movie_title");
        String posterPath = getIntent().getStringExtra("poster_path");
        double rating = getIntent().getDoubleExtra("movie_vote", 0);

        title.setText(tle);
        overviewMovie.setText(overview);
        releaseDate.append(" " + relDate);
        ratingBar.setRating((float) rating);
        ratingBar.setNumStars((int) rating);
        Picasso.with(this).load(posterPath)
                          .fit()
                          .centerCrop()
                          .transform(new RoundedCornersTransformation(10, 10))
                          .into(posterImage);

        String url =
        "https://api.themoviedb.org/3/movie/" + movieId +"/videos?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                JSONArray result = null;
                try {
                    result = response.getJSONArray("results");
                    key = result.getJSONObject(0).getString("key");
                    Log.d("DetailActivity", key);

                    player.initialize(getString(R.string.api_key),
                            new YouTubePlayer.OnInitializedListener() {
                                @Override
                                public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                                    YouTubePlayer youTubePlayer, boolean b) {
                                    youTubePlayer.loadVideo(key);
                                    Log.d("DetailActivity", "ok i am here");

                                }

                                @Override
                                public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                                    YouTubeInitializationResult youTubeInitializationResult) {
                                    Toast.makeText(DetailActivity.this, "no video available",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void onImageClick(View view) {
        layout.setVisibility(View.GONE);
        player.setVisibility(View.VISIBLE);
        posterImage.setEnabled(false);
    }
}
