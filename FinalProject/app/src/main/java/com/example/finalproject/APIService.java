package com.example.finalproject;

import com.example.finalproject.DataRespons.Movie;
import com.example.finalproject.DataRespons.TvShows;
import com.example.finalproject.Models.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {

    @GET("movie/now_playing?")
    Call<Movie> getMovie (@Query("api_key") String apikey);

    @GET("airing_today?")
    Call<TvShows> getTvShows (@Query("tvShows") String apikey);
}
