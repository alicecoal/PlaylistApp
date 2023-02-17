package com.example.playlistapp.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.playlistapp.model.Song;
import com.example.playlistapp.model.Playlist;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int version = 1;
    public int isSelectedValue = 1;
    public static final String TAG = DatabaseHelper.class.getSimpleName();

    public DatabaseHelper(@Nullable Context context) {
        super(context, "AndroidJSonDataBase", null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
         sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS AndroidJSonTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR, isSubmitted Integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int a, int b) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+"AndroidJSonTable");
    }

    public void insertData(SQLiteDatabase sqLiteDatabase, Song song){
        sqLiteDatabase.execSQL("INSERT INTO AndroidJSonTable (name) VALUES('"+song+"');");
   }

    public ArrayList<Song> getAllData(){
        ArrayList<Song> songArrayList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor res= database.rawQuery("Select * from "+"AndroidJSonTable",null);
        Log.e(TAG,"res :"+res.toString());
        while (res.moveToNext()){
            String productName = res.getString(1);
            Song song = new Song(productName);
            songArrayList.add(song);
        }
        return songArrayList;
    }

    public ArrayList<Playlist> getAllSongsFromPlaylist(){
        SQLiteDatabase database = this.getWritableDatabase();
        ArrayList<Playlist> songArrayList = new ArrayList<>();
        Cursor cursor = database.rawQuery("Select * from "+"AndroidJSonTable" +" WHERE isSubmitted = "+"'"+isSelectedValue+"' ",null);
        Log.e(TAG,"res :"+cursor.toString());
        while (cursor.moveToNext()){
            String songName = cursor.getString(1);
            Playlist song = new Playlist(songName);
            songArrayList.add(song);
        }
        return  songArrayList;
    }

}
