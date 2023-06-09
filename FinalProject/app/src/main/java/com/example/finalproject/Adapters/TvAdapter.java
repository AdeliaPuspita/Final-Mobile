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
import com.example.finalproject.DataRespons.TvShows;
import com.example.finalproject.R;

import java.util.List;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ViewHolder> {
    private final List<TvShows> tvShowsList;

    public TvAdapter(List<TvShows> tvShowsList) {
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
//        Glide.with(holder.itemView.getContext())
//                .load("https://image.tmdb.org/t/p/w200/" + tvShowsList.get(position).ge())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25)))
//                .into(holder.ivProfil);
//        holder.tvMovie.setText(tvShowsList.get(position).g());

    }

    @Override
    public int getItemCount() {
        return tvShowsList.size();
    }

    public void appendList(List<TvShows> extraTvShows) {
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
