package com.example.farooqi.movieapp.data;

import android.util.Log;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SAMSUNG on 2/5/2018.
 */

public class FetchData {

    public static final String LOG_TAG = FetchData.class.getSimpleName();

    public static List<MovieList> fromJsonArray(JSONArray array) {
        List<MovieList> list = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            try {
                list.add(new MovieList(array.getJSONObject(i).getString("title"),
                                       array.getJSONObject(i).getString("poster_path"),
                                        array.getJSONObject(i).getString("overview"),
                                        array.getJSONObject(i).getInt("id"),
                                        array.getJSONObject(i).getString("release_date"),
                                        array.getJSONObject(i).getDouble("vote_average")));
            } catch (Exception e) {
                Log.e(LOG_TAG, e.getMessage());
            }
        }
        return list;
    }

}
