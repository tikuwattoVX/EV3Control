package com.example.sample.myfragmentapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        int position = getIntent().getIntExtra(TitlesFragment.EXTRA_POSITION, 0);
        DetailFragment detailFragment = DetailFragment.newInstance(position);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.detailFrame, detailFragment)
                .commit();
    }





}
