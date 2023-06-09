package com.example.finalproject.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.finalproject.DataRespons.Movie;
import com.example.finalproject.Models.Movies;
import com.example.finalproject.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final List<Movies> nowPlayings;


    public MovieAdapter(List<Movies> nowPlayings) {
        this.nowPlayings = nowPlayings;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w200/" + nowPlayings.get(position).getPoster_path())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25)))
                .into(holder.ivPoster);
        holder.tvJudul.setText(nowPlayings.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return nowPlayings.size();
    }

    public void appendList(List<Movies> extraMovie) {
        nowPlayings.addAll(extraMovie);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPoster;
        TextView tvJudul, tvTahun;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            tvJudul = itemView.findViewById(R.id.tv_judul);
            tvTahun = itemView.findViewById(R.id.tv_tahun);
        }
    }
}