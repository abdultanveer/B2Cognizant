package com.example.b2cognizant;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.b2cognizant.FeedReaderContract.FeedEntry;


import org.jetbrains.annotations.NotNull;

public class DbAccessObject {
    DbHelper dbHelper;
    SQLiteDatabase database;

    public DbAccessObject(Context mContext){
        dbHelper = new DbHelper(mContext);
    }

    void openDb(){
        database = dbHelper.getWritableDatabase();
    }
   void closeDb(){
        database.close();
   }
    //create

    public void createRow(@NotNull String title, @NotNull String details) {
        ContentValues mapValues = new ContentValues();
        mapValues.put(FeedEntry.COLUMN_NAME_TITLE,title);
        mapValues.put(FeedEntry.COLUMN_NAME_SUBTITLE,details);
        database.insert(FeedEntry.TABLE_NAME,null,mapValues);
    }
    //read
    @NotNull
    public String query() {
        //database.rawQuery("select * from entry",null);
        Cursor cursor = database.query(FeedEntry.TABLE_NAME,null,null,null,null,null,null);
        cursor.moveToLast();
        int titleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE);
        int subtitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE);
        String title = cursor.getString(titleIndex);
        String subtitle = cursor.getString(subtitleIndex);
        return title + "\n"+ subtitle;
    }

    public void createRow(@NotNull Todo todo) {
        ContentValues mapValues = new ContentValues();
        mapValues.put(FeedEntry.COLUMN_NAME_TITLE,todo.getTitle());
        mapValues.put(FeedEntry.COLUMN_NAME_SUBTITLE,todo.getSubTitle());
        database.insert(FeedEntry.TABLE_NAME,null,mapValues);
    }

    //update
    //delete
}
