package com.bugscript.bakingapp.Description;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bugscript.bakingapp.MainActivity;
import com.bugscript.bakingapp.R;

/**
 * Created by syamsundark on 14/01/18.
 */

public class StepFragmentContent extends Fragment{

    private StepsAdapter mAdapter;

    public StepFragmentContent() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ingredient_item, container, false);
        RecyclerView IngredList=rootView.findViewById(R.id.rv_ingred);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        IngredList.setLayoutManager(layoutManager);

        IngredList.setHasFixedSize(true);

        int flag=0;
        for(int i = 0; i< MainActivity.shortDescription[DetailedList.id].length; i++){
            if(MainActivity.shortDescription[DetailedList.id][i]==null){
                break;
            }else{
                flag+=1;
            }
        }

        mAdapter = new StepsAdapter(DetailedList.id,flag);
        IngredList.setAdapter(mAdapter);

        return rootView;
    }
}
