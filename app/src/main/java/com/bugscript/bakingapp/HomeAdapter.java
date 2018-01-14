package com.bugscript.bakingapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by syamsundark on 14/01/18.
 */

public class HomeAdapter extends BaseAdapter {

    private Context mContext;


    public HomeAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CardView cardView;
        TextView dish;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cardView = (CardView) inflater.inflate(R.layout.item_card, parent, false);
            dish=cardView.findViewById(R.id.card_title);
            dish.setText(MainActivity.dishNames[position]);
        } else {
            cardView = (CardView) convertView;
        }
        return cardView;
    }
}
