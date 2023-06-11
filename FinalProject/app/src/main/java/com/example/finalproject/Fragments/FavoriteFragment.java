package com.example.finalproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.finalproject.Models.Favorite;
import com.example.finalproject.R;

import java.util.List;


public class FavoriteFragment extends Fragment {

    private RecyclerView rvUser;
    private LinearLayout reload;
    private TextView tv;
    private ImageView ivLoading;
    ProgressBar progressBar;

    private List<Favorite> favoriteList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        tv = view.findViewById(R.id.tv);
        reload = view.findViewById(R.id.reload);
        ivLoading = view.findViewById(R.id.loading);
        progressBar = view.findViewById(R.id.progressBar);
        rvUser = view.findViewById(R.id.rv_user);

        return view;
    }
}