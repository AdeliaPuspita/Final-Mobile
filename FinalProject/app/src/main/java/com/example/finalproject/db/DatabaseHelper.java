package com.example.finalproject.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DATABASE_NAME = "Favorite.db";
    private static final int DATABASE_VERSION = 1;

    private static final String SQL_CREATE_TABLE_FAVORITE =
            String.format(
                    "CREATE TABLE %s"
                            + " (%s INTEGER PRIMARY KEY AUTOINCREMENT,"
                            + " %s TEXT NOT NULL,"
                            + " %s TEXT NOT NULL,"
                            + " %s TEXT NOT NULL)",
                    DatabaseContract.TABLE_NAME,
                    DatabaseContract.FavoriteColumns._ID,
                    DatabaseContract.FavoriteColumns.TITLE,
                    DatabaseContract.FavoriteColumns.BACKDROP,
                    DatabaseContract.FavoriteColumns.POSTER,
                    DatabaseContract.FavoriteColumns.RELEASE_DATE,
                    DatabaseContract.FavoriteColumns.OVERVIEW,
                    DatabaseContract.FavoriteColumns.ICON,
                    DatabaseContract.FavoriteColumns.RATE
            );

   public DatabaseHelper(Context context) {
       super(context, DATABASE_NAME, null , DATABASE_VERSION);
   }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DatabaseContract.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
