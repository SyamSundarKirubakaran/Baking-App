package com.bugscript.bakingapp;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridview = findViewById(R.id.gridview);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            gridview.setNumColumns(2);
        }
        gridview.setAdapter(new HomeAdapter(MainActivity.this));
    }
}
