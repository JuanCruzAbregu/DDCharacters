package com.n3twork.ddcharacters.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.n3twork.ddcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpellsFragment extends Fragment {


    public SpellsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spells, container, false);
    }

}
