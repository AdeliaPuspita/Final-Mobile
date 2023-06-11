package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.finalproject.Fragments.FavoriteFragment;
import com.example.finalproject.Fragments.MovieFragment;
import com.example.finalproject.Fragments.TvFragment;

public class MainActivity extends AppCompatActivity {
    private ImageView ivMovie, ivTv, ivFav;
    private FragmentManager fragmentManager;
    TextView tvToolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMovie = findViewById(R.id.iv_movies);
        ivTv = findViewById(R.id.iv_tv);
        ivFav = findViewById(R.id.iv_fav);
        tvToolbar = findViewById(R.id.tv_toolbar);

        FavoriteHelper favoriteHelper = FavoriteHelper.getInstance(this);
        favoriteHelper.open();

        fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(MovieFragment.class.getSimpleName());
        if (!(fragment instanceof  MovieFragment)) {
            navigateFragment(new MovieFragment());
        }

        ivMovie.setOnClickListener(v -> {
            navigateFragment(new MovieFragment());
        });

        ivTv.setOnClickListener(v -> {
            navigateFragment(new TvFragment());
        });

        ivFav.setOnClickListener(v -> {
            navigateFragment(new FavoriteFragment());
        });

    }

    public void navigateFragment (Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_main,fragment, fragment.getClass().getSimpleName())
                .commit();

        //kondisi utk cek fragment sekarang
        if (fragment instanceof MovieFragment) {
            tvToolbar.setText("Movie");
        }
        if (fragment instanceof TvFragment) {
            tvToolbar.setText("Tv Shows");
        }
        if (fragment instanceof FavoriteFragment) {
            tvToolbar.setText("Favorite");
        }

    }
}