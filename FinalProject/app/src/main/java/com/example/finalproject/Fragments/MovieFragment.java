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
import android.widget.ProgressBar;
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
    ProgressBar progressBar;
    private LinearLayout reload;
    private ImageView loading;
    private int page = 1;

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
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);



        APIConfig.getApiService().getMovie(APIConfig.getApiKey()).enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {

                    movieAdapter = new MovieAdapter(response.body().getMovies());
                    GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
                    rvUser.setLayoutManager(layoutManager);
                    rvUser.setAdapter(movieAdapter);
                    reload.setVisibility(View.GONE);
                    loading.setVisibility(View.GONE);

                    Log.d("users", response.body().toString());
                    progressBar.setVisibility(View.GONE);

                    rvUser.addOnScrollListener(new RecyclerView.OnScrollListener() {
                        @Override
                        public void onScrolled(@NonNull RecyclerView recyclerView, int a, int b) {
                            int totalItem = layoutManager.getItemCount();
                            int visibleItem = layoutManager.getChildCount();
                            int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                            if (firstVisibleItem + visibleItem >= totalItem / 2) {
                                page++;
                                fetchData();
                            }
                        }

                        private void fetchData() {
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(getActivity(), "OnFailure" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}