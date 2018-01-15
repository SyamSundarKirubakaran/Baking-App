package com.bugscript.bakingapp.Steps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bugscript.bakingapp.R;

/**
 * Created by syamsundark on 15/01/18.
 */

public class FullDescriptionFragment extends Fragment{

    public FullDescriptionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmet_full_desc, container, false);
        return rootView;
    }

}
