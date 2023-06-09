package com.example.finalproject.Models;

import com.google.gson.annotations.SerializedName;

public class Movies {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("vote_average")
    private String vote_average;

    @SerializedName("poster_path")
    private String poster_path;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }
}
