package com.bugscript.bakingapp.Description;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bugscript.bakingapp.R;

public class DetailedList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list);
        IngredFragmentContent contents_1 = new IngredFragmentContent();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container_1, contents_1)
                .commit();
    }
}
