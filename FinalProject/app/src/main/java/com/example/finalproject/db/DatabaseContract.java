package com.example.finalproject.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    public static String TABLE_NAME = "favorite";
    public static final class FavoriteColumns implements BaseColumns {

        public static String TITLE = "title";
        public static String BACKDROP = "backDrop";
        public static String POSTER = "poster";
        public static String RELEASE_DATE = "release_date";
        public static String RATE = "rate";
        public static String OVERVIEW = "overview";
        public static String ICON = "icon";

    }
}
