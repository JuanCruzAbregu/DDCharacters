package com.n3twork.ddcharacters.Fragments;


import android.app.AlertDialog;
import android.content.ContentValues;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.n3twork.ddcharacters.Adapters.ConjurosAdaptador;
import com.n3twork.ddcharacters.Clases.OtrosConjuros;
import com.n3twork.ddcharacters.DB.DBHelper;
import com.n3twork.ddcharacters.R;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpellsFragment extends Fragment {

    private DBHelper dbHelper;
    private SQLiteDatabase db;
    private ListView listViewConjuros;

    private FloatingActionButton conjurosFab, nivelesFab;

    private String aux_dominio = "";
    private String aux_escuela = "";
    private String aux_id = "";
    private String aux_salv = "";
    private String aux_fallo = "";
    private String aux_conoc0 = "";
    private String aux_cd0 = "";
    private String aux_diario0 = "";
    private String aux_adicional0 = "";
    private String aux_conoc1 = "";
    private String aux_cd1 = "";
    private String aux_diario1 = "";
    private String aux_adicional1 = "";
    private String aux_conoc2 = "";
    private String aux_cd2 = "";
    private String aux_diario2 = "";
    private String aux_adicional2 = "";
    private String aux_conoc3 = "";
    private String aux_cd3 = "";
    private String aux_diario3 = "";
    private String aux_adicional3 = "";
    private String aux_conoc4 = "";
    private String aux_cd4 = "";
    private String aux_diario4 = "";
    private String aux_adicional4 = "";
    private String aux_conoc5 = "";
    private String aux_cd5 = "";
    private String aux_diario5 = "";
    private String aux_adicional5 = "";
    private String aux_conoc6 = "";
    private String aux_cd6 = "";
    private String aux_diario6 = "";
    private String aux_adicional6 = "";
    private String aux_conoc7 = "";
    private String aux_cd7 = "";
    private String aux_diario7 = "";
    private String aux_adicional7 = "";
    private String aux_conoc8 = "";
    private String aux_cd8 = "";
    private String aux_diario8 = "";
    private String aux_adicional8 = "";
    private String aux_conoc9 = "";
    private String aux_cd9 = "";
    private String aux_diario9 = "";
    private String aux_adicional9 = "";
    private String aux_ident = "";



    private int control = 0;

    private ConjurosAdaptador conjurosAdaptador;

    private Button buttonSalvConj, buttonFalloArc;

    private TextView textViewSalvConj, textViewFalloArc, tv_conjConoc0, tv_cdSalvacion, tv_conjDiarios, tv_conjAdicionales,
            tv_conjConoc1, tv_cdSalvacion1, tv_conjDiarios1, tv_conjAdicionales1, tv_conjConoc2, tv_cdSalvacion2, tv_conjDiarios2,
            tv_conjAdicionales2, tv_conjConoc3, tv_cdSalvacion3, tv_conjDiarios3, tv_conjAdicionales3, tv_conjConoc4, tv_cdSalvacion4,
            tv_conjDiarios4, tv_conjAdicionales4, tv_conjConoc5, tv_cdSalvacion5, tv_conjDiarios5, tv_conjAdicionales5,
            tv_conjConoc6, tv_cdSalvacion6, tv_conjDiarios6, tv_conjAdicionales6, tv_conjConoc7, tv_cdSalvacion7, tv_conjDiarios7,
            tv_conjAdicionales7, tv_conjConoc8, tv_cdSalvacion8, tv_conjDiarios8, tv_conjAdicionales8, tv_conjConoc9, tv_cdSalvacion9,
            tv_conjDiarios9, tv_conjAdicionales9;

    private String[] opciones_conjuros = new String[]{"Borrar"};

    private String[] opciones_spells = new String[]{"Conjuros", "Niveles"};

    private String[] opciones_niveles = new String[]{"Nivel 0", "Nivel 1", "Nivel 2", "Nivel 3", "Nivel 4", "Nivel 5", "Nivel 6", "Nivel 7", "Nivel 8", "Nivel 9"};

    public SpellsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_spells, container, false);

        if(view != null){

            dbHelper            = new DBHelper(getActivity());
            db                  = dbHelper.getWritableDatabase();
            listViewConjuros    = view.findViewById(android.R.id.list);
            conjurosFab         = view.findViewById(R.id.conjurosFab);
            nivelesFab          = view.findViewById(R.id.nivelesFab);
            buttonSalvConj      = view.findViewById(R.id.buttonSalvConj);
            buttonFalloArc      = view.findViewById(R.id.buttonFalloArc);
            textViewSalvConj    = view.findViewById(R.id.textViewSalvConj);
            textViewFalloArc    = view.findViewById(R.id.textViewFalloArc);
            tv_conjConoc0       = view.findViewById(R.id.tv_conjConoc0);
            tv_cdSalvacion      = view.findViewById(R.id.tv_cdSalvacion);
            tv_conjDiarios      = view.findViewById(R.id.tv_conjDiarios);
            tv_conjAdicionales  = view.findViewById(R.id.tv_conjAdicionales);
            tv_conjConoc1       = view.findViewById(R.id.tv_conjConoc1);
            tv_cdSalvacion1     = view.findViewById(R.id.tv_cdSalvacion1);
            tv_conjDiarios1     = view.findViewById(R.id.tv_conjDiarios1);
            tv_conjAdicionales1 = view.findViewById(R.id.tv_conjAdicionales1);
            tv_conjConoc2       = view.findViewById(R.id.tv_conjConoc2);
            tv_cdSalvacion2     = view.findViewById(R.id.tv_cdSalvacion2);
            tv_conjDiarios2     = view.findViewById(R.id.tv_conjDiarios2);
            tv_conjAdicionales2 = view.findViewById(R.id.tv_conjAdicionales2);
            tv_conjConoc3       = view.findViewById(R.id.tv_conjConoc3);
            tv_cdSalvacion3     = view.findViewById(R.id.tv_cdSalvacion3);
            tv_conjDiarios3     = view.findViewById(R.id.tv_conjDiarios3);
            tv_conjAdicionales3 = view.findViewById(R.id.tv_conjAdicionales3);
            tv_conjConoc4       = view.findViewById(R.id.tv_conjConoc4);
            tv_cdSalvacion4     = view.findViewById(R.id.tv_cdSalvacion4);
            tv_conjDiarios4     = view.findViewById(R.id.tv_conjDiarios4);
            tv_conjAdicionales4 = view.findViewById(R.id.tv_conjAdicionales4);
            tv_conjConoc5       = view.findViewById(R.id.tv_conjConoc5);
            tv_cdSalvacion5     = view.findViewById(R.id.tv_cdSalvacion5);
            tv_conjDiarios5     = view.findViewById(R.id.tv_conjDiarios5);
            tv_conjAdicionales5 = view.findViewById(R.id.tv_conjAdicionales5);
            tv_conjConoc6       = view.findViewById(R.id.tv_conjConoc6);
            tv_cdSalvacion6     = view.findViewById(R.id.tv_cdSalvacion6);
            tv_conjDiarios6     = view.findViewById(R.id.tv_conjDiarios6);
            tv_conjAdicionales6 = view.findViewById(R.id.tv_conjAdicionales6);
            tv_conjConoc7       = view.findViewById(R.id.tv_conjConoc7);
            tv_cdSalvacion7     = view.findViewById(R.id.tv_cdSalvacion7);
            tv_conjDiarios7     = view.findViewById(R.id.tv_conjDiarios7);
            tv_conjAdicionales7 = view.findViewById(R.id.tv_conjAdicionales7);
            tv_conjConoc8       = view.findViewById(R.id.tv_conjConoc8);
            tv_cdSalvacion8     = view.findViewById(R.id.tv_cdSalvacion8);
            tv_conjDiarios8     = view.findViewById(R.id.tv_conjDiarios8);
            tv_conjAdicionales8 = view.findViewById(R.id.tv_conjAdicionales8);
            tv_conjConoc9       = view.findViewById(R.id.tv_conjConoc9);
            tv_cdSalvacion9     = view.findViewById(R.id.tv_cdSalvacion9);
            tv_conjDiarios9     = view.findViewById(R.id.tv_conjDiarios9);
            tv_conjAdicionales9 = view.findViewById(R.id.tv_conjAdicionales9);

            aux_id = recuperarIDPersonaje();
            recuperarTodosLosConjuros(aux_id);

            buttonSalvConj.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 0;
                    dialogButtonMetodo("  Salvación conjuro", control, aux_id);
                }
            });

            buttonFalloArc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    control = 1;
                    dialogButtonMetodo("  Fallo conjuro", control, aux_id);
                }
            });


            conjurosFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        conjurosFabMetodo("  Nuevo conjuro", aux_id);
                    }
                });

            nivelesFab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nivelesFabOpciones(opciones_niveles);
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

    private void nivelesFabOpciones(String[] opciones_niveles){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones_niveles, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int position) {

                switch (position){

                    case 0:

                        control = 0;
                        nivelesFabMetodo("  Modificar nivel 0", control);
                        break;

                    case 1:

                        control = 1;
                        nivelesFabMetodo("  Modificar nivel 1", control);
                        break;

                    case 2:
                        control = 2;
                        nivelesFabMetodo("  Modificar nivel 2", control);
                        break;

                    case 3:
                        control = 3;
                        nivelesFabMetodo("  Modificar nivel 3", control);
                        break;

                    case 4:
                        control = 4;
                        nivelesFabMetodo("  Modificar nivel 4", control);
                        break;

                    case 5:
                        control = 5;
                        nivelesFabMetodo("  Modificar nivel 5", control);
                        break;

                    case 6:
                        control = 6;
                        nivelesFabMetodo("  Modificar nivel 6", control);
                        break;

                    case 7:
                        control = 7;
                        nivelesFabMetodo("  Modificar nivel 7", control);
                        break;

                    case 8:
                        control = 8;
                        nivelesFabMetodo("  Modificar nivel 8", control);
                        break;

                    case 9:
                        control = 9;
                        nivelesFabMetodo("  Modificar nivel 9", control);
                        break;

                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }

    private void nivelesFabMetodo(String title, final int control){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_niveles_conjuros, null);
        builder.setView(viewInflated);

        final TextView textViewTitleNiveles = viewInflated.findViewById(R.id.tvTitleNivelesConjuros);
        final EditText editTextConocConjuro = viewInflated.findViewById(R.id.editTextConjurosConoc);
        final EditText editTextCDSalvacion  = viewInflated.findViewById(R.id.editTextCDSalvacion);
        final EditText editTextDiarios      = viewInflated.findViewById(R.id.editTextDiarios);
        final EditText editTextAdicionales  = viewInflated.findViewById(R.id.editTextAdicionales);

        builder.setCancelable(true);

        textViewTitleNiveles.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String conocimiento = editTextConocConjuro.getText().toString();
                String salvacion    = editTextCDSalvacion.getText().toString();
                String diarios      = editTextDiarios.getText().toString();
                String adicionales  = editTextAdicionales.getText().toString();

                aux_id = recuperarIDPersonaje();

                db = dbHelper.getReadableDatabase();
                ContentValues values = new ContentValues();

                switch (control){

                    case 0:

                        values.put("conocConjurosCero", conocimiento);
                        values.put("cdSalvacionCero", salvacion);
                        values.put("diariosConjurosCero", diarios);
                        values.put("adicionalesComjurosCero", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 1:

                        values.put("conocConjurosUno", conocimiento);
                        values.put("cdSalvacionUno", salvacion);
                        values.put("diariosConjurosUno", diarios);
                        values.put("adicionalesComjurosUno", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 2:

                        values.put("conocConjurosDos", conocimiento);
                        values.put("cdSalvacionDos", salvacion);
                        values.put("diariosConjurosDos", diarios);
                        values.put("adicionalesComjurosDos", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 3:

                        values.put("conocConjurosTres", conocimiento);
                        values.put("cdSalvacionTres", salvacion);
                        values.put("diariosConjurosTres", diarios);
                        values.put("adicionalesComjurosTres", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 4:

                        values.put("conocConjurosCuatro", conocimiento);
                        values.put("cdSalvacionCuatro", salvacion);
                        values.put("diariosConjurosCuatro", diarios);
                        values.put("adicionalesComjurosCuatro", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 5:

                        values.put("conocConjurosCinco", conocimiento);
                        values.put("cdSalvacionCinco", salvacion);
                        values.put("diariosConjurosCinco", diarios);
                        values.put("adicionalesComjurosCinco", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 6:

                        values.put("conocConjurosSeis", conocimiento);
                        values.put("cdSalvacionSeis", salvacion);
                        values.put("diariosConjurosSeis", diarios);
                        values.put("adicionalesComjurosSeis", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 7:

                        values.put("conocConjurosSiete", conocimiento);
                        values.put("cdSalvacionSiete", salvacion);
                        values.put("diariosConjurosSiete", diarios);
                        values.put("adicionalesComjurosSiete", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 8:

                        values.put("conocConjurosOcho", conocimiento);
                        values.put("cdSalvacionOcho", salvacion);
                        values.put("diariosConjurosOcho", diarios);
                        values.put("adicionalesComjurosOcho", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                    case 9:

                        values.put("conocConjurosNueve", conocimiento);
                        values.put("cdSalvacionNueve", salvacion);
                        values.put("diariosConjurosNueve", diarios);
                        values.put("adicionalesComjurosNueve", adicionales);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                        break;

                }

                getActivity().recreate();

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

    private void dialogButtonMetodo(String title, final int control, final String aux_id){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.editar_botones_sueltos, null);
        builder.setView(viewInflated);

        builder.setCancelable(true);

        TextView tvTitleBotonesSueltos = viewInflated.findViewById(R.id.tvTitleBotonesSueltos);
        Button buttonModificarSueltos  = viewInflated.findViewById(R.id.buttonModificarSueltos);
        final EditText editTextPuntos  = viewInflated.findViewById(R.id.editTextPuntos);

        tvTitleBotonesSueltos.setText(title);

        if(control == 0){
            buttonModificarSueltos.setText("Salvación");
        }else if(control == 1){
            buttonModificarSueltos.setText("Fallo");
        }

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String puntos = editTextPuntos.getText().toString();
                db = dbHelper.getReadableDatabase();
                ContentValues values = new ContentValues();

                if(control == 0){

                    try {

                        values.put("salvacion", puntos);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                    }catch (Exception e){
                        Log.e("Error", "Error: "+e.getMessage());
                    }finally {
                        db.close();
                    }

                }else if(control == 1){

                    try {

                        values.put("fallo", puntos);
                        db.update("conjurosTab", values, "idPersonaje='" + aux_id + "'", null);

                    }catch (Exception e){
                        Log.e("Error", "Error: "+e.getMessage());
                    }finally {
                        db.close();
                    }
                }

                getActivity().recreate();

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



    private void recuperarTodosLosConjuros(String id){

        try {

            db = dbHelper.getReadableDatabase();
            Cursor c = db
                    .rawQuery("SELECT * FROM conjurosTab WHERE _id='" + id + "'", null);

            if(c.moveToFirst()){
                do{

                    aux_salv        = c.getString(1);
                    aux_fallo       = c.getString(2);
                    aux_conoc0      = c.getString(3);
                    aux_cd0         = c.getString(4);
                    aux_diario0     = c.getString(5);
                    aux_adicional0  = c.getString(6);
                    aux_conoc1      = c.getString(7);
                    aux_cd1         = c.getString(8);
                    aux_diario1     = c.getString(9);
                    aux_adicional1  = c.getString(10);
                    aux_conoc2      = c.getString(11);
                    aux_cd2         = c.getString(12);
                    aux_diario2     = c.getString(13);
                    aux_adicional2  = c.getString(14);
                    aux_conoc3      = c.getString(15);
                    aux_cd3         = c.getString(16);
                    aux_diario3     = c.getString(17);
                    aux_adicional3  = c.getString(18);
                    aux_conoc4      = c.getString(19);
                    aux_cd4         = c.getString(20);
                    aux_diario4     = c.getString(21);
                    aux_adicional4  = c.getString(22);
                    aux_conoc5      = c.getString(23);
                    aux_cd5         = c.getString(24);
                    aux_diario5     = c.getString(25);
                    aux_adicional5  = c.getString(26);
                    aux_conoc6      = c.getString(27);
                    aux_cd6         = c.getString(28);
                    aux_diario6     = c.getString(29);
                    aux_adicional6  = c.getString(30);
                    aux_conoc7      = c.getString(31);
                    aux_cd7         = c.getString(32);
                    aux_diario7     = c.getString(33);
                    aux_adicional7  = c.getString(34);
                    aux_conoc8      = c.getString(35);
                    aux_cd8         = c.getString(36);
                    aux_diario8     = c.getString(37);
                    aux_adicional8  = c.getString(38);
                    aux_conoc9      = c.getString(39);
                    aux_cd9         = c.getString(40);
                    aux_diario9     = c.getString(41);
                    aux_adicional9  = c.getString(42);

                }while (c.moveToNext());

                    textViewSalvConj.setText(aux_salv);
                    textViewFalloArc.setText(aux_fallo);
                    tv_conjConoc0.setText(aux_conoc0);
                    tv_cdSalvacion.setText(aux_cd0);
                    tv_conjDiarios.setText(aux_diario0);
                    tv_conjAdicionales.setText(aux_adicional0);
                    tv_conjConoc1.setText(aux_conoc1);
                    tv_cdSalvacion1.setText(aux_cd1);
                    tv_conjDiarios1.setText(aux_diario1);
                    tv_conjAdicionales1.setText(aux_adicional1);
                    tv_conjConoc2.setText(aux_conoc2);
                    tv_cdSalvacion2.setText(aux_cd2);
                    tv_conjDiarios2.setText(aux_diario2);
                    tv_conjAdicionales2.setText(aux_adicional2);
                    tv_conjConoc3.setText(aux_conoc3);
                    tv_cdSalvacion3.setText(aux_cd3);
                    tv_conjDiarios3.setText(aux_diario3);
                    tv_conjAdicionales3.setText(aux_adicional3);
                    tv_conjConoc4.setText(aux_conoc4);
                    tv_cdSalvacion4.setText(aux_cd4);
                    tv_conjDiarios4.setText(aux_diario4);
                    tv_conjAdicionales4.setText(aux_adicional4);
                    tv_conjConoc5.setText(aux_conoc5);
                    tv_cdSalvacion5.setText(aux_cd5);
                    tv_conjDiarios5.setText(aux_diario5);
                    tv_conjAdicionales5.setText(aux_adicional5);
                    tv_conjConoc6.setText(aux_conoc6);
                    tv_cdSalvacion6.setText(aux_cd6);
                    tv_conjDiarios6.setText(aux_diario6);
                    tv_conjAdicionales6.setText(aux_adicional6);
                    tv_conjConoc7.setText(aux_conoc7);
                    tv_cdSalvacion7.setText(aux_cd7);
                    tv_conjDiarios7.setText(aux_diario7);
                    tv_conjAdicionales7.setText(aux_adicional7);
                    tv_conjConoc8.setText(aux_conoc8);
                    tv_cdSalvacion8.setText(aux_cd8);
                    tv_conjDiarios8.setText(aux_diario8);
                    tv_conjAdicionales8.setText(aux_adicional8);
                    tv_conjConoc9.setText(aux_conoc9);
                    tv_cdSalvacion9.setText(aux_cd9);
                    tv_conjDiarios9.setText(aux_diario9);
                    tv_conjAdicionales9.setText(aux_adicional9);

            }

            Cursor cursor = dbHelper.obtenereTodosLosConjuros();

            String[] from = new String[]{
                    "_id",
                    "dominios",
                    "escuela"
            };

            int[] to = new int[]{
                    R.id.identConjuros,
                    R.id.textViewDominios,
                    R.id.textViewEscuela
            };

            conjurosAdaptador = new ConjurosAdaptador(getContext(), cursor, from, to, 0);
            listViewConjuros.setAdapter(conjurosAdaptador);

            listViewConjuros.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                    TextView textViewIdentConjuros = view.findViewById(R.id.identConjuros);

                    aux_ident = textViewIdentConjuros.getText().toString();

                    dialogOpcionListaConjuros(opciones_conjuros, aux_ident);

                    return true;
                }
            });


        }catch (Exception e){
            Log.e("Error", "Error: "+e.getMessage());
        }finally {
            db.close();
        }


    }

    private void dialogOpcionListaConjuros (String[] opciones_conjuros, final String aux_ident){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(opciones_conjuros, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int pos) {

                if(pos == 0){

                    try {
                        db = dbHelper.getWritableDatabase();
                        db.delete("otrosConjuros", "_id='" + aux_ident + "'", null);
                        recuperarTodosLosConjuros(aux_id);

                    }catch (Exception e){
                        Log.e("Error", "Error: "+e.getMessage());
                    }

                }

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

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

    private void conjurosFabMetodo(String title, final String aux_id){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View viewInflated = LayoutInflater.from(getContext()).inflate(R.layout.dialog_conjuros, null);
        builder.setView(viewInflated);
        builder.setCancelable(true);

        final TextView textViewTitle   = viewInflated.findViewById(R.id.textViewTitleConjuros);
        final EditText editTextDominio = viewInflated.findViewById(R.id.editTextDominio);
        final EditText editTextEscuela = viewInflated.findViewById(R.id.editTextEscuela);

        textViewTitle.setText(title);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                aux_dominio = editTextDominio.getText().toString();
                aux_escuela = editTextEscuela.getText().toString();
                int id      = Integer.parseInt(aux_id);
                agregarOtrosConjuros(aux_dominio, aux_escuela, id);
                recuperarTodosLosConjuros(aux_id);

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

    private void agregarOtrosConjuros(String aux_dominio, String aux_escuela, int id){

        OtrosConjuros otrosConjuros = new OtrosConjuros(aux_dominio, aux_escuela, id);

        dbHelper = new DBHelper(getContext());

        dbHelper.addOtrosConjuros(otrosConjuros);

    }

}
