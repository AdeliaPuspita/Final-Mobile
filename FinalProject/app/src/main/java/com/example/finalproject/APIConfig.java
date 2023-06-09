package com.example.finalproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIConfig {
    private static final String API_KEY = "2163b2f840387de39f84271ad3fbc5dd";
    private static final String url_API = "https://api.themoviedb.org/3/";


    public static APIService getApiService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);

        return apiService;
    }

    public static String getApiKey() {
        return API_KEY;
    }
}
