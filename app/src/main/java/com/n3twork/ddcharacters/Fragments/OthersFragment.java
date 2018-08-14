package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import com.n3twork.ddcharacters.Adapters.HitosAdaptador;
import com.n3twork.ddcharacters.Adapters.IdiomasAdaptador;
import com.n3twork.ddcharacters.Adapters.MisionesAdaptador;
import com.n3twork.ddcharacters.Clases.Dotes;
import com.n3twork.ddcharacters.Clases.Especiales;
import com.n3twork.ddcharacters.Clases.Hitos;
import com.n3twork.ddcharacters.Clases.Idiomas;
import com.n3twork.ddcharacters.Clases.Misiones;
import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthersFragment extends Fragment {

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    private ListView listViewDote, listViewAptitudes, listViewIdioma, listViewMisiones, listViewHitos;

    private String aux_id = "";
    private String aux_dotes = "";
    private String aux_pag = "";
    private String aux_ident = "";
    private String aux_aptitudes = "";
    private String aux_idiomas = "";
    private String aux_mision = "";
    private String aux_descp  = "";
    private String aux_hito = "";

    private String[] opciones = new String[]{"Borrar"};

    private FloatingActionButton dotesFab, aptitudesFab, idiomasFab, misionesFab, hitosFab;

    private DotesAdaptador dotesAdaptador;
    private EspecialesAdaptador especialesAdaptador;
    private IdiomasAdaptador idiomasAdaptador;
    private MisionesAdaptador misionesAdaptador;
    private HitosAdaptador hitosAdaptador;

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
            listViewMisiones    = view.findViewById(R.id.listViewMisiones);
            listViewHitos       = view.findViewById(R.id.listViewHitos);
            dotesFab            = view.findViewById(R.id.dotesFab);
            aptitudesFab        = view.findViewById(R.id.aptitudesFab);
            idiomasFab          = view.findViewById(R.id.idiomasFab);
            misionesFab         = view.findViewById(R.id.misionesFab);
            hitosFab            = view.findViewById(R.id.hitosFab);

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

            misionesFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        misionesFabMetodo("  Nueva misión", aux_id);
                }
            });

            hitosFab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        hitosFabMetodo("  Nuevo hito", aux_id);
                }
            });

            listViewDote.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);

                    return false;
                }
            });

            listViewAptitudes.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);

                    return false;
                }
            });

            listViewIdioma.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);

                    return false;
                }
            });

            listViewMisiones.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);

                    return false;
                }
            });

            listViewHitos.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    v.getParent().requestDisallowInterceptTouchEvent(true);

                    return false;
                }
            });

        }

        return view;
    }

    private void hitosFabMetodo(String title, final String aux_id){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_hitos, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView textViewTitleHito = viewInflated.findViewById(R.id.tvTitleHito);
        final EditText editTextHito      = viewInflated.findViewById(R.id.editTextHito);

        textViewTitleHito.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                aux_hito = editTextHito.getText().toString();
                int id = Integer.parseInt(aux_id);
                agregarHito(aux_hito, id);
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

    private void agregarHito(String aux_hito, int id){

        Hitos hitos = new Hitos(aux_hito, id);
        dbHelper = new DBHelper(getContext());
        dbHelper.addHitos(hitos);

    }

    private void misionesFabMetodo(String title, final String aux_id){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_misiones, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        final TextView textViewTitleMisiones = viewInflated.findViewById(R.id.tvTitleMisiones);
        final EditText editTextMision        = viewInflated.findViewById(R.id.editTextMision);
        final EditText editTextDescripcion   = viewInflated.findViewById(R.id.editTextDescripcion);

        textViewTitleMisiones.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                aux_mision = editTextMision.getText().toString();
                aux_descp  = editTextDescripcion.getText().toString();
                int id = Integer.parseInt(aux_id);
                agregarMision(aux_mision, aux_descp, id);
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

    private void agregarMision(String aux_mision, String aux_desc, int id){

        Misiones misiones = new Misiones(aux_mision, aux_desc, id);
        dbHelper = new DBHelper(getContext());
        dbHelper.addMisiones(misiones);

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

            Cursor cursor4 = dbHelper.obtenerTodasMisiones();

            String[] from4 = new String[]{
                    "_id",
                    "misiones",
                    "descMision"
            };

            int[] to4 = new int[]{
                    R.id.identMisiones,
                    R.id.textViewMision,
                    R.id.textViewDescMision
            };

            misionesAdaptador = new MisionesAdaptador(getContext(), cursor4, from4, to4, 0);
            listViewMisiones.setAdapter(misionesAdaptador);

            listViewMisiones.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textViewIndet = view.findViewById(R.id.identMisiones);

                    aux_ident = textViewIndet.getText().toString();

                    dialogOpcionesMisiones(opciones, aux_ident);

                    return true;
                }
            });

            Cursor cursor5 = dbHelper.obtenerTodosHitos();

            String[] from5 = new String[]{
                    "_id",
                    "hitos"
            };

            int[] to5 = new int[]{
                    R.id.identHitos,
                    R.id.textViewHitos
            };

            hitosAdaptador = new HitosAdaptador(getContext(), cursor5, from5, to5, 0);
            listViewHitos.setAdapter(hitosAdaptador);

            listViewHitos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textViewIdent = view.findViewById(R.id.identHitos);

                    aux_ident = textViewIdent.getText().toString();

                    dialogOpcionesHitos(opciones, aux_ident);

                    return true;
                }
            });

        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }

    }

    private void dialogOpcionesHitos(String[] opciones, final String aux_ident){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){

                    try {

                        db = dbHelper.getReadableDatabase();
                        db.delete("hitosTab", "_id='" + aux_ident + "'", null);
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

    private void dialogOpcionesMisiones(String[] opciones, final String aux_ident){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                if(position == 0){

                    try {

                        db = dbHelper.getReadableDatabase();
                        db.delete("misionesTab", "_id='" + aux_ident + "'", null);
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
