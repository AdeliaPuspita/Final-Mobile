package com.example.finalproject.Models;

import com.google.gson.annotations.SerializedName;

public class TvShow {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("first_air_date")
    private String first_air_date;

    @SerializedName("vote_average")
    private String vote_average;

    @SerializedName("poster_path")
    private String poster_path;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }
}
