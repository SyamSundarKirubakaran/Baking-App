package com.bugscript.bakingapp.Description;

import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bugscript.bakingapp.MainActivity;
import com.bugscript.bakingapp.R;
import com.bugscript.bakingapp.Steps.FullDescriptionFragment;
import com.bugscript.bakingapp.services.ChangeTitleService;
import com.bugscript.bakingapp.widget.WidgetList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedList extends AppCompatActivity {

    @BindView(R.id.fab) FloatingActionButton floatingActionButton;

    public static int id;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_list);
        id=getIntent().getExtras().getInt("id");
        ButterKnife.bind(this);
        sharedPreferences=getApplicationContext().getSharedPreferences("ingrad_pref",0);
        final SharedPreferences.Editor editor=sharedPreferences.edit();

        if(getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(MainActivity.dishNames[id]);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(id==sharedPreferences.getInt("selection",4)){
            floatingActionButton.setImageDrawable(ContextCompat.getDrawable(DetailedList.this,R.drawable.ic_favorite_white_24px));
        }else{
            floatingActionButton.setImageDrawable(ContextCompat.getDrawable(DetailedList.this,R.drawable.ic_favorite_border_white_24px));
        }

        if(MainActivity.tabletSize){
            IngredFragmentContent contents_1 = new IngredFragmentContent();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.container_1, contents_1)
                    .commit();
            StepFragmentContent contents_2 = new StepFragmentContent();
            fragmentManager.beginTransaction()
                    .add(R.id.container_2, contents_2)
                    .commit();

        }else {

            IngredFragmentContent contents_1 = new IngredFragmentContent();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.container_1, contents_1)
                    .commit();
            StepFragmentContent contents_2 = new StepFragmentContent();
            fragmentManager.beginTransaction()
                    .add(R.id.container_2, contents_2)
                    .commit();
        }

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(id==sharedPreferences.getInt("selection",4))) {
                    editor.putInt("selection", id);
                    editor.putString("dishName", MainActivity.dishNames[id]);
                    editor.commit();
                    ChangeTitleService.startChanging(DetailedList.this);
                    WidgetList.sendRefreshBroadcast(DetailedList.this);
                    floatingActionButton.setImageDrawable(ContextCompat.getDrawable(DetailedList.this,R.drawable.ic_favorite_white_24px));
                }else{
                    editor.putInt("selection", 4);
                    editor.putString("dishName", "NO ITEMS TO SHOW");
                    editor.commit();
                    ChangeTitleService.startChanging(DetailedList.this);
                    WidgetList.sendRefreshBroadcast(DetailedList.this);
                    floatingActionButton.setImageDrawable(ContextCompat.getDrawable(DetailedList.this,R.drawable.ic_favorite_border_white_24px));
                }
            }
        });

    }
}
