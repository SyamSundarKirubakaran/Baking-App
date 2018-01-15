package com.bugscript.bakingapp.Steps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bugscript.bakingapp.Description.DetailedList;
import com.bugscript.bakingapp.Description.StepFragmentContent;
import com.bugscript.bakingapp.MainActivity;
import com.bugscript.bakingapp.R;
import com.google.android.exoplayer2.ExoPlayer;

/**
 * Created by syamsundark on 15/01/18.
 */

public class FullDescriptionFragment extends Fragment{

    public FullDescriptionFragment() {
    }

    private int tempSelection=StepFragmentContent.currentSelection;
    private TextView shortDesc;
    private TextView completeDesc;
    private FrameLayout mPlayer;
    private int tempoFlag =StepFragmentContent.ultimateFlag;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_left:
                    if(tempSelection>0) {
                        tempSelection -= 1;
                        updatelist();
                    }else{
                        Toast.makeText(getContext(),"No Previous Contents",Toast.LENGTH_SHORT).show();
                    }
                    return true;
                case R.id.navigation_right:
                    if(tempSelection<tempoFlag-1) {
                        tempSelection+=1;
                        updatelist();
                    }else{
                        Toast.makeText(getContext(),"Can't navigate furthur",Toast.LENGTH_SHORT).show();
                    }
                    return true;
            }
            return false;
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmet_full_desc, container, false);
        shortDesc=rootView.findViewById(R.id.complete_short_desc);
        completeDesc=rootView.findViewById(R.id.complete_desc);
        mPlayer=rootView.findViewById(R.id.video_frame_layout);
        updatelist();
        BottomNavigationView navigation = rootView.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        return rootView;
    }

    private void updatelist(){
        if(MainActivity.videoURL[DetailedList.id][tempSelection].equals("")){
            mPlayer.setVisibility(View.GONE);
        }else{
            mPlayer.setVisibility(View.VISIBLE);
        }
        shortDesc.setText(MainActivity.shortDescription[DetailedList.id][tempSelection]);
        completeDesc.setText(MainActivity.description[DetailedList.id][tempSelection]);
    }

}
