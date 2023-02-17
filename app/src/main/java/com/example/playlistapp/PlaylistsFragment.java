package com.example.playlistapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.playlistapp.adapter.PlaylistAdapter;
import com.example.playlistapp.helper.DatabaseHelper;
import com.example.playlistapp.model.Playlist;

import java.util.ArrayList;

public class PlaylistsFragment extends Fragment {

    public static final String TITLE= "Playlists";
    Playlist playlist;
    ListView  listView;
    PlaylistAdapter adapterPlaylist;
    Button btnback;
    ArrayList<Playlist> playlists;
    SQLiteDatabase sqLiteDatabaseObj;
    private static final String TABLE_NAME = "AndroidJSonTable";
    public static final String TAG= PlaylistsFragment.class.getSimpleName();
    int isSelectedValue = 0;

    public static PlaylistsFragment newInstance(){
        return new PlaylistsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_second,container,false);
        listView = rootView.findViewById(R.id.listViewOrder);

        btnback = rootView.findViewById(R.id.btnBack);
        DatabaseHelper helper = new DatabaseHelper(rootView.getContext());

        if(helper.getAllSongsFromPlaylist() == null){
            String [] values = new String[]{"Jazz","Pop","Rock","Classical","Rap","WorldMusic","Metal","Electronic","Blues","Indie","Alternative","R&B","RetroPop","BardMusic","Country","Punk","Reggae","Dried Produce","RussianChanson","NatureSounds","EasyListening","Dance","Ska","BackgroundMusic","Hip-Hop"};
            final ArrayList<Playlist> arrayList = new ArrayList<>();
            for (int i = 0; i < values.length; ++i){
                arrayList.add(new Playlist(values[i]));
            }
            final PlaylistAdapter adapter = new PlaylistAdapter(arrayList,getActivity());
            listView.setAdapter(adapter);
        } else {
            playlists = helper.getAllSongsFromPlaylist();
            for (int i = 0; i< playlists.size(); i++){
               playlist = playlists.get(i);
               Log.e(TAG,"songs data :" + playlist.getSong());
            }
            adapterPlaylist = new PlaylistAdapter(playlists,rootView.getContext());
            listView.setAdapter(adapterPlaylist);
        }

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            for (Playlist p: playlists){
                Log.e(TAG,"Songs are :" + p.getSong());
                isSelectedValue =0;
                SQLiteDataBaseBuild();
                SQLiteTableBuild();
                InsertDataIntoSQLiteDatabase();
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
            }
        });
        return  rootView;
    }

    public void InsertDataIntoSQLiteDatabase() {
        Log.e(TAG,"Songs Value Checked : "+ playlist.getSong());
        for(int i = 0; i< playlists.size(); i++){
            sqLiteDatabaseObj.execSQL("UPDATE "+TABLE_NAME+" SET isSubmitted = "+"'"+isSelectedValue+"' "
                    + "WHERE name = "+"'"+ playlist.getSong()+"'");
        }
    }
    public void SQLiteTableBuild(){
        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS AndroidJSonTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR,isSubmitted Integer);");
    }

    public void SQLiteDataBaseBuild(){
        sqLiteDatabaseObj = getActivity().openOrCreateDatabase("AndroidJSonDataBase", Context.MODE_PRIVATE, null);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
