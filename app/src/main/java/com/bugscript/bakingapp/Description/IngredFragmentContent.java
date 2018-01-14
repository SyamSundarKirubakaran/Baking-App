package com.bugscript.bakingapp.Description;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bugscript.bakingapp.R;

/**
 * Created by syamsundark on 14/01/18.
 */

public class IngredFragmentContent extends Fragment{

    private static final int NUM_LIST_ITEMS = 50;

    private IngredAdapter mAdapter;

    public IngredFragmentContent() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ingredient_item, container, false);
        RecyclerView IngredList=rootView.findViewById(R.id.rv_ingred);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        IngredList.setLayoutManager(layoutManager);

        IngredList.setHasFixedSize(true);

        mAdapter = new IngredAdapter(NUM_LIST_ITEMS);
        IngredList.setAdapter(mAdapter);


        return rootView;
    }

}
