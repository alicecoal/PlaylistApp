package com.example.playlistapp.model;

public class Playlist {
    private String song;

    public Playlist() {
    }

    public Playlist(String song) {
        this.song = song;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }
}
