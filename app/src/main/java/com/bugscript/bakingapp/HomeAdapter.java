package com.bugscript.bakingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bugscript.bakingapp.Description.DetailedList;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by syamsundark on 14/01/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private Context mContext;

    public HomeAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.dish.setText(MainActivity.dishNames[position]);
        holder.dishImageLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(mContext, DetailedList.class);
                i.putExtra("id",position);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return MainActivity.dishNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.card_title) TextView dish;
        @BindView(R.id.itemcardImage) ImageView dishImageLoad;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
