package com.n3twork.ddcharacters.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import com.n3twork.ddcharacters.R;

/**
 * Created by N3TWORK on 21/2/2018.
 */

public class PersonajeAdaptador extends SimpleCursorAdapter {

    private Cursor cursor;

    /**
     * Constructor con un sólo parámetro
     *
     * @param context
     */

    public PersonajeAdaptador(Context context, Cursor cursor, String[] from, int[] to, int flags){
        super(context, R.layout.list_view_pj_item_row, cursor, from, to, flags);
        this.cursor = cursor;
    }

}
