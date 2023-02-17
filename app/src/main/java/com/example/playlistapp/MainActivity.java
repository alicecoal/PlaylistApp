package com.example.playlistapp;

import android.os.Bundle;

import com.example.playlistapp.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Toolbar mToolbar;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabLayout;

    Button btnAdd;
    Button btnSubmit;

    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        btnAdd = findViewById(R.id.addProduct);
        btnSubmit = findViewById(R.id.submit);

        linearLayout = findViewById(R.id.fragment_container);
        setViewPager();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAdd.setVisibility(View.GONE);
                btnSubmit.setVisibility(View.GONE);
                mViewPager.setVisibility(View.GONE);
                linearLayout.setVisibility(View.VISIBLE);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                InsertSongFragment insertSongFragment = new InsertSongFragment();
                fragmentTransaction.add(R.id.fragment_container, insertSongFragment,"Add Song");
                fragmentTransaction.commit();
            }
        });
    }

    public void setViewPager(){
        mViewPager = findViewById(R.id.pager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

        mTabLayout = findViewById(R.id.tab);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
