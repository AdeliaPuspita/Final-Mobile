package com.example.finalproject.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
import com.example.finalproject.Adapters.TvAdapter;
import com.example.finalproject.DataRespons.Movie;
import com.example.finalproject.DataRespons.TvShows;
import com.example.finalproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TvFragment extends Fragment {

    TvAdapter tvAdapter;
    RecyclerView rvUsers;
    private LinearLayout reloadd;
    private ImageView loadingg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvUsers = view.findViewById(R.id.rv_users);
        reloadd = view.findViewById(R.id.reloadd);
        loadingg = view.findViewById(R.id.loadingg);

        APIConfig.getApiService().getTvShows(APIConfig.getApiKey()).enqueue(new Callback<TvShows>() {
            @Override
            public void onResponse(Call<TvShows> call, Response<TvShows> response) {
                if (response.isSuccessful() && response.body() != null) {

                    tvAdapter = new TvAdapter(response.body().getTvShow());
                    rvUsers.setAdapter(tvAdapter);
                    reloadd.setVisibility(View.GONE);
                    loadingg.setVisibility(View.GONE);
                    rvUsers.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                    Log.d("users", response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<TvShows> call, Throwable t) {
                    Toast.makeText(getActivity(), "OnFailure" + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }