package com.example.b2cognizant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import com.example.b2cognizant.FeedReaderContract.FeedEntry;

/**
 * to help me create a db and its tables
 */
public class DbHelper extends SQLiteOpenHelper {
//"CREATE TABLE entry (_id INTEGER PRIMARY KEY,title TEXT,subtitle TEXT)"
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NAME_TITLE + " TEXT," +
                    FeedEntry.COLUMN_NAME_SUBTITLE + " TEXT)";

    public DbHelper(@Nullable Context context){
        super(context, "todoDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
