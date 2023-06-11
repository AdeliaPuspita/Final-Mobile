package com.example.finalproject.Adapters;

import android.content.Intent;
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
import com.example.finalproject.DataRespons.TvShows;
import com.example.finalproject.MainActivity2;
import com.example.finalproject.Models.TvShow;
import com.example.finalproject.R;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {
    private final List<TvShow> tvShowsList;

    public TvAdapter(List<TvShow> tvShowsList) {
        this.tvShowsList = tvShowsList;
    }

    @NonNull
    @Override
    public TvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout. item_tv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvAdapter.ViewHolder holder, int position) {
        TvShow tvShows = tvShowsList.get(position);
        holder.tvMovie.setText(tvShows.getName());
        holder.tvTahun.setText(tvShows.getFirst_air_date());
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w200/" + tvShowsList.get(position).getPoster_path())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25)))
                .into(holder.ivProfil);


        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent((holder.itemView.getContext()), MainActivity2.class);
            intent.putExtra("tvShows", tvShows);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tvShowsList.size();
    }

    public void appendList(List<TvShow> extraTvShows) {
        tvShowsList.addAll(extraTvShows);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView ivProfil;
        TextView tvMovie, tvTahun;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProfil = itemView.findViewById(R.id.iv_profile);
            tvMovie = itemView.findViewById(R.id.tv_movie);
            tvTahun = itemView.findViewById(R.id.tv_thn);
        }
    }
}
