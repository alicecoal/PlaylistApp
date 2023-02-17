package com.example.playlistapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

@RunWith(JUnit4.class)
public class PlaylistsFragmentTest {

    private PlaylistsFragment playlistsFragment;

    @Before
    public void setUp() throws Exception {
        playlistsFragment = Mockito.mock(ChangeAlbumListActivity.class);
    }
    @Test
    public void buildDatabase() throws Exception {
        playlistsFragment.SQLiteDataBaseBuild();
        verify(playlistsFragment).SQLiteDataBaseBuild();
    }
    @Test
    public void buildTable() throws Exception {
        playlistsFragment.SQLiteTableBuild();
        verify(playlistsFragment).SQLiteTableBuild();
    }

    @Test
    public void insert() throws Exception {
        playlistsFragment.InsertDataIntoSQLiteDatabase();
        verify(playlistsFragment).InsertDataIntoSQLiteDatabase();
    }

    @After
    public void tearDown() throws Exception {
        playlistsFragment = null;
    }
}