package com.bugscript.bakingapp.Description;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bugscript.bakingapp.MainActivity;
import com.bugscript.bakingapp.R;

/**
 * Created by syamsundark on 14/01/18.
 */

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepViewHolder>{

    private static int mTimes;
    private static int mIndex;

    public StepsAdapter(int index,int times) {
        mIndex=index;
        mTimes=times;
    }

    @Override
    public StepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.steps_item_design;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        StepViewHolder viewHolder=new StepViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StepViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mTimes;
    }

    class StepViewHolder extends RecyclerView.ViewHolder{
        TextView stepsToBeDone;
        public StepViewHolder(View itemView) {
            super(itemView);
            stepsToBeDone=itemView.findViewById(R.id.tv_step_name);
        }
        void bind(int listIndex) {
            stepsToBeDone.setText(MainActivity.shortDescription[mIndex][listIndex]);
        }
    }

}
