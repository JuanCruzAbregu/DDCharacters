package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.n3twork.ddcharacters.Adapters.DotesAdaptador;
import com.n3twork.ddcharacters.Adapters.EspecialesAdaptador;
import com.n3twork.ddcharacters.Adapters.IdiomasAdaptador;
import com.n3twork.ddcharacters.Clases.Dotes;
import com.n3twork.ddcharacters.Clases.Especiales;
import com.n3twork.ddcharacters.Clases.Idiomas;
import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthersFragment extends Fragment {

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    private ListView listViewDote, listViewAptitudes, listViewIdioma;

    private String aux_id = "";
    private String aux_dotes = "";
    private String aux_pag = "";
    private String aux_ident = "";
    private String aux_aptitudes = "";
    private String aux_idiomas = "";

    private String[] opciones = new String[]{"Borrar"};

    private FloatingActionButton dotesFab, aptitudesFab, idiomasFab;

    private DotesAdaptador dotesAdaptador;
    private EspecialesAdaptador especialesAdaptador;
    private IdiomasAdaptador idiomasAdaptador;

    public OthersFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_others, container, false);

        if(view != null){

            dbHelper            = new DBHelper(getActivity());
            db                  = dbHelper.getWritableDatabase();
            listViewDote        = view.findViewById(android.R.id.list);
            listViewAptitudes   = view.findViewById(R.id.listViewAptitudes);
            listViewIdioma      = view.findViewById(R.id.listViewIdiomas);
            dotesFab            = view.findViewById(R.id.dotesFab);
            aptitudesFab        = view.findViewById(R.id.aptitudesFab);
            idiomasFab          = view.findViewById(R.id.idiomasFab);

            aux_id = recuperarIDPersonaje();
            recuperarTodosLosOtros(aux_id);

            dotesFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dotesFabMetodo("  Nuevo dote", aux_id);
                }
            });

            aptitudesFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aptitudesFabMetodo("  Nueva aptitud especial", aux_id);
                }
            });

            idiomasFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    idiomasFabMetodo("  Nuevo idioma", aux_id);
                }
            });


        }


        return view;
    }

    private void idiomasFabMetodo(String title, final String aux_id){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_idiomas, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView textViewTitleIdiomas = viewInflated.findViewById(R.id.tvTitleIdiomas);
        final EditText editTextIdiomas      = viewInflated.findViewById(R.id.editTextIdiomas);

        textViewTitleIdiomas.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                aux_idiomas = editTextIdiomas.getText().toString();
                int id = Integer.parseInt(aux_id);
                agregarIdiomas(aux_idiomas, id);
                recuperarTodosLosOtros(aux_id);


            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void agregarIdiomas(String aux_idiomas, int id){

        Idiomas idiomas = new Idiomas(aux_idiomas, id);
        dbHelper = new DBHelper(getContext());
        dbHelper.addIdiomas(idiomas);

    }

    private void aptitudesFabMetodo(String title, final String aux_id){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_aptitudes, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView tvTitleAptitudes  = viewInflated.findViewById(R.id.tvTitleAptitudes);
        final EditText editTextAptitudes = viewInflated.findViewById(R.id.editTextAptitudes);

        tvTitleAptitudes.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                aux_aptitudes = editTextAptitudes.getText().toString();
                int id = Integer.parseInt(aux_id);
                agregarAptitudes(aux_aptitudes, id);
                recuperarTodosLosOtros(aux_id);


            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void agregarAptitudes(String aux_aptitudes, int id){

        Especiales especiales = new Especiales(aux_aptitudes, id);
        dbHelper = new DBHelper(getContext());
        dbHelper.addEspeciales(especiales);

    }

    private void dotesFabMetodo(String title, final String aux_id){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_dotes, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView textViewTitleDotes  = viewInflated.findViewById(R.id.textViewTitleDotes);
        final EditText editTextDotes       = viewInflated.findViewById(R.id.editTextDotes);
        final EditText editTextPaginaDotes = viewInflated.findViewById(R.id.editTextPaginaDotes);

        textViewTitleDotes.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                aux_dotes = editTextDotes.getText().toString();
                aux_pag   = editTextPaginaDotes.getText().toString();
                int id    = Integer.parseInt(aux_id);

                agregarDotes(aux_dotes, aux_pag, id);
                recuperarTodosLosOtros(aux_id);

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();;


    }

    private void agregarDotes(String aux_dotes, String aux_pag, int id){

        Dotes dotes = new Dotes(aux_dotes, aux_pag, id);
        dbHelper = new DBHelper(getContext());
        dbHelper.addDotes(dotes);

    }

    private String recuperarIDPersonaje(){

        try {

            db = dbHelper.getReadableDatabase();
            Cursor c = db
                    .rawQuery("SELECT _id FROM personaje WHERE controlAct='1'", null);

            if(c.moveToFirst()){

                do{

                    aux_id = c.getString(0);


                }while (c.moveToNext());
            }

        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }

        return aux_id;

    }

    private void recuperarTodosLosOtros(final String aux_id){

        try {

            db = dbHelper.getReadableDatabase();
            Cursor cursor = dbHelper.obternerTodosDotes();

            String[] from = new String[]{
                    "_id",
                    "dote",
                    "pagina"
            };

            int[] to = new int[]{
                    R.id.identDotes,
                    R.id.textViewDotes,
                    R.id.textViewPagina
            };

            dotesAdaptador = new DotesAdaptador(getContext(), cursor, from, to, 0);
            listViewDote.setAdapter(dotesAdaptador);

            listViewDote.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textViewIdent = view.findViewById(R.id.identDotes);

                    aux_ident = textViewIdent.getText().toString();

                    dialogOpcionesDotes(opciones, aux_ident);

                    return true;
                }
            });

            Cursor cursor2 = dbHelper.obternerTodosEspeciales();

            String[] from2 = new String[]{
                    "_id",
                    "aptitudesEsp"
            };

            int[] to2 = new int[]{
                    R.id.identAptitudes,
                    R.id.textViewAptitudes
            };

            especialesAdaptador = new EspecialesAdaptador(getContext(), cursor2, from2, to2, 0);
            listViewAptitudes.setAdapter(especialesAdaptador);

            listViewAptitudes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textViewIdent = view.findViewById(R.id.identAptitudes);

                    aux_ident = textViewIdent.getText().toString();

                    dialogOpcionesAptitudes(opciones, aux_ident);


                    return true;
                }
            });

            Cursor cursor3 = dbHelper.obternerTodosIdiomas();

            String[] from3 = new String[]{
                    "_id",
                    "idiomas"
            };

            int[] to3 = new int[]{
                    R.id.identIdiomas,
                    R.id.textViewIdiomas
            };

            idiomasAdaptador = new IdiomasAdaptador(getContext(), cursor3, from3, to3, 0);
            listViewIdioma.setAdapter(idiomasAdaptador);

            listViewIdioma.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textViewIdent = view.findViewById(R.id.identIdiomas);

                    aux_ident = textViewIdent.getText().toString();

                    dialogOpcionesIdiomas(opciones, aux_ident);

                    return true;
                }
            });


        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }

    }

    private void dialogOpcionesIdiomas(String[] opciones, final String aux_ident){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){

                    try {

                        db = dbHelper.getReadableDatabase();
                        db.delete("idiomasTab", "_id='" + aux_ident + "'", null);
                        recuperarTodosLosOtros(aux_id);


                    }catch (Exception e){
                        Log.e("Error", "Error: "+e.getMessage());
                    }

                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void dialogOpcionesAptitudes(String[] opciones, final String aux_ident){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){

                    try {

                        db = dbHelper.getReadableDatabase();
                        db.delete("especiales", "_id='" + aux_ident + "'", null);
                        recuperarTodosLosOtros(aux_id);

                    }catch (Exception e){
                        Log.e("Error", "Error: "+e.getMessage());
                    }

                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void dialogOpcionesDotes(String[] opciones, final String aux_ident){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){

                    try {

                        db = dbHelper.getReadableDatabase();
                        db.delete("dotesTab", "_id='" + aux_ident + "'", null);
                        recuperarTodosLosOtros(aux_id);


                    }catch (Exception e){
                        Log.e("Error", "Error: "+e.getMessage());
                    }

                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

}
