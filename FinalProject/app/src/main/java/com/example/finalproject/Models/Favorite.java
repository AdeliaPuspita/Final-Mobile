package com.example.finalproject.Models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Favorite implements Parcelable {

     private String ivpp, ivIcon, backdrop, poster;
     private String tvNama, tvTahun, releasedate, rate, overview;

     public Favorite() {
          this.ivpp = ivpp;
          this.ivIcon = ivIcon;
          this.backdrop = backdrop;
          this.poster = poster;
          this.tvNama = tvNama;
          this.tvTahun = tvTahun;
          this.releasedate = releasedate;
          this.rate = rate;
          this.overview = overview;
     }


     protected Favorite(Parcel in) {
          ivpp = in.readString();
          ivIcon = in.readString();
          backdrop = in.readString();
          poster = in.readString();
          tvNama = in.readString();
          tvTahun = in.readString();
          releasedate = in.readString();
          rate = in.readString();
          overview = in.readString();
     }

     public static final Creator<Favorite> CREATOR = new Creator<Favorite>() {
          @Override
          public Favorite createFromParcel(Parcel in) {
               return new Favorite(in);
          }

          @Override
          public Favorite[] newArray(int size) {
               return new Favorite[size];
          }
     };

     public String getIvpp() {
          return ivpp;
     }

     public void setIvpp(String ivpp) {
          this.ivpp = ivpp;
     }

     public String getIvIcon() {
          return ivIcon;
     }

     public void setIvIcon(String ivIcon) {
          this.ivIcon = ivIcon;
     }

     public String getBackdrop() {
          return backdrop;
     }

     public void setBackdrop(String backdrop) {
          this.backdrop = backdrop;
     }

     public String getPoster() {
          return poster;
     }

     public void setPoster(String poster) {
          this.poster = poster;
     }

     public String getTvNama() {
          return tvNama;
     }

     public void setTvNama(String tvNama) {
          this.tvNama = tvNama;
     }

     public String getTvTahun() {
          return tvTahun;
     }

     public void setTvTahun(String tvTahun) {
          this.tvTahun = tvTahun;
     }

     public String getReleasedate() {
          return releasedate;
     }

     public void setReleasedate(String releasedate) {
          this.releasedate = releasedate;
     }

     public String getRate() {
          return rate;
     }

     public void setRate(String rate) {
          this.rate = rate;
     }

     public String getOverview() {
          return overview;
     }

     public void setOverview(String overview) {
          this.overview = overview;
     }

     @Override
     public int describeContents() {
          return 0;
     }

     @Override
     public void writeToParcel(@NonNull Parcel parcel, int i) {
          parcel.writeString(ivpp);
          parcel.writeString(ivIcon);
          parcel.writeString(backdrop);
          parcel.writeString(poster);
          parcel.writeString(tvNama);
          parcel.writeString(tvTahun);
          parcel.writeString(releasedate);
          parcel.writeString(rate);
          parcel.writeString(overview);
     }
}


