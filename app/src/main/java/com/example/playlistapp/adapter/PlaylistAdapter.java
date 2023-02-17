package com.example.playlistapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.playlistapp.R;
import com.example.playlistapp.model.Playlist;

import java.util.ArrayList;

public class PlaylistAdapter extends BaseAdapter {
    private ArrayList<Playlist> productsList;

    private Context context;

    public static final String TAG = PlaylistAdapter.class.getSimpleName();

    public PlaylistAdapter(ArrayList<Playlist> playlists, Context context){
        this.context =context;
        this.productsList = playlists;
    }
    @Override
    public int getCount() {
        return productsList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.productsList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        ViewHolder holder = null;

        if(converView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            converView = inflater.inflate(R.layout.song_item2,null);
            holder = new ViewHolder();

            holder.textViewOrder =converView.findViewById(R.id.textViewOrder);

            converView.setTag(holder);
        }else {
            holder = (ViewHolder) converView.getTag();
        }

        final Playlist playlist = productsList.get(position);
        Log.e(TAG,"products :"+ playlist.getSong());
        holder.textViewOrder.setText(playlist.getSong());

        return converView;
    }

    public static  class ViewHolder{
        public TextView textViewOrder;
    }
}
