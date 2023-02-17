package com.example.playlistapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.playlistapp.SongsFragment;
import com.example.playlistapp.PlaylistsFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public static int TAB_COUNT = 2;
    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return SongsFragment.newInstance();
            case 1:
                return PlaylistsFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return SongsFragment.TITLE;
            case 1:
                return PlaylistsFragment.TITLE;
        }
        return super.getPageTitle(position);
    }
}
