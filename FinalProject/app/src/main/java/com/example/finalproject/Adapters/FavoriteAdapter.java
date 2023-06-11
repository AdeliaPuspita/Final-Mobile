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
import com.example.finalproject.Models.Favorite;
import com.example.finalproject.Models.Movies;
import com.example.finalproject.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {
    private final List<Favorite> favorites = new ArrayList<>();

    public FavoriteAdapter() {}

    public void addItem(Favorite fav) {
        favorites.add(fav);
        notifyItemInserted(favorites.size() - 1);
    }
    public void removeItem(Favorite favorite) {
        int position = favorites.indexOf(favorite);
        if (position != -1) {
            favorites.remove(position);
            notifyItemRemoved(position);
        }
    }


    public void setData(ArrayList<Favorite> notesList) {
        favorites.clear();
        if (notesList != null) {
            favorites.addAll(notesList);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_favorite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteAdapter.ViewHolder holder, int position) {

        Favorite favorite = favorites.get(position);
        holder.tvNama.setText(favorite.getTvNama());
        holder.tvThn.setText(favorite.getTvTahun());
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w200/" + favorites.get(position).getPoster())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(25)))
                .into(holder.ivLogo );

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
