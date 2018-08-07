package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionButton;
import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpellsFragment extends Fragment {

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private ListView listViewConjuros;

    private FloatingActionButton conjurosFab;

    public SpellsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spells, container, false);

        if(view != null){

            dbHelper         = new DBHelper(getActivity());
            db               = dbHelper.getWritableDatabase();
            listViewConjuros = view.findViewById(android.R.id.list);
            conjurosFab      = view.findViewById(R.id.conjurosFab);


            conjurosFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    conjurosFabMetodo();
                }
            });


            //Metodo para recuperar la atencion del listView para poder scrollear
            listViewConjuros.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);

                    return false;
                }
            });



        }
        return view;
    }

    private void conjurosFabMetodo( ){



    }

}
