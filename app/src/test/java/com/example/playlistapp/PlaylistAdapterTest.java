package com.example.playlistapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import com.example.playlistapp.adapter.PlaylistAdapter;
import com.example.playlistapp.model.Playlist;

import java.util.ArrayList;

@RunWith(JUnit4.class)
public class PlaylistAdapterTest {

    private PlaylistAdapter playlistAdapter;

    @Before
    public void setUp() throws Exception {
        playlistAdapter = Mockito.mock(PlaylistAdapter.class);
    }

    @Test
    public void getCount() throws Exception {
        ArrayList<Playlist> playlist = null;
        assertEquals(playlist.size(),playlistAdapter.getCount());
    }
    @Test
    public void getItem(int position ) throws Exception {
        ArrayList<Playlist> playlist = null;
        assertEquals(playlist.get(position), playlistAdapter.getItem(position));
    }

    @After
    public void tearDown() throws Exception {
        playlistAdapter = null;
    }
}
