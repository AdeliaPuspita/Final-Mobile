package com.example.finalproject.DataRespons;

import com.example.finalproject.Models.Movies;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {

    @SerializedName("results")
    private List<Movies> movies;

    public List<Movies> getMovies() {
        return movies;
    }
}
