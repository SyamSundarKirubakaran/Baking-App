package com.bugscript.bakingapp.Steps;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bugscript.bakingapp.Description.DetailedList;
import com.bugscript.bakingapp.MainActivity;
import com.bugscript.bakingapp.R;

public class FullDescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_description);
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(MainActivity.dishNames[DetailedList.id]);
        }
        FullDescriptionFragment fullDescriptionFragment=new FullDescriptionFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.main_desc, fullDescriptionFragment)
                .commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportActionBar().hide();
        }else{
            getSupportActionBar().show();
        }
    }
}
