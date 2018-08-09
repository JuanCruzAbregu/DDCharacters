package com.n3twork.ddcharacters.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.widget.SimpleCursorAdapter;

import com.n3twork.ddcharacters.R;

public class IdiomasAdaptador extends SimpleCursorAdapter {

    private Cursor cursor;

    /**
     * Constructor con un sólo parámetro
     *
     * @param context
     */

    public IdiomasAdaptador(Context context, Cursor cursor, String[] from, int[] to, int flags) {
        super(context, R.layout.list_idiomas_item_row, cursor, from, to, flags);
        this.cursor = cursor;
    }

}
