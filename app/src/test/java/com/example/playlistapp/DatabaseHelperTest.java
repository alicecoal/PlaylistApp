package com.example.playlistapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

import android.database.sqlite.SQLiteDatabase;

import com.example.playlistapp.helper.DatabaseHelper;
import com.example.playlistapp.model.Playlist;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class DatabaseHelperTest{

    private DatabaseHelper databaseHelper;

    @Before
    public void setUp() throws Exception {
        databaseHelper = Mockito.mock(DatabaseHelper.class);
    }
    @Test
    public void getPlaylist() throws Exception {
        ArrayList<Playlist> songsArrayList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        databaseHelper.getAllSongsFromPlaylist();
        verify(databaseHelper).getAllSongsFromPlaylist();
    }
    
    @Test
    public void getSongs() throws Exception {
        ArrayList<Playlist> songsArrayList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        databaseHelper.getAllData();
        verify(databaseHelper).getAllData();
    }
    @After
    public void tearDown() throws Exception {
        groceryListGragment = null;
    }
}
