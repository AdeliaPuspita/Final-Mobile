package com.example.finalproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Movies implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("vote_average")
    private String vote_average;

    @SerializedName("poster_path")
    private String poster_path;

    public String getIcon_movie() {
        return icon_movie;
    }

    @SerializedName("icon_movie")
    private String icon_movie;

    protected Movies(Parcel in) {
        id = in.readString();
        title = in.readString();
        overview = in.readString();
        backdrop_path = in.readString();
        release_date = in.readString();
        vote_average = in.readString();
        poster_path = in.readString();
        icon_movie = in.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel in) {
            return new Movies(in);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getPoster_path() {
        return poster_path;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(overview);
        parcel.writeString(backdrop_path);
        parcel.writeString(release_date);
        parcel.writeString(vote_average);
        parcel.writeString(poster_path);
        parcel.writeString(icon_movie);
    }
}
