package com.example.finalproject.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Models.Favorite;
import com.example.finalproject.R;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private final List<Favorite> favorites;


    public FavoriteAdapter(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPp , ivLogo;
        TextView tvNama, tvThn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPp = itemView.findViewById(R.id.iv_pp);
            ivLogo = itemView.findViewById(R.id.iv_Logo);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvThn = itemView.findViewById(R.id.tv_tahun);
        }
    }
}
