package com.example.farooqi.movieapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class LaunchVideoActivity extends YouTubeBaseActivity {

    YouTubePlayerView player;
    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_video);

        player = findViewById(R.id.player_lunch_video);

        int movieId = getIntent().getIntExtra("movie_id", 0);

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
                                }

                                @Override
                                public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                                    YouTubeInitializationResult youTubeInitializationResult) {
                                    Toast.makeText(LaunchVideoActivity.this, "no video available",
                                            Toast.LENGTH_SHORT).show();
                                }
                            });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
