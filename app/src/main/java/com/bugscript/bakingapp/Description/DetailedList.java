package com.bugscript.bakingapp.Description;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bugscript.bakingapp.R;

public class DetailedList extends AppCompatActivity {

    public static int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list);
        id=getIntent().getExtras().getInt("id");
        IngredFragmentContent contents_1 = new IngredFragmentContent();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.container_1, contents_1)
                .commit();
        StepFragmentContent contents_2=new StepFragmentContent();
        fragmentManager.beginTransaction()
                .add(R.id.container_2, contents_2)
                .commit();
    }
}
