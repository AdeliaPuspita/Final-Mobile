package com.example.finalproject.DataRespons;

import com.example.finalproject.Models.Movies;
import com.example.finalproject.Models.TvShow;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvShows {
    @SerializedName("results")
    private List<TvShow> tvShow;

    public List<TvShow> getTvShow() {
        return tvShow;
    }
}
