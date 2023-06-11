package com.example.finalproject.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.finalproject.Adapters.FavoriteAdapter;
import com.example.finalproject.Adapters.MovieAdapter;
import com.example.finalproject.FavoriteHelper;
import com.example.finalproject.Models.Favorite;
import com.example.finalproject.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class FavoriteFragment extends Fragment {

    ProgressBar progressBar;
    RecyclerView rv;
    FavoriteAdapter favoriteAdapter;
    FavoriteHelper favoriteHelper;

    private ArrayList<Favorite> favoriteList = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        rv = view.findViewById(R.id.rv_user);
        favoriteAdapter = new FavoriteAdapter();

        rv.setHasFixedSize(true);
        favoriteHelper = FavoriteHelper.getInstance(getActivity());
        favoriteHelper.open();

        rv.setAdapter(favoriteAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        new LoadStudentsAsync(getActivity(), favv -> {
            if (favv.size() > 0) {
                favoriteAdapter.setData(favv);
                favoriteList = favv;
            } else {
                favoriteList = null;
            }
            if (favoriteList != null) {
                showCurrentUser(favoriteList);
                rv.setAdapter(favoriteAdapter);
            } else {
                showCurrentUser(new ArrayList<>());
                Toast.makeText(getActivity(), "ehh?", Toast.LENGTH_SHORT).show();
            }

        }).execute();

        return view;
    }

    private static class LoadStudentsAsync {
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadStudentsCallback> weakCallback;

        private LoadStudentsAsync(Context context, LoadStudentsCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }

        void execute() {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Handler handler = new Handler(Looper.getMainLooper());
            executor.execute(() -> {
                Context context = weakContext.get();
                FavoriteHelper favoriteHelper = FavoriteHelper.getInstance(context);
                favoriteHelper.open();
                ArrayList<Favorite> favList = favoriteHelper.getAllNotes();
                favoriteHelper.close();
                handler.post(() -> weakCallback.get().postExecute(favList));
            });
        }
    }

    interface LoadStudentsCallback {
        void postExecute(ArrayList<Favorite> favv);
    }

    private void showCurrentUser(ArrayList<Favorite> favoriteList) {
        favoriteAdapter.setData(favoriteList);

//        favoriteAdapter.setData(favoriteList);
//
//        if (favoriteList.size() > 0) {
//            rv.setVisibility(View.GONE);
//        } else {
//            rv.setVisibility(View.VISIBLE);
//        }
    }
}