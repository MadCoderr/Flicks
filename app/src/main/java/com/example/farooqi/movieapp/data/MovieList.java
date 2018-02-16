package com.example.farooqi.movieapp.data;

/**
 * Created by SAMSUNG on 2/5/2018.
 */

public class MovieList {
    String title;
    String posterImage;
    String overview;
    String relDate;
    double vote;
    int id;


    public MovieList() {

    }

    public MovieList(String title, String posterImage, String overview, int id, String relDate,
                     double vote) {
        this.title = title;
        this.posterImage = posterImage;
        this.overview = overview;
        this.id = id;
        this.relDate = relDate;
        this.vote = vote;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterImage() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterImage);
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelDate() {
        return relDate;
    }

    public void setRelDate(String relDate) {
        this.relDate = relDate;
    }

    public double getVote() {
        return this.vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }
}
