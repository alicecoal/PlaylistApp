package com.example.playlistapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.playlistapp.adapter.SongAdapter;
import com.example.playlistapp.helper.DatabaseHelper;
import com.example.playlistapp.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongsFragment extends Fragment {

    public static final String TITLE= "Songs";

    ListView listView;

    List<String> items = new ArrayList<String>();

    Song song;

    Button btnAdd;
    Button btnSubmit;
    SongAdapter adapter;

    LinearLayout linearLayout;
    public static final String TAG = SongsFragment.class.getSimpleName();

    String SQLiteDataBaseQueryHolder;

    SQLiteDatabase sqLiteDatabaseObj;

    public ArrayList<Song> getData;
    private static final String TABLE_NAME = "AndroidJSonTable";
    int isSelectedValue = 0;
    public static SongsFragment newInstance(){
        return new SongsFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View rootView = inflater.inflate(R.layout.fragment_first,container,false);
        listView = rootView.findViewById(R.id.listView1);

        btnAdd =rootView. findViewById(R.id.btnAdd1);
        btnSubmit = rootView.findViewById(R.id.btnSubmit1);
        linearLayout = rootView.findViewById(R.id.fragment_container1);

        DatabaseHelper helper = new DatabaseHelper(rootView.getContext());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  adapter.getProductsList();
               getData = adapter.getProductsList();

                for(Song p :getData){
                    Log.e(TAG,"getData :"+p.getSong());
                    Log.e(TAG,"isChecked Value :"+p.getIsSubmitted());
                    isSelectedValue = 1;
                    SQLiteDataBaseBuild();
                    SQLiteTableBuild();
                   InsertDataIntoSQLiteDatabase();
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAdd.setVisibility(View.GONE);
                btnSubmit.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager =getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                InsertSongFragment insertSongFragment = new InsertSongFragment();
                fragmentTransaction.add(R.id.fragment_container1, insertSongFragment,"Add Song");
                fragmentTransaction.commit();
            }
        });
        if(helper.getAllData() == null){
             String [] values = new String[]{"Canned & Jarred Food","Cereal & Muesli","Baking Supplies","Dried Fruits","Nuts & Seeds","Jams","Honey","Spreads","Poultry & Seafood","Pasta & Noodles","Cheese","Beer","Milk","Cereals","Frozen dinners","Oil & Fat","Condiments","Dried Produce","Soups","Dairy","Pasta","Salad Dressings","Sauces","Eggs","Tea and coffee"};

            final ArrayList<Song> arrayList = new ArrayList<>();

        for(int i=0;i<values.length;++i){
            arrayList.add(new Song(values[i]));
        }
            final SongAdapter adapter1 = new SongAdapter(arrayList,getActivity());
             listView.setAdapter((ListAdapter) adapter1);
        }else {
            final ArrayList<Song> songs = helper.getAllData();

            for(int i = 0; i< songs.size(); i++){
                 song = songs.get(i);
                Log.e(TAG,"songs data :"+ song.getSong());
              //  products.add(product);
            }
            Log.e(TAG,"songs :"+ songs);

            adapter = new SongAdapter(songs,rootView.getContext());

            listView.setAdapter(adapter);
        }

        return rootView;
    }

    public void InsertDataIntoSQLiteDatabase() {
         Log.e(TAG,"songs Value Checked : "+ song.getSong());
         for(int i=0;i<getData.size();i++){
             sqLiteDatabaseObj.execSQL("UPDATE "+TABLE_NAME+" SET isSubmitted = "+"'"+isSelectedValue+"' "+ "WHERE name = "+"'"+ song.getSong()+"'");
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
