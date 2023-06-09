package com.example.finalproject.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.finalproject.APIConfig;
import com.example.finalproject.Adapters.MovieAdapter;
import com.example.finalproject.DataRespons.Movie;
import com.example.finalproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieFragment extends Fragment {

    MovieAdapter movieAdapter;
    RecyclerView rvUser;
    private LinearLayout reload;
    private ImageView loading;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvUser = view.findViewById(R.id.rv_user);
        reload = view.findViewById(R.id.reload);
        loading = view.findViewById(R.id.loading);


        APIConfig.getApiService().getMovie(APIConfig.getApiKey()).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {

                    movieAdapter = new MovieAdapter(response.body().getMovies());
                    rvUser.setAdapter(movieAdapter);
                    rvUser.setLayoutManager(new GridLayoutManager(getActivity(), 3));
                    Log.d("users", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(getActivity(), "OnFailure" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}