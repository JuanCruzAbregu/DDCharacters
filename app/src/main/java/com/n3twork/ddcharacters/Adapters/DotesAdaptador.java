package com.n3twork.ddcharacters.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import com.n3twork.ddcharacters.R;

public class DotesAdaptador extends SimpleCursorAdapter {

    private Cursor cursor;

    /**
     * Constructor con un sólo parámetro
     *
     * @param context
     */

    public DotesAdaptador(Context context, Cursor cursor, String[] from, int[] to, int flags) {
        super(context, R.layout.list_dotes_item_row, cursor, from, to, flags);
        this.cursor = cursor;
    }

}
