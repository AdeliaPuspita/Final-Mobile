package com.example.finalproject;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.finalproject.Models.Favorite;
import com.example.finalproject.db.DatabaseContract;
import com.example.finalproject.db.DatabaseHelper;

import java.util.ArrayList;

public class FavoriteHelper {
    private static final String DATABASE_TABLE = DatabaseContract.TABLE_NAME;
    private static DatabaseHelper databaseHelper;
    private static SQLiteDatabase database;
    private static volatile FavoriteHelper INSTANCE;

    private FavoriteHelper(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public static FavoriteHelper getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (SQLiteOpenHelper.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FavoriteHelper(context);
                }
            }
        }
        return INSTANCE;
    }

    public void open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
    }

    public void close() {
        databaseHelper.close();
        if (database.isOpen()) {
            database.close();
        }
    }

    public ArrayList<Favorite> getAllNotes() {
        ArrayList<Favorite> favoriteList = new ArrayList<>();
        Cursor cursor = database.query(
                DATABASE_TABLE,
                null,
                null,
                null,
                null,
                null,
                DatabaseContract.FavoriteColumns._ID + " DESC"
        );
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Favorite favorite = getFavoriteFromCursor(cursor);
            favoriteList.add(favorite);
            cursor.moveToNext();
        }
        cursor.close();
        return favoriteList;
    }

    private Favorite getFavoriteFromCursor(Cursor cursor) {
        Favorite favorite = new Favorite();
        favorite.setTvNama(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.TITLE)));
        favorite.setBackdrop(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.BACKDROP)));
        favorite.setPoster(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.POSTER)));
        favorite.setRate(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.RATE)));
        favorite.setReleasedate(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.RELEASE_DATE)));
        favorite.setOverview(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.OVERVIEW)));
        favorite.setIvIcon(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FavoriteColumns.ICON)));

        return favorite;
    }

    public Cursor queryById(String id) {
        return database.query(
                DATABASE_TABLE,
                null,
                DatabaseContract.FavoriteColumns._ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null
        );
    }

    public static long insert(ContentValues values) {
        return database.insert(DATABASE_TABLE, null, values);
    }

    public static int update(String id, ContentValues values) {
        return database.update(DATABASE_TABLE, values, DatabaseContract.FavoriteColumns._ID
                + " = ?", new String[]{id});
    }

    public int deleteById(String id) {
        return database.delete(DATABASE_TABLE, DatabaseContract.FavoriteColumns._ID + " = "
                + id, null);
    }

    @SuppressLint("Range")
    public ArrayList<Favorite> fav (String searchText) {
        ArrayList<Favorite> searchResults = new ArrayList<>();

        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String query = "SELECT * FROM " + DatabaseContract.TABLE_NAME + " WHERE " + DatabaseContract.FavoriteColumns.TITLE + " LIKE '" + searchText + "%'";
        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Favorite favorite = getFavoriteFromCursor(cursor);
                searchResults.add(favorite);
            }
        }

        if (cursor != null) {
            cursor.close();
        }

        return searchResults;
    }
}

