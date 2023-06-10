package com.example.finalproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class TvShow implements Parcelable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("first_air_date")
    private String first_air_date;

    @SerializedName("vote_average")
    private String vote_average;

    @SerializedName("poster_path")
    private String poster_path;

    public String getIcon_tv() {
        return icon_tv;
    }

    @SerializedName("icon_tv")
    private String icon_tv;

    protected TvShow(Parcel in) {
        id = in.readString();
        name = in.readString();
        overview = in.readString();
        backdrop_path = in.readString();
        first_air_date = in.readString();
        vote_average = in.readString();
        poster_path = in.readString();
        icon_tv = in.readString();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel in) {
            return new TvShow(in);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getFirst_air_date() {
        return first_air_date;
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
        parcel.writeString(name);
        parcel.writeString(overview);
        parcel.writeString(backdrop_path);
        parcel.writeString(first_air_date);
        parcel.writeString(vote_average);
        parcel.writeString(poster_path);
        parcel.writeString(icon_tv);
    }
}
