package com.example.farooqi.movieapp;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farooqi.movieapp.data.FetchData;
import com.example.farooqi.movieapp.data.MovieList;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    List<MovieList> movies;
    RecyclerView recycle;
    MultiViewRecyclerView mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = new ArrayList<>();
        recycle = findViewById(R.id.rec_view);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        if (isConnected()) {
            AsyncHttpClient client = new AsyncHttpClient();
            client.get(getString(R.string.API_URL), new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    JSONArray results = null;
                    try {
                        results = response.getJSONArray("results");
                        movies.addAll(FetchData.fromJsonArray(results));
                        Log.i("MainActivity", "movies: " + movies.toString());
                        if (mAdapter == null) {
                            mAdapter = new MultiViewRecyclerView(MainActivity.this, movies);
                            recycle.setAdapter(mAdapter);
                        }
                    } catch (Exception e) {
                        Log.e(LOG_TAG, e.getMessage());
                    }
                }
            });
        } else {
            Toast.makeText(this, "Please turn on internet", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return manager.getActiveNetworkInfo() != null;
    }

}
