package com.example.playlistapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;



import com.example.playlistapp.R;
import com.example.playlistapp.model.Song;

import java.util.ArrayList;

public class SongAdapter extends BaseAdapter {

    private ArrayList<Song> productsList;
    private ArrayList<Song> selectedSongs = new ArrayList<>();

    private Context context;

    public static  final String TAG = SongAdapter.class.getSimpleName();
    public SongAdapter(ArrayList<Song> song, Context cont){
        this.context = cont;
        this.productsList = song;
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
        ViewHolder  holder= null;

        if(converView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            converView = inflater.inflate(R.layout.song_item1,null);
            holder = new ViewHolder();

            holder.textProduct =converView.findViewById(R.id.textView1);
            holder.checkBox = converView.findViewById(R.id.checkBox1);


            converView.setTag(holder);

        }else{
            holder = (ViewHolder) converView.getTag();
        }

        final Song song = productsList.get(position);

        Log.e(TAG,"products :"+ song.getSong());
        holder.textProduct.setText(song.getSong());
        final ViewHolder finalHolder = holder;
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                            Log.e(TAG,"product Value Checked :"+ song.getSong());
                                    song.setIsSubmitted(1);
                                selectedSongs.add(song);
//                                finalHolder.checkBox.setChecked(false);
//                                finalHolder.checkBox.setClickable(false);
//                            getData(product.getProduct());
                }else {
                    song.setIsSubmitted(0);
                    selectedSongs.remove(song);
                    Log.e(TAG,"product Value Not Checked :"+ song.getSong());
                }
            }
        });
        return  converView;
    }

    public ArrayList<Song> getProductsList()
    {
        return selectedSongs;
    }


    private static class ViewHolder{
        public TextView textProduct;
        public CheckBox checkBox;
    }
}
