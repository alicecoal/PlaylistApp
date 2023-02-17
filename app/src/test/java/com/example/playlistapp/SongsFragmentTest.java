package com.example.playlistapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class SongsFragmentTest {

    private InsertSongFragment insertSongFragment;

    @Before
    public void setUp() throws Exception {
        insertSongFragment = Mockito.mock(ChangeAlbumListActivity.class);
    }
    @Test
    public void buildDatabase() throws Exception {
        insertSongFragment.SQLiteDataBaseBuild();
        verify(insertSongFragment).SQLiteDataBaseBuild();
    }
    @Test
    public void buildTable() throws Exception {
        insertSongFragment.SQLiteTableBuild();
        verify(insertSongFragment).SQLiteTableBuild();
    }

    @Test
    public void insert() throws Exception {
        insertSongFragment.InsertDataIntoSQLiteDatabase();
        verify(insertSongFragment).InsertDataIntoSQLiteDatabase();
    }

    @After
    public void tearDown() throws Exception {
        insertSongFragment = null;
    }
}