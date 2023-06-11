package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.finalproject.Models.Favorite;
import com.example.finalproject.Models.Movies;
import com.example.finalproject.Models.TvShow;
import com.example.finalproject.db.DatabaseContract;

public class MainActivity2 extends AppCompatActivity {

     ImageView ivBackdrop, ivBtnBack, ivFavorite, ivPoster, ivIcon;
     TextView tvReleaseDate, tvRate, tvDesc, tvTitle;
     CardView cvBack , cvFav;
     FavoriteHelper favoriteHelper;

     private Favorite favorite;
        public static final String EXTRA_FAVORITE = "extra_fav";
    public static final int RESULT_ADD = 101;
    public static final int RESULT_UPDATE = 201;
    public static final int RESULT_DELETE = 301;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ivBackdrop = findViewById(R.id.iv_backdrop);
        ivBtnBack = findViewById(R.id.iv_btnBack);
        ivFavorite = findViewById(R.id.iv_favorite);
        ivPoster = findViewById(R.id.iv_poster);
        ivIcon = findViewById(R.id.icon_movie);
        cvBack = findViewById(R.id.cv_back);
        cvFav = findViewById(R.id.cv_fav);

        tvReleaseDate = findViewById(R.id.tv_release_Date);
        tvTitle = findViewById(R.id.tv_title);
        tvRate = findViewById(R.id.tv_rate);
        tvDesc = findViewById(R.id.tv_desc);

        favoriteHelper = FavoriteHelper.getInstance(getApplicationContext());
        favoriteHelper.open();

        Intent intent = getIntent();
        if (intent.getParcelableExtra("movie") != null){

            Movies movies = intent.getParcelableExtra("movie");
            tvTitle.setText(movies.getTitle());
            tvDesc.setText(movies.getOverview());
            tvRate.setText(movies.getVote_average());
            tvReleaseDate.setText(movies.getRelease_date());

            Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + movies.getPoster_path()).into(ivPoster);
            Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + movies.getBackdrop_path()).into(ivBackdrop);
            Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + movies.getIcon_movie()).into(ivIcon);

            cvFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentFav = new Intent();
                    intentFav.putExtra(EXTRA_FAVORITE, favorite);
                    ContentValues values = new ContentValues();
                    values.put(DatabaseContract.FavoriteColumns.POSTER, movies.getPoster_path());
                    values.put(DatabaseContract.FavoriteColumns.TITLE, movies.getTitle());
                    values.put(DatabaseContract.FavoriteColumns.ICON, movies.getIcon_movie());
                    values.put(DatabaseContract.FavoriteColumns.RELEASE_DATE, movies.getRelease_date());
                    values.put(DatabaseContract.FavoriteColumns.BACKDROP, movies.getBackdrop_path());
                    values.put(DatabaseContract.FavoriteColumns.OVERVIEW, movies.getOverview());
                    values.put(DatabaseContract.FavoriteColumns.RATE, movies.getVote_average());
                    Toast.makeText(MainActivity2.this, "berhasil memasukkan ke favorite", Toast.LENGTH_SHORT).show();

                    long result = FavoriteHelper.insert(values);
                    if (result > 0) {
                        setResult(RESULT_UPDATE, intent);
                        finish();
                        startActivity(intent);
                    }
                }
            });

        } else if (intent.getParcelableExtra("tvShows") != null ) {
            TvShow tvShow = intent.getParcelableExtra("tvShows");
            tvTitle.setText(tvShow.getName());
            tvDesc.setText(tvShow.getOverview());
            tvRate.setText(tvShow.getVote_average());
            tvReleaseDate.setText(tvShow.getFirst_air_date());

            Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + tvShow.getPoster_path()).into(ivPoster);
            Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + tvShow.getBackdrop_path()).into(ivBackdrop);
            Glide.with(this).load("https://image.tmdb.org/t/p/w200/" + tvShow.getIcon_tv()).into(ivIcon);
            
        }

        ivBtnBack.setOnClickListener(view -> {
            finish();
        });
    }
}